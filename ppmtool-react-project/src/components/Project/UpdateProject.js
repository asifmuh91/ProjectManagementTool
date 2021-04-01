import React, { useState, useEffect } from "react";
import { Container, Row, Col, Form, Button } from "react-bootstrap";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { getProject, createProject } from "../../actions/projectActions";
import classnames from "classnames";

function UpdateProject(props) {
  const [input, setInput] = useState({});
  const [errors, setErrors] = useState({});

  useEffect(() => {
    const { id } = props.match.params;

    props.getProject(id, props.history);
  }, []);

  useEffect(() => {
    if (props.errors) {
      setErrors(props.errors);
    }
    setInput(props.project);
  }, [props]);

  const handleInputChange = (event) => {
    event.persist();
    setInput((inputs) => ({
      ...inputs,
      [event.target.name]: event.target.value,
    }));
  };

  const handleSubmit = (event) => {
    if (event) {
      event.preventDefault();
    }
    props.createProject(input, props.history);
  };

  return (
    <div>
      <Container>
        <Row>
          <Col className="col-md-8 m-auto">
            <h6 className="display-4 text center"> Edit Project form</h6>
            <Form onSubmit={handleSubmit}>
              <Form.Group>
                <Form.Label>Project Name</Form.Label>
                <Form.Control
                  type="text"
                  className={classnames("form-control form-control-lg", {
                    "is-invalid": errors.projectName,
                  })}
                  placeholder="Project Name"
                  size="lg"
                  name="projectName"
                  value={input.projectName}
                  onChange={handleInputChange}
                ></Form.Control>
                {errors.projectName && (
                  <div className="invalid-feedback">{errors.projectName}</div>
                )}
              </Form.Group>
              <Form.Group>
                <Form.Label>Project Identifier</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Unique Project ID"
                  disabled
                  size="lg"
                  name="projectIdentifier"
                  value={input.projectIdentifier}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Label>Project Description</Form.Label>
                <Form.Control
                  as="textarea"
                  className={classnames("form-control form-control-lg", {
                    "is-invalid": errors.description,
                  })}
                  placeholder="Project Description"
                  size="lg"
                  name="description"
                  value={input.description}
                  onChange={handleInputChange}
                />
                {errors.description && (
                  <div className="invalid-feedback">{errors.description}</div>
                )}
              </Form.Group>
              <Form.Group>
                <Form.Label>Start Date</Form.Label>
                <Form.Control
                  type="date"
                  size="lg"
                  name="startDate"
                  value={input.startDate}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Label>End Date</Form.Label>
                <Form.Control
                  type="date"
                  size="lg"
                  name="endDate"
                  value={input.endDate}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Button
                variant="primary"
                type="submit"
                className="btn-block mt-4"
              >
                Submit
              </Button>
            </Form>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

UpdateProject.propTypes = {
  getProject: PropTypes.func.isRequired,
  createProject: PropTypes.func.isRequired,
  project: PropTypes.object.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  project: state.project.project,
  errors: state.errors,
});

export default connect(mapStateToProps, { getProject, createProject })(
  UpdateProject
);
