package Lab02;

public class RusticSofa extends Sofa{
    public RusticSofa(String uid)
    {
        this.UID= uid;
    }
    @Override
    public void showSofaFeature() {
        System.out.println("Rustic Sofa");
    }
}
