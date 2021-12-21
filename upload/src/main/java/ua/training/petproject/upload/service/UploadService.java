package ua.training.petproject.upload.service;

import ua.training.petproject.upload.rest.UploadRequest;

public interface UploadService {

    String uploadFile(UploadRequest request);
}
