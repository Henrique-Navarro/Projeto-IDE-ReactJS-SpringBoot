import styles from "../../assets/css/Header.module.css";
export const Header = () => {
  return (
    <div className={styles.container}>
      <div className={styles.logo_container}>
        <h1>Euros Compiler</h1>
      </div>
      <div className={styles.login_container}>
        <button>login</button>
      </div>
    </div>
  );
};
