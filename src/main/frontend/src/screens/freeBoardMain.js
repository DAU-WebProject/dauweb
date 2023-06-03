import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { CircularProgress, Pagination } from "@mui/material";

function FreeBoardMain() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const [posts, setPosts] = useState([]);
  const postsPerPage = 5;
  useEffect(() => {
    setLoading(true);
    async function fetchdata() {
      await axios
        .get("/api/articles")
        .then((response) => setData(response.data))
        .then(setLoading(false))
        .catch((error) => console.log(error));
    }
    fetchdata();
  }, []);

  useEffect(() => {
    let postArr = data.content?.slice(0);
    postArr?.sort((a, b) => b.id - a.id);
    let startPostIdx = currentPage === 1 ? 0 : 5 * (currentPage - 1);
    let endPostIdx = startPostIdx + 5;
    setPosts(postArr?.slice(startPostIdx, endPostIdx));
  }, [currentPage, data]);

  const lastPage = Math.ceil(data.content?.length / postsPerPage);
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
                  justifyContent: "center",
                  alignItems: "center",
                  flex: 8,
                  width: "100%",
                }}
              >
                <ul
                  style={{
                    display: "flex",
                    flexDirection: "column",
                    listStyle: "none",
                    justifyContent: "space-evenly",
                    height: "80%",
                    width: "80%",
                  }}
                >
                  {posts?.map((item) => (
                    <li
                      key={item.id}
                      style={{
                        display: "flex",
                        flexDirection: "row",
                        listStyle: "none",
                        justifyContent: "space-between",
                        width: "100%",
                      }}
                    >
                      <Link
                        to="/freeBoardDetail"
                        state={{ id: item.id }}
                        style={{ textDecoration: "none" }}
                      >
                        <h3 style={{ color: "black" }}>{item.title}</h3>
                      </Link>
                      <h4 style={{ color: "gray" }}>
                        {item.createdAt.slice(0, 10)}
                      </h4>
                    </li>
                  ))}
                </ul>
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "center",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <Pagination
                  count={lastPage}
                  onClick={(item) =>
                    setCurrentPage(
                      item.target.innerText === ">"
                        ? currentPage + 1
                        : item.target.innerText === "<"
                        ? currentPage + 1
                        : item.target.innerText
                    )
                  }
                  hidePrevButton
                  hideNextButton
                />
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
      </div>
    </div>
  );
}

export default FreeBoardMain;
