package Lab02;

public class VictorianFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair(String uid) {
        return new VictorianChair(uid);
    }

    @Override
    public Table createTable(String uid) {
        return new VictorianTable(uid);
    }

    @Override
    public Sofa createSofa(String uid) {
        return new Victoriansofa( uid);
    }
}
