package com.example.real_estate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.real_estate.Domain.PropertyDomain;
import com.example.real_estate.databinding.ViewholderItemBinding;

import java.util.ArrayList;

public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.Viewholder> {
    ArrayList<PropertyDomain> items;
    Context context;
    ViewholderItemBinding binding;

    public ListItemsAdapter(ArrayList<PropertyDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListItemsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context=parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemsAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.sizaTxt.setText(items.get(position).getSize()+"m2");
        if(items.get(position).isGarage()){
            binding.garageTxt.setText("Car in Garage");
        }
        else{
            binding.garageTxt.setText("There is not any Car");
        }

        binding.adressTxt.setText(items.get(position).getAddress());
        binding.bedTxt.setText(items.get(position).getBed()+" Bed");
        binding.bethTxt.setText(items.get(position).getBath()+" Bath");

        int drawableResourceId=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPickPath(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(binding.pic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderItemBinding binding) {
            super(binding.getRoot());
        }
    }
}
