import React from "react";
import "./App.css";
import DashBoard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import Dashboard from "./components/Dashboard";

function App() {
  return (
    <>
      <Header />
      <Dashboard />
    </>
  );
}

export default App;
