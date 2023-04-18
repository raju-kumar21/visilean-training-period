import * as BT from "./bookTypes";

const initialState={
    language:'',
    book:'',
    error:''
};

export const bookReducer=(state=initialState,action)=>{
    switch(action.type){
        case BT.SAVE_BOOK_REQUEST:
        case BT.FETCH_BOOK_REQUEST:
        case BT.UPDATE_BOOK_REQUEST:
        case BT.DELETE_BOOK_REQUEST:
        case BT.FETCH_LANGUAGE_REQUEST:
            return{
                ...state
            };
        case BT.BOOK_SUCCESS:
            return{
                   
                    book: action.payload,
                    error: ''
            };
        case BT.BOOK_FAILURE:
            return{
                book: '',
                error:action.payload
            };
       case BT.LANGUAGE_SUCCESS:
            return{
                   
                    language: action.payload,
                    error: ''
            };
        case BT.LANGUAGE_FAILURE:
            return{
                language: '',
                error:action.payload
            };
        default:return {state};
    }
}