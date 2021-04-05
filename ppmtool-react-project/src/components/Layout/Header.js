import React from "react";
import { Navbar, Nav, Button, NavItem } from "react-bootstrap";
function Header() {
  return (
    <>
      <Navbar collapseOnSelect bg="dark" variant="dark">
        <Navbar.Brand>Project Management Service</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="/Dashboard">Dashboard</Nav.Link>
          </Nav>
        </Navbar.Collapse>
        <NavItem>
          <Button className="button-big">Sign-up</Button>
          <Button className="btn-light">Login</Button>
        </NavItem>
      </Navbar>
    </>
  );
}

export default Header;
