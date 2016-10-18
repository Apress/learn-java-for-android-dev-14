#include <windows.h>
#include "Joystick.h"

JNIEXPORT jint JNICALL Java_Joystick_joyGetNumDevs(JNIEnv *pEnv, jclass clazz)
{
   return joyGetNumDevs();
}