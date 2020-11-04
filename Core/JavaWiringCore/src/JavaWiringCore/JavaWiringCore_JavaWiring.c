#include <wiringPi.h>
#include "JavaWiringCore_JavaWiring.h"

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiring_wiringPiSetup(JNIEnv * env, jobject obj)
{
    return wiringPiSetup();
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiring_wiringPiSetupGpio(JNIEnv * env, jobject obj)
{
    return wiringPiSetupGpio();
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiring_wiringPiSetupPhys(JNIEnv * env, jobject obj)
{
    return wiringPiSetupPhys();
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiring_wiringPiSetupSys(JNIEnv * env, jobject obj)
{
    return wiringPiSetupSys();
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiring_pinMode(JNIEnv * env, jobject obj, jint pin, jint mode)
{
    pinMode(pin, mode);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiring_pullUpDnControl(JNIEnv * env, jobject obj, jint pin, jint pud)
{
    pullUpDnControl(pin, pud);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiring_digitalWrite(JNIEnv * env, jobject obj, jint pin, jint value)
{
    digitalWrite(pin, value);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiring_pwmWrite(JNIEnv * env, jobject obj, jint pin, jint value)
{
    pwmWrite(pin, value);
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiring_digitalRead(JNIEnv * env, jobject obj, jint pin)
{
    return digitalRead(pin);
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiring_analogRead(JNIEnv * env, jobject obj, jint pin)
{
    return analogRead(pin);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiring_analogWrite(JNIEnv * env, jobject obj, jint pin, jint value)
{
    analogWrite(pin, value);
}