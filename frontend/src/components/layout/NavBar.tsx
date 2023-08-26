import { Link } from "react-router-dom";
import styles from "../../assets/css/NavBar.module.css";
import {
  FaJava,
  FaPython,
  FaHome,
  FaNodeJs,
  FaPhp,
  FaRProject,
  FaRust,
  FaSwift,
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
      </Link>

      <Link to="/cpp" className={styles.link}>
        <li>
          <SiCplusplus className={styles.icon} />
        </li>
      </Link>

      <Link to="/c" className={styles.link}>
        <li>
          C
          <FaJava className={styles.icon} />
        </li>
      </Link>

      <Link to="/cs" className={styles.link}>
        <li>
          C#
          <FaJava className={styles.icon} />
        </li>
      </Link>

      <Link to="/go" className={styles.link}>
        <li>
          <FaGolang className={styles.icon} />
        </li>
      </Link>

      <Link to="/java" className={styles.link}>
        <li>
          <FaJava className={styles.icon} />
        </li>
      </Link>

      <Link to="/kotlin" className={styles.link}>
        <li>
          <TbBrandKotlin className={styles.icon} />
        </li>
      </Link>

      <Link to="/nodejs" className={styles.link}>
        <li>
          <FaNodeJs className={styles.icon} />
        </li>
      </Link>

      <Link to="/php" className={styles.link}>
        <li>
          <FaPhp className={styles.icon} />
        </li>
      </Link>

      <Link to="/pthon" className={styles.link}>
        <li>
          <FaPython className={styles.icon} />
        </li>
      </Link>

      <Link to="/r" className={styles.link}>
        <li>
          <FaRProject className={styles.icon} />
        </li>
      </Link>

      <Link to="/ruby" className={styles.link}>
        <li>
          <SiRuby className={styles.icon} />
        </li>
      </Link>

      <Link to="/rust" className={styles.link}>
        <li>
          <FaRust className={styles.icon} />
        </li>
      </Link>

      <Link to="/swift" className={styles.link}>
        <li>
          <FaSwift className={styles.icon} />
        </li>
      </Link>
    </ul>
  );
};
