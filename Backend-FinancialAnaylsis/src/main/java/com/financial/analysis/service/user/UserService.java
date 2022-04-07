package com.financial.analysis.service.user;

import com.financial.analysis.model.request.UserRequest;
import com.financial.analysis.model.response.user.UserResponse;
import com.financial.analysis.service.user.impl.CustomUserException;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getUsers();

    UserResponse getUser(Long id) throws Exception;

    UserResponse updateUser(UserRequest request) throws Exception;

    void deleteUser(Long id) throws RuntimeException;
}
