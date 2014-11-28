package com.ikar.oneri.application;

import android.app.Application;

import com.ikar.oneri.model.Category;

import java.util.ArrayList;

public class OneriApplication extends Application {
    public static ArrayList<Category> categoryList = new ArrayList<Category>();

    @Override
    public void onCreate() {
        super.onCreate();
        ArrayList<String> subList1 = new ArrayList<String>();
        subList1.add("Klasik");
        subList1.add("Bilim Kurgu");
        Category category1 = new Category("Kitap", subList1);

        ArrayList<String> subList2 = new ArrayList<String>();
        subList2.add("Yerli Muzik");
        subList2.add("Yabanci Muzik");
        Category category2 = new Category("Muzik", subList2);

        ArrayList<String> subList3 = new ArrayList<String>();
        subList3.add("Mobil Oyun");
        subList3.add("Bilgisayar Oyun");
        Category category3 = new Category("Oyunlar", subList3);
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);

    }
}
