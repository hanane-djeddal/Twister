import React, { Component } from 'react';
import {MDBBtn, MDBCol} from 'mdbreact';

class Logout extends Component {
  constructor (props){
    super(props);
  }

  render() {
    return (
      <MDBCol md="1">
    <MDBBtn 
      size="sm"
      color=" brown lighten-2"
      className="my-1 mx-0 p-2"
      type="submit">Logout</MDBBtn>
      </MDBCol>
    );
  }
}

export default Logout;
