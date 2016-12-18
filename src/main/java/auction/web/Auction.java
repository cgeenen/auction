/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.web;

import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.AuctionMgr;
import auction.service.SellerMgr;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import nl.fontys.util.Money;

/**
 *
 * @author Jules
 */
@WebService
public class Auction {
    
    
    private EntityManager em;
    private AuctionMgr auctionMgr;
    private SellerMgr sellerMgr;
    
    public Auction(){
        auctionMgr = new AuctionMgr();
        sellerMgr = new SellerMgr();
    }
    
    public Item getItem(long id) {
        return auctionMgr.getItem(id);
    }
    
    public List<Item> findItemByDescription(String description){
        return auctionMgr.findItemByDescription(description);
    }
    
    public Bid newBid(Item item, User buyer, Money amount){
        return auctionMgr.newBid(item, buyer, amount);
    }
    
    public Item offerItem(User seller, Category category, String description){
        return sellerMgr.offerItem(seller, category, description);
    }
    
    public boolean revokeItem(Item item){
        return sellerMgr.revokeItem(item);
    }
}
