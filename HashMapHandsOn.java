import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class HashMapHandsOn {

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product eBike1 = new Product("E-Bike", "A bike with a battery");
        System.out.println("Shallow Compare " + (eBike == eBike1));
        System.out.println("Deep Compare " + (eBike.equals(eBike1)));

        Product eBike2 = new Product("E-Bike", "A bike with a battery");

        System.out.println("productsByName " + productsByName.get("E-Bike"));
        Product roadBike = new Product("Road bike", "A bike for competition");
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);
        productsByName.merge(eBike.getName(), eBike2, (old, newV) -> old);
        // Iterating over a HashMap
        for (String name : productsByName.keySet()) {
            System.out.println(name + " " + productsByName.get(name));
        }
        // we can iterate over the set of all entries:
        for (Map.Entry<String, Product> entry : productsByName.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        productsByName.forEach((k, v) -> System.out.println("k " + k + " v " + v));
    }
}

@Getter
@Setter
@AllArgsConstructor
class Product {

    private String name;
    private String description;
    private List<String> tags = new ArrayList<>();

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
//        tags.add("abc");
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Product addTagsOfOtherProduct(Product product) {
        this.tags.addAll(product.getTags());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name.equals(product.name) && description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}