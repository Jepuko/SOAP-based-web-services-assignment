package com.example.ws.endpoint;

import com.supply.inventorymanagementservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;


@Endpoint
public class InventoryManagementEndpoint {

//    Sell Product Operation
    @PayloadRoot(
            namespace = "http://supply.com/InventoryManagementService",
            localPart = "sellObject")
   @ResponsePayload
    public SellResponseObject sellObject(@RequestPayload SellObject request) {

        String sellResponseString = "Hey User-"+request.getUserId()+" you sold "+request.getNumberOfProducts()+" products";

        SellResponseObject response= new SellResponseObject();
        response.setSellResponse(sellResponseString);
        return response;
    }

//    Purchase Product Operation
@PayloadRoot(
        namespace = "http://supply.com/InventoryManagementService",
        localPart = "purchaseObject")
@ResponsePayload
public PurchaseResponseObject purchaseObject(@RequestPayload PurchaseObject request) {

    String purchaseResponseString = "Hey User-"+request.getUserId()+" you purchased "+request.getNumberOfProducts()+" products";

    PurchaseResponseObject response= new PurchaseResponseObject();
    response.setPurchaseResponse(purchaseResponseString);
    return response;
}

//    Inventory Request Operation
@PayloadRoot(
        namespace = "http://supply.com/InventoryManagementService",
        localPart = "inventoryRequestObject")
@ResponsePayload
public InventoryResponseObject getCurrentInventory(@RequestPayload InventoryRequestObject request) {

    InventoryResponseObject response= new InventoryResponseObject();
    response.setUserName("user-1234");
    response.setNumberOfProducts(new BigInteger("420"));
    return response;
}
}