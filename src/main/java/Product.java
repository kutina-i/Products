import java.util.Objects;

public class Product {
    private String name;
    private String description;

    public Product(String name, String description){
        if(name == null){
            throw new IllegalArgumentException("Не введено название");
        }
        this.name = name;
        if(description == null){
            throw new IllegalArgumentException("Не введено описание");
        }
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        if(name == null){
            throw new IllegalArgumentException("Не введено название");
        }
        this.name = name;
    }

    public void setDescription(String description){
        if(description == null){
            throw new IllegalArgumentException("Не введено описание");
        }
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
