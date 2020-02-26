import React, { Component } from 'react';
import {  MDBRow, MDBCol, MDBBtn, MDBCard, MDBAvatar, MDBCardBody, MDBIcon } from "mdbreact";

class Friend extends Component {
    constructor (props){
        super(props);
    }
    render(){
  return (
    <MDBRow className="text-md-left">
    <MDBCol md="12" className="my-3">
      <MDBCol md="2" className="float-left mx-0 px-0">
      <a href="#">
      <img
          src="https://mdbootstrap.com/img/Photos/Avatars/avatar-1-mini.jpg"
          alt=""
          className="mx-0 mb-md-0 mb-4 rounded z-depth-1 img-fluid"
           width="80 em" 
           height="80 em"
      />
    </a>
      </MDBCol>
      <MDBCol md="10" className="float-right">
        <h6 className="font-weight-bold mb-2">{this.props.nom} {this.props.prenom}</h6>
        <MDBBtn 
          size="sm"
          color=" brown lighten-2"
          className="mt-1.5 mx-0 p-1.9"
          >{this.props.isFriend == "true"? "Remove" : "Add"}
          </MDBBtn>
      </MDBCol>
      </MDBCol>
    </MDBRow>
  );
    }
}

export default Friend;