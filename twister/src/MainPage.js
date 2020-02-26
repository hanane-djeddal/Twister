import React, { Component } from 'react';
import { MDBContainer, MDBMask, MDBView,MDBCol, MDBRow } from 'mdbreact';
import NavigationPannel from './NavigationPannel';
import SignUp from './SignUp';

import Message from './Message';
import Profil from './Profil';
import "./MainPage.css"
import HomePage from "./HomePage.js";

class MainPage extends Component {
  constructor (props){
    super(props);
    this.state={page_courante:"connexion", isConnected:"false", collapseID: "",nom:"nnnn",prenom:"nnnnn",login:"nnnn"};
    this.getConnected = this.getConnected.bind(this);
    this.setLogout = this.setLogout.bind(this);
    this.setProfil = this.setProfil.bind(this);
    this.getInfo = this.getInfo.bind(this);
    
  }
  getConnected(nom1,prenom1,login1) {
    this.setState({login:login1,prenom:prenom1,nom:nom1,page_courante:"HomePage",isConnected:"true"}); 
  }
  setLogout() {
    this.setState({page_courante:"connexion",isConnected:"false"});
  }
  setProfil () {
    this.setState({page_courante:"Profil",isConnected:"true"}); 
  }
  toggleCollapse = collapseID => () =>
    this.setState(prevState => ({
      collapseID: prevState.collapseID !== collapseID ? collapseID : ""
  }));
  getInfo(nom1,prenom1,login1){
    this.setState({login:login1,prenom:prenom1,nom:nom1,page_courante:"HomePage",isConnected:"true"});  
  }
  render() {
    /*var affichage_courant = (this.page_courante == "HomePage")?
    <HomePage user_login={this.state.login} friendsNum="5" annee="2019" profil={this.setProfil}/> :
    <Profil login={this.state.login} nom={this.state.nom} prenom={this.state.prenom}></Profil>;*/
    return (
      <div id="mainpage">
      <NavigationPannel login={this.getConnected} logout={this.setLogout} isConnected={this.state.isConnected}/>
      <div id="container">
      {
       (this.state.page_courante==="connexion" && this.state.isConnected==="false")?
       <SignUp getInfo={this.getInfo} />:
       <HomePage user_login={this.state.login} friendsNum="5" annee="2019" profil={this.setProfil}/>
      }
      </div>
      </div>
    );
  }
    
    
  
}

export default MainPage;