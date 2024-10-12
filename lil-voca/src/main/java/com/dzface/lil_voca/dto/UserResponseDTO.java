package com.dzface.lil_voca.dto;

import com.dzface.lil_voca.entitiy.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String userId;
    private String userPassword;
    private String userNick;

    public UserResponseDTO(String userId, String userPassword, String userNick) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNick = userNick;
    }

}
