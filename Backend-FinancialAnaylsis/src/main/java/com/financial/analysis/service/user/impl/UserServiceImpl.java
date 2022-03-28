package com.financial.analysis.service.user.impl;

import com.financial.analysis.entitys.Authority;
import com.financial.analysis.entitys.User;
import com.financial.analysis.model.request.UserRequest;
import com.financial.analysis.model.response.user.UserResponse;
import com.financial.analysis.persistence.repository.UserDetailsRepository;
import com.financial.analysis.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailsRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // ObjectMapper로 파라미터 명이 맞으면 자동 set 해주기 확인
    @Override
    public UserResponse createUser(UserRequest request) {
        List<Authority> authorities = new ArrayList<>();

        authorities.add(createAuthority("USER", "User Role"));
        authorities.add(createAuthority("ADMIN", "Admin Role"));

        User userEntity = new User();
        userEntity.setUsername(request.getUserName());
        userEntity.setEmail(request.getEmail());
        userEntity.setCreatedAt(new Date());
        userEntity.setAuthroityies(authorities);
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setEnabled(true);

        userRepository.save(userEntity);

        UserResponse response = UserResponse.builder()
                .userName(request.getUserName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .build();

        return response;
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(user -> {
                    return UserResponse.builder().userName(user.getUsername())
                            .email(user.getEmail())
                            .phoneNumber(user.getPhoneNumber())
                            .build();
                }
        ).collect(Collectors.toList());

    }

    @Override
    public UserResponse getUser(Long id) throws Exception {
        Optional<User> userEntity = userRepository.findById(id);
        System.out.println(id);
        User user = userEntity.orElseThrow(() -> new Exception("User not found"));

        return UserResponse.builder()
                .userName(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();

    }

    @Override
    public UserResponse updateUser(UserRequest request) throws Exception {
        User userFoundByID = userRepository.findById(request.getId()).orElseThrow(() -> new Exception("User not found"));

        userFoundByID.setUsername(request.getUserName());
        userFoundByID.setPhoneNumber(request.getPhoneNumber());
        userFoundByID.setPassword(request.getPhoneNumber());
        userFoundByID.setUpdatedAt(new Date());
        userRepository.save(userFoundByID);

        return UserResponse.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    @Override
    public void deleteUser(Long id) throws CustomUserException {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            throw new CustomUserException("User not found");
        }
        userRepository.deleteById(id);
    }

    private Authority createAuthority(String roleCode, String roleDescription) {
        Authority authority = new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }

}
