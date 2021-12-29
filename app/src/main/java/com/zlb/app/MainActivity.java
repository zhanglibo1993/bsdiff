package com.zlb.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zlb.bsdiff.BsDiff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDiff;
    private Button btnPath;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDiff = findViewById(R.id.btn_diff);
        btnPath = findViewById(R.id.btn_patch);
        btnDiff.setOnClickListener(this);
        btnPath.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_diff:
                createPathFile();
                break;

            case R.id.btn_patch:
                restoreFile();

                break;
        }
    }

    private void createPathFile() {
        String path = getCacheDir().getAbsolutePath();
        File oldFile = new File(path + "/old.txt");
        File newFile = new File(path + "/new.txt");

        try {
            FileOutputStream fos = new FileOutputStream(oldFile);
            fos.write("12345".getBytes());
            fos.close();

            fos = new FileOutputStream(newFile);
            fos.write("12345623423434".getBytes());
            fos.close();

            int result = BsDiff.bsDiff(path + "/old.txt", path + "/new.txt", path + "/diff.txt");
            Log.d(TAG, "new file size:"+result);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }


    }


    private void restoreFile() {
        String path = getCacheDir().getAbsolutePath();


        BsDiff.bsPatch(path + "/old.txt", path + "/new.txt", path + "/diff.txt", 14);


    }
}