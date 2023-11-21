package com.sidroded.service;

import java.io.*;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileService {
    private static final String fileName = "Updated File.txt";
    private static final Logger log = LoggerFactory.getLogger(FileService.class.getName());

    public void createFile() {
        File file = new File(fileName);

        try {
            if (file.createNewFile()) {
                log.info("File '{}' successfully created", fileName);
            } else {
                log.info("File '{}' already exist.", fileName);
            }
        } catch (IOException e) {
            log.error("Problem with creating '{}'.", fileName);
            throw new RuntimeException(e);
        }
    }

    public void updateFile() {
        String record = getRecord();

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(record + "\n");
            log.info("Record '{}' successfully added", record);
        } catch (IOException e) {
            log.error("Problem with updating '{}'.", fileName);
        }
    }

    public int getNumOfCurrentRecord() {
        int currentNum = 0;

        try (FileReader reader = new FileReader(fileName); Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                currentNum++;
            }
        } catch (IOException e) {
            log.error("Problem with '{}'.", fileName);
        }

        return ++currentNum;
    }

    private String getRecord() {
       return "Record №" + getNumOfCurrentRecord() + ": " + java.time.LocalDateTime.now();
    }
}
