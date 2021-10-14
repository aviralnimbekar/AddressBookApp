package com.bridgelabz.addressbookapp.constants;

public enum RequestMsg {
    GET_CALL("Get call Successful, All Contacts :"),
    GET_CALL_ID("Get call Successful for id : "),
    POST_CALL("Post call Successful, Created Contact for : "),
    PUT_CALL("Put call Successful, Updated Data for : "),
    DELETE_CALL("Delete call Successful, Deleted Data for : ");

    public final String message;

    RequestMsg(String Message) {
        message = Message;
    }
}
