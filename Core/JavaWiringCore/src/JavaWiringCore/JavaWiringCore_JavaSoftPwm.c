#include <wiringPi.h>
#include <softPwm.h>
#include "JavaWiringCore_JavaSoftPwm.h"

JNIEXPORT jint JNICALL Java_JavaWiringCore_JavaSoftPwm_softPwmCreate(JNIEnv * env, jobject obj, jint pin, jint initialValue, jint pwmRange)
{
    return softPwmCreate(pin, initialValue, pwmRange);
}

JNIEXPORT void JNICALL Java_JavaWiringCore_JavaSoftPwm_softPwmWrite(JNIEnv * env, jobject obj, jint pin, jint value)
{
    return softPwmWrite(pin, value);
}
