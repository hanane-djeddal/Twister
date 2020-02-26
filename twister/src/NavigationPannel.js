import React, { Component } from 'react';
import { MDBNavbar, MDBNavbarBrand,MDBFormInline,MDBNavItem, MDBNavbarNav, MDBNavbarToggler, MDBCollapse, MDBContainer} from 'mdbreact';
import { BrowserRouter as Router } from 'react-router-dom';
import Logout from './Logout';
import Login from './Login';

class NavigationPannel extends Component {
  constructor (props){
    super(props);
    this.state = {
      collapse: false,
      isWideEnough: false,
    };
    this.onClick = this.onClick.bind(this);
  }

  onClick() {
    this.setState({
      collapse: !this.state.collapse,
    });
  }
  
  render() {
    const navStyle = { margin: "0rem" };
    return (
      <Router>
        <div>
            <MDBNavbar style={navStyle} color=" brown lighten-3" fixed="top" dark expand="md" scrolling transparent>
              <MDBNavbarBrand href="/" className="blue-grey-text m-0 p-0 mt-3">
                <h3>Twister</h3>
              </MDBNavbarBrand>
              {!this.state.isWideEnough && <MDBNavbarToggler onClick={this.onClick} />}
              <MDBCollapse isOpen={this.state.collapse} navbar>
              {this.props.isConnected === "true"? 
              <MDBNavbarNav left>
                    <MDBNavItem>
                      <MDBFormInline waves>
                        <div className="md-form my-1">
                          <input
                            className="form-control ml-3 mr-sm-1.5 p-1.5"
                            size="sm"
                            type="text"
                            placeholder="Search"
                            aria-label="Search"
                          />
                        </div>
                      </MDBFormInline>
                    </MDBNavItem>
                  </MDBNavbarNav> : ""}
                <MDBNavbarNav right>
                {this.props.isConnected === "false"? <Login login= {this.props.login}/> : 
                <Logout logout={this.props.logout}/> }
                </MDBNavbarNav>
              </MDBCollapse>
            </MDBNavbar>
           </div>
      </Router>
    );
  }
}

export default NavigationPannel;
