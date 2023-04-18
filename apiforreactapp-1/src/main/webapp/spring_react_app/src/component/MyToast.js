import React from 'react';
import Toast from 'react-bootstrap/Toast';


const MyToast=()=>{

const toastCss={
         marginTop:'50px',
         zIndex:'1',
         position:'fixed',
         top:'60px',
         right:'10px',
         transition: '5s',
         boxShadow:'0 4px 8px 0 rgba(0,0,0) '
}


    return(

                <div style={toastCss}>
                    <Toast className={"border border-success bg-success text-white"} >
                        <Toast.Header closeButton={false } className={"bg-success text-white"}>
                                <strong className="mr-auto">Success</strong>
                        </Toast.Header>
                        <Toast.Body>
                                Book  SAVE Successfully.

                        </Toast.Body>

                    </Toast>


                </div>

    );

}


export default MyToast;