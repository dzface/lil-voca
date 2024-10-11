package com.dzface.lil_voca.service;

import com.dzface.lil_voca.dto.VocaRequestDTO;
import com.dzface.lil_voca.entitiy.Voca;
import com.dzface.lil_voca.dto.VocaResponseDTO;
import com.dzface.lil_voca.entitiy.isMemorized;
import com.dzface.lil_voca.repository.VocaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VocaService {

    private final VocaRepository vocaRepository;
    public VocaService (VocaRepository vocaRepository) {
        this.vocaRepository = vocaRepository;
    }
    public ResponseEntity<String> addVocabulary(VocaRequestDTO vocaRequestDTO) {
        // Null 유효성 검증
        if (vocaRequestDTO.getKorVoca() == null || vocaRequestDTO.getEngVoca() == null) {
            return new ResponseEntity<>("value is nothing", HttpStatus.BAD_REQUEST);
        }
        // 중복 조회 로직
        Optional<Voca> isDuplicateVoca = vocaRepository.findByKorVoca(vocaRequestDTO.getKorVoca());
        if(isDuplicateVoca.isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Voca voca = Voca.builder()
                .korVoca(vocaRequestDTO.getKorVoca())
                .engVoca(vocaRequestDTO.getEngVoca())
                .status(isMemorized.NO) // 공부하지 않은 상태
                .build();

        // 저장
        vocaRepository.save(voca);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<VocaResponseDTO>> getAllVocabulary() {
        List<Voca> vocaList = vocaRepository.findAll();
        List<VocaResponseDTO> vocaResponseDTOLIST = new ArrayList<>();
        for(Voca voca : vocaList) {
            VocaResponseDTO vocaResponseDTO = new VocaResponseDTO(
                    voca.getKorVoca(),
                    voca.getEngVoca(),
                    voca.getStatus()
            );
            vocaResponseDTOLIST.add(vocaResponseDTO);
        }
        return new ResponseEntity<>(vocaResponseDTOLIST, HttpStatus.OK);
    };

}
