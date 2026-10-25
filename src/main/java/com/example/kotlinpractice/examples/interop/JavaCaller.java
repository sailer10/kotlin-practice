package com.example.kotlinpractice.examples.interop;

public final class JavaCaller {
    private JavaCaller() {}
    public static String callKotlin() {
        return KotlinBridge.greeting() + ":" + KotlinBridge.LANGUAGE;
    }
}
