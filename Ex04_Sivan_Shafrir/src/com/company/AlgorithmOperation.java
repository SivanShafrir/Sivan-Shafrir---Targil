package com.company;

/**
 * Created by hackeru on 3/21/2017.
 */
public  class AlgorithmOperation {

    public static Listener listener;

    public static void setListener(Listener listener) {
        AlgorithmOperation.listener = listener;
    }

    public void startedEncryption (){
        if(listener != null)
            listener.startEncrypt();
    }

    public void finishedEncryption(){
        if(listener != null)
            listener.finishEncrypt();
    }
    public void startedDecryption(){
        if(listener != null)
            listener.startDecrypt();
    }
    public void finishedDecryption(){
        if(listener != null)
            listener.finishDecrypt();
    }


    interface Listener {
        void startEncrypt();
        void finishEncrypt();
        void startDecrypt();
        void finishDecrypt();
    }
}
