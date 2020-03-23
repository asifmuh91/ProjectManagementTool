import React from "react";
import { Container, Row, Col, Form, Button } from "react-bootstrap";
import useCreateProjectForm from "./CreateProjectHook";

function AddProject() {
  const { inputs, handleInputChange, handleSubmit } = useCreateProjectForm();
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
                  placeholder="Project Name"
                  size="lg"
                  name="projectName"
                  value={inputs.projectName}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Control
                  type="text"
                  placeholder="Unique Project ID"
                  size="lg"
                  name="projectIdentifier"
                  value={inputs.projectIdentifier}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Control
                  as="textarea"
                  placeholder="Project Description"
                  size="lg"
                  name="description"
                  value={inputs.description}
                  onChange={handleInputChange}
                />
              </Form.Group>
              <Form.Group>
                <Form.Label>Start Date</Form.Label>
                <Form.Control
                  type="date"
                  size="lg"
                  name="start_date"
                  value={inputs.start_date}
                  onChange={handleInputChange}
                ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Label>End Date</Form.Label>
                <Form.Control
                  type="date"
                  size="lg"
                  name="end_date"
                  value={inputs.end_date}
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

export default AddProject;
