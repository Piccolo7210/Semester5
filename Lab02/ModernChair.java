package Lab02;

public class ModernChair extends Chair{

    public ModernChair(String uid){
        this.UID=uid;
    }
    @Override
    public void showChairFeature() {
        System.out.println("Modern Chair");
    }
}
