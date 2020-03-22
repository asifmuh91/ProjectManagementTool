import React from "react";
import { Container, Col, Row, ListGroup, ListGroupItem } from "react-bootstrap";

function ProjectItem() {
  return (
    <div>
      <Container className="card card-body bg-light mb-3">
        <Row>
          <Col className="col-2">
            <span className="mx-auto">REACT </span>
          </Col>
          <Col className="col-lg-6 col-md-4 col-8">
            <h3>Spring / React Love it</h3>
            <p>Create a Kanban board with Spring</p>
          </Col>
          <Col className="col-md-4">
            <ListGroup>
              <ListGroup.Item
                action
                variant="success"
                className="fa fa-flag-checkered pr-1"
              >
                {" "}
                Project Board
              </ListGroup.Item>
              <ListGroup.Item
                action
                variant="warning"
                className="fa fa-edit pr-1"
              >
                {" "}
                Update Project
              </ListGroup.Item>
              <ListGroup.Item
                action
                variant="danger"
                className="fa fa-minus-circle pr-1"
              >
                {" "}
                Delete Project
              </ListGroup.Item>
            </ListGroup>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default ProjectItem;
