public class LaptopFactory extends DeviceFactory{
    @Override
    protected Devices deviceCreation(String model,String str) {
        return new Laptop(model,str);
    }
}
