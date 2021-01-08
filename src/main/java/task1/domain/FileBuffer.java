package task1.domain;

import task1.domain.interfaces.IFileBuffer;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

public class FileBuffer implements IFileBuffer {
    private final ArrayBlockingQueue<File> buffer;

    public FileBuffer() {
        buffer = new ArrayBlockingQueue<>(1);
    }

    @Override
    public void putFileToQueue(File file) throws InterruptedException {
        buffer.put(file);
        System.out.println("File " + file.getName() + " was put in queue");
    }

    @Override
    public File takeFileFromQueue() throws InterruptedException {
        File fileToWork = buffer.take();
        System.out.println("File " + fileToWork.getName() + " was taken from queue");
        return fileToWork;
    }

    @Override
    public boolean isQueueEmpty() {
        return buffer.isEmpty();
    }
}
