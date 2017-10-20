package com.doctor.networkutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String ip = "www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public boolean isNetWorkAvailable(String ip) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("ping -c 1 -w 3 "+ip);
            int statusCode = process.waitFor();
            return (statusCode == 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }
}
