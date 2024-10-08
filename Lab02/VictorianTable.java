package Lab02;

public class VictorianTable extends Table{
    public VictorianTable(String str){
        this.UID=str;
    }
    @Override
    public void showTableFeature() {
        System.out.println("Victorian table");
    }
}
