import java.util.Arrays;
import java.util.Objects;

public class BatchOfProducts{
private String description;
private Package[] batchOfProducts;

public BatchOfProducts(String description, Package [] batchOfProducts){
    if(description == null){
        throw new IllegalArgumentException("Не введено описание");
    }
    this.description = description;

    if(batchOfProducts == null){
        throw new IllegalArgumentException("Отсутствуют упакованные товары");
    }
    this.batchOfProducts = batchOfProducts;

}

public double getBrutto(){
    double sum = 0;
    for(int i = 0; i < batchOfProducts.length; i++){
        sum = sum + batchOfProducts[i].getBruttoWeight();
    }
return sum;
}

public String getDescription(){
        return description;
    }

public void setDescription(String description){
    if(description == null){
        throw new IllegalArgumentException("Не введено описание");
    }
    this.description = description;
}

public Package[] getBatchOfProducts(){
    return batchOfProducts;
}

public Package getProducts(int i){ return batchOfProducts[i]; }

public int getSize(){ return batchOfProducts.length;}

public void setBatchOfProducts(Package[] batchOfProducts){
    if(batchOfProducts == null){
        throw new IllegalArgumentException("Отсутствуют упакованные товары");
    }
    this.batchOfProducts = batchOfProducts;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchOfProducts that = (BatchOfProducts) o;
        return Objects.equals(description, that.description) && Arrays.equals(batchOfProducts, that.batchOfProducts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(description);
        result = 31 * result + Arrays.hashCode(batchOfProducts);
        return result;
    }

    @Override
    public String toString() {
        return "BatchOfProducts{" +
                "description='" + description + '\'' +
                ", batchOfProducts=" + Arrays.toString(batchOfProducts) +
                '}';
    }
}
