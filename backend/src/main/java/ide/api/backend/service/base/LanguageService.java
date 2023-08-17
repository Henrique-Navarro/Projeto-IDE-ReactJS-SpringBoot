package ide.api.backend.service.base;

import java.io.IOException;

public interface LanguageService {
    public String compileAndRun(String code) throws IOException, InterruptedException;
}
