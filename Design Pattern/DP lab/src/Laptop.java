public class Laptop extends Devices{
    String Company;
    public Laptop(String model,String company){
        super.deviceModel = model;
        this.Company = company;
    }
    @Override
    public void powerOff() {
        System.out.println("Laptop Company" +": "+ this.Company+"Model: "+ super.deviceModel+" Powered Off");
    }

    @Override
    public void powerOn() {
        System.out.println("Laptop Company" +": "+this.Company+ " Model: "+ super.deviceModel+" Powered On");
    }
}
