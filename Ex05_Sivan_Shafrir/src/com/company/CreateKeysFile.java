package com.company;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Siven on 20/03/2017.
 */
public class CreateKeysFile {

    public DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> createKey() {
        KeyGenerator<Integer> randomKeyGenerator=new RandomKeyGenerator();
        KeyGenerator<Integer> oddRandomKeyGenerator=new OddRandomKeyGenerator();
        Key<Integer> key1=  randomKeyGenerator.createKey();
        Key<Integer> key2=  randomKeyGenerator.createKey();
        Key<Integer> key3=  oddRandomKeyGenerator.createKey();
        DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> key = new DoubleKey<>(key1, new DoubleKey<>(key2, key3));
        return key;
    }

    public <T extends Serializable> void writeKey(T key, File keysFile){
        HandlerFile.writeObjectToFile(keysFile, key);
    }

    public <T extends  Serializable> T getKey(File keysFile) throws IOException, ClassNotFoundException {
        return HandlerFile.readObjectFromFile(keysFile);
    }

}
