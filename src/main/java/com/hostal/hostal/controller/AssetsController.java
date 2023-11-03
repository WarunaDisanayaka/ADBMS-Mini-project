package com.hostal.hostal.controller;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hostal.hostal.entity.AssetsEntity;
import com.hostal.hostal.service.AssetsService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    private static final String QR_CODE_DIRECTORY = "qrcodes";

    @Autowired
    private AssetsService assetsService;

    @GetMapping("/")
    public List<AssetsEntity> getAllAssets() {
        return assetsService.getAllAssets();
    }


    @GetMapping("/{id}")
    public AssetsEntity getAsset(@PathVariable Long id) {
        String stringId = String.valueOf(id);
        return assetsService.getAssetById(stringId);
    }


    @PostMapping("/")
    public AssetsEntity createAsset(@RequestBody AssetsEntity asset) {
        try {
            // Generate a QR code
            String qrCodeData = asset.getAssetsId();
            int width = 200; // QR code width
            int height = 200; // QR code height

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hints = new Hashtable<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, width, height, hints);

            // Create the directory if it doesn't exist
            File directory = new File(QR_CODE_DIRECTORY);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Define the file path for the QR code image
            String qrCodeFilePath = QR_CODE_DIRECTORY + File.separator + "qr_" + asset.getAssetsId() + ".png";

            // Save the QR code as an image file
            BufferedImage image = toBufferedImage(bitMatrix);
            File qrCodeFile = new File(qrCodeFilePath);
            ImageIO.write(image, "PNG", qrCodeFile);

            // Set the QR code file path in the asset entity
            asset.setQrCodePath(qrCodeFilePath);

            // Save the asset entity in the database
            return assetsService.createAsset(asset);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return null;
        }
    }


    @PutMapping("/{id}")
    public AssetsEntity updateAsset(@PathVariable String id, @RequestBody AssetsEntity asset) {
        return assetsService.updateAsset(id, asset);
    }

    @DeleteMapping("/{id}")
    public void deleteAsset(@PathVariable String id) {
        assetsService.deleteAsset(id);
    }


    private static BufferedImage toBufferedImage(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        return image;
    }
}
