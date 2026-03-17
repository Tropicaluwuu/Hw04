package smartHomeSys;

import java.util.Scanner;

public class SmartHomeController {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DeviceManager manager = new DeviceManager();

        System.out.println("Please enter the number of devices to add: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++){
            System.out.println("Please enter your device type (Light/Thermostat: ");
            String type = scanner.nextLine();

            System.out.println("Please enter your device name: ");
            String name = scanner.nextLine();

            switch (type){
                case "Light":
                System.out.println("Please enter brightness (0 - 100");
                int brightness = Integer.parseInt(scanner.nextLine());
                
                System.out.println("Is the light ON? (Y/N): ");
                String lightStatus = scanner.nextLine();
                
                //only "y" or "yes" counts as on, case insensitive!
                boolean lightOn = lightStatus.equalsIgnoreCase("yes") || lightStatus.equalsIgnoreCase("y");

                Light light = new Light(name, brightness, lightOn);
                if (lightOn) light.turnOn();
                    else light.turnOff();
                manager.addDevice(light);
                System.out.println("Device '" + name + "' got added to the list successfully!");
                break;


                case "Thermostat":
                    System.out.println("Please enter temperature (F): ");
                    double temp = Double.parseDouble(scanner.nextLine());

                    System.out.println("Is the thermostate ON? (Y/N: ");
                    String thermoStatus = scanner.nextLine();
                    boolean thermoOn = thermoStatus.equalsIgnoreCase("yes") || thermoStatus.equalsIgnoreCase("y");

                    Thermostat thermostat = new Thermostat(name, temp, thermoOn);
                    if (thermoOn) thermostat.turnOn(); else thermostat.turnOff();
                    manager.addDevice(thermostat);
                    System.out.println("Device '" + name + "' got added to the list successfully!");
                    break;

                default:
                    System.out.println("Invalid device type, skipping...");
                    break;
                }
            }
    
    System.out.println("");
    manager.displayAllDevices();

    scanner.close();
    } 
//im gonna kms
}
