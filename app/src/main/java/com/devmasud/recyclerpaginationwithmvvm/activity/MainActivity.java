package com.devmasud.recyclerpaginationwithmvvm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();
    }

    private void doInitialization() {
        activityMainBinding.productRecycler.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        productAdapter = new ProductAdapter(bigSaveDataResponseList);
        activityMainBinding.productRecycler.setAdapter(productAdapter);


        getProductsList();
    }

    private void getProductsList() {
        toggleLoading();
        viewModel.getProducts(currentPage).observe(this, getProduct -> {
            toggleLoading();
            if (getProduct != null) {
                if (getProduct.getData() != null) {
                    bigSaveDataResponseList.addAll(getProduct.getData());
                    productAdapter.notifyDataSetChanged();

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