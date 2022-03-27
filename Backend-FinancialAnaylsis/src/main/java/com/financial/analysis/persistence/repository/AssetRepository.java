package com.financial.analysis.persistence.repository;


import com.financial.analysis.persistence.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity,Long> {

    AssetEntity findByMonth(String month);

}
