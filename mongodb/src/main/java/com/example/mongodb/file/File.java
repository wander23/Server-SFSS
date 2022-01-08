package com.example.mongodb.file;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class File {
    @Id
    private String id;
    private String urlFile;

    public File() {}

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", urlFile='" + urlFile + '\'' +
                '}';
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public File(String id, String urlFile) {
        this.id = id;
        this.urlFile = urlFile;
    }
}
