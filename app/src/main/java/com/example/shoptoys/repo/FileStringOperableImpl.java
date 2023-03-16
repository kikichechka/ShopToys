package com.example.shoptoys.repo;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileStringOperableImpl implements FileStringOperable {
    private final String fileName;

    public FileStringOperableImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> getList(Context context) {
        List<String> list = new ArrayList<>();
        try {
            FileInputStream file = context.openFileInput(fileName);
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(reader);
            String lines;
            while ((lines = br.readLine()) != null) {
                list.add(lines);
            }
            file.close();
        } catch (FileNotFoundException e) {
            updateList("", context);
            getList(context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void updateList(String str, Context context) {
        StringBuffer sb = new StringBuffer();
        if (str.equals("")) {
            try {
                FileOutputStream file = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                sb.append(str);
                file.write(sb.toString().getBytes());
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            List <String> list = getList(context);
            list.add(str);
            try {
                FileOutputStream file = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                for (String s: list) {
                    sb.append(s).append("\n");
                }
                file.write(sb.toString().getBytes());
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
