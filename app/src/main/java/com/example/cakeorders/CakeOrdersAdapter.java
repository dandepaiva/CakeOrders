package com.example.cakeorders;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cakeorders.cakeFactory.CakeObject;

import java.util.ArrayList;

public class CakeOrdersAdapter extends RecyclerView.Adapter<CakeOrdersAdapter.CakeOrdersViewHolder> {
    ArrayList<CakeObject> cakeObjectArrayList;

    public CakeOrdersAdapter() {
        this.cakeObjectArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CakeOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View lineView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cake_recycler_view, viewGroup, false);
        return new CakeOrdersViewHolder(lineView);
    }

    @Override
    public void onBindViewHolder(@NonNull CakeOrdersViewHolder cakeOrdersViewHolder, int position) {
        cakeOrdersViewHolder.onBind(cakeObjectArrayList.get(position));
    }

    void updateCakeList(ArrayList<CakeObject> cakeObjectArrayListUpdate){
        cakeObjectArrayList = cakeObjectArrayListUpdate;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cakeObjectArrayList.size();
    }

    public static class CakeOrdersViewHolder extends RecyclerView.ViewHolder {
        final TextView cakeName;
        final TextView cakeId;
        final TextView cakeType;
        final TextView cakePPU;
        final RecyclerView toppingView;
        final RecyclerView batterView;
        CakeAddOnAdapter toppingAdapter;
        CakeAddOnAdapter batterAdapter;


        public CakeOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            // View representation
            cakeName = itemView.findViewById(R.id.cake_name);
            cakeId = itemView.findViewById(R.id.cake_id);
            cakeType = itemView.findViewById(R.id.cake_type);
            cakePPU = itemView.findViewById(R.id.cake_ppu);

            toppingView = itemView.findViewById(R.id.topping_view);
            toppingView.setHasFixedSize(true);

            batterView = itemView.findViewById(R.id.batter_view);
            batterView.setHasFixedSize(true);

            // LayoutManagers for the recycler views
            RecyclerView.LayoutManager toppingLayoutManager =
                    new LinearLayoutManager(CakeOrdersApplication.getContext(), LinearLayout.HORIZONTAL, false);
            RecyclerView.LayoutManager batterLayoutManager =
                    new LinearLayoutManager(CakeOrdersApplication.getContext(), LinearLayout.HORIZONTAL, false);

            // Adapters for the Recycler Views
            toppingAdapter = new CakeAddOnAdapter();
            batterAdapter = new CakeAddOnAdapter();

            toppingView.setLayoutManager(toppingLayoutManager);
            toppingView.setAdapter(toppingAdapter);

            batterView.setLayoutManager(batterLayoutManager);
            batterView.setAdapter(batterAdapter);
        }

        void onBind (CakeObject cakeObject){
            cakeName.setText(cakeObject.getName());
            cakeId.setText("id: " + cakeObject.getId());
            cakeType.setText("type: " + cakeObject.getType());
            cakePPU.setText("ppu: " + cakeObject.getPpu());
            toppingAdapter.updateCakeAddOn(cakeObject.getTopping());
            batterAdapter.updateCakeAddOn(cakeObject.getBatters());


        }
    }
}
