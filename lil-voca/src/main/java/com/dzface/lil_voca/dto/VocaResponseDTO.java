package com.dzface.lil_voca.dto;

import com.dzface.lil_voca.entitiy.isMemorized;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VocaResponseDTO {
    private String korVoca;
    private String engVoca;
    private isMemorized status;
}
