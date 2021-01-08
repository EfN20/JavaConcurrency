package task1.services;

import task1.services.interfaces.IFilesService;

import java.io.File;

public class FileService implements IFilesService {

    @Override
    public File[] getFileList() {
        return new File("/home/azatkali/JavaProjects/Assignment-1/src/main/webapp/task1-web/files").listFiles();
    }

}
