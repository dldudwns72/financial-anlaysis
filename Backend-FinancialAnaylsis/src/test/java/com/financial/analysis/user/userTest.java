package com.financial.analysis.user;

import com.financial.analysis.entitys.Authority;
import com.financial.analysis.entitys.User;
import com.financial.analysis.model.request.UserRequest;
import com.financial.analysis.model.response.user.UserResponse;
import com.financial.analysis.persistence.repository.UserDetailsRepository;
import com.financial.analysis.service.user.UserService;
import com.financial.analysis.service.user.impl.CustomUserException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;


@SpringBootTest
public class userTest {

    @Autowired
    UserService userService;

    @MockBean
    UserDetailsRepository userRepository;

    @BeforeEach
    void 유저정보_초기세팅() {
    }

    @Test
    @Transactional
    public void 사용자_생성() {
        UserRequest userRequest = new UserRequest();

        userRequest.setUserName("yjlee");
        userRequest.setPassword("1234");
        userRequest.setEmail("yjlee@naver.com");
        userRequest.setPhoneNumber("0102020");

        UserResponse response = userService.createUser(userRequest);
        assertThat(response.getUserName()).isEqualTo("yjlee");
    }

    @Test
    @Transactional(readOnly = true)
    public void 전체사용자_조회() {
        given(userRepository.findAll()).willReturn(mockFindAllUser());
        List<UserResponse> responses = userService.getUsers();
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    @Transactional(readOnly = true)
    public void 단일사용자_조회() throws Exception{
        given(userRepository.findById(1L)).willReturn(mockFindUserByID());
        UserResponse response = userService.getUser(1L);
        assertThat(response.getUserName()).isEqualTo("yjlee");
    }

    @Test
    @Transactional
    public void 사용자_제거() throws Exception {
        // 없는 사용자 조회 시 에러 처리 테스트를 하고 싶다..
//        assertThatThrownBy(() -> userService.deleteUser(122L))
//                .isInstanceOf(CustomUserException.class);
    }

    private List<User> mockFindAllUser() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("yjlee");
        user1.setPassword("1234");
        user1.setEmail("yjlee@email.com");
        user1.setPhoneNumber("010");
        users.add(user1);

        User user2 = new User();
        user2.setUsername("hyjoo");
        user2.setPassword("12345");
        user2.setEmail("hyjoo@email.com");
        user2.setPhoneNumber("0101234");
        users.add(user2);
        return users;
    }

    private Optional<User> mockFindUserByID(){
        User user1 = new User();
        user1.setUsername("yjlee");
        user1.setPassword("1234");
        user1.setEmail("yjlee@email.com");
        user1.setPhoneNumber("010");

        return Optional.of(user1);
    }


}
