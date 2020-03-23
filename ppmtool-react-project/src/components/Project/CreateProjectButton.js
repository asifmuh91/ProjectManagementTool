import React from "react";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";

const CreateProjectButton = () => {
  return (
    <>
      <Link to="/addProject">
        <Button className="btn btn-lg btn-info">Create a Project</Button>
      </Link>
    </>
  );
};

export default CreateProjectButton;
