import React, { useState } from "react";
import {
  Button,
  ButtonGroup,
  Card,
  Col,
  Container,
  Form,
  FormControl,
  InputGroup,
  Row,
} from "react-bootstrap";
import { BsFillPersonPlusFill } from "react-icons/bs";
import { FaGooglePlusSquare, FaLock, FaPhone, FaUserAlt, FaUserLock } from "react-icons/fa";

const Register = () => {

const[name,setName]=useState('');
const[eamil,setEmail]=useState('');
const[password,setPasswor]=useState('');
const[mobile,setMobile]=useState('');

const saveUser = () => {

    alert(name+" "+eamil+" "+password+" "+mobile)

};
  const resetRegisterForm = () => {
    setName('');
    setEmail('');
    setMobile('');
    setPasswor('');


  };
  

  return (
    <div>
      {/* <div style={{ display: show ? "block" : "none" }}>
          <MyToast show={show} message={message} type={"success"} />
        </div> */}
     
          <Card style={{marginTop:'20%',fontWeight:'bolder' ,width:'90%'}} className={"border border-dark bg-dark text-center text-white"}>
            <Card.Header><BsFillPersonPlusFill/> Register</Card.Header>
            <Card.Body>
            <Row className="justify-content-md-center m-2">
            <Col lg={3}>
                <Form.Group className="m-2" >
                  <InputGroup>
                    <InputGroup.Text><FaUserAlt/></InputGroup.Text>

                    <FormControl
                      
                      type="text"
                      name="name"
                      value={name}
                      onChange={(e)=>setName(e.target.value)}
                      className={"bg-dark text-white"}
                      placeholder="Enter Name"
                    />
                  </InputGroup>
                </Form.Group>
            </Col> <Col lg={3}>
                <Form.Group className="m-2"  >
                  <InputGroup>
                    <InputGroup.Text><FaGooglePlusSquare/></InputGroup.Text>

                    <FormControl
                      required
                      
                      type="text"
                      name="email"
                      value={eamil}
                      onChange={(e)=>setEmail(e.target.value)}
                      className={"bg-dark text-white"}
                      placeholder="Enter Email Address"
                    />
                  </InputGroup>
                </Form.Group>
                </Col> <Col>
                <Form.Group className="m-2" >
                  <InputGroup>
                    <InputGroup.Text><FaLock/></InputGroup.Text>

                    <FormControl
                      required
                      
                      type="password"
                      name="password"
                      value={password}
                      onChange={(e)=>setPasswor(e.target.value)}
                      className={"bg-dark text-white"}
                      placeholder="Enter Password"
                    />
                  </InputGroup>
                </Form.Group>
                </Col> <Col lg={3}>
                <Form.Group className="m-2"  >
                  <InputGroup>
                    <InputGroup.Text><FaPhone/></InputGroup.Text>

                    <FormControl
                      
                      type="text"
                      name="mobile"
                      value={mobile}
                      onChange={(e)=>setMobile(e.target.value)}
                      className={"bg-dark text-white"}
                      placeholder="Enter Mobile Number"
                    />
                  </InputGroup>
                </Form.Group>
                </Col> 
                </Row>
            </Card.Body>
            <Card.Footer style={{ textAlign: "center" }}>
              <Button  disabled={eamil.length == 0 || password.length == 0}
                size="sm"
                type="button"
                variant="success"
                onClick={saveUser}
              >
                Register
              </Button>{" "}
              <Button
                size="sm"
                type="button"
                variant="info"
                onClick={resetRegisterForm}
              >
                Reset
              </Button>
            </Card.Footer>
          </Card>
    
    </div>
  );
};

export default Register;
