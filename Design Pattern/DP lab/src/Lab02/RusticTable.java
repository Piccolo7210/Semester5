package Lab02;

public class RusticTable extends Table{
    public RusticTable(String uid){
        this.UID=uid;
    }
    @Override
    public void showTableFeature() {
        System.out.println("Rustic Table");
    }
}
