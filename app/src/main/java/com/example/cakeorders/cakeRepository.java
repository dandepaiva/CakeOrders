package com.example.cakeorders;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class CakeRepository {
    Executor executor = Executors.newFixedThreadPool(3);

    private CakeRepository() {}
    static CakeRepository getInstance(){
        return Singleton.INSTANCE;
    }

    void showCakes(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        executor.execute(runnable);
    }




    private String loadAsset(String file) {
        String asset = null;
        try {
            InputStream inputStream = CakeOrdersApplication.getContext().getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            asset = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asset;
    }

    private  static class Singleton{
        private static final CakeRepository INSTANCE = new CakeRepository();
    }
}
