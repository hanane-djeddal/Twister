import React from "react";
import { MDBRow, MDBCol, MDBCard, MDBCardBody } from "mdbreact";
import Message from './Message';

const ListMessage = ({messages}) => {
   return (<div> 
     <MDBCard
     >
         <MDBCardBody>
            <h5 className="h1-responsive font-weight-bold text-center my-5">
                Posts Recents
            </h5>
            { messages.map(msg=>{
                return(<Message login={msg.login} message={msg.message} />);
            })}
         </MDBCardBody>
   </MDBCard>
    </div>
  );
}

export default ListMessage;