package Lab02;

public class ModernSofa extends Sofa{
    public ModernSofa(String uid){
        this.UID=uid;
    }
    @Override
    public void showSofaFeature() {
        System.out.println("Modern Sofa");
    }
}
