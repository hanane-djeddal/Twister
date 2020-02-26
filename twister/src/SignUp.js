import React, { Component } from 'react';
import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBCard, MDBInput, MDBCardBody } from 'mdbreact';
import "./SignUp.css"
class SignUp extends Component {
  constructor (props){
    super(props);
  }
  
  render() {
    return (
      <MDBContainer >
        <MDBRow className="d-flex justify-content-center align-items-center" > 
           <MDBCol md="6" xl="5">
           <MDBCard id="classic-card">
            <MDBCardBody className="z-depth-2 white-text">
            	<form>
                <p className="h5 text-center mb-4">Inscription</p>
                  <div className="white-text">
                    <MDBInput
                      label="Nom"
                      group
                      type="text"
                      validate
                      error="wrong"
                      success="right"
                      />
                      <MDBInput
                      label="Prenom"
                      group
                      type="text"
                      validate
                      error="wrong"
                      success="right"
                      />
                      <MDBInput
                      label="Login"
                      group
                      type="text"
                      validate
                      error="wrong"
                      success="right"
                      />
                      <MDBInput
                      type="password"
                      rows="2"
                      label="Mot de passe"
                      />
                      </div>
                      <div className="text-center mb-3 col-md-12">
                  <MDBBtn
                    color=" brown lighten-2"
                    rounded
                    type="button"
                    className="btn-block z-depth-1"
                  >
                    Sign in
                  </MDBBtn>
                </div>
                      </form>
                      </MDBCardBody>
                      </MDBCard>
                    </MDBCol>
                  </MDBRow>
              </MDBContainer>
    );
  }
}

export default SignUp;
