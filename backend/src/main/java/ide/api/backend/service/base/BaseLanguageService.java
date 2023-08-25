package ide.api.backend.service.base;

import lombok.AllArgsConstructor;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public abstract class BaseLanguageService implements LanguageService {

    private final String fileExtension;

    @Override
    public String compileAndRun(String code) throws IOException, InterruptedException {
        File tempDir = createTempFilesWithCode(code);

        String compileErrors = shouldCompile(fileExtension) ? compile(tempDir) : null;
        String runOutput = compileErrors == null ? run(tempDir) : "Erro!";

        return compileErrors != null ? compileErrors : runOutput;
    }

    private boolean shouldCompile(String fileExtension) {
        //EXTENSÕES DAS LINGUAGENS COMPILADAS
        List<String> compiledLanguages = Arrays.asList(
                "java", "c", "cpp", "cs");
        return compiledLanguages.contains(fileExtension);
    }

    private File createTempFilesWithCode(String code) throws IOException {
        File tempDir = Files.createTempDirectory("compiler").toFile();
        File tempFile = new File(tempDir, "main." + fileExtension);

        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.write(code);
        }
        return tempDir;
    }

    private String compile(File tempDir) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = createCompilerProcessBuilder(tempDir);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        StringBuilder compileErrors = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                compileErrors.append(line).append("\n");
            }
        }
        process.waitFor();
        return process.exitValue() != 0 ? compileErrors.toString() : null;
    }

    private String run(File tempDir) throws IOException, InterruptedException {
        ProcessBuilder runProcessBuilder = createRunProcessBuilder(tempDir);
        runProcessBuilder.redirectErrorStream(true);
        Process runProcess = runProcessBuilder.start();

        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(runProcess.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }
        runProcess.waitFor();
        return output.toString();
    }

    protected abstract ProcessBuilder createCompilerProcessBuilder(File tempDir);

    protected abstract ProcessBuilder createRunProcessBuilder(File tempDir);

}
