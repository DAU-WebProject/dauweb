import { useState, useEffect } from "react";
import axios from "axios";
import { CircularProgress } from "@mui/material";

function Library() {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState({});
  useEffect(() => {
    setLoading(true);
    async function fetchdata() {
      await axios
        .get("/api/lib")
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
          <h2>한림도서관 좌석정보</h2>
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
              }}
            >
              <div
                style={{
                  display: "flex",
                  justifyContent: "center",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <h3>{data.title}</h3>
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "flex-start",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <h3 style={{ marginLeft: 10 }}>{data.subTitle}</h3>
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "flex-start",
                  alignItems: "center",
                  flex: 10,
                  flexDirection: "column",
                }}
              >
                <table style={{ width: "90%", height: "90%" }}>
                  <thead>
                    <tr style={{ backgroundColor: "lightgray" }}>
                      {data.header?.map((item, idx) => (
                        <th key={idx}>{item}</th>
                      ))}
                    </tr>
                  </thead>
                  <tbody>
                    {data.t_body?.map((item, itemIdx) => (
                      <tr style={{ backgroundColor: "skyblue" }} key={itemIdx}>
                        {item?.split(" ").map((token, tokenIdx) =>
                          tokenIdx === 1 ? (
                            <th key={tokenIdx}>
                              <a
                                href={data.links[itemIdx]}
                                style={{
                                  textDecoration: "none",
                                  color: "black",
                                }}
                                target="_blank"
                                rel="noreferrer"
                              >
                                {token}
                              </a>
                            </th>
                          ) : (
                            <th key={tokenIdx}>{token}</th>
                          )
                        )}
                      </tr>
                    ))}
                  </tbody>
                </table>
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

export default Library;
