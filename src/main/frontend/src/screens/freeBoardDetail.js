import { Link, useLocation } from "react-router-dom";

function FreeBoardDetail() {
  let location = useLocation();
  let state = location.state;
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
          <h2>{state.title}</h2>
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
                {state.createdAt.slice(0, 10)}
              </h4>
            </div>
            <div
              style={{
                display: "flex",
                justifyContent: "flex-start",
                flex: 10,
                flexDirection: "column",
                width: "90%",
                flexWrap: "wrap",
              }}
            >
              {state.content}
            </div>
          </div>
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
