package com.devmasud.recyclerpaginationwithmvvm.adapter;

import android.content.Context;
import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasud.recyclerpaginationwithmvvm.R;
import com.devmasud.recyclerpaginationwithmvvm.databinding.RowItemBinding;
import com.devmasud.recyclerpaginationwithmvvm.model.BigSaveDataResponse;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<BigSaveDataResponse> productList;
    private Context mContext;

    public ProductAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<BigSaveDataResponse> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.row_item,parent,false);

        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        BigSaveDataResponse bigSaveDataResponse=productList.get(position);

        Picasso.get().load(bigSaveDataResponse.getThumbnail()).into(holder.thumb);
        holder.name.setText(bigSaveDataResponse.getName());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView thumb;
        private TextView name;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            thumb=itemView.findViewById(R.id.imgIcon);
            name=itemView.findViewById(R.id.txtName);
        }
    }
}
