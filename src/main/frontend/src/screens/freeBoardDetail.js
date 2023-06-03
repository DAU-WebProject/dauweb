import { useState, useEffect } from "react";
import { Link, useLocation } from "react-router-dom";
import axios from "axios";
import { CircularProgress } from "@mui/material";

function FreeBoardDetail() {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState([]);
  let location = useLocation();
  let state = location.state;

  useEffect(() => {
    setLoading(true);
    async function fetchdata() {
      await axios
        .get(`/api/articles/view/${state.id}`)
        .then((response) => setData(response.data))
        .then(setLoading(false))
        .catch((error) => console.log(error));
    }
    fetchdata();
  }, []);
  let check = !loading && Object.keys(data).length;
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
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div
          style={{
            display: "flex",
            flex: 1,
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <h2>{loading ? "" : data.title}</h2>
        </div>
        <div
          style={{
            display: "flex",
            flex: 9,
            alignItems: "center",
            justifyContent: "center",
            height: "100%",
            width: "100%",
          }}
        >
          {check ? (
            <div
              style={{
                display: "flex",
                backgroundColor: "white",
                height: "90%",
                width: "90%",
                border: "1px solid white",
                borderRadius: "10px",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
              <div
                style={{
                  display: "flex",
                  justifyContent: "flex-end",
                  alignItems: "center",
                  flex: 1,
                  width: "100%",
                }}
              >
                <h4 style={{ marginRight: 10, color: "gray" }}>
                  {data.createdAt.slice(0, 10)}
                </h4>
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "flex-start",
                  flex: 6,
                  flexDirection: "column",
                  width: "90%",
                  flexWrap: "wrap",
                }}
              >
                {data.content}
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "flex-start",
                  flex: 4,
                  flexDirection: "column",
                  width: "90%",
                  flexWrap: "wrap",
                }}
              >
                <div
                  style={{
                    display: "flex",
                    height: 50,
                    justifyContent: "space-between",
                    alignItems: "center",
                  }}
                >
                  <div style={{ display: "flex", width: "85%" }}>
                    <textarea style={{ display: "flex", width: "100%" }} />
                  </div>
                  <div
                    style={{
                      display: "flex",
                      backgroundColor: "#1ea4ca",
                      borderRadius: "10px",
                      height: 30,
                      width: 60,
                      justifyContent: "center",
                      alignItems: "center",
                    }}
                  >
                    <h4 style={{ color: "black" }}>작성</h4>
                  </div>
                </div>
                {data.articleCommentDtoList.map((item, _) => {
                  return (
                    <div
                      style={{
                        display: "flex",
                        justifyContent: "space-between",
                        alignItems: "center",
                      }}
                    >
                      <h5 style={{ margin: 3, padding: 3 }}>{item.content}</h5>
                      <h5 style={{ margin: 3, padding: 3 }}>
                        {item.CreatedAt.slice(0, 10)}
                      </h5>
                    </div>
                  );
                })}
              </div>
            </div>
          ) : (
            <div
              style={{
                display: "flex",
                backgroundColor: "white",
                height: "90%",
                width: "90%",
                border: "1px solid white",
                borderRadius: "10px",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
              <CircularProgress />
            </div>
          )}
        </div>
        <Link to="/freeBoardMain" style={{ textDecoration: "none" }}>
          <div
            style={{
              display: "flex",
              backgroundColor: "white",
              borderRadius: "10px",
              height: 30,
              width: 80,
              marginRight: 35,
              marginBottom: 20,
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <h4 style={{ color: "black" }}>목록으로</h4>
          </div>
        </Link>
      </div>
    </div>
  );
}

export default FreeBoardDetail;
