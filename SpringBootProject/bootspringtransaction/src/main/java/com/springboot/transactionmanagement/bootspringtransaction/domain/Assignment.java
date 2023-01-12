package com.springboot.transactionmanagement.bootspringtransaction.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long assignment_id;

    private String assignmentName;

    @ManyToOne( cascade = CascadeType.ALL,optional=false)
    // @JoinColumn(name = "assignment", referencedColumnName ="user_id")
    @JoinColumn(name = "user_id")
    private User userDetail;





    public Assignment() {
    }

    

    public Assignment(Long assignment_id, String assignmentName, User userDetail) {
        this.assignment_id = assignment_id;
        this.assignmentName = assignmentName;
        this.userDetail = userDetail;
    }



    

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }



    public User getUserDetail() {
        return userDetail;
    }



    public void setUserDetail(User userDetail) {
        this.userDetail = userDetail;
    }



    public Long getAssignment_id() {
        return assignment_id;
    }



    public void setAssignment_id(Long assignment_id) {
        this.assignment_id = assignment_id;
    }

    


}
