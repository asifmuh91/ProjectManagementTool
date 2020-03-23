import React from "react";
import ProjectItem from "./Project/ProjectItem";
import { Container, Row, Col } from "react-bootstrap";
import CreateProjectButton from "./Project/CreateProjectButton";

function Dashboard() {
  return (
    <div>
      <Container className="container-fluid">
        <Row>
          <Col className="col-md-12">
            <h1 className="display-4 text-center">Projects</h1>
            <br />
            <CreateProjectButton />
            <br />
            <ProjectItem />
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default Dashboard;
