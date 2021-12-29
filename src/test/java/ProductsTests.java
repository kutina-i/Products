import org.junit.Test;
import static org.junit.Assert.*;

public class ProductsTests {
    @Test
    public void PackageOfProductNameTest() {
        String name = "Упаковка стандартная";
        double weight = 15;
        PackageOfProduct a = new PackageOfProduct(name, weight);
        assertEquals(a.getName(), name);
    }

    @Test
    public void PackageOfProductWeightTest() {
        String name = "Упаковка стандартная";
        double weight = 15;
        PackageOfProduct a = new PackageOfProduct(name, weight);
        assertEquals(a.getWeight(), weight, 16);
    }

    @Test
    public void PackageOfProductNameTestErr() {
        String name = null;
        double weight = 15;
        try {
            PackageOfProduct a = new PackageOfProduct(name, weight);
        } catch (IllegalArgumentException err) {
            System.err.println("Не введено название");
        }
    }

    @Test
    public void PackageOfProductWeightTestErr() {
        String name = "Упаковка стандартная";
        double weight = -6;
        try {
            PackageOfProduct a = new PackageOfProduct(name, weight);
        } catch (IllegalArgumentException err) {
            System.err.println("Введен некорректный вес");
        }
    }

    @Test
    public void ProductNameTest() {
        String name = "Яблоки";
        String description = "Не существуют";
        Product a = new Product(name, description);
        assertEquals(a.getName(), name);
    }

    @Test
    public void ProductDescriptionTest() {
        String name = "Яблоки";
        String description = "Не существуют";
        Product a = new Product(name, description);
        assertEquals(a.getDescription(), description);
    }

    @Test
    public void ProductNameTestErr() {
        String name = null;
        String description = "Не существуют";
        try {
            Product a = new Product(name, description);
        } catch (IllegalArgumentException err) {
            System.err.println("Не введено название");
        }
    }

    @Test
    public void ProductDescriptionTestErr() {
        String name = "Яблоки";
        String description = null;
        try {
            Product a = new Product(name, description);
        } catch (IllegalArgumentException err) {
            System.err.println("Не введено описание");
        }
    }

    @Test
    public void WeightProductTest() {
        String name = "Яблоки";
        String description = "Не существуют";
        double weight = 31;
        WeightProduct a = new WeightProduct(name, description, weight);
        assertEquals(a.getWeight(), weight, 17);
    }

    @Test
    public void WeightProductTestErr() {
        String name = "Яблоки";
        String description = "Не существуют";
        double weight = -5;
        try {
            WeightProduct a = new WeightProduct(name, description, weight);
        } catch (IllegalArgumentException err) {
            System.err.println("Введен некорректный вес");
        }
    }

    @Test
    public void PieceProductTest() {
        String name = "Яблоки";
        String description = "Не существуют";
        double weight = 4;
        WeightProduct a = new WeightProduct(name, description, weight);
        assertEquals(a.getWeight(), weight, 17);
    }

    @Test
    public void PieceProductTestErr() {
        String name = "Яблоки";
        String description = "Не существуют";
        double weight = -1;
        try {
            WeightProduct a = new WeightProduct(name, description, weight);
        } catch (IllegalArgumentException err) {
            System.err.println("Введен некорректный вес");
        }
    }

    @Test
    public void PackedWeightProduct_PackageOfProductTest() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = 30;
        PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        assertEquals(a.getPackageOfProduct(), pack);
    }

    @Test
    public void PackedWeightProduct_WeightProductTest() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = 30;
        PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        assertEquals(a.getWeightProduct(), weightProduct);
    }

    @Test
    public void PackedWeightProductWeightTest() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = 30;
        PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        assertEquals(a.getWeight(), weight, 14);
    }

    @Test
    public void PackedWeightProductWeightTestErr() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = -5;
        try {
            PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        } catch (IllegalArgumentException err) {
            System.err.println("Введен некорректный вес");
        }
    }

    @Test
    public void PackedWeightProduct_getNettoWeightTest() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = 30;
        PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        assertEquals(a.getNettoWeight(), weight, 14);
    }

    @Test
    public void PackedWeightProduct_getBruttoWeightTest() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = 30;
        PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        double BruttoWeight = a.getNettoWeight() + pack.getWeight();
        assertEquals(a.getBruttoWeight(), BruttoWeight, 14);
    }

    @Test
    public void PackedWeightProduct_getNameTest() {
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct = new WeightProduct("Яблоки", "Не существуют", 17);
        double weight = 30;
        PackedWeightProduct a = new PackedWeightProduct(pack, weightProduct, weight);
        assertEquals(a.getName(), weightProduct.getName());
    }

    @Test
    public void PackedPieceProduct_PieceProductTest() {
        int n = 5;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        assertEquals(a.getPieceProduct(), pieceProduct);
    }

    @Test
    public void PackedPieceProduct_PackageOfProductTest() {
        int n = 5;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        assertEquals(a.getPackageOfProduct(), pack);
    }

    @Test
    public void PackedPieceProduct_NumberTest() {
        int n = 5;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        assertEquals(a.getNumber(), n);
    }

    @Test
    public void PackedPieceProduct_NumberTestErr() {
        int n = -1;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        try {
            PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        } catch (IllegalArgumentException err) {
            System.err.println("Введен некорректный размер");
        }
    }

    @Test
    public void PackedPieceProduct_BruttoWeightTest() {
        int n = 5;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        double BruttoWeight = a.getNettoWeight() + pack.getWeight();
        assertEquals(a.getBruttoWeight(), BruttoWeight, 7);
    }

    @Test
    public void PackedPieceProduct_NettoWeightTest() {
        int n = 5;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        double NettoWeight = n * pieceProduct.getWeight();
        assertEquals(a.getNettoWeight(), NettoWeight, 7);
    }

    @Test
    public void BatchOfProducts_NameTest() {
        int n = 5;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct = new PieceProduct("Яблоки", "Не существуют", 17);
        PackedPieceProduct a = new PackedPieceProduct(n, pieceProduct, pack);
        assertEquals(a.getName(), pieceProduct.getName());
    }


    @Test
    public void BatchOfProducts_BruttoTest() {

        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Не существуют", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Круглые", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбуз", "Сочный", 35);

        PackedPieceProduct a1 = new PackedPieceProduct(n, pieceProduct1, pack);
        PackedPieceProduct a2 = new PackedPieceProduct(n, pieceProduct2, pack);
        PackedPieceProduct a3 = new PackedPieceProduct(n, pieceProduct3, pack);
        Package[] C = new Package[n];
        C[0] = a1;
        C[1] = a2;
        C[2] = a3;
        BatchOfProducts batch = new BatchOfProducts("Фрукты", C);

        double Brutto = 0;
        for (int i = 0; i < C.length; i++) {
            Brutto = Brutto + C[i].getBruttoWeight();
        }

        assertEquals(batch.getBrutto(), Brutto, 16);
    }

    @Test
    public void BeginStringFilterTest1() {

        String str = "Мама мыла раму";
        BeginStringFilter filter1 = new BeginStringFilter("Мама");

        assertEquals(filter1.apply(str), true);
    }

    @Test
    public void BeginStringFilterTest2() {

        String str = "Мама мыла раму";
        BeginStringFilter filter2 = new BeginStringFilter("мыла");

        assertEquals(filter2.apply(str), false);
    }

    @Test
    public void SearchWordFilterTest1() {

        String str = "Мама мыла раму";
        char a = 'а';
        SearchWordFilter filter1 = new SearchWordFilter(a);

        assertEquals(filter1.apply(str), true);
    }

    @Test
    public void SearchWordFilterTest2() {

        String str = "Мама мыла раму";
        char a = 'в';
        SearchWordFilter filter1 = new SearchWordFilter(a);

        assertEquals(filter1.apply(str), false);
    }

    @Test
    public void CompareLastFilterTest1() {

        String str = "Мама мыла раму";
        char a = 'у';
        CompareLastFilter filter1 = new CompareLastFilter(a);

        assertEquals(filter1.apply(str), true);
    }

    @Test
    public void CompareLastFilterTest2() {

        String str = "Мама мыла раму";
        char a = 'в';
        CompareLastFilter filter1 = new CompareLastFilter(a);

        assertEquals(filter1.apply(str), false);
    }

    @Test
    public void countByFilterTest1() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Не существуют", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Круглые", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбузы", "Сочный", 35);

        PackedPieceProduct a1 = new PackedPieceProduct(n, pieceProduct1, pack);
        PackedPieceProduct a2 = new PackedPieceProduct(n, pieceProduct2, pack);
        PackedPieceProduct a3 = new PackedPieceProduct(n, pieceProduct3, pack);
        Package[] C = new Package[n];
        C[0] = a1;
        C[1] = a2;
        C[2] = a3;
        BatchOfProducts batch = new BatchOfProducts("Фрукты", C);
        char a = 'ы';
        CompareLastFilter filter1 = new CompareLastFilter(a);
        ServiceOfProducts S = new ServiceOfProducts();

        assertEquals(S.countByFilter(batch, filter1), 2);
    }

    @Test
    public void countByFilterDeepTest1() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Не существуют", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Круглые", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбузы", "Сочный", 35);

        PackedPieceProduct a1 = new PackedPieceProduct(n, pieceProduct1, pack);
        PackedPieceProduct a2 = new PackedPieceProduct(n, pieceProduct2, pack);
        PackedPieceProduct a3 = new PackedPieceProduct(n, pieceProduct3, pack);
        Package[] C = new Package[n];
        C[0] = a1;
        C[1] = a2;
        C[2] = a3;
        BatchOfProducts batch = new BatchOfProducts("Фрукты", C);
        char a = 'и';
        CompareLastFilter filter1 = new CompareLastFilter(a);
        ServiceOfProducts S = new ServiceOfProducts();

        assertEquals(S.countByFilterDeep(batch, filter1), true);
    }

    @Test
    public void countByFilterDeepTest2() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Не существуют", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Круглые", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбузы", "Сочный", 35);

        PackedPieceProduct a1 = new PackedPieceProduct(n, pieceProduct1, pack);
        PackedPieceProduct a2 = new PackedPieceProduct(n, pieceProduct2, pack);
        PackedPieceProduct a3 = new PackedPieceProduct(n, pieceProduct3, pack);
        Package[] C = new Package[n];
        C[0] = a1;
        C[1] = a2;
        C[2] = a3;
        BatchOfProducts batch = new BatchOfProducts("Фрукты", C);
        char a = 'а';
        CompareLastFilter filter1 = new CompareLastFilter(a);
        ServiceOfProducts S = new ServiceOfProducts();

        assertEquals(S.countByFilterDeep(batch, filter1), false);
    }

    @Test
    public void checkAllWeightedTest1() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Весовой", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Круглые", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбузы", "Весовой", 35);

        PackedPieceProduct a1 = new PackedPieceProduct(n, pieceProduct1, pack);
        PackedPieceProduct a2 = new PackedPieceProduct(n, pieceProduct2, pack);
        PackedPieceProduct a3 = new PackedPieceProduct(n, pieceProduct3, pack);
        Package[] C = new Package[n];
        C[0] = a1;
        C[1] = a2;
        C[2] = a3;
        BatchOfProducts batch = new BatchOfProducts("Фрукты", C);
        ServiceOfProducts S = new ServiceOfProducts();

        assertEquals(S.checkAllWeighted(batch), false);
    }

    @Test
    public void checkAllWeightedTest2() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Весовой", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Весовой", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбузы", "Весовой", 35);

        PackedPieceProduct a1 = new PackedPieceProduct(n, pieceProduct1, pack);
        PackedPieceProduct a2 = new PackedPieceProduct(n, pieceProduct2, pack);
        PackedPieceProduct a3 = new PackedPieceProduct(n, pieceProduct3, pack);
        Package[] C = new Package[n];
        C[0] = a1;
        C[1] = a2;
        C[2] = a3;
        BatchOfProducts batch = new BatchOfProducts("Фрукты", C);
        ServiceOfProducts S = new ServiceOfProducts();

        assertEquals(S.checkAllWeighted(batch), true);
    }

    @Test
    public void ComparatorToDemoTest01() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        PieceProduct pieceProduct1 = new PieceProduct("Яблоки", "Весовой", 17);
        PieceProduct pieceProduct2 = new PieceProduct("Апельсины", "Круглые", 21);
        PieceProduct pieceProduct3 = new PieceProduct("Арбузы", "Весовой", 35);
        PackedPieceProduct[] products = {
                new PackedPieceProduct(n, pieceProduct1, pack),
                new PackedPieceProduct(n, pieceProduct2, pack),
                new PackedPieceProduct(n, pieceProduct3, pack),
        };

        PackedPieceProduct[] sorted =  {
                new PackedPieceProduct(n, pieceProduct2, pack),
                new PackedPieceProduct(n, pieceProduct3, pack),
                 new PackedPieceProduct(n, pieceProduct1, pack),
        };
        ComparatorToDemo.sortProducts(products);
        assertArrayEquals(products, sorted);

    }

    @Test
    public void ComparatorToDemoTest02() {
        int n = 3;
        PackageOfProduct pack = new PackageOfProduct("Упаковка стандартная", 15);
        WeightProduct weightProduct1 = new WeightProduct("Яблоки", "Красные", 17);
        WeightProduct weightProduct2 = new WeightProduct("Апельсины", "Круглые", 21);
        WeightProduct weightProduct3 = new WeightProduct("Арбузы", "Сочный", 35);
        PackedWeightProduct[] products = {
                new PackedWeightProduct(pack, weightProduct1, 2),
                new PackedWeightProduct(pack, weightProduct2, 6),
                new PackedWeightProduct(pack, weightProduct3, 1),
        };

        PackedWeightProduct[] sorted =  {
                new PackedWeightProduct(pack, weightProduct2, 6),
                new PackedWeightProduct(pack, weightProduct3, 1),
                new PackedWeightProduct(pack, weightProduct1, 2),
        };
        ComparatorToDemo.sortProducts(products);
        assertArrayEquals(products, sorted);

    }

    @Test
    public void ComparatorToDemoTest1() {
        Product[] products = {
               new WeightProduct("Яблоки", "Красные", 17),
               new WeightProduct("Апельсины", "Круглые", 21),
               new WeightProduct("Арбузы", "Сочный", 35),
        };

        Product[] sorted =  {
                new WeightProduct("Апельсины", "Круглые", 21),
                new WeightProduct("Арбузы", "Сочный", 35),
                new WeightProduct("Яблоки", "Красные", 17),
        };
        ComparatorToDemo.sortProducts(products);
        assertArrayEquals(products, sorted);

    }

    @Test
    public void ComparatorToDemoTest11() {
        Product[] products = {
                new PieceProduct("Яблоки", "Красные", 17),
                new PieceProduct("Апельсины", "Круглые", 21),
                new PieceProduct("Арбузы", "Сочный", 35),
        };

        Product[] sorted =  {
                new PieceProduct("Апельсины", "Круглые", 21),
                new PieceProduct("Арбузы", "Сочный", 35),
                new PieceProduct("Яблоки", "Красные", 17),
        };
        ComparatorToDemo.sortProducts(products);
        assertArrayEquals(products, sorted);

    }

    @Test
    public void ComparatorToDemoTest2() {
        Product[] products = {
                new WeightProduct("Яблоки", "Красные", 17),
                new WeightProduct("Яблоки", "Круглые", 21),
                new WeightProduct("Яблоки", "Сочный", 35),
        };

        Product[] sorted =  {
                new WeightProduct("Яблоки", "Красные", 17),
                new WeightProduct("Яблоки", "Круглые", 21),
                new WeightProduct("Яблоки", "Сочный", 35),
        };
        ComparatorToDemo.sortProducts(products);
        assertArrayEquals(products, sorted);

    }

    @Test
    public void ComparatorToDemoTest22() {
        Product[] products = {
                new PieceProduct("Яблоки", "Красные", 17),
                new PieceProduct("Яблоки", "Круглые", 21),
                new PieceProduct("Яблоки", "Сочный", 35),
        };

        Product[] sorted =  {
                new PieceProduct("Яблоки", "Красные", 17),
                new PieceProduct("Яблоки", "Круглые", 21),
                new PieceProduct("Яблоки", "Сочный", 35),
        };
        ComparatorToDemo.sortProducts(products);
        assertArrayEquals(products, sorted);

    }

    @Test
    public void ComparTest1() {
        Compar c = new Compar();
                WeightProduct product1 = new WeightProduct("Яблоки", "Красные", 17);
                 WeightProduct product2 = new WeightProduct("Яблоки", "Красные", 17);
        assertEquals(c.compare(product1,product2), 0);

    }


    @Test
    public void ComparTest21() {
        int j = 0;
        Compar c = new Compar();
        WeightProduct product1 = new WeightProduct("Яблоки", "Красные", 17);
        WeightProduct product2 = new WeightProduct("Яблоки", "Круглые", 17);
        if(c.compare(product1,product2 )!= 0) {
            j = -1;
        }
        assertEquals(j, -1);

    }

    @Test
    public void ComparTest22() {
        int j = 0;
        Compar c = new Compar();
        WeightProduct product1 = new WeightProduct("Яблоки", "Красные", 17);
        WeightProduct product2 = new WeightProduct("Арбузы", "Красные", 17);
        if(c.compare(product1,product2 )!= 0) {
            j = -1;
        }
        assertEquals(j, -1);

    }
}