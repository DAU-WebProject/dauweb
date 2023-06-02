import { useState } from "react";
import test from "./assets/main_visual.jpg";
import { Link, Route, Routes } from "react-router-dom";
import Home from "./screens/home";
import Cafeteria from "./screens/cafeteria";
import Library from "./screens/library";
import NotFound from "./screens/notFound";
import FreeBoardMain from "./screens/freeBoardMain";
import FreeBoardWrite from "./screens/freeBoardWrite";
import FreeBoardDetail from "./screens/freeBoardDetail";

function App() {
  return (
    <div
      className="App"
      style={{ display: "flex", flex: 1, flexDirection: "column" }}
    >
      <div
        style={{
          display: "flex",
          flex: 1,
          justifyContent: "center",
          alignItems: "flex-end",
        }}
      >
        <Link to="/" style={{ textDecoration: "none" }}>
          <img src={require("./assets/header_logo.png")} alt="logo" />
        </Link>
      </div>

      <div style={{ display: "flex", flex: 0.1 }}></div>
      <div
        style={{
          display: "flex",
          flex: 3,
          justifyContent: "center",
          alignItems: "center",
          backgroundImage: `url(${test})`,
        }}
      >
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/library" element={<Library />} />
          <Route path="/cafeteria" element={<Cafeteria />} />
          <Route path="/freeBoardMain" element={<FreeBoardMain />} />
          <Route path="/freeBoardWrite" element={<FreeBoardWrite />} />
          <Route path="/freeBoardDetail" Component={FreeBoardDetail} />
        </Routes>
      </div>
      <div style={{ display: "flex", flex: 1 }}></div>
    </div>
  );
}

export default App;
