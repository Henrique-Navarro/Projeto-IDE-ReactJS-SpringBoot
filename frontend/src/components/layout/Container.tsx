import styles from "../../assets/css/Container.module.css";
import { ReactNode } from "react";

interface ContainerProps {
  children: ReactNode;
}

export const Container: React.FC<ContainerProps> = ({ children }) => {
  return <div className={styles.flex_container}>{children}</div>;
};
