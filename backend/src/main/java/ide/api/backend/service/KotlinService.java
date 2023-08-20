package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class KotlinService extends BaseLanguageService {
    public KotlinService() {
        super("kt");
    }

    @Override
    public ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "kotlin:latest",
                "kotlinc", "/app/main.kt", "-include-runtime", "-d", "/app/main.jar");
    }

    @Override
    public ProcessBuilder createRunProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "openjdk:11",
                "java", "-jar", "/app/main.jar");
    }

}
