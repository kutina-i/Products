import java.util.Objects;

public class PackedWeightProduct extends Product implements Package{
private PackageOfProduct pack;
private WeightProduct weightProduct;
private double weight;

public PackedWeightProduct(PackageOfProduct pack, WeightProduct weightProduct, double weight){
    super(weightProduct.getName(), weightProduct.getDescription());
    if(pack == null){
        throw new IllegalArgumentException("Нет упаковки");
    }
    this.pack = pack;

    if(weightProduct == null){
        throw new IllegalArgumentException("Нет весового товара");
    }
    this.weightProduct = weightProduct;

    if((Double.compare(weight, 0) < 0)||(Double.compare(weight, 0) == 0)){
        throw new IllegalArgumentException("Введен некорректный вес");
    }
    this.weight = weight;

}

    public WeightProduct getWeightProduct() {
        return weightProduct;
    }

    public void setWeightProduct(WeightProduct weightProduct){
        if(weightProduct == null){
            throw new IllegalArgumentException("Нет штучного товара");
        }
        this.weightProduct = weightProduct;
    }

    public PackageOfProduct getPackageOfProduct() {
        return pack;
    }

    public void setPackageOfProduct(PackageOfProduct pack){
        if(pack == null){
            throw new IllegalArgumentException("Нет упаковки");
        }
        this.pack = pack;
    }

    public String getDescription(){
    return weightProduct.getDescription();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight){
        if((Double.compare(weight, 0) < 0)||(Double.compare(weight, 0) == 0)){
            throw new IllegalArgumentException("Введен некорректный вес");
        }
        this.weight = weight;
    }

    public double getBruttoWeight(){
        return this.getNettoWeight() + this.pack.getWeight();
    }

    public double getNettoWeight(){ return this.weight;}

    public String getName() { return weightProduct.getName();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackedWeightProduct that = (PackedWeightProduct) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(pack, that.pack) && Objects.equals(weightProduct, that.weightProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pack, weightProduct, weight);
    }

    @Override
    public String toString() {
        return "PackedWeightProduct{" +
                "pack=" + pack +
                ", weightProduct=" + weightProduct +
                ", weight=" + weight +
                '}';
    }
}
