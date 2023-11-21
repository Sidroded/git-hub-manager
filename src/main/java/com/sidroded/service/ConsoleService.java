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
            log.info("{} complete", addProcess.info());

            Process commitProcess = Runtime.getRuntime().exec(getCommitCommand());
            log.info("{} complete", commitProcess.info());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void gitPush() {
        try {
            Process pushProcess = Runtime.getRuntime().exec(pushCommand);
            log.info("{} complete", pushProcess.info());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCommitCommand() {
        return "git commit -m \"Automated commit for record №" + (fileService.getNumOfCurrentRecord() - 1) + "\"";
    }
}
