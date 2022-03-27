package com.financial.analysis.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Long id;

    private String userName;

    private String password;

    private String email;

    private String phoneNumber;

}
