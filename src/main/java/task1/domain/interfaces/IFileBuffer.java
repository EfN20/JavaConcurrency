package task1.domain.interfaces;

import java.io.File;

public interface IFileBuffer<T> {
    void putFileToQueue(T t) throws InterruptedException;

    File takeFileFromQueue() throws InterruptedException;

    boolean isQueueEmpty();
}
