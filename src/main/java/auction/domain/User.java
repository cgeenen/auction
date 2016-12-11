package auction.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "User.count", query = "select count(u) from User as u"),
    @NamedQuery(name = "User.email", query = "select u from User as u where u.email = :email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "Item")
    private Set<Item> offeredItems;
    private String email;

    public User() {
        this.offeredItems = new HashSet<>();
    }

    public User(String email) {
        this.email = email;
        this.offeredItems = new HashSet<>();
    }

    public int numberOfOfferdItems() {
        return offeredItems.size();
    }

    protected void addItem(Item item) {
        if (item != null) {
            offeredItems.add(item);
        }
    }

    public Iterator<Item> getOfferedItems() {
        return offeredItems.iterator();
    }

    public void setOfferedItems(Set<Item> offeredItems) {
        this.offeredItems = offeredItems;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
