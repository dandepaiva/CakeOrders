package com.example.cakeorders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cakeorders.model.CakeIngredients;

import java.util.ArrayList;


/**
 * An adapter to be used by Recycler Views using the {@link CakeIngredients} object
 */
public class CakeIngredientsAdapter extends RecyclerView.Adapter<CakeIngredientsAdapter.CakeIngredientsViewHolder> {
    ArrayList<CakeIngredients> cakeIngredientsArrayList;
    /**
     * constructor for the CakeIngredientsAdapter
     */
    public CakeIngredientsAdapter() {
        this.cakeIngredientsArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CakeIngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View addOnView = LayoutInflater.from(CakeOrdersApplication.getContext()).inflate(R.layout.ingredient_recycler_view, viewGroup, false);
        return new CakeIngredientsViewHolder(addOnView);
    }

    @Override
    public void onBindViewHolder(@NonNull CakeIngredientsViewHolder cakeIngredientsViewHolder, int position) {
        cakeIngredientsViewHolder.onBind(cakeIngredientsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return cakeIngredientsArrayList.size();
    }

    /**
     * a method used to update the List of Cake Ingredients
     * and notify of said update to the activity
     * @param cakeAddOnsUpdate a List of Cake Ingredients
     */
    void updateCakeIngredients(ArrayList<CakeIngredients> cakeAddOnsUpdate) {
        cakeIngredientsArrayList = cakeAddOnsUpdate;
        notifyDataSetChanged();
    }


    /**
     * View Holder for the Cake Adapter
     */
    static class CakeIngredientsViewHolder extends RecyclerView.ViewHolder {
        final TextView ingredientId;
        final TextView ingredientType;

        public CakeIngredientsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ingredientId = itemView.findViewById(R.id.ingredient_id);
            this.ingredientType = itemView.findViewById(R.id.ingredient_type);
        }

        /**
         * Bind an AddOn to this View Holder
         * @param cakeIngredients CakeIngredients object to be shown here
         */
        void onBind(CakeIngredients cakeIngredients) {
            ingredientId.setText(CakeOrdersApplication.getContext().getString(
                    R.string.id_message, cakeIngredients.getId()));
            ingredientType.setText(CakeOrdersApplication.getContext().getString(
                    R.string.type_message, cakeIngredients.getType()));
        }

    }
}
