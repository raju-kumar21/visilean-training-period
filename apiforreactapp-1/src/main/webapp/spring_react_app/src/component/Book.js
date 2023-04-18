import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useParams, useLocation } from "react-router-dom";
import { connect } from "react-redux";
import {
  saveBook,
  fetchBook,
  updateBook,
  fetchLanguages,
} from "../services/index";
//import  BiBookAdd  from 'react-icons/BiBookAdd';
import {
  BiBookAdd,
  BiSave,
  BiReset,
  BiListUl,
  BiEditAlt,
} from "react-icons/bi";
import { Card, Form, Button, Row, Col, Alert } from "react-bootstrap";
import MyToast from "./MyToast";
import axios from "axios";
const Book = (props) => {
  const [sn, setSn] = useState();
  const [show, setShow] = useState(false);
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [isbnNumber, setIsbnNumber] = useState("");
  const [coverPhotoURL, setCoverPhotoURL] = useState("");
  const [price, setPrice] = useState("");
  const [language, setLanguage] = useState("");
  const [languages, setLanguages] = useState([]);
  const [bookError, setBookError] = useState(false);
  const [errormsg, setErrormsg] = useState([]);
  const navigate = useNavigate();
  const params = useParams();
  const location = useLocation();
  useEffect(() => {
    findAllLnaguage()
    const bookId = params.id;

    if (bookId) {
      findBookById(bookId);
    }
    
  }, []);
  function findAllLnaguage() {
    props.fetchLanguages();
    setTimeout(() => {
      let bookLanguage = props.bookObject.language;
      alert("Language "+bookLanguage);
      if (bookLanguage) {
        setLanguages(
          [{ value: "", display: "select Language" }].concat(
            bookLanguage.map((items) => {
              return { value: items, display: items };
            })
          )
        );
      }else{
        alert("Language not found");
      }
    }, 100);
    // axios.get("http://localhost:8080/Book/language").then(response=>response.data).then((data)=>{

    // })
  }
  const findBookById = (bookId) => {
    props.fetchBook(bookId);

    setTimeout(() => {
      let bookData = props.bookObject.book;
      if (bookData != null) {
        setSn(bookData.s_no);
        setTitle(bookData.title);
        setAuthor(bookData.author);
        setIsbnNumber(bookData.isbnNumber);
        setCoverPhotoURL(bookData.coverPhotoURL);
        setPrice(bookData.price);
        setLanguage(bookData.language);
      }
    }, 1000);

    /*axios
                  .get(`http://localhost:8080/Book/findBookById/${bookId}`)
                  .then((response) => {
                    if (response.data != null) {
                      setSn(response.data.s_no);
                      setTitle(response.data.title);
                      setAuthor(response.data.author);
                      setIsbnNumber(response.data.isbnNumber);
                      setCoverPhotoURL(response.data.coverPhotoURL);
                      setPrice(response.data.price);
                      setLanguage(response.data.language);
                      //                                    if(location.pathname===`/edit/${bookId}`)
                      //                                   {
                      //                                        setHeading("Edit")
                      //                                   }
                    }
                  });*/
  };

  function onSubmit(e) {
    e.preventDefault();

    const book = {
      s_no: sn,
      title: title,
      author: author,
      coverPhotoURL: coverPhotoURL,
      isbnNumber: isbnNumber,
      price: price,
      language: language,
    };
    props.saveBook(book);

    if (props.bookObject.book != null && props.bookObject.book != " ") {
      setShow(true);
      setShow(false);
      navigate("/list");
      onReset();

      alert("Book Saved Successfully");
    } else {
      setBookError(true);
      setErrormsg(props.bookObject.error);
    }

    // axios
    //   .post("http://localhost:8080/Book/saveBook", book)
    //   .then((response) => {
    //     if (response.data != null) {
    //       setShow(true);
    //       setTimeout(() => setShow(false), 3000);
    //       setTimeout(() => navigate("/list"), 3000);
    //       setSn(null);
    //       setTitle("");
    //       setAuthor("");
    //       setIsbnNumber("");
    //       setCoverPhotoURL("");
    //       setPrice("");
    //       setLanguage("");

    //       //                       alert("Book Saved Successfully")
    //     }
    //   })
    //   .catch(() => alert("Error in POST"));
  }
  const onReset = () => {
    setSn("");
    setTitle("");
    setAuthor("");
    setIsbnNumber("");
    setCoverPhotoURL("");
    setPrice("");
    setLanguage("");
  };

  const updateBook = (e) => {
    e.preventDefault();
    let books = {
      s_no: sn,
      title: title,
      author: author,
      coverPhotoURL: coverPhotoURL,
      isbnNumber: isbnNumber,
      price: price,
      language: language,
    };
    props.updateBook(books);
    if (props.bookObject.book != null) {
      onReset();
      setShow(true);
      setShow(false);
      navigate("/list");
      //                      alert("Book Saved Successfully")
    }
    // axios
    //   .put("http://localhost:8080/Book/updateBook", books)
    //   .then((response) => {
    //     if (response.data != null) {

    //       onReset();
    //       setShow(true);
    //       setShow(false);
    //        navigate("/list");
    //       //                       alert("Book Saved Successfully")
    //     }
    //   })
    //   .catch(() => alert("Error in PUT"));
  };

  return (
    <React.Fragment>
      {bookError ? (
        <Alert style={{ marginTop: "20%" }} variant="danger">
          {" "}
          {errormsg.message}
        </Alert>
      ) : (
        <div>
          <div style={{ display: show ? "block" : "none" }}>
            <MyToast />
          </div>

          <Card
            style={{ borderRadius: "5px", boxShadow: "5px -1px 20px black" }}
            className={"border m-5 border-dark bg-dark text-white"}
          >
            <Form
              onReset={onReset}
              onSubmit={location.pathname === `/add` ? onSubmit : updateBook}
              id="bookFormId"
            >
              <Card.Body>
                <Card.Title className="text-center m-3 pb-5">
                  {location.pathname === `/add` ? <BiBookAdd /> : <BiEditAlt />}{" "}
                  <span style={{ borderBottom: "2px solid red" }}>
                    {location.pathname === `/add` ? "Add" : "Edit"} Book{" "}
                  </span>
                </Card.Title>
                <Row>
                  <Col lg={6}>
                    <Form.Group className="mb-3" controlId="formGridTitle">
                      <Form.Label>S.No.</Form.Label>
                      <Form.Control
                        required
                        className="bg-dark text-white"
                        type="number"
                        min="0"
                        readOnly={location.pathname === `/add` ? false : true}
                        value={sn}
                        onChange={(e) => setSn(e.target.value)}
                        name="s_no"
                        placeholder="Enter Book S_No."
                      />
                    </Form.Group>
                  </Col>
                  <Col lg={6}>
                    <Form.Group className="mb-3" controlId="formGridTitle">
                      <Form.Label>Title</Form.Label>
                      <Form.Control
                        required
                        className="bg-dark text-white"
                        type="text"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        name="title"
                        placeholder="Enter Book Title"
                      />
                    </Form.Group>
                  </Col>
                  <Col lg={6}>
                    <Form.Group className="mb-3" controlId="formGridAuthor">
                      <Form.Label>Author</Form.Label>
                      <Form.Control
                        required
                        className="bg-dark text-white"
                        type="text"
                        value={author}
                        onChange={(e) => setAuthor(e.target.value)}
                        name="author"
                        placeholder="Enter Author Name"
                      />
                    </Form.Group>
                  </Col>
                  <Col lg={6}>
                    <Form.Group
                      className="mb-3"
                      controlId="formGridCoverPhotoURL"
                    >
                      <Form.Label>Cover Photo URL</Form.Label>
                      <Form.Control
                        required
                        className="bg-dark text-white"
                        type="text"
                        value={coverPhotoURL}
                        onChange={(e) => setCoverPhotoURL(e.target.value)}
                        name="coverPhotoURL"
                        placeholder="Enter Book Cover Photo URL"
                      />
                    </Form.Group>
                  </Col>
                  <Col lg={6}>
                    <Form.Group className="mb-3" controlId="formGridIsbnNumber">
                      <Form.Label>ISBN Number</Form.Label>
                      <Form.Control
                        required
                        className="bg-dark text-white"
                        type="text"
                        value={isbnNumber}
                        onChange={(e) => setIsbnNumber(e.target.value)}
                        name="isbnNumber"
                        placeholder="Enter ISBN Number"
                      />
                    </Form.Group>
                  </Col>
                  <Col lg={6}>
                    <Form.Group className="mb-3" controlId="formGridPrice">
                      <Form.Label>Price</Form.Label>
                      <Form.Control
                        required
                        className="bg-dark text-white"
                        type="text"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                        name="price"
                        placeholder="Enter Price"
                      />
                    </Form.Group>
                  </Col>
                  <Col lg={6}>
                    <Form.Group className="mb-3" controlId="formGridLanguage">
                      <Form.Label>Book Language</Form.Label>
                      <Form.Control
                        required
                        as="select"
                        custom
                        onChange={(e) => setLanguage(e.target.value)}
                        name="language"
                        value={language}
                        className="bg-dark text-white"
                      >
                        {languages.map((item) => (
                          <option key={item.value} value={item.value}>
                            {item.display}
                          </option>
                        ))}
                      </Form.Control>
                    </Form.Group>
                  </Col>
                </Row>
              </Card.Body>
              <Card.Footer className="text-center">
                <Button
                  disabled={
                    sn == "" ||
                    title == "" ||
                    author == "" ||
                    coverPhotoURL == "" ||
                    isbnNumber == "" ||
                    price == "" ||
                    language == ""
                      ? true
                      : false
                  }
                  variant="success"
                  className="m-2"
                  type="submit"
                >
                  <BiSave /> {location.pathname !== `/add` ? "Update" : "Save"}
                </Button>
                <Button variant="info" className="m-2" type="reset">
                  <BiReset /> Reset
                </Button>
                <Button
                  variant="info"
                  className="m-2"
                  type="button"
                  onClick={() => {
                    navigate("/list");
                  }}
                >
                  <BiListUl /> Book List
                </Button>
              </Card.Footer>
            </Form>
          </Card>
        </div>
      )}
    </React.Fragment>
  );
};

const mapStateToProps = (state) => {
  return {
    saveBookObject: state.book,
    bookObject: state.book,
    updateBookObject: state.book,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    saveBook: (book) => dispatch(saveBook(book)),
    fetchBook: (bookId) => dispatch(fetchBook(bookId)),
    updateBook: (book) => dispatch(updateBook(book)),
    fetchLanguages:()=> dispatch(fetchLanguages())
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Book);
