import React from 'react'
import { MDBInput, MDBContainer,MDBRow,MDBCol ,MDBBtn   } from 'mdbreact';

const Post = () => {
    return (
        <MDBContainer>
      <MDBRow>
        <MDBCol md="6" className="px-0.5">
          <form>
            <div className="row"> 
              <div className="item">
                <MDBCol md="8">
        <textarea
         placeholder="Exprimez vous..." 
         rows="3" cols="50"></textarea>
                </MDBCol>
              </div>
              <div className="item">
                <MDBCol md="1">
                <MDBBtn 
                  size="sm"
                  color=" brown lighten-2"
                  className="mb-3 mx-0 p-1.5"
                  type="submit">Publier</MDBBtn>
                </MDBCol>
              </div>
              </div>
              </form>
              </MDBCol>
              </MDBRow>
              </MDBContainer>
    )
}

export default Post;