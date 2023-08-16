package ide.api.backend.java;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Log4j2
public class JavaService {

    public String readMainFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Path.of(filePath)));
    }

    public String compileAndRun(String code) throws IOException, InterruptedException {
        
        
        // Crie um arquivo temporário para armazenar o código
        File tempDir = Files.createTempDirectory("java_compiler").toFile();
        File tempFile = new File(tempDir, "Main.java");

        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.write(code);
        }

        // Crie um processo para compilar e executar o código
        ProcessBuilder processBuilder = new ProcessBuilder("docker", "run", "--rm", "-v", tempDir.getAbsolutePath() + ":/app", "openjdk:11", "javac", "/app/Main.java");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Leia a saída do processo
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        // Compile o arquivo Main.java
        process.waitFor();

        // Verifique se a compilação teve sucesso antes de executar
        if (process.exitValue() == 0) {
            // Crie um processo para executar o código compilado
            ProcessBuilder runProcessBuilder = new ProcessBuilder("docker", "run", "--rm", "-v", tempDir.getAbsolutePath() + ":/app", "openjdk:11", "java", "-classpath", "/app", "Main");
            runProcessBuilder.redirectErrorStream(true);
            Process runProcess = runProcessBuilder.start();

            // Leia a saída do processo de execução
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            // Aguarde a conclusão do processo de execução
            runProcess.waitFor();
        }
        //log.info("{}", output.toString());
        return output.toString();
    }
}
