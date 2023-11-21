package com.sidroded;

import com.sidroded.service.FileService;

public class Main {
    private static final FileService fileService = new FileService();
    public static void main(String[] args) {
        fileService.createFile();
        fileService.updateFile();
    }
}