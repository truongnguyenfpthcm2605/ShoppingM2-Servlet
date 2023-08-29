package com.m2m.shopping.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Using with options Register, Login
public class AccountDTO {
    private String email;
    private String fullname;
    private String password;
    private String confirm;
    private String verify;
    private Date birthday;
    private Boolean gender;
    private Long timeout;
}
