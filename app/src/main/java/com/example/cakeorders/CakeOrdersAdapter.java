package com.example.cakeorders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class CakeOrdersAdapter extends RecyclerView.Adapter<CakeOrdersAdapter.CakeOrdersViewHolder> {
    @NonNull
    @Override
    public CakeOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CakeOrdersViewHolder cakeOrdersViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CakeOrdersViewHolder extends RecyclerView.ViewHolder {

        public CakeOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
