package com.financial.analysis.service.user;


import com.financial.analysis.entitys.User;
import com.financial.analysis.persistence.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsRepository.findByUsername(username)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User Not Found : " + username);
                });

        return user;
    }

}
