import { useState } from "react";
import axios from "axios";

function FreeBoardWrite() {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");
  const [title, setTitle] = useState("");
  const [contents, setContents] = useState("");

  const submit = () => {
    const data = {
      title: title,
      content: contents,
      password: pw,
    };
    console.log(data);
    async function fetchdata() {
      await axios
        .post("/api/articles/write", data)
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
    }
    fetchdata();
  };

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
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <h2>글쓰기</h2>
        </div>
        <div
          style={{
            display: "flex",
            flex: 1,
            marginLeft: 30,
          }}
        >
          <h4 style={{ marginLeft: 10 }}>제목</h4>
          <input
            style={{
              height: 20,
              alignSelf: "center",
              marginLeft: 10,
              borderRadius: "10px",
              borderColor: "white",
              width: "60%",
            }}
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>
        <div
          style={{
            display: "flex",
            flex: 7,
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <input
            style={{
              display: "flex",
              backgroundColor: "white",
              height: "90%",
              width: "90%",
              border: "1px solid white",
              borderRadius: "10px",
            }}
            value={contents}
            onChange={(e) => setContents(e.target.value)}
          />
        </div>
        <div
          style={{
            display: "flex",
            flex: 1,
            justifyContent: "flex-end",
            alignItems: "center",
          }}
        >
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              marginRight: 35,
              marginBottom: 20,
            }}
          >
            <h4>아이디</h4>
            <input
              style={{
                height: 20,
                alignSelf: "center",
                marginLeft: 10,
                borderRadius: "10px",
                borderColor: "white",
              }}
              value={id}
              onChange={(e) => setId(e.target.value)}
            />
          </div>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              marginRight: 35,
              marginBottom: 20,
            }}
          >
            <h4>비밀번호</h4>
            <input
              style={{
                height: 20,
                alignSelf: "center",
                marginLeft: 10,
                borderRadius: "10px",
                borderColor: "white",
              }}
              value={pw}
              onChange={(e) => setPw(e.target.value)}
            />
          </div>
          <div
            style={{
              display: "flex",
              backgroundColor: "white",
              borderRadius: "10px",
              height: 30,
              width: 60,
              marginRight: 35,
              marginBottom: 20,
              justifyContent: "center",
              alignItems: "center",
            }}
            onClick={() => submit()}
          >
            <h4 style={{ color: "black" }}>글쓰기</h4>
          </div>
        </div>
      </div>
    </div>
  );
}

export default FreeBoardWrite;
