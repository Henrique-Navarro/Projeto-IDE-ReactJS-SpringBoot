import { Outlet } from "react-router-dom";
import { NavBar } from "./components/layout/NavBar";
import { TextArea } from "./components/layout/TextArea";
import "./assets/css/app.css";
export const App = () => {
  return (
    <>
      <NavBar />
      <TextArea />
      <Outlet />
    </>
  );
};
