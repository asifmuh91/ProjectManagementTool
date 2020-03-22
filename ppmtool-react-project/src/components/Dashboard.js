import React from "react";
import ProjectItem from "./Project/ProjectItem";
import { Container, Navbar, Button, Row, Col } from "react-bootstrap";
import Header from "./Layout/Header";

function Dashboard() {
  return (
    <div>
      <Container className="container-fluid">
        <row>
          <Col className="col-md-12">
            <h1 className="display-4 text-center">Projects</h1>
            <br />
            <Button className="btn btn-lg btn-info">Create a Project</Button>
            <br />
            <ProjectItem />
          </Col>
        </row>
      </Container>
    </div>
  );
}

export default Dashboard;
