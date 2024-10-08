package Lab02;

public class VictorianChair extends Chair{
    public VictorianChair(String uid){
        this.UID=uid;
    }
    @Override
    public void showChairFeature() {
        System.out.println("Victorian Chair");
    }
}
