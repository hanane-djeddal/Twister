import React, { Component } from 'react';
import { MDBContainer, MDBMask, MDBView,MDBCol, MDBRow } from 'mdbreact';
import ListFriend from "./ListFriend";


class Test2 extends Component {
  constructor (props){

    super(props);
    this.state={friends:[{nom:"hane",prenom:"doea"},{nom:"Jane",prenom:"doe"},{nom:"Lala",prenom:"Jane"},{nom:"Elizabeth",prenom:"Banks"}]};
  }
  render(){
  return (
      <div>
        <MDBContainer className="m-1">
        <MDBRow><MDBCol md="6">
             <ListFriend 
                friends={this.state.friends}
             />
             </MDBCol></MDBRow>
             </MDBContainer>
      </div>
    
  );
  }
}

export default Test2;

