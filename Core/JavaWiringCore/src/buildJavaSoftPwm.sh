javac -d ../out ./JavaWiringCore/JavaSoftPwm.java -h ./JavaWiringCore
mkdir ../out/lib
gcc -shared -o ../out/lib/libjavasoftpwm.so ./JavaWiringCore/JavaWiringCore_JavaSoftPwm.c -fPIC -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux -lwiringPi -lpthread
