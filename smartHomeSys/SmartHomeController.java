package smartHomeSys;

import java.util.Scanner;

public class SmartHomeController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeviceManager manager = new DeviceManager();

        System.out.print("Please enter the number of devices to add: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("------------------------------");

            // keep asking until they enter a valid device type
            String type = "";
            while (!type.equals("Light") && !type.equals("Thermostat")) {
                System.out.print("Enter device type (Light/Thermostat): ");
                type = scanner.nextLine();
                if (!type.equals("Light") && !type.equals("Thermostat")) {
                    System.out.println("Invalid device type, skipping...");
                }
            }

            System.out.print("Please enter your device name: ");
            String name = scanner.nextLine();

            switch (type) {
                case "Light":
                    System.out.print("Enter brightness (0-100): ");
                    int brightness = Integer.parseInt(scanner.nextLine());

                    // keep asking until they enter valid brightness
                    while (brightness < 0 || brightness > 100) {
                        System.out.println("Invalid! Brightness must be between 0 and 100.");
                        System.out.print("Enter brightness (0-100): ");
                        brightness = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.print("Is the light ON? (Yes/No): ");
                    String lightStatus = scanner.nextLine();
                    boolean lightOn = lightStatus.equalsIgnoreCase("yes") || lightStatus.equalsIgnoreCase("y");

                    Light light = new Light(name, brightness, lightOn);
                    if (lightOn) light.turnOn(); else light.turnOff();
                    manager.addDevice(light);
                    System.out.println("Device '" + name + "' got added successfully!");
                    break;

                case "Thermostat":
                    System.out.print("Please enter temperature (F): ");
                    double temp = Double.parseDouble(scanner.nextLine());

                    System.out.print("Is the thermostat ON? (Yes/No): ");
                    String thermoStatus = scanner.nextLine();
                    boolean thermoOn = thermoStatus.equalsIgnoreCase("yes") || thermoStatus.equalsIgnoreCase("y");

                    Thermostat thermostat = new Thermostat(name, temp, thermoOn);
                    if (thermoOn) thermostat.turnOn(); else thermostat.turnOff();
                    manager.addDevice(thermostat);
                    System.out.println("Device '" + name + "' got added successfully!");
                    break;
            }
        }

        System.out.println("------------");
        manager.displayAllDevices();
        scanner.close();
    }
}