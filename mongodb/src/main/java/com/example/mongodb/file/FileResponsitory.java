package com.example.mongodb.file;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileResponsitory extends MongoRepository<File,String> {
}
