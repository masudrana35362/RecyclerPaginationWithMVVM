package com.devmasud.recyclerpaginationwithmvvm.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.devmasud.recyclerpaginationwithmvvm.R;
import com.devmasud.recyclerpaginationwithmvvm.adapter.ProductAdapter;
import com.devmasud.recyclerpaginationwithmvvm.databinding.ActivityMainBinding;
import com.devmasud.recyclerpaginationwithmvvm.model.BigSaveDataResponse;
import com.devmasud.recyclerpaginationwithmvvm.viewmodels.ProductsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private ProductsViewModel viewModel;
    private List<BigSaveDataResponse> bigSaveDataResponseList = new ArrayList<>();
    private ProductAdapter productAdapter;
    private int currentPage = 1;
    private int totalAvailablePage=20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        productAdapter = new ProductAdapter(this);
        doInitialization();

    }

    private void doInitialization() {

        activityMainBinding.productRecycler.setHasFixedSize(true);
        activityMainBinding.productRecycler.setLayoutManager(new GridLayoutManager(this,2));
        viewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        productAdapter.setData(bigSaveDataResponseList);
        activityMainBinding.productRecycler.setAdapter(productAdapter);
        activityMainBinding.productRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!activityMainBinding.productRecycler.canScrollVertically(1)){
                    if (currentPage <= totalAvailablePage){
                        currentPage +=1;
                        getProductsList();
                    }
                }
            }
        });

        getProductsList();
    }

    private void getProductsList() {
        toggleLoading();
        viewModel.getProducts(currentPage).observe(this, getProduct -> {
            toggleLoading();
            if (getProduct != null) {
                if (getProduct.getData() != null) {
                    int oldCount=bigSaveDataResponseList.size();
                    bigSaveDataResponseList.addAll(getProduct.getData());
                    productAdapter.notifyItemRangeInserted(oldCount,bigSaveDataResponseList.size());

                }
            }

        });
    }

    private void toggleLoading() {

        if (currentPage == 1) {
            if (activityMainBinding.getIsLoading() != null && activityMainBinding.getIsLoading()) {
                activityMainBinding.setIsLoading(false);
            } else {
                activityMainBinding.setIsLoading(true);
            }
        } else {
            if (activityMainBinding.getIsLoadingMore() != null && activityMainBinding.getIsLoadingMore()) {
                activityMainBinding.setIsLoadingMore(false);
            } else {
                activityMainBinding.setIsLoadingMore(true);
            }
        }
    }



}