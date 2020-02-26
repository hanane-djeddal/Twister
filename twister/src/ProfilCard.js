import React, { Component } from 'react';
import {  MDBRow,  MDBCard, MDBCardBody, MDBIcon, MDBCol, MDBCardImage, MDBView, MDBMask, MDBCardTitle, MDBCardText} from "mdbreact";

class ProfilCard extends Component {
  constructor (props){
    super(props);
  }
  render () {
  return (
    <MDBRow>
      <MDBCol md="12">
          <MDBCard personal className="mb-md-0 mb-4">
            <MDBView hover>
              <MDBCardImage
                top
                src="https://mdbootstrap.com/img/Photos/Avatars/img%20(26).jpg"
                alt="MDBCard image cap"
              />
              <a href="#!" onClick={this.props.profil}>
                <MDBMask overlay="white-slight" />
              </a>
            </MDBView>
            <MDBCardBody>
              <a href="#!">
                <MDBCardTitle>{this.props.user_login}</MDBCardTitle>
              </a>
              <hr />
              <a href="#!" className="card-meta">
                <span>
                  <MDBIcon icon="user" />
                  {this.props.friendsNum} Friends
                </span>
              </a>
              <p className="card-meta float-right">Joined in {this.props.annee}</p>
            </MDBCardBody>
          </MDBCard>
          </MDBCol>
          </MDBRow>
  );
  }
}

export default ProfilCard;