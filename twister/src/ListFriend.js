import React from "react";
import { MDBRow, MDBCol, MDBCard, MDBCardBody } from "mdbreact";
import Friend from './Friend';

const ListFriend = ({friends}) => {
   return (
     <MDBCard md="12" className="text-center">
         <MDBCardBody>
            
            { friends.map(friend=>{
                return(<Friend nom={friend.nom} prenom={friend.prenom} isFriend="true" />);
            })}
         </MDBCardBody>
   </MDBCard>
  
  );
}

export default ListFriend;