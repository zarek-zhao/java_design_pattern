package com.zarek.singleton.thehungrytype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonStaticCodeBlock {
    static SingletonStaticCodeBlock instance;

    static {
        instance = new SingletonStaticCodeBlock();

    }

    private SingletonStaticCodeBlock(){

    }

    public static SingletonStaticCodeBlock getInstance(){
        return instance;
    }

}
