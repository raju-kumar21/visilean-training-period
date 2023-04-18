import React from "react";
import { Alert, Button, Card, FormControl, InputGroup, Table } from "react-bootstrap";
import { BiListUl, BiEditAlt, BiTrash } from "react-icons/bi";
import { useEffect, useState } from "react";
import { connect, Connect } from "react-redux";
import {fetchUsers} from "../services/index";
import axios from "axios";
import { BsFillPersonLinesFill, BsFillSkipBackwardFill, BsFillSkipEndFill, BsFillSkipForwardFill, BsFillSkipStartFill, BsPersonCircle } from "react-icons/bs";
import { Outlet } from "react-router-dom";
import NavigationBar from "./NavigationBar";

const UserList = (props) => {
 
  const [currentPage, setCurrentPage] = useState(1);
  const [usersPerPage, setUsersPerPage] = useState(5);

  useEffect(() => {
    //findAllRandomUsers();
      props.fetchUsers();

  }, []);
  // const findAllRandomUsers = () => {
  //   axios
  //     .get(
  //       "https://randomapi.com/api/6de6abfedb24f889e0b5f675edc50deb?fmt=raw&sole"
  //     )
  //     .then((response) => response.data)
  //     .then((data) => {
  //       setUser(data);
  //     })
  //     .catch(() => {
  //       alert("data not found");
  //     });
  // };
  const userData=props.userData;
  const user=userData.users;
  const lastIndex = currentPage * usersPerPage;
  const firstIndex = lastIndex - usersPerPage;
  const currentUsers = user.slice(firstIndex, lastIndex);
  const totalPages = user.length / usersPerPage;

  const pageNumCss={

    width:'45px',
    border:'1px solid #17A2B8',
    color:'#17A2B8',
    textAlign:'center',
    fontWeight:'bolder'


  };

const firstPage=()=>{
    if(currentPage>1)
    {
        setCurrentPage(1);
    }
}
const prevPage=()=>{
    if(currentPage>1)
    {
        setCurrentPage(currentPage-1);
    }
}
const nextPage=()=>{
    if(currentPage < Math.ceil(user.length/usersPerPage))
    {
        setCurrentPage(currentPage+1);
    }
}
const lastPage=()=>{
    if(currentPage < Math.ceil(user.length/usersPerPage))
    {
        setCurrentPage(Math.ceil(user.length/usersPerPage));
    }
}

  return (
    <React.Fragment>

    <div style={{ marginTop: "7%" }}>

        {userData.error ? <Alert style={{marginTop:'20%'}} variant="danger"> {userData.error}</Alert> : 


      <Card className={"border border-dark bg-dark text-white"}>
        <Card.Header className="text-center">
          <BsFillPersonLinesFill /> User List{" "}
        </Card.Header>
        <Card.Body>
          <Table bordered hover striped variant="dark">
            <thead>
              <tr>
              <th>S No.</th>
                <th>
                  <BsPersonCircle /> Name
                </th>
                
                <th>Email</th>
                <th>Address</th>
                <th>Created</th>
                <th>Balance</th>
              </tr>
            </thead>
            <tbody>
              {currentPage <=0 || currentPage>totalPages ? (
                <tr align="center">
                  <td colSpan="6">No Users Available 📢</td>
                </tr>
              ) : (
                currentUsers.map((data, index) => (
                  <tr key={index}>
                  <td>{index+1}</td>
                    <td>
                      {data.first}
                      {"  "}
                      {data.last}
                    </td>
                    <td>{data.email}</td>
                    <td>{data.address}</td>
                    <td>{data.created}</td>
                    <td>{data.balance}</td>
                  </tr>
                ))
              )}
            </tbody>
          </Table>
        </Card.Body>
        <Card.Footer>
          <div style={{ float: "left" }}>
            Showing Page {currentPage} of {totalPages}
          </div>
          <div style={{ float: "right" }}>
            <InputGroup size="sm">
             
                <Button onClick={firstPage} type="button" variant="outline-info" disabled={currentPage == 1 ? true : false}>
                <BsFillSkipBackwardFill/> First</Button>
                <Button onClick={prevPage} type="button"  variant="outline-info" disabled={currentPage == 1 ? true : false}>
                <BsFillSkipStartFill/> Prev</Button>
           
              <FormControl onChange={(e)=>setCurrentPage(e.target.value)} value={currentPage}  name="currentPage" style={pageNumCss} maxLength='2' className="bg-dark" />
                <Button onClick={nextPage} type="button" variant="outline-info" disabled={currentPage == totalPages ? true : false}>
                <BsFillSkipEndFill/> Next</Button>
                <Button onClick={lastPage} type="button" variant="outline-info" disabled={currentPage == totalPages ? true : false}>
                <BsFillSkipForwardFill/>  Last</Button>
          
            </InputGroup>
          </div>
        </Card.Footer>
      </Card>}
{/* <Outlet /> */}
      {/* <h1>UserList</h1>
                    <Button onClick={findAllRandomUsers} variant="success">Get Users</Button> */}
    </div>
    </React.Fragment>
  );
};


const mapStateToProps=state=>{
  return{
    userData:state.user
  }
};

const mapDispatchToProps=dispatch=>{
  return{
    fetchUsers:()=>dispatch(fetchUsers())
  }
};


export default connect(mapStateToProps,mapDispatchToProps) (UserList);
