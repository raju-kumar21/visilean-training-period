 import React, { Component } from "react";

 import {gantt} from 'dhtmlx-gantt';

 import 'dhtmlx-gantt/codebase/dhtmlxgantt.css';

//  import './Gantt.css';

 export default class Gantt extends Component{
    componentDidMount(){
        const {tasks} =this.props;
        gantt.init(this.ganttContainer);
        gantt.parse(tasks);
    }

    render(){
        return(
            <div
              ref={(input)=>{this.ganttContainer=input}}
              style={{width:'100%',height:'100%'}}>
                
              </div>
        )
    }
 }