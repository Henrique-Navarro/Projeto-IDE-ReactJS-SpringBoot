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
      {/*CODE*/}
      <div className={styles.container_left}>
        <div className={styles.header_container}>
          <div className={styles.align_left}>main.c</div>
          <div className={styles.align_right}>
            <input
              onClick={() => submit(code, input, output)}
              type="submit"
              value="run"
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
            <span>Output</span>
          </div>
          <div className={styles.align_right}>
            <input type="submit" value="clear" className={styles.button} />
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
