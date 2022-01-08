package com.example.mongodb.photo;

import com.example.mongodb.model.ResponeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoResponsitory photoResponsitory;

    @PostMapping("/one")
    ResponseEntity<ResponeObject> addImage(@RequestBody Photo newPhoto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(photoResponsitory.save(newPhoto))
        );
    }

    @PostMapping("/multiple")
    ResponseEntity<ResponeObject> addImages(@RequestBody List<Photo> Photos)
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(photoResponsitory.saveAll(Photos))
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponeObject> getImageOfUser(@PathVariable String id)
    {
        List<Photo> foundAll = photoResponsitory.findByIdUser(id);
        List<String> urlImage = new ArrayList<>();
        for (Photo i: foundAll)
        {
            urlImage.add(i.getUrlImage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(urlImage)
        );
    }


}
