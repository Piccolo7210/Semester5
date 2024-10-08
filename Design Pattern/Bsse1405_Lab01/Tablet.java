public class Tablet extends Devices{
    String Color;
    public Tablet(String model,String color){
        super.deviceModel = model;
        this.Color = color;
    }
    @Override
    public void powerOff() {
        System.out.println("Tablet Model" +": "+ super.deviceModel+" Color: "+this.Color+" Powered Off");
    }

    @Override
    public void powerOn() {
        System.out.println("Tablet Model" +": "+ super.deviceModel+" Color: "+this.Color+" Powered On");
    }
}
