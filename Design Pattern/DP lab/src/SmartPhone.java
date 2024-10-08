public class SmartPhone extends Devices{
    String Display;
    public SmartPhone(String model,String Display){
        super.deviceModel = model;
        this.Display = Display;
    }
    @Override
    public void powerOff() {
        System.out.println("Smart Phone model: "+ super.deviceModel+" Display: "+this.Display+"Powered Off");
    }

    @Override
    public void powerOn() {
        System.out.println("Smart Phone model: "+ super.deviceModel+" Display: "+this.Display+" Powered On");
    }

}
