package task1.domain;

import java.io.File;
import java.security.SecureRandom;

public class Task1Domain extends Thread {
    private static int COUNTER = 1;
    private FileBuffer sharedBuffer;
    private static SecureRandom secureRandom = new SecureRandom();
    private File[] files;

    public Task1Domain(FileBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
        this.files = sharedBuffer.getFileList();
    }

    @Override
    public void run() {
        while(COUNTER <= files.length) {
            try {
                Thread.sleep(secureRandom.nextInt(3000));
                if(sharedBuffer.isQueueEmpty()) {
                    sharedBuffer.putFileToQueue(files[COUNTER - 1]);
                    System.out.println("PRODUCER COUNTER: " + COUNTER);
                }
                else if(!sharedBuffer.isQueueEmpty()) {
                    File oldFile = sharedBuffer.takeFileFromQueue();
                    String oldFileExt = oldFile.getName().substring(oldFile.getName().indexOf(46));
                    File newNameFile = new File("/home/azatkali/JavaProjects/Assignment-1/src/main/webapp/task1-web/files",
                            (String.valueOf(COUNTER) + oldFileExt));
                    System.out.println(newNameFile.getName() + "=============================");
                    if(oldFile.renameTo(newNameFile)){
                        System.out.println("RENAMED FILE TO " + COUNTER++);
                    }
                    System.out.println("CONSUMER COUNTER: " + COUNTER);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
