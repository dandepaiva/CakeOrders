package com.example.cakeorders;

import com.example.cakeorders.model.Cake;
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
    private Set<CakeListInterface> cakeListInterfaceSet = new HashSet<>();

    private CakeRepository() {}
    static CakeRepository getInstance(){
        return Singleton.INSTANCE;
    }

    void showCakes(CakeListInterface cakeListInterfaceShowCakes){
        addToSet(cakeListInterfaceShowCakes);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String cakeListAsset = loadAsset("complexdata.json");

                Type cakeType = new TypeToken<ArrayList<Cake>>(){
                }.getType();
                Gson gson = new Gson();
                ArrayList<Cake> cakeList = gson.fromJson(cakeListAsset, cakeType);

                for (CakeListInterface callback: cakeListInterfaceSet){
                    callback.sendCake(cakeList);
                }

                /*for(Cake cakeObject : cakeList){
                    Log.d(TAG, "run() called with:\n\t Batters: " + cakeObject.getBatters());
                }*/
            }
        };
        executor.execute(runnable);
    }

    void addToSet(CakeListInterface cakeListInterface){
        cakeListInterfaceSet.add(cakeListInterface);
    }

    void removeFromSet(CakeListInterface cakeListInterface){
        cakeListInterfaceSet.remove(cakeListInterface);
    }

    private String loadAsset(String file) {
        String asset = null;
        try(      InputStream inputStream = CakeOrdersApplication.getContext().getAssets().open(file)) {
           // InputStream inputStream = CakeOrdersApplication.getContext().getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);

            asset = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asset;
    }

    public interface CakeListInterface {
        void sendCake(ArrayList<Cake> cakeArrayList);
    }

    private  static class Singleton{
        private static final CakeRepository INSTANCE = new CakeRepository();
    }
}
