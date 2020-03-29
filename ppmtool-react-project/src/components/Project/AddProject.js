import React, { useState, useEffect } from "react";
import { Container, Row, Col, Form, Button } from "react-bootstrap";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createProject } from "../../actions/projectActions";
import classnames from "classnames";

function AddProject(props) {
  const [inputs, setInputs] = useState({});
  const [errors, setErrors] = useState({});

  const handleSubmit = event => {
    if (event) {
      event.preventDefault();
    }
    props.createProject(inputs, props.history);
  };
  const handleInputChange = event => {
    event.persist();
    setInputs(inputs => ({
      ...inputs,
      [event.target.name]: event.target.value
    }));
  };

  useEffect(() => {
    if (props.errors) {
      setErrors(props.errors);
    }
  }, [props]);

  return (
    <div>
      <Container>
        <Row>
          <Col className="col-md-8 m-auto">
            <h6 className="display-4 text center">
              {" "}
              Create / Edit Project form
            </h6>
            <Form onSubmit={handleSubmit}>
              <Form.Group>
                <Form.Control
                  type="text"
                  className={classnames("form-control form-control-lg", {
                    "is-invalid": errors.projectName
                  })}
                  placeholder="Project Name"
                  size="lg"
                  name="projectName"
                  value={inputs.projectName}
                  onChange={handleInputChange}
                ></Form.Control>
                {errors.projectName && (
                  <div className="invalid-feedback">{errors.projectName}</div>
                )}
              </Form.Group>
              <Form.Group>
                <Form.Control
                  type="text"
                  className={classnames("form-control form-control-lg", {
                    "is-invalid": errors.projectIdentifier
                  })}
                  placeholder="Unique Project ID"
                  size="lg"
                  name="projectIdentifier"
                  value={inputs.projectIdentifier}
                  onChange={handleInputChange}
                ></Form.Control>
                {errors.projectIdentifier && (
                  <div className="invalid-feedback">
                    {errors.projectIdentifier}
                  </div>
                )}
              </Form.Group>
              <Form.Group>
                <Form.Control
                  as="textarea"
                  className={classnames("form-control form-control-lg", {
                    "is-invalid": errors.description
                  })}
                  placeholder="Project Description"
                  size="lg"
                  name="description"
                  value={inputs.description}
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
                  value={inputs.startDate}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Label>End Date</Form.Label>
                <Form.Control
                  type="date"
                  size="lg"
                  name="endDate"
                  value={inputs.endDate}
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

AddProject.propTypes = {
  createProject: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(mapStateToProps, { createProject })(AddProject);
