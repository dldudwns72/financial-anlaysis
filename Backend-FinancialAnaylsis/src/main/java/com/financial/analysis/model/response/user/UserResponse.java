package com.financial.analysis.model.response.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {

    private String userName;

    private String email;

    private String phoneNumber;

}
