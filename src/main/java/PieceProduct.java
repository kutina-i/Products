import java.util.Objects;

public class PieceProduct extends Product{

    private double weight;
     public PieceProduct(String name, String description, double weight){
         super(name, description);
         if((Double.compare(weight, 0) < 0)||(Double.compare(weight, 0) == 0)){
             throw new IllegalArgumentException("Введен некорректный вес");
         }
         this.weight = weight;
     }

     public void setWeight(double weight){
         if((Double.compare(weight, 0) < 0)||(Double.compare(weight, 0) == 0)){
             throw new IllegalArgumentException("Введен некорректный вес");
         }
         this.weight = weight;
     }

     public double getWeight(){
         return weight;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String toString() {
        return "PieceProduct{" +
                "weight=" + weight +
                '}';
    }
}
