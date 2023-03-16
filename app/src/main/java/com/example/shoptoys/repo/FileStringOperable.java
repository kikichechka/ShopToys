package com.example.shoptoys.repo;

import android.content.Context;
import java.util.List;

public interface FileStringOperable {
    List<String> getList(Context context);
    void updateList(String str, Context context);
}
