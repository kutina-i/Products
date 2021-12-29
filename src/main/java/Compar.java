import java.util.Comparator;

public class Compar implements Comparator<Product> {
    public int compare(Product product1, Product product2){
       if(product1.getName().compareToIgnoreCase(product2.getName()) == 0){
           return product1.getDescription().compareToIgnoreCase(product2.getDescription());
       }
        return product1.getName().compareToIgnoreCase(product2.getName());
    }

}
