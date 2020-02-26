import React, { Component } from 'react';
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBBtn,
  MDBInput
} from "mdbreact";
import "./Login.css"
class Login extends Component {
  constructor (props){
    super(props);
    this.state={nom:"",prenom:"",user_login:"", user_password:""};
    this.changedLogin = this.changedLogin.bind(this);
    this.changedPW = this.changedPW.bind(this);
  }
  changedLogin(event){
    this.setState({user_login: event.target.value});
  }
  changedPW(event){
    this.setState({user_password: event.target.value});
  }
render(){
  return (
    <MDBContainer >
      <MDBRow>
        <MDBCol md="5.9" className="px-0.5">
          <form>
            <div className="logIn"> 
              <div className="item">
                <MDBCol md="8">
                  <MDBInput
                  onChange={this.changedLogin}
                  className="m-0 p-1.5"
                  size="sm"
                  label="Username"
                  group
                  type="email"
                  validate
                  error="wrong"
                  />
                </MDBCol>
               </div>
             
              <div className="item">
                <MDBCol md="8">
                  <MDBInput
                  onChange={this.changedPW}
                  className="m-0 p-1.5"
                  size="sm"
                  label="Mot de passe"
                  group
                  type="password"
                  validate
                  error="wrong"
                  />
                </MDBCol>
              </div>
              <div className="item">
                <MDBCol md="1">
                  <MDBBtn 
                  onClick={()=>this.props.login(this.state.nom,this.state.prenom,this.state.user_login)}
                  size="sm"
                  color=" brown lighten-2"
                  className="mb-3 mx-0 p-1.5"
                  type="submit">Login</MDBBtn>
                </MDBCol>
              </div>
            </div>
          </form>  
        </MDBCol>  
      </MDBRow>
    </MDBContainer>
  );
}
}

export default Login;