package auction.service;

import auction.dao.ItemDAOJPAImpl;
import auction.domain.Category;
import auction.domain.Furniture;
import auction.domain.Item;
import auction.domain.Painting;
import auction.domain.User;

public class SellerMgr {

    private ItemDAOJPAImpl IDAO;

    public SellerMgr() {
        IDAO = new ItemDAOJPAImpl();
    }

    /**
     * @param seller
     * @param cat
     * @param description
     * @return het item aangeboden door seller, behorende tot de categorie cat
     * en met de beschrijving description
     */
    public Item offerItem(User seller, Category cat, String description) {
        Item item = new Item(seller, cat, description);
        IDAO.create(item);
        return item;
    }

    /**
     * @param item
     * @return true als er nog niet geboden is op het item. Het item word
     * verwijderd. false als er al geboden was op het item.
     */
    public boolean revokeItem(Item item) {
        Item rItem = IDAO.find(item.getId());
        if (rItem.getHighestBid() == null) {
            IDAO.remove(item);

            return true;
        }
        return false;
    }

    public Item offerFurniture(User seller, Category cat, String desc, String material) {
        Furniture furniture = new Furniture(seller, cat, desc, material);
        IDAO.create(furniture);
        seller.addItemToUser(furniture);
        return furniture;
    }

    public Item offerPainting(User seller, Category cat, String desc, String title, String painter) {
        Painting painting = new Painting(seller, cat, desc, title, painter);
        IDAO.create(painting);
        seller.addItemToUser(painting);
        return painting;
    }
}
