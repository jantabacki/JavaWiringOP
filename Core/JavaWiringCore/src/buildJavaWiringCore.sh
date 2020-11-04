javac -d ../out ./JavaWiringCore/JavaWiring.java -h ./JavaWiringCore
mkdir ../out/lib
gcc -shared -o ../out/lib/libjavawiring.so ./JavaWiringCore/JavaWiringCore_JavaWiring.c -fPIC -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux -lwiringPi
