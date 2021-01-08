package task2.services;

import task1.domain.interfaces.IFileBuffer;
import task1.services.interfaces.IFilesService;

import java.io.File;

public class SomeService implements IFilesService {
//    private final ArrayBlockingQueue<File> buffer;
//
//    public SomeService() {
//        buffer = new ArrayBlockingQueue<>(1);
//    }
    public SomeService() {}

    @Override
    public File[] getFileList() {
        return new File("/home/azatkali/JavaProjects/Assignment-1/src/main/webapp/task2-web/files").listFiles();
    }
//
//    @Override
//    public void putFileToQueue(File file) throws InterruptedException {
//        buffer.put(file);
//        System.out.println("File " + file.getName() + " was put in queue");
//    }
//
//    @Override
//    public File takeFileFromQueue() throws InterruptedException {
//        File fileToWork = buffer.take();
//        System.out.println("File " + fileToWork.getName() + " was taken from queue");
//        return fileToWork;
//    }
//
//    @Override
//    public boolean isQueueEmpty() {
//        return buffer.isEmpty();
//    }
}
