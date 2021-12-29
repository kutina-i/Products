import java.lang.reflect.Array;
import java.util.Arrays;

public class ComparatorToDemo {

public static void sortProducts(Product[] products){
    Arrays.sort(products,new Compar());
}
}
