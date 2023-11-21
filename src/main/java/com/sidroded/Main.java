package com.sidroded;

import com.sidroded.service.ConsoleService;
import com.sidroded.service.FileService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final FileService fileService = new FileService();
    private static final ConsoleService consoleService = new ConsoleService();
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            fileService.createFile();
            fileService.updateFile();
            consoleService.gitCommit();
            consoleService.gitPush();
        }, 0, 3, TimeUnit.HOURS);
    }
}