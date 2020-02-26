import React, { Component } from 'react';
import { MDBContainer, MDBRow, MDBCol, MDBCard, MDBCardBody, MDBMask, MDBIcon, MDBView, MDBBtn } from "mdbreact";
import ListMessage from './ListMessage';
import Post from './Post';
import ProfilCard from './ProfilCard';

   class HomePage extends Component {
    constructor (props){

      super(props);
      this.state={messages:[{login:"hanane",message:"hy there "},{login:"liticia",message:"hy there "},{login:"maya",message:"hy there "},{login:"lisa",message:"hy there "}]};
    }
  
    render() {
      return (
        <MDBCard className="my-0 px-5 pb-5"
        style={{backgroundColor: "transparent"}}>
      <MDBCardBody>
        <MDBRow>
          <MDBCol md="12">
            <MDBContainer className="mt-5">
            <MDBRow>
            <MDBCol md="4">
            <ProfilCard user_login={this.props.user_login} 
            friendsNum={this.props.friendsNum}
             annee={this.props.annee}
             profil={this.props.profil}
             />
             </MDBCol>
             <MDBCol md="8">
             <Post/>
             <ListMessage 
                messages={this.state.messages}
             />
             </MDBCol>
            </MDBRow>
            </MDBContainer>
          </MDBCol>
        </MDBRow>
        <hr className="mb-5 mt-4" />
        
      </MDBCardBody>
    </MDBCard>
    );
    }
  }

export default HomePage;