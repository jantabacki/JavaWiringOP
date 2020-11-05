package JavaWiringCore;

public class JavaWiringSerial {
    public native int serialOpen(String device, int baud);

    public native void serialClose(int fd);

    public native void serialPutchar(int fd, char c);

    public native void serialPuts(int fd, String s);

    public native void serialPrintf(int fd, String message);

    public native int serialDataAvail(int fd);

    public native int serialGetchar(int fd);

    public native void serialFlush(int fd);
}
