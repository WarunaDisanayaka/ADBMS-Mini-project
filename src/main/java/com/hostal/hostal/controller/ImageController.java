package com.hostal.hostal.controller;

import javax.annotation.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    private static final String baseDirectory = "qrcodes/";


    @GetMapping("/images/{imageName:.+}")
    public ResponseEntity<?> serveImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get(baseDirectory, imageName);
            UrlResource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_PNG);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception stack trace for debugging purposes
            return ResponseEntity.notFound().build();
        }
    }


}
