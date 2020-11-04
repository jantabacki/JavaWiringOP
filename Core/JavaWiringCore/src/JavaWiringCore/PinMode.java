package JavaWiringCore;

public class PinMode {
    private PinMode() {
    }

    public static final int INPUT = 0;
    public static final int OUTPUT = 1;
    public static final int PWM_OUTPUT = 2;
    public static final int GPIO_CLOCK = 3;
    public static final int SOFT_PWM_OUTPUT = 4;
    public static final int SOFT_TONE_OUTPUT = 5;
    public static final int PWM_TONE_OUTPUT = 6;

    public static final int LOW = 0;
    public static final int HIGH = 1;
}
