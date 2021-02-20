package com.bswen.svc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TestCmd1 implements CommandLineRunner {
    static final SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyyMMdd");
    private static Log log = LogFactory.getLog(TestCmd1.class);

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(getRelativeBeforeDate(600));
        testConcurrentFormat();
        //testConcurrentFormatArrayIndexOutOfBoundsException();
    }

    final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    ExecutorService ex = Executors.newFixedThreadPool(20);

    public void testConcurrentFormat() {
        for(;;){
            ex.execute(new Runnable() {
                public void run() {
                    try {
                        sdfLocal.get().format(new Date(new Random().nextLong()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                };
            });
        }
    }

    public void testConcurrentFormatArrayIndexOutOfBoundsException() {
        for(;;){
            ex.execute(new Runnable() {
                public void run() {
                    try {
                        sdf.format(new Date(new Random().nextLong()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                };
            });
        }
    }

    public static String getRelativeBeforeDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -days);
        Date date = calendar.getTime();
        return sdfLocal.get().format(date);
    }

    static final ThreadLocal<SimpleDateFormat> sdfLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
}
