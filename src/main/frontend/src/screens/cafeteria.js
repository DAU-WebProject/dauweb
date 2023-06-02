import { useState, useEffect } from "react";
import axios from "axios";
import { CircularProgress } from "@mui/material";

function Cafeteria() {
  const [loading, setLoading] = useState(true);
  const [data, setData] = useState({});
  const [campus, setCampus] = useState("S");
  useEffect(() => {
    setLoading(true);
    async function fetchdata() {
      await axios
        .get("/api/menu")
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
          <h2>학식</h2>
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
                  justifyContent: "space-evenly",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <div
                  style={{
                    border: "2px solid #0489B1",
                    height: "60%",
                    width: "35%",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    borderRadius: "10px",
                  }}
                  onClick={() => setCampus("S")}
                >
                  <h4>승학캠퍼스</h4>
                </div>
                <div
                  style={{
                    border: "2px solid #0489B1",
                    height: "60%",
                    width: "35%",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    borderRadius: "10px",
                  }}
                  onClick={() => setCampus("B")}
                >
                  <h4>부민캠퍼스</h4>
                </div>
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
                {campus === "S" ? (
                  <table
                    style={{
                      width: "90%",
                      height: "90%",
                      tableLayout: "fixed",
                    }}
                  >
                    <thead>
                      <tr
                        style={{
                          backgroundColor: "lightgray",
                        }}
                      >
                        <th key={0}>{data.SLLM_name}</th>
                        <th key={1}>{data.SPLM_name}</th>
                        <th key={2}>{data.SSLM_name}</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr style={{ backgroundColor: "skyblue" }}>
                        <th key={0}>
                          {data.SLLM.map((item, _) => (
                            <h5 style={{ padding: 0, margin: 0 }}>{item}</h5>
                          ))}
                        </th>
                        <th key={1}>
                          {data.SPLM.map((item, _) => (
                            <h5 style={{ padding: 0, margin: 0 }}>{item}</h5>
                          ))}
                        </th>
                        <th key={2}>
                          {data.SSLM.map((item, _) => (
                            <h5 style={{ padding: 0, margin: 0 }}>{item}</h5>
                          ))}
                        </th>
                      </tr>
                    </tbody>
                  </table>
                ) : (
                  <table
                    style={{
                      width: "90%",
                      height: "90%",
                      tableLayout: "fixed",
                    }}
                  >
                    <thead>
                      <tr
                        style={{
                          backgroundColor: "lightgray",
                        }}
                      >
                        <th key={0}>{data.BGLM_name}</th>
                        <th key={1}>{data.BTLM_name}</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr style={{ backgroundColor: "skyblue" }}>
                        <th key={0}>
                          {data.BGLM.map((item, _) => (
                            <h5 style={{ padding: 0, margin: 0 }}>{item}</h5>
                          ))}
                        </th>
                        <th key={1}>
                          {data.BTLM.map((item, _) => (
                            <h5 style={{ padding: 0, margin: 0 }}>{item}</h5>
                          ))}
                        </th>
                      </tr>
                    </tbody>
                  </table>
                )}
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

export default Cafeteria;
