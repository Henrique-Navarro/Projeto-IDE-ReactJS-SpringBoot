package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class RService extends BaseLanguageService {
    public RService() {
        super("R");
    }

    @Override
    public ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "r-base:latest",
                "Rscript", "/app/main.R");
    }

    @Override
    public ProcessBuilder createRunProcessBuilder(File tempDir) {
        return null;
    }
}
