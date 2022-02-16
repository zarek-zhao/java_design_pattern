package com.zarek.singleton.thelazytype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class DoubleCheckSingleton {

    public static volatile DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton()
    {
    }

    public static DoubleCheckSingleton getInstance()
    {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }


        return instance;
    }
}
