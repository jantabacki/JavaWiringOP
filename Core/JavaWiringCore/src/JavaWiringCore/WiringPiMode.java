package JavaWiringCore;

public class WiringPiMode {
    private WiringPiMode() {
    }

    public static final int WPI_MODE_PINS = 0;
    public static final int WPI_MODE_GPIO = 1;
    public static final int WPI_MODE_GPIO_SYS = 2;
    public static final int WPI_MODE_PHYS = 3;
    public static final int WPI_MODE_PIFACE = 4;
    public static final int WPI_MODE_UNINITIALISED = -1;
}
