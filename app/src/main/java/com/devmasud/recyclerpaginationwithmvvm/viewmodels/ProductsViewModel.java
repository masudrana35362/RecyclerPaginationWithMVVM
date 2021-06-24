package com.devmasud.recyclerpaginationwithmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.devmasud.recyclerpaginationwithmvvm.model.BigSaveResponse;
import com.devmasud.recyclerpaginationwithmvvm.repositoris.ProductRepositores;

public class ProductsViewModel extends ViewModel {

    private ProductRepositores productRepositores;


    public ProductsViewModel(){
        productRepositores=new ProductRepositores();

    }

    public LiveData<BigSaveResponse> getProducts(int page){
        return productRepositores.getProducts(page);
    }

}
