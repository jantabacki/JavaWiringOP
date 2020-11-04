package JavaWiringCore;

public class JavaWiring {
    public native int wiringPiSetup();

    public native int wiringPiSetupGpio();

    public native int wiringPiSetupPhys();

    public native int wiringPiSetupSys();

    public native void pinMode(int pin, int mode);

    public native void pullUpDnControl(int pin, int pud);

    public native void digitalWrite(int pin, int value);

    public native void pwmWrite(int pin, int value);

    public native int digitalRead(int pin);

    public native int analogRead(int pin);

    public native void analogWrite(int pin, int value);
}
