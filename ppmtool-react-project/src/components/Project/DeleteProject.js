import { confirmAlert } from "react-confirm-alert"; // Import
import "react-confirm-alert/src/react-confirm-alert.css";
import { deleteProject } from "../../actions/projectActions";
import { connect } from "react-redux";
import PropTypes from "prop-types";

function DeleteProject(props) {
  if (props.project === undefined) {
  } else {
    confirmAlert({
      title: "Confirm to submit",
      message:
        "Are you sure to Delete Project with ID " +
        `${props.project.projectIdentifier}`,
      closeOnClickOutside: true,
      buttons: [
        {
          label: "Yes",
          onClick: () => {
            deleteProject(props.project.projectIdentifier, props.history);
          }
        },
        {
          label: "No",
          onClick: () => {}
        }
      ]
    });
  }
}

export default DeleteProject;
