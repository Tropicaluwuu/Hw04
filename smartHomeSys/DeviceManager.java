package smartHomeSys;

import java.util.ArrayList;
import java.util.List;


public class DeviceManager {
    private List<SmartDevice> devices = new ArrayList<>();

        public void addDevice(SmartDevice device){
            devices.add(device);
        }

    public void displayAllDevices(){
        System.out.println("-- Device Summary --");

        if (devices.isEmpty()){
            System.out.println("No devices to display!");
        }
        else{
            for (SmartDevice device : devices){
                device.displayDeviceInfo();
            }
        }
        System.out.println("------------");
    }

}
