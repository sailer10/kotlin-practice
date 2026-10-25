package com.example.kotlinpractice.exercises.interop;

public final class JavaCaller {
    private JavaCaller() {}
    public static String callKotlin() {
        return KotlinBridge.greeting() + ":" + KotlinBridge.LANGUAGE;
    }
}
