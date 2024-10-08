package Lab02;

public class Client {
    private Chair chair;
    private Table table;
    private Sofa sofa;
    public Client(FurnitureFactory factory,String uid){
        this.chair= factory.createChair(uid);
        this.table = factory.createTable(uid);
        this.sofa= factory.createSofa(uid);
    }
    public void printing(){
        System.out.println("Product Catagory:");
        this.chair.showChairFeature();
        this.sofa.showSofaFeature();
        this.table.showTableFeature();
        System.out.println("Product UID: ");
        System.out.println("Chair"+this.chair.UID);
    }
}
