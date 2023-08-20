package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PhpService extends BaseLanguageService {
    public PhpService() {
        super("php");
    }

    @Override
    public ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return null;
    }

    @Override
    public ProcessBuilder createRunProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "php:latest",
                "php", "/app/main.php");
    }
}
