package com.example.mongodb.file;

import com.example.mongodb.model.ResponeObject;
import com.example.mongodb.photo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileResponsitory fileResponsitory;

    @PostMapping("/one")
    ResponseEntity<ResponeObject> addFile(@RequestBody File newFile)
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(fileResponsitory.save(newFile))
        );
    }

    @PostMapping("/multiple")
    ResponseEntity<ResponeObject> addFiles(@RequestBody List<File> files)
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(fileResponsitory.saveAll(files))
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponeObject> getFileFormat(@PathVariable String id)
    {
        Optional<File> findFile = fileResponsitory.findById(id);
        return findFile.map(file -> ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(file.getUrlFile())
        )).orElseGet(() -> ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("")
        ));
    }
}
