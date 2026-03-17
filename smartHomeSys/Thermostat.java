package smartHomeSys;

public class Thermostat implements SmartDevice {
    private String name;
    private String type;
    private double temperature; //double bc temperatures can be 72.5, etc
    private boolean isOn;

   public Thermostat(String name, double temperature, boolean isOn){
    this.name = name;
    this.type = "Thermostat";
    this.temperature = temperature;
    this.isOn = isOn;
   } 

@Override
public void turnOn(){
    isOn = true;
}

@Override
public void turnOff(){
    isOn = false;
}

@Override
public void displayDeviceInfo(){
    System.out.println("Device: " + name);
    System.out.println("Type: " + type);
    System.out.println("Temperature:" + temperature + "F");
    System.out.println("Status: " + (isOn ? "ON" : "OFF"));
    System.out.println("------------");
}

}
