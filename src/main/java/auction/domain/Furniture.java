package auction.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Furniture extends Item implements Serializable {

    private String material;

    public Furniture(User seller, Category category, String description, String material) {
        super(seller, category, description);
        this.material = material;
    }

    public Furniture() {
    }
}
