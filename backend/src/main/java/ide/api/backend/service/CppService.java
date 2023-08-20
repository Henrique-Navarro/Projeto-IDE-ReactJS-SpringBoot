package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class CppService extends BaseLanguageService {
    public CppService() {
        super("cpp");
    }

    @Override
    public ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "gcc:latest",
                "g++", "/app/main.cpp", "-o", "/app/main");
    }

    @Override
    public ProcessBuilder createRunProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "gcc:latest",
                "/app/main");
    }
}
