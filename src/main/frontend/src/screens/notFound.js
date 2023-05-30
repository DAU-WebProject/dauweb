function NotFound() {
  return (
    <div
      style={{
        display: "flex",
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <div
        style={{
          display: "flex",
          backgroundColor: "white",
          height: 300,
          width: 300,
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        잘못된 주소 입니다.
      </div>
    </div>
  );
}

export default NotFound;
