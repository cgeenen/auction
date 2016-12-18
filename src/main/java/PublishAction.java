
import auction.web.Auction;
import auction.web.Registration;
import javax.xml.ws.Endpoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jules
 */
public class PublishAction {
    
    private static final String url = "http://localhost:8081";

    public static void main(String[] args) {
        Endpoint.publish(url + "/Registration", new Registration());
        Endpoint.publish(url + "/Auction", new Auction());
    }
}
