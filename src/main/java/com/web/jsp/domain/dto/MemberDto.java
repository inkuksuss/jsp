package com.web.jsp.domain.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter @Setter
@ToString
public class MemberDto implements Serializable {

    private String memberIdx;
    private String memberId;
    private String memberNick;
    private String memberPassword;
    private String memberAuth;
    private Timestamp dateReg;
    private Timestamp dateMod;
}
