package ide.api.backend.controller;

import ide.api.backend.service.JavaService;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static ide.api.backend.util.CodeCreator.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private JavaService javaService;

    private final String expectedOutput = "Hello, World!";

    @BeforeEach
    void setup() throws IOException, InterruptedException {
        BDDMockito.when(javaService.compileAndRun(ArgumentMatchers.anyString())).thenReturn(expectedOutput);
    }

    @Test
    public void compilarJava_returnsStatusOK_WithSuccessfulCompilationAndExecution() throws IOException, InterruptedException {
        ResponseEntity<String> response = controller.
                compilarJava(createCorrectJavaCode());

        Assertions.assertThat(
                response.getBody()).isEqualTo(expectedOutput);
    }

    @Test
    public void compilarJava_returnsStatusINTERNAL_SERVER_ERROR_WithSuccessfulCompilationAndExecution() throws IOException, InterruptedException {
        ResponseEntity<String> response = controller.
                compilarJava(createIncorrectJavaCode());
        
        Assertions.not(
                Assertions.assertThat(response.getBody()).isEqualTo(expectedOutput));
    }
}
