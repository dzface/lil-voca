package com.dzface.lil_voca.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor // 기본생성자 추가
@AllArgsConstructor // 모든 필드 포함한 생성자 추가
public class UserRequestDTO {
    private String userId;
    private String userPassword;
    private String userNick;
}
