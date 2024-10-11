package com.dzface.lil_voca.controller;

import com.dzface.lil_voca.dto.VocaRequestDTO;
import com.dzface.lil_voca.dto.VocaResponseDTO;
import com.dzface.lil_voca.service.VocaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/voca")
public class VocaController {
    private final VocaService vocaService;
    public VocaController (VocaService vocaService) {
        this.vocaService =vocaService;
    }

    @PostMapping("")
    public ResponseEntity<String> addVocabulary(@RequestBody VocaRequestDTO vocaRequestDTO) {
        return vocaService.addVocabulary(vocaRequestDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<VocaResponseDTO>> getAllVocabulary() {
        return vocaService.getAllVocabulary();
    }



}
