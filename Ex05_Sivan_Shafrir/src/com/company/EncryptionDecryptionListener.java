package com.company;

/**
 * Created by hackeru on 3/27/2017.
 */
public class EncryptionDecryptionListener implements Listener {
    private Output output;

    public EncryptionDecryptionListener(Output output) {
        this.output = output;
    }

    @Override
    public void onStart() {
        //int startTime= (int) System.nanoTime();
        output.output("action start  "+System.nanoTime());
    }

    @Override
    public void onEnd() {
        output.output("action end  "+System.nanoTime());
    }
}
