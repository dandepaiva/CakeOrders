package com.example.cakeorders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        // TODO recycler view for batters
        final RecyclerView toppingView;
        CakeAddOnAdapter toppingAdapter;


        public CakeOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            cakeName = itemView.findViewById(R.id.cake_name);
            cakeId = itemView.findViewById(R.id.cake_id);
            cakeType = itemView.findViewById(R.id.cake_type);
            cakePPU = itemView.findViewById(R.id.cake_ppu);

            toppingView = itemView.findViewById(R.id.topping_view);
            toppingView.setHasFixedSize(true);

            RecyclerView.LayoutManager toppingLayoutManager =
                    new LinearLayoutManager(CakeOrdersApplication.getContext());
            toppingView.setLayoutManager(toppingLayoutManager);
            toppingAdapter = new CakeAddOnAdapter();
            toppingView.setAdapter(toppingAdapter);
        }

        void onBind (CakeObject cakeObject){
            cakeName.setText(cakeObject.getName());
            cakeId.setText("id: " + cakeObject.getId());
            cakeType.setText("type: " + cakeObject.getType());
            cakePPU.setText("ppu: " + cakeObject.getPpu());
            toppingAdapter.updateCakeAddOn(cakeObject.getTopping());
        }
    }
}
