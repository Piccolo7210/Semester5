package Lab02;

public class ModernFurnitureFactory implements FurnitureFactory{
    private static volatile ModernFurnitureFactory instance;
    String id;

    private ModernFurnitureFactory(){
      this.id ="10000000";
    }
    public static ModernFurnitureFactory getInstance(){
        ModernFurnitureFactory result = instance;
        if(instance!=null)return result;
        synchronized (ModernFurnitureFactory.class){
            if(instance== null){
                instance = new ModernFurnitureFactory();
            }
            return instance;
        }
    }
    @Override
    public Chair createChair(String uid) {
        return new ModernChair(uid);
    }

    @Override
    public Table createTable(String uid) {
        return new ModernTable(uid);
    }

    @Override
    public Sofa createSofa(String uid) {
        return new ModernSofa(uid);
    }
}
