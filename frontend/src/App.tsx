import { Outlet } from "react-router-dom";
import { NavBar } from "./components/layout/NavBar";
import { TextArea } from "./components/layout/TextArea";
import { Header } from "./components/layout/Header";
import { Container } from "./components/layout/Container";

import "./assets/css/app.css";

export const App = () => {
  return (
    <>
      <Header />
      <Container>
        <NavBar />
        <TextArea />
        <Outlet />
      </Container>
    </>
  );
};
