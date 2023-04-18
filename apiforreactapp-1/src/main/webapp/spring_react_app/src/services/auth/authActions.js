import { LOGIN_REQUEST,LOGOUT_REQUEST, SUCCESS, FAILURE } from "./authType";
import axios  from 'axios';
export const authenticateUser = (email, password) => {

    const credentials={
        email:email,
        password:password
    };
  return dispatch => {
    dispatch(
   {
       type: LOGIN_REQUEST
     });
     axios.post("http://localhost:8081/user/authenticate",credentials)
     .then(response =>{
            let token=response.data.token;
            localStorage.setItem('jwtToken',token)
            dispatch(success(true));
     }).catch((error)=>{

        dispatch(failure());
     });
    if (email == "test" && password == "test") {
      dispatch(success(true));
    } else {
      dispatch(failure(false));
    }
  };
};


export const logoutUser=()=>{
  return dispatch=>{
    dispatch({
                    type: LOGIN_REQUEST
                  });
    localStorage.removeItem('jwtToken');
    dispatch(success(false));
  };
};

const success = isLoggedIn => {
  return {
    type: SUCCESS,
    payload:isLoggedIn,
  };
};

const failure = isLoggedIn => {
  return {
    type: FAILURE,
    payload:isLoggedIn,
  };
};
