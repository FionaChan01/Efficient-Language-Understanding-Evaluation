package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class Info {
    Integer datasetId;
    String email;
    String description;
    String submissionName;
    String affiliation;
    File[]tsvfile;
    File pyfile;

    public Info(Integer datasetId, String email, String description, String submissionName,
                String affiliation, File[] tsvfile,File pyfile) {
        this.datasetId = datasetId;
        this.email = email;
        this.description = description;
        this.submissionName = submissionName;
        this.affiliation = affiliation;
        this.tsvfile = tsvfile;
        this.pyfile = pyfile;
    }
}
