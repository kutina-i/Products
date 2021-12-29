public class ServiceOfProducts {
    public int countByFilter(BatchOfProducts n, Filter filter){
        int j = 0;
        for(int i = 0; i < n.getSize(); i++){
            if(filter.apply(n.getProducts(i).getName())==true){
                j++;
            }
        }
        return j;
    }

public boolean countByFilterDeep(BatchOfProducts n, Filter filter){
    for(int i = 0; i < n.getSize(); i++){
        if(filter.apply(n.getProducts(i).getName())==true){
            return true;
        }
    }
    return false;
}

public boolean checkAllWeighted(BatchOfProducts n){

    Filter filter = new BeginStringFilter("Весовой");
    for(int i = 0; i < n.getSize(); i++){
    if(filter.apply(n.getProducts(i).getDescription())==false) {
        return false;
        }
    }
    return true;
}

}
