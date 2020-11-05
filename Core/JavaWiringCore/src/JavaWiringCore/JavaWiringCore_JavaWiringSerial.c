#include <wiringSerial.h>
#include "JavaWiringCore_JavaWiringSerial.h"

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiringSerial_serialOpen(JNIEnv *env, jobject obj, jstring device, jint baud)
{
    const char *nativeString = (*env)->GetStringUTFChars(env, device, 0);
    jint response = serialOpen(nativeString, baud);
    (*env)->ReleaseStringUTFChars(env, device, nativeString);
    return response;
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiringSerial_serialClose(JNIEnv *env, jobject obj, jint fd)
{
    serialClose(fd);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiringSerial_serialPutchar(JNIEnv *env, jobject obj, jint fd, jchar c)
{
    serialPutchar(fd, c);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiringSerial_serialPuts(JNIEnv *env, jobject obj, jint fd, jstring s)
{
    const char *nativeString = (*env)->GetStringUTFChars(env, s, 0);
    serialPuts(fd, nativeString);
    (*env)->ReleaseStringUTFChars(env, s, nativeString);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiringSerial_serialPrintf(JNIEnv *env, jobject obj, jint fd, jstring message)
{
    const char *nativeString = (*env)->GetStringUTFChars(env, message, 0);
    serialPrintf(fd, nativeString);
    (*env)->ReleaseStringUTFChars(env, message, nativeString);
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiringSerial_serialDataAvail(JNIEnv *env, jobject obj, jint fd)
{
    return serialDataAvail(fd);
}

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaWiringSerial_serialGetchar(JNIEnv *env, jobject obj, jint fd)
{
    return serialGetchar(fd);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaWiringSerial_serialFlush(JNIEnv *env, jobject obj, jint fd)
{
    serialFlush(fd);
}
