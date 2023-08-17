package ide.api.backend.controller;

import ide.api.backend.service.JavaService;
import ide.api.backend.service.PythonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class Controller {
    private final JavaService javaService;
    private final PythonService pythonService;

    @PostMapping(path = "java")
    public String compilarJava(@RequestBody String code) throws IOException, InterruptedException {
        return javaService.compileAndRun(code);
    }

    @PostMapping(path = "python")
    public String compilarPython(@RequestBody String code) throws IOException, InterruptedException {
        return pythonService.compileAndRun(code);
    }
}
