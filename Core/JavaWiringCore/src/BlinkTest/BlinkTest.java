package BlinkTest;

import JavaWiringCore.JavaWiring;
import JavaWiringCore.PinMode;

public class BlinkTest {
    static{
        System.loadLibrary("javawiring");
    }
    public static void main(String[] args) throws InterruptedException {
        JavaWiring javaWiring = new JavaWiring();
        javaWiring.wiringPiSetup();
        javaWiring.pinMode(0, PinMode.OUTPUT);
        for (; ; ) {
            javaWiring.digitalWrite(0, PinMode.HIGH);
            Thread.sleep(1000);
            javaWiring.digitalWrite(0, PinMode.LOW);
            Thread.sleep(1000);
        }
    }
}
