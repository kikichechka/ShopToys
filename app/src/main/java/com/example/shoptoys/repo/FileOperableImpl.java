package com.example.shoptoys.repo;

import android.content.Context;

import com.example.shoptoys.model.Toy;
import com.example.shoptoys.model.ToyMapperImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileOperableImpl implements FileOperable {
    private final String fileName;
    private final ToyMapperImpl toyMapper = new ToyMapperImpl();

    public FileOperableImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Toy> getListToys(Context context) {
        List<Toy> list = new ArrayList<>();
        try {
            FileInputStream file = context.openFileInput(fileName);
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(reader);
            String lines;
            int id = 0;
            while ((lines = br.readLine()) != null) {
                Toy toy = toyMapper.mapToToy(lines);
                toy.setId(id++);
                list.add(toy);
            }
            file.close();
        } catch (FileNotFoundException e) {
            addListToy(list, context);
            getListToys(context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void addToy(Toy toy, Context context) {
        List <Toy> list = getListToys(context);
        list.add(toy);
        StringBuffer sb = new StringBuffer();
        try {
            FileOutputStream file = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            for (Toy t: list) {
                sb.append(toyMapper.mapToString(t)).append("\n");
            }
            file.write(sb.toString().getBytes());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addListToy(List<Toy> list, Context context) {
        StringBuffer sb = new StringBuffer();
        try {
            FileOutputStream file = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            for (Toy t: list) {
                sb.append(toyMapper.mapToString(t)).append("\n");
            }
            file.write(sb.toString().getBytes());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteToy(int id, Context context) {
        List<Toy> list = getListToys(context);
        List<Toy> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() != id) {
                newList.add(list.get(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        try {
            FileOutputStream file = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            for (Toy t: newList) {
                sb.append(toyMapper.mapToString(t)).append("\n");
            }
            file.write(sb.toString().getBytes());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
