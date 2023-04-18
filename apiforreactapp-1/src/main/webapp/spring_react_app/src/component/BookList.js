import React from "react";
import {
  Card,
  Table,
  Button,
  Container,
  ButtonGroup,
  Image,
  InputGroup,
  FormControl,
} from "react-bootstrap";
//import { FaAccessibleIcon } from "react-icons/fa";
import { BiListUl, BiEditAlt, BiTrash } from "react-icons/bi";
import "../index.css";
import "./Style.css";
import {connect} from 'react-redux';
import {deleteBook} from "../services/index";
import {
  BsSortNumericDown,
  BsFillPersonFill,
  BsFillPenFill,
  BsFillEaselFill,
  BsCurrencyRupee,
  BsFillBadgeCcFill,
  BsSortNumericUp ,BsFillPersonLinesFill, BsFillSkipBackwardFill, BsFillSkipEndFill, BsFillSkipForwardFill, BsFillSkipStartFill, BsPersonCircle, BsSearch, BsX ,
} from "react-icons/bs";
import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import axios from "axios";

const BookList = (props) => {
  
  const[sortToggle,setSortToggle]=useState(true);
  const [addBook, setAddBook] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [booksPerPage, setBooksPerPage] = useState(5);
  const [totalPage, setTotalPage] = useState();
  const [totalElements, setTotalElements] = useState();
  const[search,setSearch]=useState('');
  useEffect(() => {
    getBooks(currentPage);
  }, []);


  

  function getBooks(currentPage) {
    currentPage -=1;
    const sortDir=sortToggle?"asc":"desc";
    axios
    .get("http://localhost:8080/Book/findBookSort/?pageNumber="+currentPage+"&pageSize="+booksPerPage+"&sortBy=s_no&sortDir="+sortDir)
    .then((response) => response.data)
      .then((data) => {
        
        setAddBook(data.content);
        setTotalPage(data.totalPages);
        setTotalElements(data.totalElements)
        setCurrentPage((data.number)+1);
        
      });
  }

  function getBooksBySort(currentPage) {
    currentPage =1;
   
    axios
      .get("http://localhost:8080/Book/findBookSort/?page="+currentPage+"&size="+booksPerPage+"&sortBy=title&sortDir="+sortDir)
      .then((response) => response.data)
      .then((data) => {
        
        setAddBook(data.content);
        setTotalPage(data.totalPages);
        // alert(data.number+1);
        setTotalElements(data.totalElements)
        setCurrentPage((data.number)+1);
        
      });
  }

  function deleteBook(id) {
      props.deleteBook(id);
      setTimeout(()=>{
        if(props.bookObject !=null){
          getBooks(currentPage);
        }else{
          alert("error in delete")
        }


      },1000)

    // axios
    //   .delete(`http://localhost:8080/Book/deleteById/${id}`)
    //   .then((response) => {
    //     if (response.data != null) {
    //       //                            setAddBook({
    //       //                                 addBook:addBook.filter(addBook=>addBook.id !== id)
    //       //                            });
    //       getBooks(currentPage);
    //     }
    //   })
    //   .catch(() => alert("delete : Error"));
  }

  function sortData(){
  setTimeout(()=>{
 
    setSortToggle(!sortToggle);
    getBooks(currentPage);  
    
  },500)
   

  }


function searchData(currentPage)
{
  currentPage -=1;
    axios.get("http://localhost:8080/Book/findBookSearch/"+search+"?page="+currentPage+"&size="+booksPerPage)
      .then((response) => response.data)
      .then((data) => {
        
        setAddBook(data.content);
        setTotalPage(data.totalPages);

        setTotalElements(data.totalElements)
        setCurrentPage((data.number)+1);
        
      }).catch(()=>{alert("Error in Search")});

}


const firstPage=()=>{
  let firstPage=1;
  if(currentPage>firstPage)
  {
    getBooks(firstPage);
  }
}
const prevPage=()=>{
  let prevPage=1;
  if(currentPage>prevPage)
  {
    getBooks(currentPage-prevPage);
  }
}
const nextPage=()=>{
  if(currentPage < Math.ceil(totalElements/booksPerPage))
  {
      getBooks(currentPage+1);
  }
}
const lastPage=()=>{
  let condition=Math.ceil(totalElements/booksPerPage);
  if(currentPage < condition)
  {
      getBooks(condition);
  }
}

const change=(e)=>{
  let targetPage=e.target.value;
  getBooks(targetPage);
  setCurrentPage(targetPage);

}









  const pageNumCss={

    width:'45px',
    border:'1px solid #17A2B8',
    color:'#17A2B8',
    textAlign:'center',
    fontWeight:'bolder'


  };

 
function clearSearch()
{
  setSearch('');
  getBooks(currentPage);
}




  return (
    <Container className="pt-5">
      <Card
        style={{ borderRadius: "5px" }}
        className={"border mt-5 mb-5 w-100 border-dark bg-dark text-white"}
      >
        <Card.Body
          className=""
          style={{ borderRadius: "5px", boxShadow: "5px -1px 20px black" }}
        >
  
          <Card.Title>
          <div style={{"float":"left"}}><BiListUl /> Book List</div>
          <div style={{"float":"right"}}>
          <InputGroup size="sm">
            <FormControl required="true"  placeholder="Search" name="search" value={search}  onChange={(e)=>setSearch(e.target.value)} className="bg-dark info-border
text-white" />
            <ButtonGroup >
              <Button onClick={searchData} size="sm" variant="outline-success"><BsSearch/></Button>
              <Button onClick={clearSearch}  size="sm" variant="outline-danger"><BsX/></Button>
            </ButtonGroup>
          </InputGroup>
          </div>
          </Card.Title>
          <Table className="w-100" striped bordered hover variant="dark">
            <thead>
              <tr>
                <th>
                  <BsSortNumericDown />
                  S. No.<div onClick={sortData} className={sortToggle ? "arrow arrow-up" :" arrow arrow-down"} ></div>
                </th>
                <th>
                  <BsFillPenFill /> Title
                </th>
                <th >
                  <BsFillPersonFill /> Author
                </th>
                <th>
                  <BsSortNumericUp /> ISBN Number
                </th>
                <th>
                  {" "}
                  <BsCurrencyRupee /> Price
                </th>
                <th>
                  <BsFillBadgeCcFill /> Language
                </th>
                <th colSpan="2">
                  <BsFillEaselFill /> Action
                </th>
              </tr>
            </thead>
            <tbody>
              {addBook.length == 0 ? (
                <tr align="center">
                  <td colSpan="7">No Books Available 😥</td>
                </tr>
              ) : (
                addBook.map((book) => (
                  <tr key={book.s_no}>
                    <td>{book.s_no}</td>
                    <td>
                      <Image
                        src={book.coverPhotoURL}
                        width="60"
                        height="80"
                        className="Image"
                      />{" "}
                      {book.title}
                    </td>
                    <td>{book.author}</td>
                    <td>{book.isbnNumber}</td>
                    <td>{book.price}</td>
                    <td>{book.language}</td>
                    <td>
                      <ButtonGroup>
                        <NavLink
                          to={"/edit/" + book.s_no}
                          className="btn m-1  btn-outline-success"
                        >
                          <BiEditAlt />
                        </NavLink>
                        <Button
                          variant="none"
                          className="m-1  btn-outline-danger"
                          onClick={() => deleteBook(book.s_no)}
                        >
                          <BiTrash />
                        </Button>
                      </ButtonGroup>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </Table>
        </Card.Body>
       
          
          <Card.Footer>
        <div>
          <div style={{ float: "left" }}>
            Showing Page {currentPage} of {totalPage}
          </div>
          <div style={{ float: "right" }}>
          <InputGroup size="sm" disabled='true'>
             
             <Button onClick={firstPage} type="button" variant="outline-info" disabled={currentPage == 1 ? true : false}>
             <BsFillSkipBackwardFill/> First</Button>
             <Button onClick={prevPage} type="button"  variant="outline-info" disabled={currentPage == 1 ? true : false}>
             <BsFillSkipStartFill/> Prev</Button>
        
           <FormControl  onChange={change} value={currentPage}  name="currentPage" style={pageNumCss} maxLength='3' className="bg-dark" />
             <Button onClick={nextPage} type="button" variant="outline-info" disabled={currentPage == totalPage ? true : false}>
             <BsFillSkipEndFill/> Next</Button>
             <Button onClick={lastPage} type="button" variant="outline-info" disabled={currentPage == totalPage ? true : false}>
             <BsFillSkipForwardFill/>  Last</Button>
       
         </InputGroup>
          </div></div>
        </Card.Footer>
      </Card>
    </Container>
  );
};

const mapStateToProps = state =>{
  return{
    bookObject:state.book
  }
}

const mapDispatchToProps = dispatch =>{
  return{
    deleteBook:(bookId)=>dispatch(deleteBook(bookId))
  }
}

export default connect(mapStateToProps,mapDispatchToProps) (BookList);


