import { Link } from "react-router-dom";
import styles from "../../assets/css/NavBar.module.css";

export const NavBar = () => {
  return (
    <ul className={styles.navbar}>
      <Link to="/" className={styles.link}>
        <li>Home</li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>Java</li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>Java22</li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>Java333</li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>Java444</li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>J</li>
      </Link>
    </ul>
  );
};
