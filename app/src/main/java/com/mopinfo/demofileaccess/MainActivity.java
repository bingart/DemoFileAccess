package com.mopinfo.demofileaccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String data = "bbb";
            String fileName = "a.txt";
            FileOutputStream fOut = openFileOutput(fileName, MODE_PRIVATE);
            fOut.write(data.getBytes());
            fOut.close();

            FileInputStream fin = openFileInput(fileName);
            int c;
            String temp = "";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            if (temp != null) {
                temp = "abad";
                Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
