import React from "react";
import { Container, Col, Row, ListGroup } from "react-bootstrap";
import { Link } from "react-router-dom";
import DeleteProject from "./DeleteProject";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteProject } from "../../actions/projectActions";

function ProjectItem(props) {
  const onDeleteClick = id => {
    props.deleteProject(id);
  };
  return (
    <div>
      <Container className="card card-body bg-light mb-3">
        <Row>
          <Col className="col-2">
            <span className="mx-auto">{props.project.projectIdentifier} </span>
          </Col>
          <Col className="col-lg-6 col-md-4 col-8">
            <h3>{props.project.projectName}</h3>
            <p>{props.project.description}</p>
          </Col>
          <Col className="col-md-4">
            <ListGroup>
              <ListGroup.Item
                action
                variant="success"
                className="fa fa-flag-checkered pr-1"
              >
                {"  "}
                Project Board
              </ListGroup.Item>
            </ListGroup>
            <ListGroup>
              <Link to={`/updateProject/${props.project.projectIdentifier}`}>
                <ListGroup.Item
                  action
                  variant="warning"
                  className="fa fa-edit pr-1"
                >
                  {"  "}
                  Update Project
                </ListGroup.Item>
              </Link>
            </ListGroup>
            <ListGroup>
              <ListGroup.Item
                action
                variant="danger"
                className="fa fa-minus-circle pr-1"
                onClick={() => onDeleteClick(props.project.projectIdentifier)}
              >
                {"  "}
                Delete Project
              </ListGroup.Item>
            </ListGroup>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

ProjectItem.propTypes = {
  deleteProject: PropTypes.func.isRequired
};

export default connect(null, { deleteProject })(ProjectItem);
