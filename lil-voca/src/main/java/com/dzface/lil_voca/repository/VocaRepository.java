package com.dzface.lil_voca.repository;

import com.dzface.lil_voca.entitiy.Voca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VocaRepository extends JpaRepository<Voca, Long> {
    Optional<Voca> findByKorVoca(String korVoca);
}
