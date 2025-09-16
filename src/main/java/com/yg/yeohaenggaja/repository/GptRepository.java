package com.yg.yeohaenggaja.repository;

import com.yg.yeohaenggaja.domain.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GptRepository extends JpaRepository<Prompt, Long> {
    List<Prompt> findByName(String name);
}
