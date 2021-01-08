package task1.domain.interfaces;

import java.io.File;

public interface IFileBuffer {
    void putFileToQueue(File file) throws InterruptedException;

    File takeFileFromQueue() throws InterruptedException;

    boolean isQueueEmpty();
}
