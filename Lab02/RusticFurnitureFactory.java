package Lab02;

public class RusticFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair(String uid) {
        return new RusticChair(uid);
    }

    @Override
    public Table createTable(String uid) {
        return new RusticTable(uid);
    }

    @Override
    public Sofa createSofa(String uid) {
        return new RusticSofa(uid);
    }
}
