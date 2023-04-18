import { combineReducers } from "redux";
import { bookReducer } from "./book/bookReducer";
import  authReducer  from "./auth/authReducer";
import userReducer from "./user/userReducer";


const rootReducers=combineReducers({
    user:userReducer,
    book:bookReducer,
    auth:authReducer
});

export default rootReducers;