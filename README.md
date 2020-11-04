# JavaWiringOP
Java package made with JNI which allows to use WiringPI C code to write code in Java on OrangePi.

    JavaWiringOP - Java package made with JNI which allows to use 
    WiringPI C code to write code in Java on OrangePi.
    2020  Jan Tabacki

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
    

This package was delivered in the form of the IntelliJ Idea Community project, however, this is to facilitate the development of software using it. IntelliJ Idea Community does not allow to compile this code with it's currently made configuration for this solution. 
See further instructions for information on how to use the project.


The solution has been tested for OrangePi with the Raspbian operating system.


To begin with, we need to make sure that the JDK is installed on our runtime environment, which is OrangePi with Raspbian.
We can do this by running 
```
java -version
```
At the console output, we should receive
```
openjdk version "11.0.9" 2020-10-20
OpenJDK Runtime Environment (build 11.0.9+11-post-Debian-1deb10u1)
OpenJDK Server VM (build 11.0.9+11-post-Debian-1deb10u1, mixed mode)
```
If not try to download OpenJDK with
```
sudo apt-get install default-jdk
```
After that java should be installed, check also 
```
javac -version
```

When JDK is set correctly we can install WiringOP library for our OrangePi board. Library is available on https://github.com/orangepi-xunlong/wiringOP . In readme section it is described how to install this library.

After instalation check if library is correctly installed with
```
gpio readall
```
Sample output should look similiar to
```
 +------+-----+----------+------+---+OrangePiH3+---+------+----------+-----+------+
 | GPIO | wPi |   Name   | Mode | V | Physical | V | Mode | Name     | wPi | GPIO |
 +------+-----+----------+------+---+----++----+---+------+----------+-----+------+
 |      |     |     3.3V |      |   |  1 || 2  |   |      | 5V       |     |      |
 |   12 |   0 |    SDA.0 |  OUT | 0 |  3 || 4  |   |      | 5V       |     |      |
 |   11 |   1 |    SCL.0 |  OFF | 0 |  5 || 6  |   |      | GND      |     |      |
 |    6 |   2 |      PA6 |  OFF | 0 |  7 || 8  | 0 | OFF  | TXD.3    | 3   | 13   |
 |      |     |      GND |      |   |  9 || 10 | 0 | OFF  | RXD.3    | 4   | 14   |
 |    1 |   5 |    RXD.2 |  OFF | 0 | 11 || 12 | 0 | OFF  | PD14     | 6   | 110  |
 |    0 |   7 |    TXD.2 |  OFF | 0 | 13 || 14 |   |      | GND      |     |      |
 |    3 |   8 |    CTS.2 |  OFF | 0 | 15 || 16 | 0 | OFF  | PC04     | 9   | 68   |
 |      |     |     3.3V |      |   | 17 || 18 | 0 | OFF  | PC07     | 10  | 71   |
 |   64 |  11 |   MOSI.0 |  OFF | 0 | 19 || 20 |   |      | GND      |     |      |
 |   65 |  12 |   MISO.0 |  OFF | 0 | 21 || 22 | 0 | OFF  | RTS.2    | 13  | 2    |
 |   66 |  14 |   SCLK.0 |  OFF | 0 | 23 || 24 | 0 | OFF  | CE.0     | 15  | 67   |
 |      |     |      GND |      |   | 25 || 26 | 0 | OFF  | PA21     | 16  | 21   |
 |   19 |  17 |    SDA.1 |  OFF | 0 | 27 || 28 | 0 | OFF  | SCL.1    | 18  | 18   |
 |    7 |  19 |     PA07 |  OFF | 0 | 29 || 30 |   |      | GND      |     |      |
 |    8 |  20 |     PA08 |  OFF | 0 | 31 || 32 | 0 | OFF  | RTS.1    | 21  | 200  |
 |    9 |  22 |     PA09 |  OFF | 0 | 33 || 34 |   |      | GND      |     |      |
 |   10 |  23 |     PA10 |  OFF | 0 | 35 || 36 | 0 | OFF  | CTS.1    | 24  | 201  |
 |   20 |  25 |     PA20 |  OFF | 0 | 37 || 38 | 0 | OFF  | TXD.1    | 26  | 198  |
 |      |     |      GND |      |   | 39 || 40 | 0 | OFF  | RXD.1    | 27  | 199  |
 +------+-----+----------+------+---+----++----+---+------+----------+-----+------+
 | GPIO | wPi |   Name   | Mode | V | Physical | V | Mode | Name     | wPi | GPIO |
 +------+-----+----------+------+---+OrangePiH3+---+------+----------+-----+------+
```

Now it is time to clone this repository to preferred location on your OrangePi.

```
git clone https://github.com/jantabacki/JavaWiringOP.git
```

When repository is cloned enter location ./JavaWiringOP/Core/JavaWiringCore/src
```
cd JavaWiringOP/Core/JavaWiringCore/src
```
Set privileges for building scripts, for example
```
chmod +x buildJavaWiringCore.sh
chmod +x buildBlinkTest.sh
```
Now you can build JavaWiringCore and example code BlinkTest
```
./buildJavaWiringCore.sh
./buildBlinkTest.sh
```

Above scr directory scripts should create out directory.
```
cd ..
```

Set privileges for runBlinkTest.sh
```
chmod +x runBlinkTest.sh
```

Now it's time to attach LED to your GPIO pins. At this point of the manual, I assume that you know how to do it correctly, because the manual is about software and not about electrical connections.

BlinkTest code is:
``` java
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
```
That means that your GPIO 0 will alternate HIGH and LOW every second. 

All available methods of JavaWiring class are described in http://wiringpi.com/reference/setup/ and http://wiringpi.com/reference/core-functions/ . Methods are mapped from this library with JNI to Java. Exact mapping is from library https://github.com/orangepi-xunlong/wiringOP which is based on WiringPi library.


It is likely possible that the prepared Java package also works correctly for Raspberry Pi computers when the WiringPi library for RaspberryPi is installed on them. The plugs that need to be made in order to get the project to work can be very similar. This solution has not yet been tested on a Raspberry Pi. 

If you managed to run this project on Orange Pi or Raspberry Pi please let me know. In case of any problems, please contact me.
