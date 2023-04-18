import React, { Component } from "react";
import './Gantt.css';

import Gantt from "./Gantt";


const data={
    data:[{id:1,text:'Task #1',start_date:'15-04-2019',duration:3,progress:0.6},
          {id:2,text:'Task #2',start_date:'18-04-2019',duration:3,progress:0.4}
 ],links:[{id:1,source:1,target:2,type:'0'}]
};

export default class GanttApp extends Component{
    render(){
        return(
            <div>
                <div style={{width:'100%',height:'100%'}} >
                    <Gantt tasks={data} />
                </div>
            </div>
        );
    }
}