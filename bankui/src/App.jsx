import { useState } from "react";
import "./App.css";
import Header from "./Components/Header";
import Balance from "./Components/Balance";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div>
      {/* <Header /> */}
      <Balance />
    </div>
  );
}

export default App;
