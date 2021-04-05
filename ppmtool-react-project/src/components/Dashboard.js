import React, { useEffect } from "react";
import ProjectItem from "./Project/ProjectItem";
import { Container, Row, Col } from "react-bootstrap";
import CreateProjectButton from "./Project/CreateProjectButton";
import { connect } from "react-redux";
import { getProjects } from "../actions/projectActions";
import PropTypes from "prop-types";

function Dashboard(props) {
  useEffect(() => {
    props.getProjects();
  }, []);

  const { projects } = props.project;

  return (
    <div>
      <Container className="container-fluid">
        <Row>
          <Col className="col-md-12">
            <h1 className="display-4 text-center">Projects</h1>
            <br />
            <CreateProjectButton />
            <br />
            <hr />
            {projects.map(project => (
              <ProjectItem key={project.id} project={project} />
            ))}
          </Col>
        </Row>
      </Container>
    </div>
  );
}

Dashboard.propTypes = {
  project: PropTypes.object.isRequired,
  getProjects: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  project: state.project
});

export default connect(mapStateToProps, { getProjects })(Dashboard);
