package com.financial.analysis.persistence.repository;

import com.financial.analysis.persistence.entity.board.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    Optional<BoardEntity> findByTitle(String title);
}
