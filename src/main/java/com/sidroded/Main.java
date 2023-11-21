package com.sidroded;

import com.sidroded.service.ConsoleService;
import com.sidroded.service.FileService;

public class Main {
    private static final FileService fileService = new FileService();
    private static final ConsoleService consoleService = new ConsoleService();
    public static void main(String[] args) {
        fileService.createFile();
        fileService.updateFile();
        consoleService.gitCommit();
        consoleService.gitPush();
    }
}