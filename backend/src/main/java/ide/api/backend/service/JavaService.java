package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Log4j2
public class JavaService extends BaseLanguageService {

    public JavaService() {
        super("java");
    }

    @Override
    public ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "openjdk:11",
                "javac", "/app/Main.java");
    }

    @Override
    public ProcessBuilder createRunProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "openjdk:11",
                "java", "-classpath", "/app", "Main");
    }
}
