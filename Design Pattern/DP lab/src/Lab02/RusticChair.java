package Lab02;

public class RusticChair extends Chair{
    public RusticChair(String uid){
        this.UID=uid;
    }
    @Override
    public void showChairFeature() {
        System.out.println("Rustic Chair");
    }
}
