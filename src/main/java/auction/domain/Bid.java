package auction.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

@Entity
public class Bid implements Serializable {

    private FontysTime time;
    private User buyer;
    private Money amount;
    @Id
    private Long id;

    public Bid() {
    }

    public Bid(User buyer, Money amount) {
        //TODO
        this.buyer = buyer;
        this.amount = amount;
    }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
