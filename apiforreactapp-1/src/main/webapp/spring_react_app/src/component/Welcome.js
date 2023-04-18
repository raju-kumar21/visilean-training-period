import React from 'react';
import {Button,Col} from 'react-bootstrap';
import GanttApp from './GanttApp';

const Welcome=()=>{
return(
        <React.Fragment>
         <div style={{width:'100%',height:'100%'}}><GanttApp/></div>
        <Col lg={12} style={{marginTop:'60px' ,textAlign:'center'}}>
                            <div className="bg-dark text-white" style={{padding:'10px',borderRadius:'5px',boxShadow:'5px -1px 20px black'}}>
                            {/* <h1 className="text-center">Welcome to Book Store</h1>
                            <blockquote className="blockquote mb-0">
                            <p>Good friends, good books, and a sleepy conscience: this is the ideal life.</p>
                            <footer className="blockquote-footer text-center">
                            Raju Kumar
                            </footer>
                            </blockquote> */}
                          
                    </div>
                         </Col>
    </React.Fragment>
);}


export default Welcome;