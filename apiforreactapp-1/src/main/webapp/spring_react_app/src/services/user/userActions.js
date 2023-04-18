import { FETCH_USER_FAILURE,FETCH_USER_SUCCESS , FETCH_USER_REQUEST } from "./userTypes"; 


import axios from "axios";


const fetchUsers=()=>{
    return dispatch =>{
        dispatch(fetchUserRequest());
        axios.get("https://randomapi.com/api/6de6abfedb24f889e0b5f675edc50deb?fmt=raw&sole")
        .then(response=>{
            dispatch(fetchUserSuccess(response.data));
        }).catch(error=>{
                dispatch(fetchUserFailure(error.message));
        });
         
    };

};

const fetchUserRequest=()=>{
    return{
        type:FETCH_USER_REQUEST
    };
};



const fetchUserSuccess=users=>{
    return{
        type:FETCH_USER_SUCCESS,
        payload:users
    };
};


const fetchUserFailure=error=>{
    return{
        type:FETCH_USER_FAILURE,
        payload:error
    };
};

export  {fetchUsers};