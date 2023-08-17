package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;

@Service
@Log4j2
public class PythonService extends BaseLanguageService {

    public PythonService() {
        super("py");
    }

    @Override
    protected ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return null;
    }

    @Override
    protected ProcessBuilder createRunProcessBuilder(File tempDir) {
        return new ProcessBuilder("docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "python:3",
                "python", "/app/main.py");
    }
}
