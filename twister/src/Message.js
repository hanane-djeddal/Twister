import React, { Component } from 'react';
import { MDBRow, MDBCol,MDBContainer } from "mdbreact";

class Message extends Component {
  constructor (props){
    super(props);
  }
  
  render() {
    return (
      
    <MDBContainer>
      <MDBRow>
      <MDBCol md="1">
          <img
            className="rounded-circle "
            src="https://mdbootstrap.com/img/Photos/Others/images/49.jpg"
            alt=""
            width="40 em" 
            height="40 em"
          />  
      </MDBCol>
      <MDBCol md="5">
        <h6 className="font-weight-bold mb-3 p-0 ">
          <strong>
          <a href="#!" className="font-weight-bold brown-text">{this.props.login}</a>
          </strong>
        </h6>
        <p className="dark-grey-text">
          {this.props.message}
          
        </p>
        <p>
           19/04/2018
        </p>

      </MDBCol>
    </MDBRow>
    <hr className="my-5" />
    </MDBContainer>

     
    );
  }
}

export default Message;


