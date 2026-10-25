package com.example.kotlinpractice.interop;



public final class JavaGreeter {
    private JavaGreeter() {}
    public static String maybeName(boolean present) { return present ? "Seil" : null; }
    public static String greet(String name) { return "Hello, " + name; }
}
