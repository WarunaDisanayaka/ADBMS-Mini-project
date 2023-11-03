package com.hostal.hostal.service;

import com.hostal.hostal.entity.AssetsEntity;
import com.hostal.hostal.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsService {

    @Autowired
    private AssetsRepository assetsRepository;

    public List<AssetsEntity> getAllAssets() {
        return assetsRepository.findAll();
    }

    public AssetsEntity getAssetById(Long id) {
        return assetsRepository.findById(id).orElse(null);
    }

    public AssetsEntity createAsset(AssetsEntity asset) {
        return assetsRepository.save(asset);
    }

    public AssetsEntity updateAsset(Long id, AssetsEntity asset) {
        if (assetsRepository.existsById(id)) {
            asset.setAssetsId(String.valueOf(id));
            return assetsRepository.save(asset);
        }
        return null;
    }

    public void deleteAsset(Long id) {
        assetsRepository.deleteById(id);
    }
}
