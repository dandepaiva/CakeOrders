package com.example.cakeorders;

import android.provider.ContactsContract;
import android.util.Log;

import com.example.cakeorders.cakeFactory.CakeObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class CakeRepository {
    private static final String TAG = "REPOSITORY";
    Executor executor = Executors.newFixedThreadPool(3);
    private Set<DataCommunicator> dataCommunicatorSet = new HashSet<>();

    private CakeRepository() {}
    static CakeRepository getInstance(){
        return Singleton.INSTANCE;
    }

    void showCakes(DataCommunicator dataCommunicatorShowCakes){
        addToSet(dataCommunicatorShowCakes);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String cakeListAsset = loadAsset("complexdata.json");

                Type cakeType = new TypeToken<ArrayList<CakeObject>>(){
                }.getType();
                Gson gson = new Gson();
                ArrayList<CakeObject> cakeList = gson.fromJson(cakeListAsset, cakeType);

                for (DataCommunicator callback: dataCommunicatorSet){
                    callback.sendCake(cakeList);
                }

                /*for(CakeObject cakeObject : cakeList){
                    Log.d(TAG, "run() called with:\n\t Batters: " + cakeObject.getBatters());
                }*/
            }
        };
        executor.execute(runnable);
    }

    void addToSet(DataCommunicator dataCommunicator){
        dataCommunicatorSet.add(dataCommunicator);
    }

    void removeFromSet(DataCommunicator dataCommunicator){
        dataCommunicatorSet.remove(dataCommunicator);
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

    public interface DataCommunicator{
        void sendCake(ArrayList<CakeObject> cakeArrayList);
    }

    private  static class Singleton{
        private static final CakeRepository INSTANCE = new CakeRepository();
    }
}
