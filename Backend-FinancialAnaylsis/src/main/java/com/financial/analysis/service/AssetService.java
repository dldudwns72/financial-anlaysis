package com.financial.analysis.service;

import com.financial.analysis.model.AssetDTO;

import java.util.List;

public interface AssetService {
    void createAssert(AssetDTO assetDTO);

    List<AssetDTO> getAsserts();

    AssetDTO getAssert(String assetID);

    AssetDTO updateAssert(AssetDTO assetDTO);

    void deleteAssert(String assetID);

}
