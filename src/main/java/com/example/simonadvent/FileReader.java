package com.example.simonadvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileReader {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<String> readLinesFromResourceFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(resourceLoader.getResource("classpath:" + filename).getURI()));

        }

    }

