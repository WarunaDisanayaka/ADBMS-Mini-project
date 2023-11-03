package com.hostal.hostal.controller;

import com.hostal.hostal.entity.AssetsEntity;
import com.hostal.hostal.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private AssetsService assetsService;

    @GetMapping("/")
    public List<AssetsEntity> getAllAssets() {
        return assetsService.getAllAssets();
    }

    @GetMapping("/{id}")
    public AssetsEntity getAsset(@PathVariable Long id) {
        return assetsService.getAssetById(id);
    }

    @PostMapping("/")
    public AssetsEntity createAsset(@RequestBody AssetsEntity asset) {
        return assetsService.createAsset(asset);
    }

    @PutMapping("/{id}")
    public AssetsEntity updateAsset(@PathVariable Long id, @RequestBody AssetsEntity asset) {
        return assetsService.updateAsset(id, asset);
    }

    @DeleteMapping("/{id}")
    public void deleteAsset(@PathVariable Long id) {
        assetsService.deleteAsset(id);
    }
}
