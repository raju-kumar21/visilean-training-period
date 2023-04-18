import React, { Component } from 'react';
import logo from './logo.svg';
import {Container,Row,Col} from 'react-bootstrap';
import {
  BrowserRouter,
  BrowserRouter as Router,
  Route,
  Routes,
  Link,
  Outlet,
} from "react-router-dom";


import { Provider } from 'react-redux';
import Welcome from './component/Welcome';
import BookList from './component/BookList';
import Book from './component/Book';

import Footer from './component/Footer';

import NavigationBar from './component/NavigationBar';
import UserList from './component/UserList';
import Register from './component/Register';
import LoginUser from './component/Login';

class App extends Component {

  render() {
    return (
      <BrowserRouter>
          <NavigationBar/>

                <Container>
                     <Row>
                        <Col style={{marginTop:'30px'}}>
                             <Routes>      
                              <Route path="/userlist"   element={<UserList />}/>

                                <Route path="/" exact  element={<Welcome />}/>
                                <Route path="/add"   element={<Book  />}/>
                                <Route path="/edit/:id" element={<Book  />}/>
                                <Route path="/list"   element={<BookList />}/>
                         
                                <Route path="/register"   element={<Register/>}  />
                                <Route path="/login" element={<LoginUser/>}  />
                                <Route path="/logout"  element={<LoginUser/>}  />

                              </Routes>
                        </Col>
                    </Row>
                </Container>
                <Footer/>
         </BrowserRouter>

    );
  }
}

export default App;


/**
 
React And Spring Boot : Create Login flow using React and Redux? 
React And Spring Boot: Integrate JWT for Authentication & Authorization using Spring Security?

 */