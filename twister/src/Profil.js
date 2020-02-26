import React, { Component } from 'react';
import { MDBContainer, MDBRow, MDBCol, MDBCard, MDBCardBody, MDBMask, MDBIcon, MDBView, MDBBtn } from "mdbreact";
import ListMessage from './ListMessage';

   class Profil extends Component {
    constructor (props){

      super(props);
      this.state={messages:[{login:"hanane",message:"hy there "},{login:"liticia",message:"hy there "},{login:"maya",message:"hy there "},{login:"lisa",message:"hy there "}]};
    }
  
    render() {
      return (
      <MDBCard>
      <MDBCardBody>
      <MDBRow >
        <MDBCol md="12">
            <MDBCard reverse>
              <MDBCardBody cascade className="text-center">
                <img
                  className="rounded-circle "
                  src="https://mdbootstrap.com/img/Photos/Avatars/img%20(20).jpg"
                  alt=""
                  width="150 em" 
                  height="150 em"
                />
                <h6 className="font-weight-bold ">
                  <a>{this.props.login}</a>
                </h6>
                <p>
                  
                  <a href="#!">
                    <strong>{this.props.nom} {this.props.prenom}</strong>
                  </a>
                  
                </p>
                <MDBBtn className="btn-fb brown lighten-2">
                  <MDBIcon fab icon="facebook-f" className="pr-2" />
                  Facebook
                </MDBBtn>
                
                <MDBBtn className="btn-tw brown lighten-2">
                  <MDBIcon fab icon="twitter" className="pr-2" />
                  Twitter
                </MDBBtn>
                
                <MDBBtn className="btn-gplus brown lighten-2">
                  <MDBIcon fab icon="google-plus-g" className="pr-2" />
                  Google
                </MDBBtn>
                
                <MDBBtn color=" brown lighten-2" className="waves-light">
                  <MDBIcon icon="comments" className="pr-2" />
                  Message
                </MDBBtn>
                
              </MDBCardBody>
            </MDBCard>
            <MDBContainer className="mt-5">
            <MDBRow>
             <MDBCol md="12">
            <ListMessage 
                messages={this.state.messages}
             />
             </MDBCol>
            </MDBRow>
            </MDBContainer>
          </MDBCol>
        </MDBRow>
        <hr className="mb-5 mt-2" />
        
      </MDBCardBody>
    </MDBCard>
    );
    }
  }

export default Profil;