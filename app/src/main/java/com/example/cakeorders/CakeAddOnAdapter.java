package com.example.cakeorders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cakeorders.model.CakeAddOn;

import java.util.ArrayList;

public class CakeAddOnAdapter extends RecyclerView.Adapter<CakeAddOnAdapter.CakeAddOnViewHolder> {
    ArrayList<CakeAddOn> cakeAddOnArrayList;

    public CakeAddOnAdapter() {
        this.cakeAddOnArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CakeAddOnViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View addOnView = LayoutInflater.from(CakeOrdersApplication.getContext()).inflate(R.layout.addon_recycler_view, viewGroup, false);
        return new CakeAddOnViewHolder(addOnView);
    }

    @Override
    public void onBindViewHolder(@NonNull CakeAddOnViewHolder cakeAddOnViewHolder, int position) {
        cakeAddOnViewHolder.onBind(cakeAddOnArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return cakeAddOnArrayList.size();
    }

    void updateCakeAddOn(ArrayList<CakeAddOn> cakeAddOnsUpdate){
        cakeAddOnArrayList = cakeAddOnsUpdate;
        notifyDataSetChanged();
    }

    static class CakeAddOnViewHolder extends RecyclerView.ViewHolder{
        final TextView addOnId;
        final TextView addOnType;

        public CakeAddOnViewHolder(@NonNull View itemView) {
            super(itemView);
            this.addOnId = itemView.findViewById(R.id.addon_id);
            this.addOnType = itemView.findViewById(R.id.addon_type);
        }

        void onBind(CakeAddOn cakeAddOn){
            addOnId.setText(CakeOrdersApplication.getContext().getString(
                            R.string.id_message,cakeAddOn.getId()));
            addOnType.setText(CakeOrdersApplication.getContext().getString(
                    R.string.type_message,cakeAddOn.getType()));
        }

    }
}
