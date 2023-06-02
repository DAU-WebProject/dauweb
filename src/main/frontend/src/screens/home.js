import { useState } from "react";
import test from "../assets/main_visual.jpg";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div
      style={{
        display: "flex",
        flex: 1,
        justifyContent: "space-evenly",
        alignItems: "center",
        flexDirection: "row",
      }}
    >
      <Link to="/library" style={{ textDecoration: "none" }}>
        <div
          style={{
            display: "flex",
            height: 250,
            width: 250,
            justifyContent: "center",
            alignItems: "center",
            borderRadius: 30 + "px",
            backgroundColor: "#0174DF",
            border: "1px solid white",
          }}
        >
          <h2 style={{ color: "white" }}>도서관</h2>
        </div>
      </Link>
      <Link to="/cafeteria" style={{ textDecoration: "none" }}>
        <div
          style={{
            display: "flex",
            height: 250,
            width: 250,
            justifyContent: "center",
            alignItems: "center",
            borderRadius: 30 + "px",
            backgroundColor: "#0174DF",
            border: "1px solid white",
          }}
        >
          <h2 style={{ color: "white" }}>학식</h2>
        </div>
      </Link>
      <Link to="/freeBoardMain" style={{ textDecoration: "none" }}>
        <div
          style={{
            display: "flex",
            height: 250,
            width: 250,
            justifyContent: "center",
            alignItems: "center",
            borderRadius: 30 + "px",
            backgroundColor: "#0174DF",
            border: "1px solid white",
          }}
        >
          <h2 style={{ color: "white" }}>자유게시판</h2>
        </div>
      </Link>
    </div>
  );
}

export default Home;
