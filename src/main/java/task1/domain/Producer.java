package task1.domain;

import java.io.File;
import java.security.SecureRandom;

public class Producer implements Runnable {
    private static int COUNTER = 1;
    private FileBuffer sharedBuffer;
    private static SecureRandom secureRandom = new SecureRandom();
    private File[] files;

    public Producer(FileBuffer sharedBuffer, File[] files) {
        this.sharedBuffer = sharedBuffer;
        this.files = files;
    }

    @Override
    public void run() {
        while(COUNTER <= files.length) {
            try {
                Thread.sleep(secureRandom.nextInt(3000));
                sharedBuffer.putFileToQueue(files[COUNTER - 1]);
                COUNTER++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("PRODUCER COUNTER: " + COUNTER);
        }
    }
}
