package com.financial.analysis.persistence.repository;

import com.financial.analysis.persistence.entity.board.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

}
