package com.devmasud.recyclerpaginationwithmvvm.adapter;

import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasud.recyclerpaginationwithmvvm.R;
import com.devmasud.recyclerpaginationwithmvvm.databinding.RowItemBinding;
import com.devmasud.recyclerpaginationwithmvvm.model.BigSaveDataResponse;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<BigSaveDataResponse> productList;
    private LayoutInflater layoutInflater;

    public ProductAdapter(List<BigSaveDataResponse> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        RowItemBinding rowItemBinding= DataBindingUtil.inflate(
                layoutInflater, R.layout.row_item,parent,false
        );

        return new ProductViewHolder(rowItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bindProduct(productList.get(position));


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder{

        private RowItemBinding rowItemBinding;

        public ProductViewHolder(RowItemBinding rowItemBinding){
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }

        public void bindProduct(BigSaveDataResponse pShow){
            rowItemBinding.setPShow(pShow);
            rowItemBinding.executePendingBindings();

        }

    }
}
