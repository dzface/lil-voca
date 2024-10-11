package com.dzface.lil_voca.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String userPassword;
    private String userNick;

    //Getter
    public String getUserId() {
        return this.userId;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    public String getUserNick() {
        return this.userNick;
    }
}
