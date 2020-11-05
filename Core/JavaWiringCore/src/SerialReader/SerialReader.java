package SerialReader;

import JavaWiringCore.JavaWiringSerial;

public class SerialReader {
    static {
        System.loadLibrary("javawiringserial");
    }

    public static void main(String[] args) {
        JavaWiringSerial javaWiringSerial = new JavaWiringSerial();
        int fd = javaWiringSerial.serialOpen("/dev/ttyUSB0", 9600);
        javaWiringSerial.serialFlush(fd);
        while (true) {
            if (javaWiringSerial.serialDataAvail(fd) > 0) {
                while (javaWiringSerial.serialDataAvail(fd) > 0) {
                    System.out.print((char) javaWiringSerial.serialGetchar(fd));
                }
            }
        }
    }
}
