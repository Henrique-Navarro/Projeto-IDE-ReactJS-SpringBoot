import { Link } from "react-router-dom";
import styles from "../../assets/css/NavBar.module.css";
import {
  FaJava,
  FaPython,
  FaHome,
  FaNodeJs,
  FaPhp,
  FaRProject,
} from "react-icons/fa";
import { FaGolang } from "react-icons/fa6";
import { SiRuby, SiCplusplus } from "react-icons/si";
import { TbBrandKotlin } from "react-icons/tb";
export const NavBar = () => {
  return (
    <ul className={styles.navbar}>
      <Link to="/" className={styles.link}>
        <li>
          <FaHome className={styles.icon} />
        </li>
        <Link to="/java" className={styles.link}>
          <li>
            <SiCplusplus className={styles.icon} />
          </li>
        </Link>
        <Link to="/java" className={styles.link}>
          <li>
            C
            <FaJava className={styles.icon} />
          </li>
        </Link>
        <Link to="/java" className={styles.link}>
          <li>
            C#
            <FaJava className={styles.icon} />
          </li>
        </Link>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <FaGolang className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <FaJava className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <TbBrandKotlin className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <FaNodeJs className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <FaPhp className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <FaPython className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <SiRuby className={styles.icon} />
        </li>
      </Link>
      <Link to="/java" className={styles.link}>
        <li>
          <FaRProject className={styles.icon} />
        </li>
      </Link>
    </ul>
  );
};
