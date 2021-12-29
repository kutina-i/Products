import java.util.Objects;

public class PackageOfProduct {
    private String name;
    private double weight;

    public PackageOfProduct(String name, double weight){
        if(name == null){
            throw new IllegalArgumentException("Не введено название");
        }
        this.name = name;
        if((Double.compare(weight, 0) < 0)||(Double.compare(weight, 0) == 0)){
            throw new IllegalArgumentException("Введен некорректный вес");
        }
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name == null){
            throw new IllegalArgumentException("Не введено название");
        }
        this.name = name;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        if((Double.compare(weight, 0) < 0)||(Double.compare(weight, 0) == 0)){
            throw new IllegalArgumentException("Введен некорректный вес");
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageOfProduct that = (PackageOfProduct) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "PackageOfProduct{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
