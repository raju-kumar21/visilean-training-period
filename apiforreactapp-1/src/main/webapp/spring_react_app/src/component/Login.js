import React, { useState } from "react";
import {
  Alert,
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
import { connect } from "react-redux";
import { authenticateUser } from "../services/";
import { BsFillEnvelopeAtFill, BsFillShieldLockFill, BsPersonVcardFill } from "react-icons/bs";
import { AiFillGooglePlusCircle } from "react-icons/ai";
import { FaSignInAlt } from "react-icons/fa";
import { useNavigate} from "react-router-dom";


const LoginUser = (props) => {


  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error,setError]=useState("");
  

  const userLogin=()=>{
   
  props.authenticateUser(email,password);
  
    setTimeout(()=>{
     
      if(props.auth.isLoggedIn)
      {
         return navigate("/");
      }else{
       
        setEmail("");
        setPassword("");
        setError("Invalid email and password");
      }
    },500)
  }
  return (
    <Container style={{}}>
          {error && <Alert style={{marginTop:'20%'}} variant="danger">{error}</Alert>}
          <Card className={"bg-dark text-white text-center"} style={{marginTop:'20%',width:'70%'}} >
            <Card.Header style={{fontWeight:'bolder'}} >
            <FaSignInAlt /> Login
            </Card.Header>
            <Card.Body>
            <Row  >
            <Col lg={6} className="p-2" >
            <Form.Group>
              <InputGroup>
                <InputGroup.Text >
                  {" "}
                  <BsFillEnvelopeAtFill />
                </InputGroup.Text>

                <FormControl
                  required
                  autoComplete="off"
                  onChange={(e) => setEmail(e.target.value)}
                  type="text"
                  name="email"
                  value={email}
                  bg="dark"
                 
                  placeholder="Enter your Email..."
                />
              </InputGroup>
            </Form.Group>
            </Col><Col className="p-2" lg={6}>
            <Form.Group>
              <InputGroup>
                <InputGroup.Text>
                  {" "}
                  <BsFillShieldLockFill />{" "}
                </InputGroup.Text>

                <FormControl
                  required
                  autoComplete="off"
                  onChange={(e) => setPassword(e.target.value)}
                  type="text"
                  name="password"
                  value={password}
        
                  placeholder="Enter your password..."
                />
              </InputGroup>
            </Form.Group>
            </Col> </Row>
             
            </Card.Body>
            <Card.Footer>
            <ButtonGroup className="m-3 ">
              <Button disabled={email.length==0 || password.length==0}  onClick={userLogin} variant="outline-success" className="m-1">
                Login
              </Button>
              <Button disabled={email.length==0 && password.length==0}  onClick={()=>{setEmail(''),setPassword('')}} variant="outline-info" className="m-1">
                Reset
              </Button>
            </ButtonGroup>
            </Card.Footer>
          </Card>
       
    </Container>
  );
};

const mapStateToProps = state =>{
      return{
        auth:state.auth
      }

}

const mapDispatchToProps = dispatch =>{
  return{
    authenticateUser:(email,password) =>{dispatch(authenticateUser(email,password))}
  }
}

 
export default connect (mapStateToProps,mapDispatchToProps)(LoginUser);
