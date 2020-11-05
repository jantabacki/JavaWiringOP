package JavaWiringCore;

public class JavaSoftPwm {
    public native int softPwmCreate(int pin, int initialValue, int pwmRange);

    public native void softPwmWrite(int pin, int value);
}
