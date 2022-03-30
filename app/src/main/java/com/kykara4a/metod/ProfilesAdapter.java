package com.kykara4a.metod;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder>{
    private RecyclerView recyclerView = null;
    private ArrayList<Profile> profiles;
    SharedPreferences sharedPreferences;
    private OnItemClickListener mOnItemClickListener;
    public ProfilesAdapter(ArrayList<Profile> profiles, OnItemClickListener onItemClickListener) {

this.mOnItemClickListener = onItemClickListener;
        this.profiles = profiles;
    }

    public ProfilesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        return new ProfilesAdapter.ViewHolder(view, mOnItemClickListener);
    }

    public void onBindViewHolder(@NonNull final ProfilesAdapter.ViewHolder holder, final int position){
        Profile profile = profiles.get(position);
        //////////////////////
        holder.name.setText(profile.getName());
        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                if (!(profile.id==-1)) {
                    contextMenu.add(holder.getAdapterPosition(), 0, 0, R.string.remove);
                }
            }
        });
    }
    public  int getItemCount(){
        return profiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        OnItemClickListener onItemClickListener;
        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
itemView.setOnClickListener(this);
this.onItemClickListener = onItemClickListener;
            name = (TextView)itemView.findViewById(R.id.name);
        }

        @Override
        public void onClick(View v) {
onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        this.recyclerView = recyclerView;
    }
    public interface OnItemClickListener{
void onItemClick(int position);
    }
    public void setItems(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }
}
