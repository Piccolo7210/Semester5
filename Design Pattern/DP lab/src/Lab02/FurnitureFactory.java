package Lab02;

public interface FurnitureFactory {
    public Table createTable(String UID);
    public Sofa createSofa(String UID);
    public Chair createChair(String UID);
}
