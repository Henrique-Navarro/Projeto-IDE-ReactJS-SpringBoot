import styles from "../../assets/css/TextArea.module.css";
import { useState } from "react";

function clear(setOutput: any) {
  setOutput("");
}

function submit(code: any, input: any, output: any, setOutput: any) {
  // Obtém a URL atual do navegador
  const currentURL = window.location.href;
  // Divide a URL em partes usando a barra como separador
  const parts = currentURL.split("/");
  // Pega a última parte da URL após a última barra
  const lastPart = parts[parts.length - 1];
  // Agora você pode usar a última parte como parte da URL na requisição Fetch
  const url = `http://localhost:8080/${lastPart}`;

  console.log(code);
  console.log(input);
  console.log(output);
  console.log(lastPart);
  console.log(url);

  setOutput("Compilando...");
  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "text/plain",
    },
    body: code,
  })
    .then((response) => response.text())
    .then((data) => {
      console.log("Resposta do servidor:", data);
      setOutput(data);
    })
    .catch((error) => {
      console.error("Ocorreu um erro:", error);
    });
}
export const TextArea = () => {
  const [code, setCode] = useState("");
  const [input, setInput] = useState("");
  const [output, setOutput] = useState("");

  return (
    <>
      {/*CODE*/}
      <div className={styles.container_left}>
        <div className={styles.header_container}>
          <div className={styles.align_left}>
            <input
              type="submit"
              value="main.c"
              className={styles.button_tittle}
            />
          </div>
          <div className={styles.align_right}>
            <input
              onClick={() => submit(code, input, output, setOutput)}
              type="submit"
              value="Run"
              className={styles.button}
            />
          </div>
        </div>
        <textarea
          placeholder="Code"
          value={code}
          onChange={(e) => setCode(e.target.value)}
          className={styles.code_area}
        />
      </div>

      {/*OUTPUT*/}
      <div className={styles.container_right}>
        <div className={styles.header_container}>
          <div className={styles.align_left}>
            <input
              type="submit"
              value="Output"
              className={styles.button_tittle}
            />
          </div>
          <div className={styles.align_right}>
            <input
              type="submit"
              value="Clear"
              className={styles.button}
              onClick={() => clear(setOutput)}
            />
          </div>
        </div>
        <textarea
          placeholder="Input"
          className={styles.input_area}
          value={input}
          onChange={(e) => setInput(e.target.value)}
        />
        <textarea
          placeholder="Output"
          className={styles.output_area}
          value={output}
          onChange={(e) => setOutput(e.target.value)}
        />
      </div>
    </>
  );
};
