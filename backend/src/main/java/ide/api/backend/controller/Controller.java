package ide.api.backend.controller;

import ide.api.backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class Controller {
    private final CppService cppService;
    private final CService cService;
    private final CsService csService;
    private final GoService goService;
    private final JavaService javaService;
    private final KotlinService kotlinService;
    private final NodeJsService nodeJsService;
    private final PhpService phpService;
    private final PythonService pythonService;
    private final RService rService;
    private final RubyService rubyService;
    private final RustService rustService;
    private final SwiftService swiftService;

    @PostMapping(path = "cpp")
    public String compilarCpp(@RequestBody String code) throws IOException, InterruptedException {
        return cppService.compileAndRun(code);
    }

    @PostMapping(path = "c")
    public String compilarC(@RequestBody String code) throws IOException, InterruptedException {
        return cService.compileAndRun(code);
    }

    @PostMapping(path = "cs")
    //.NET NÃO ESTÁ PÚBLICA
    public String compilarCs(@RequestBody String code) throws IOException, InterruptedException {
        return csService.compileAndRun(code);
    }

    @PostMapping(path = "go")
    public String compilarGo(@RequestBody String code) throws IOException, InterruptedException {
        return goService.compileAndRun(code);
    }

    @PostMapping(path = "java")
    public ResponseEntity<String> compilarJava(@RequestBody String code) throws IOException, InterruptedException {
        return ResponseEntity.status(HttpStatus.OK).body(javaService.compileAndRun(code));
    }

    @PostMapping(path = "kotlin")
    public String compilarKotlin(@RequestBody String code) throws IOException, InterruptedException {
        return kotlinService.compileAndRun(code);
    }

    @PostMapping(path = "nodejs")
    public String compilarNodejs(@RequestBody String code) throws IOException, InterruptedException {
        return nodeJsService.compileAndRun(code);
    }

    @PostMapping(path = "php")
    public String compilarPhp(@RequestBody String code) throws IOException, InterruptedException {
        return phpService.compileAndRun(code);
    }

    @PostMapping(path = "python")
    public String compilarPython(@RequestBody String code) throws IOException, InterruptedException {
        return pythonService.compileAndRun(code);
    }

    @PostMapping(path = "r")
    public String compilarR(@RequestBody String code) throws IOException, InterruptedException {
        return rustService.compileAndRun(code);
    }

    @PostMapping(path = "ruby")
    public String compilarRuby(@RequestBody String code) throws IOException, InterruptedException {
        return rubyService.compileAndRun(code);
    }

    @PostMapping(path = "rust")
    public String compilarRust(@RequestBody String code) throws IOException, InterruptedException {
        return rustService.compileAndRun(code);
    }

    @PostMapping(path = "swift")
    public String compilarSwift(@RequestBody String code) throws IOException, InterruptedException {
        return swiftService.compileAndRun(code);
    }
}
