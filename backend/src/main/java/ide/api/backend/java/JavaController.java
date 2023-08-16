package ide.api.backend.java;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("java")
@RequiredArgsConstructor
public class JavaController {
    private final JavaService javaService;

    @PostMapping
    public String compilar(@RequestBody String code) throws IOException, InterruptedException {
        /*String code;
        if (contentType.equalsIgnoreCase("application/json")) {
            JSONObject jsonObject = new JSONObject(requestBody);
            code = jsonObject.getString("codigo");
        } else if (contentType.equalsIgnoreCase("application/xml")) {
            // Faça o parsing do XML e extraia o código, se necessário
        } else if (contentType.equalsIgnoreCase("application/x-www-form-urlencoded")) {
            // Extraia o código dos parâmetros do form data, se necessário
        } else {
            // Trate outros formatos, se necessário
            return "Formato de conteúdo não suportado";
        }*/
        return javaService.compileAndRun(code);
    }
}
