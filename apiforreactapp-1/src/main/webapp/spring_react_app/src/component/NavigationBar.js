import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { BsFillPersonPlusFill } from "react-icons/bs";
import { Link, NavLink } from "react-router-dom";
import { FaSignInAlt } from "react-icons/fa";
import { Component } from "react";
import { connect } from "react-redux";
import { logoutUser } from "../services"; 
class NavigationBar extends Component {

  logout=()=>{
    this.props.logoutUser();
  }

  render() {
    const guestLinks =  (
    
      <>
        <Nav className="navbar-right me-2 ">
          <Link className="nav-link" to={"/register"}>
            <BsFillPersonPlusFill /> Register
          </Link>
          <Link className="nav-link" to={"/login"}>
            {" "}
            <FaSignInAlt /> Login
          </Link>
        </Nav>
        </>
    );

    const userLinks= (
        <>
          <Nav className="mr-auto">
              <Link className="nav-link" to={"/add"}>Add Book</Link>
              <Link className="nav-link" to={"/list"}>Book List</Link>
              <Link className="nav-link" to={"/"}>Pricing</Link>
              <Link className="nav-link" to={"/userlist"}>Users</Link>
            </Nav>
            <Nav className="navbar-right">
                <Link onClick={this.logout} to={"/login"} className="nav-link" > <FaSignInAlt />Logout</Link>
            </Nav>
            </>
    );
    return (
      <>
         <Navbar  className="bg-dark "> 
         <Link  className="navbar-brand">
         <img
                className="img"
                src="https://miro.medium.com/v2/resize:fit:1400/1*B7M1EIzU5Em5KPh3RM_L3g.gif"
                width="50"
                height="50"
                alt="brand"
              />
              Book Store
         </Link>
            {this.props.auth.isLoggedIn  ? userLinks :guestLinks}
            </Navbar>
      </>
    );
  }
}

const mapStateToProps = state => {
  return {
    auth: state.auth,
  };
};

const mapDispatchToProps = dispatch=>{
  return{
    logoutUser:()=>dispatch(logoutUser())
  }
}



export default  connect(mapStateToProps,mapDispatchToProps) (NavigationBar);
