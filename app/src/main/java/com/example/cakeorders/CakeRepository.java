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

/**
 * Repository for Cakes (Singleton Class)
 */
class CakeRepository {
    Executor executor = Executors.newFixedThreadPool(3);
    private Set<CakeCommunicationInterface> cakeInterfaceSet = new HashSet<>();

    /**
     * constructor of the Singleton Class: CakeRepository
     */
    private CakeRepository() {}
    static CakeRepository getInstance(){
        return Singleton.INSTANCE;
    }

    /**
     * method which will read the Asset containing data in JSON format
     * uses GSON framework to create an ArrayList of {@link Cake}s
     * Sends said list through an Interface
     * @param cakeShowInterface instance of the Interface
     */
    void showCakes(CakeCommunicationInterface cakeShowInterface){
        addToSet(cakeShowInterface);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String cakeListAsset = loadAsset("complexdata.json");

                Type cakeType = new TypeToken<ArrayList<Cake>>(){
                }.getType();
                Gson gson = new Gson();
                ArrayList<Cake> cakeList = gson.fromJson(cakeListAsset, cakeType);

                for (CakeCommunicationInterface callback: cakeInterfaceSet){
                    callback.sendCakeList(cakeList);
                }
            }
        };
        executor.execute(runnable);
    }

    void addToSet(CakeCommunicationInterface cakeCommunicationInterface){
        cakeInterfaceSet.add(cakeCommunicationInterface);
    }

    void removeFromSet(CakeCommunicationInterface cakeCommunicationInterface){
        cakeInterfaceSet.remove(cakeCommunicationInterface);
    }

    /**
     * Read a file containing JSON data
     * @param file the file to be read
     * @return String with the content of file
     */
    private String loadAsset(String file) {
        String asset = null;
        try(InputStream inputStream
                    = CakeOrdersApplication.getContext().getAssets().open(file)) {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            asset = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asset;
    }

    public interface CakeCommunicationInterface {
        void sendCakeList(ArrayList<Cake> cakeArrayList);
    }

    private  static class Singleton{
        private static final CakeRepository INSTANCE = new CakeRepository();
    }
}
