import java.util.Objects;

public class PackedPieceProduct extends Product implements Package{
private int n;
private PieceProduct pieceProduct;
private PackageOfProduct pack;

public PackedPieceProduct(int n, PieceProduct pieceProduct, PackageOfProduct pack){
    super(pieceProduct.getName(), pieceProduct.getDescription());
    if(n <= 0){
        throw new IllegalArgumentException("Введен некорректный размер");
    }
    this.n = n;
    if(pieceProduct == null){
        throw new IllegalArgumentException("Нет штучного товара");
    }
    this.pieceProduct = pieceProduct;
    if(pack == null){
        throw new IllegalArgumentException("Нет упаковки");
    }
    this.pack = pack;
}

public int getNumber(){
    return n;
}

public void setNumber(){
    if(n <= 0){
        throw new IllegalArgumentException("Введен некорректный размер");
    }
    this.n = n;
}

public PieceProduct getPieceProduct() {
    return pieceProduct;
}

public void setPieceProduct(PieceProduct pieceProduct){
    if(pieceProduct == null){
        throw new IllegalArgumentException("Нет штучного товара");
    }
    this.pieceProduct = pieceProduct;
}

public PackageOfProduct getPackageOfProduct() {
    return pack;
}

public String getDescription(){
    return pieceProduct.getDescription();
}

public void setPackageOfProduct(PackageOfProduct pack){
    if(pack == null){
        throw new IllegalArgumentException("Нет упаковки");
    }
    this.pack = pack;
}

public double getBruttoWeight(){
    return this.getNettoWeight() + this.pack.getWeight();
}

public double getNettoWeight(){
    return this.n * this.pieceProduct.getWeight();
}

public String getName() {
    return pieceProduct.getName();
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackedPieceProduct that = (PackedPieceProduct) o;
        return n == that.n && Objects.equals(pieceProduct, that.pieceProduct) && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, pieceProduct, pack);
    }

    @Override
    public String toString() {
        return "PackedPieceProduct{" +
                "n=" + n +
                ", pieceProduct=" + pieceProduct +
                ", pack=" + pack +
                '}';
    }
}
