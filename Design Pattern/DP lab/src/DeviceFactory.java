public abstract class DeviceFactory {

    protected Devices createDevices(String model,String str) {
        Devices device = deviceCreation(model,str);
        return device;
    }
    protected abstract Devices deviceCreation(String model,String str);
}
