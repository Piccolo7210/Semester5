public class TabletFactory extends DeviceFactory{
    @Override
    protected Devices deviceCreation(String model,String str) {
        return new Tablet(model,str);
    }
}
