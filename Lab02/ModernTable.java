package Lab02;

public class ModernTable extends Table{
    public ModernTable(String uid){
        this.UID=uid;
    }
    @Override
    public void showTableFeature() {
        System.out.println("Modern Table");
    }
}
