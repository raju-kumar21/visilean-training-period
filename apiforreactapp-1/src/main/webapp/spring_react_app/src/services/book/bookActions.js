import * as BT from "./bookTypes";
import axios from "axios";

export const saveBook = (book) => {
  return (dispatch) => {
    dispatch({ type: BT.SAVE_BOOK_REQUEST });
    axios
      .post("http://localhost:8080/Book/saveBook", book)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

export const fetchBook = (bookId) => {
  return (dispatch) => {
    dispatch({ type: BT.FETCH_BOOK_REQUEST });
    axios
      .get(`http://localhost:8080/Book/findBookById/${bookId}`)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

export const updateBook = (book) => {
  return (dispatch) => {
    dispatch({
      type: BT.UPDATE_BOOK_REQUEST,
    });
    axios
      .put("http://localhost:8080/Book/updateBook", book)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

export const deleteBook = (bookId) => {
  return (dispatch) => {
    dispatch({
      type: BT.DELETE_BOOK_REQUEST,
    });
    axios
      .delete(`http://localhost:8080/Book/deleteById/${bookId}`)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

const bookSuccess = book => {
  // alert("bookSuccess"+book.s_no)
  return {
    type: BT.BOOK_SUCCESS,
    payload: book,
  };
};

const bookFailure = error => {
  return {
    type: BT.BOOK_FAILURE,
    payload: error,
  };
};


export const fetchLanguages =()=>{
    return dispatch =>{
        dispatch({
            type:BT.FETCH_LANGUAGE_REQUEST
        });
        axios.get("http://localhost:8080/Book/language")
        .then(response=>{
            dispatch({
                type:BT.LANGUAGE_SUCCESS,
                payload:response.data
            })
        }).catch(error=>{
            dispatch({
                type:BT.LANGUAGE_FAILURE,
                payload:error
            })
        });
    }
}