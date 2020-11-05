javac -d ../out ./JavaWiringCore/JavaWiringSerial.java -h ./JavaWiringCore
mkdir ../out/lib
gcc -shared -o ../out/lib/libjavawiringserial.so ./JavaWiringCore/JavaWiringCore_JavaWiringSerial.c -fPIC -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux -lwiringPi
