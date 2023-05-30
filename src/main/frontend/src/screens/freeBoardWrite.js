import { useState } from "react";
import test from "../assets/main_visual.jpg";
import { Link } from "react-router-dom";

function FreeBoardWrite() {
  return (
    <div
      style={{
        display: "flex",
        height: "100%",
        width: "100%",
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <div
        style={{
          display: "flex",
          height: "90%",
          width: 800,
          backgroundColor: "#0489B1",
          flexDirection: "column",
          borderRadius: "10px",
        }}
      ></div>
    </div>
  );
}

export default FreeBoardWrite;
