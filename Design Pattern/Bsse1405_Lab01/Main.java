//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DeviceFactory smrtphoneFac = new SmartPhoneFactory();
        Devices smartPhone = smrtphoneFac.createDevices("Android","OlED");
        smartPhone.powerOn();
        DeviceFactory tabletFac = new TabletFactory();
        Devices Tablet = tabletFac.createDevices("Tab 13","Black");
        Tablet.powerOn();
        DeviceFactory LaptopFac = new LaptopFactory();
        Devices laptop = LaptopFac.createDevices("Core i5","Msi");
        laptop.powerOn();
    }
}