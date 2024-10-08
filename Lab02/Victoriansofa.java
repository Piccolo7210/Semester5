package Lab02;

public class Victoriansofa extends Sofa{
    public Victoriansofa(String str){
        this.UID=str;
    }
    @Override
    public void showSofaFeature() {
        System.out.println("Victorian Sofa");
    }
}
