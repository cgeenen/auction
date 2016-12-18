/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.web;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Cornee
 */
public class server {

    private static final String HTTP = "http://localhost:1337/";

    public static void main(String[] args) {
        Endpoint.publish(HTTP + "auction", new Auction());
        Endpoint.publish(HTTP + "registration", new Registration());
    }
}
