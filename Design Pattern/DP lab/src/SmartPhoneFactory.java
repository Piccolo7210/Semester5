public class SmartPhoneFactory extends DeviceFactory{

        @Override
        protected Devices deviceCreation(String model,String str) {
            return new SmartPhone(model,str);
        }

}
