package com.dzface.lil_voca.entitiy;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voca {
    @Id @GeneratedValue
    private Long id;
    @Column(length = 50) @NotNull
    private String korVoca;
    @Column(length = 50) @NotNull
    private String engVoca;
    @Column(length = 5) @NotNull
    private isMemorized status;
}


