import styles from "../../assets/css/TextArea.module.css";
import { useState } from "react";

function submit(code: any, input: any, output: any) {
  console.log(code);
  console.log(input);
  console.log(output);
}
export const TextArea = () => {
  const [code, setCode] = useState("");
  const [input, setInput] = useState("");
  const [output, setOutput] = useState("");

  return (
    <>
      <input
        onClick={() => submit(code, input, output)}
        type="submit"
        value="run"
        className={styles.button}
      />
      <div className={styles.container}>
        <textarea
          placeholder="Code"
          value={code}
          onChange={(e) => setCode(e.target.value)}
        />
      </div>
      <div className={styles.container}>
        <textarea
          placeholder="Input"
          className={styles.input}
          value={input}
          onChange={(e) => setInput(e.target.value)}
        />
        <textarea
          placeholder="Output"
          value={output}
          onChange={(e) => setOutput(e.target.value)}
        />
      </div>
    </>
  );
};
