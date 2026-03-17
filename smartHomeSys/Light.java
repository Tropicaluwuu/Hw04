package smartHomeSys;

public class Light implements SmartDevice{
    private String name;
    private String type;
    private int brightness;
    private boolean isOn;

    public Light(String name, int brightness, boolean isOn){
        this.name = name;
        this.type = "Light";
        this.brightness = brightness;
        this.isOn = isOn;
    }

@Override
public void turnOn(){
    isOn = false;
}
@Override
public void turnOff(){
    isOn = false;
}

@Override
public void displayDeviceInfo(){
    System.out.println("Device: " + name);
    System.out.println("Type:" + type);
    System.out.println("Brightness: " + brightness + "%" );
    System.out.println("Status: " + (isOn ? "ON" : "OFF"));
    System.out.println("------------");
}

}
