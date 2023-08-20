package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class RubyService extends BaseLanguageService {
    public RubyService() {
        super("rb");
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
                "ruby:latest",
                "ruby", "/app/main.rb");
    }
}
