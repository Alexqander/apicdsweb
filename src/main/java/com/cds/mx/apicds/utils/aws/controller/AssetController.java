package com.cds.mx.apicds.utils.aws.controller;

import com.cds.mx.apicds.utils.aws.Asset;
import com.cds.mx.apicds.utils.aws.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cds/assets")
@CrossOrigin(origins = {"*"})
public class AssetController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    Map<String,String> upload(@RequestParam MultipartFile file){
        String key = s3Service.putObject(file);

        Map<String,String>result = new HashMap<>();
        result.put("key",key);
        result.put("url",s3Service.getObjectUrl(key));

        String urlGuardar = s3Service.getObjectUrl(key);

        System.out.println( "Esta es la url del archivo" + urlGuardar);

        return result;
    }

    @GetMapping(value = "/get-object",params = "key")
    ResponseEntity<ByteArrayResource>getObject(@RequestParam String key){
        Asset asset = s3Service.getObject(key);
        ByteArrayResource resource = new ByteArrayResource(asset.getContent());

        return ResponseEntity
                .ok()
                .header("Content-Type", asset.getContentType())
                .contentLength(asset.getContent().length)
                .body(resource);
    }

    @DeleteMapping(value = "/get-object",params = "key")
    void deleteObject(@RequestParam String key){
        s3Service.deleteObject(key);
    }

}
