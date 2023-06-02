import { useState } from "react";
import test from "../assets/main_visual.jpg";
import { Link } from "react-router-dom";

function FreeBoardMain() {
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
      >
        <div
          style={{
            display: "flex",
            flex: 1,
          }}
        >
          <div style={{ display: "flex", flex: 1 }}></div>
          <div
            style={{
              display: "flex",
              flex: 1,
              alignItems: "center",
              justifyContent: "center",
            }}
          >
            <h2>자유게시판</h2>
          </div>
          <div
            style={{
              display: "flex",
              flex: 1,
              alignItems: "center",
              justifyContent: "flex-end",
            }}
          >
            <Link to="/freeBoardWrite" style={{ textDecoration: "none" }}>
              <div
                style={{
                  display: "flex",
                  backgroundColor: "white",
                  borderRadius: "10px",
                  height: 30,
                  width: 60,
                  justifyContent: "center",
                  alignItems: "center",
                  marginRight: 20,
                }}
              >
                <h4 style={{ color: "black" }}>글쓰기</h4>
              </div>
            </Link>
          </div>
        </div>
        <div
          style={{
            display: "flex",
            flex: 9,
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <div
            style={{
              display: "flex",
              backgroundColor: "white",
              height: "90%",
              width: "90%",
              border: "1px solid white",
              borderRadius: "10px",
            }}
          >
            내용
          </div>
        </div>
      </div>
    </div>
  );
}

export default FreeBoardMain;
