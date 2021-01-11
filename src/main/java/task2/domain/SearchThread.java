package task2.domain;

import task2.services.SomeService;

import java.io.*;
import java.security.SecureRandom;
import java.util.concurrent.Callable;

public class SearchThread implements Callable<String>, Runnable {
    private static int COUNTER_FILE = 0;
    private static Integer SUM = 0;
    private static SecureRandom secureRandom = new SecureRandom();
    private SomeService someService;
    private String searchText;
    private int counter;
    private File curFile;

    public SearchThread(SomeService someService, String searchText) {
        this.someService = someService;
        this.searchText = searchText;
        this.counter = 0;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(secureRandom.nextInt(3000));
        run();
        return curFile.getName() + ": " + counter;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " " + someService.getFileList()[COUNTER_FILE]);
            searchWord(someService.getFileList()[COUNTER_FILE]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void nextFile() {
        System.out.println(COUNTER_FILE + "=================================");
        if(COUNTER_FILE < 4){
            COUNTER_FILE++;
        } else {
            System.out.println("COUNTER FILE MNOGO");
        }
    }

    public void searchWord(File file) throws IOException {
        this.curFile = file;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while( (s = br.readLine()) != null) {
            if(s.contains(searchText)) {
                SUM++;
                counter++;
            }
        }
        nextFile();
    }
}
