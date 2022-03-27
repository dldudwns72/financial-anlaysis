package com.financial.analysis;

import com.financial.analysis.model.AssetDTO;
import com.financial.analysis.persistence.entity.AssetEntity;
import com.financial.analysis.persistence.repository.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Rollback(value = false)
public class AssetRepositoryTest {

    @Autowired
    AssetRepository assetRepository;

    @BeforeEach
    void setUp(){

    }

    @Test
    @Transactional
    void assetsRepositoryCreateTest() throws Exception{
        AssetDTO dto = new AssetDTO();
        dto.setMonth("1월");
        dto.setCash(3000000);
        dto.setStock(10000000);
        dto.setSavings(8000000);
        dto.setDeposit(50000000);

        AssetEntity asset = new AssetEntity(dto.getCash(),dto.getStock(),dto.getDeposit(),dto.getSavings(),dto.getMonth());

        assetRepository.save(asset);
    }

    @Test
    @Transactional
    void getByMonth() throws Exception{
        AssetEntity assetByMonth = assetRepository.findByMonth("1월");
        assertThat(assetByMonth.getCash()).isEqualTo(3000000);
    }




}
