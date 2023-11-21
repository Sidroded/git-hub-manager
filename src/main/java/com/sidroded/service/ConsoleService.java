package com.sidroded.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ConsoleService {
    private static final Logger log = LoggerFactory.getLogger(ConsoleService.class);
    private static final String addCommand = "git add .";
    private static final String pushCommand = "git push";
    private final FileService fileService = new FileService();

    public void gitCommit() {
        try {
            Process addProcess = Runtime.getRuntime().exec(addCommand);
            int addExitCode = addProcess.waitFor();
            log.info("git add complete with exit code: {}", addExitCode);

            Process commitProcess = Runtime.getRuntime().exec(getCommitCommand());
            int commitExitCode = commitProcess.waitFor();
            log.info("git commit complete with exit code: {}", commitExitCode);
        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }
    }

    public void gitPush() {
        try {
            Process pushProcess = Runtime.getRuntime().exec(pushCommand);
            int pushExitCode = pushProcess.waitFor();
            log.info("git push complete with exit code: {}", pushExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getCommitCommand() {
        return "git commit -m \"Automated commit for record №" + (fileService.getNumOfCurrentRecord() - 1) + "\"";
    }
}
