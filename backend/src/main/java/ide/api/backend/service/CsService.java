package ide.api.backend.service;

import ide.api.backend.service.base.BaseLanguageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class CsService extends BaseLanguageService {
    public CsService() {
        super("cs");
    }

    @Override
    public ProcessBuilder createCompilerProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "microsoft/dotnet:latest",
                "csc", "/app/main.cs");
    }

    @Override
    public ProcessBuilder createRunProcessBuilder(File tempDir) {
        return new ProcessBuilder(
                "docker", "run", "--rm",
                "-v", tempDir.getAbsolutePath() + ":/app",
                "microsoft/dotnet:latest",
                "dotnet", "/app/main.dll");
    }
}