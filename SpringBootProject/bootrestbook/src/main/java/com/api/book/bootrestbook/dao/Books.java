package com.api.book.bootrestbook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.api.book.bootrestbook.entities.Book;

@XmlRootElement
public class Books extends ArrayList<Book>{

    private static final long serialVersionUID=-325325335535253L;

    public Books()
    {

    }

    @XmlElement
    public List<Book> getBookXML()
    {
        return this;
    }
    
}
