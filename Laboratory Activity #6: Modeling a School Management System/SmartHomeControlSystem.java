import java.util.ArrayList;

class Device {
    private boolean power = false;

    public void turnOn() {
        power = true;
        System.out.println(getClass().getSimpleName() + " is now ON");
    }

    public void turnOff() {
        power = false;
        System.out.println(getClass().getSimpleName() + " is now OFF");
    }

    public boolean isOn() {
        return power;
    }

    public void showStatus() {
        System.out.println("Device Status");
    }

    public static void switchAll(ArrayList<Device> list, boolean on) {
        for (Device d : list) {
            if (on) d.turnOn();
            else d.turnOff();
        }
    }

    public static int countOn(ArrayList<Device> list) {
        int c = 0;
        for (Device d : list) {
            if (d.isOn()) c++;
        }
        return c;
    }
}

class AirConditioner extends Device {
    private int fanSpeed = 3;
    private int temperature = 24;

    @Override
    public void showStatus() {
        if (isOn())
            System.out.println("AirConditioner = Fan: " + fanSpeed + " Temperature: " + temperature);
        else
            System.out.println("AirConditioner is OFF");
    }
}

class LampShade extends Device {
    private int brightness;
    private String color;

    public LampShade(int b, String c) {
        brightness = b;
        color = c;
    }
    public LampShade(LampShade other) {
        brightness = other.brightness;
        color = other.color;
    }
    
    @Override
    public void showStatus() {
        if (isOn())
            System.out.println("LampShade = Brightness: " + brightness + "% Color: " + color);
        else
            System.out.println("LampShade is OFF");
    }
}

class Television extends Device {
    private int channel = 1;
    private int volume = 10;

    @Override
    public void showStatus() {
        if (isOn())
            System.out.println("TV = Channel: " + channel + " Volume: " + volume + "%");
        else
            System.out.println("TV is OFF");
    }
}

class MicrowaveOven extends Device {
    private int timer = 00;
    private int temp = 0;

    @Override
    public void showStatus() {
        if (isOn())
            System.out.println("Microwave = Timer: " + timer + " Temperature: " + temp);
        else
            System.out.println("Microwave is OFF");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {

        ArrayList<Device> devices = new ArrayList<>();

        AirConditioner ac = new AirConditioner();
        LampShade lamp1 = new LampShade(100, "Yellow");
        LampShade lamp2 = new LampShade(lamp1);
        Television tv = new Television();
        MicrowaveOven micro = new MicrowaveOven();

        devices.add(ac);
        devices.add(lamp1);
        devices.add(lamp2);
        devices.add(tv);
        devices.add(micro);
        
        System.out.print("————————————————————\n");
        System.out.println("\n(TURNING ALL DEVICES ON)");
        Device.switchAll(devices, true);
        System.out.println("Number of Devices ON: " + Device.countOn(devices));
        System.out.println("\n       (STATUS)");
        for (Device d : devices) {
            d.showStatus();
        }
        System.out.print("\n————————————————————\n");

        System.out.println("\n(TURNING ALL DEVICES OFF)");
        Device.switchAll(devices, false);
        System.out.println("Number of Devices ON: " + Device.countOn(devices));
        System.out.println("\n       (STATUS)");
        for (Device d : devices) {
            d.showStatus();            
        }
    }
}
