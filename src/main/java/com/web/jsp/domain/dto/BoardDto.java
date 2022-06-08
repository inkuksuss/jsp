package com.web.jsp.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Getter @Setter
public class BoardDto {

    private String boardIdx;
    private String memberIdx;
    private String memberNick;
    private String boardName;
    private String boardBody;
    private int boardHeart;
    private String boardState;
    private String productState;
    private String productName;
    private int productPrice;
    private int productAmount;
    private String productImage;

    private Timestamp dateReg;
    private Timestamp dateMod;
}
