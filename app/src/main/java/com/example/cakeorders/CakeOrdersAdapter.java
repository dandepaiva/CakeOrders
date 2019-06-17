package com.example.cakeorders;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cakeorders.model.Cake;

import java.util.ArrayList;

public class CakeOrdersAdapter extends RecyclerView.Adapter<CakeOrdersAdapter.CakeOrdersViewHolder> {
    private ArrayList<Cake> cakeArrayList;

    public CakeOrdersAdapter() {
        this.cakeArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CakeOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View lineView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cake_recycler_view, viewGroup, false);
        return new CakeOrdersViewHolder(lineView);
    }

    @Override
    public void onBindViewHolder(@NonNull CakeOrdersViewHolder cakeOrdersViewHolder, int position) {
        cakeOrdersViewHolder.onBind(cakeArrayList.get(position));
    }

    void updateCakeList(ArrayList<Cake> cakeArrayListUpdate){
        cakeArrayList = cakeArrayListUpdate;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cakeArrayList.size();
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

            // Adapters for the Recycler Views
            toppingAdapter = new CakeAddOnAdapter();
            batterAdapter = new CakeAddOnAdapter();

            setupCakeView(batterView, batterAdapter);
            setupCakeView(toppingView, toppingAdapter);
        }

        void onBind (Cake cake){
            cakeName.setText(cake.getName());
            cakeId.setText(CakeOrdersApplication.getContext().getString(
                    R.string.id_message,cake.getId()));
            cakeType.setText(CakeOrdersApplication.getContext().getString(
                    R.string.type_message,cake.getType()));
            cakePPU.setText(CakeOrdersApplication.getContext().getString(
                    R.string.ppu_message,cake.getPpu()));
            toppingAdapter.updateCakeAddOn(cake.getTopping());
            batterAdapter.updateCakeAddOn(cake.getBatters());


        }

        void setupCakeView(RecyclerView recyclerView, CakeAddOnAdapter cakeAddOnAdapter){
            // LayoutManagers for the recycler views
            RecyclerView.LayoutManager layoutManager =
                    new LinearLayoutManager(CakeOrdersApplication.getContext(), LinearLayout.HORIZONTAL, false);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(cakeAddOnAdapter);
        }

    }
}
