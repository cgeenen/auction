package auction.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

@Entity
public class Bid implements Serializable {

    private FontysTime time;
    @OneToOne
    private User buyer;
    private Money amount;
    @OneToOne
    @JoinColumn(nullable=false)
    private Item item;
    @Id
    @GeneratedValue
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
