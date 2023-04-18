package com.polus_plus.tmedic.POJO.Examples;

import android.widget.TextView;

import com.polus_plus.tmedic.POJO.Catalog.Catalog;
import com.polus_plus.tmedic.POJO.News.News;
import com.polus_plus.tmedic.POJO.RetrofitAPI;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogExample {
	public void example() {
		TextView tv = new TextView(null);
		
		Call<List<Catalog>> newsCall = RetrofitAPI.api().getCatalog();
		newsCall.enqueue(new Callback<List<Catalog>>() {
			@Override
			public void onResponse(Call<List<Catalog>> call, Response<List<Catalog>> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				List<Catalog> catalogList = response.body();
				catalogList.sort(Comparator.comparingInt(Catalog::getId));
				
				String content = "length: " + catalogList.size() + "\n";
				for(Catalog catalog : catalogList) {
					content += "ID: " + catalog.getId() + "\n";
					content += "Name: " + catalog.getName() + "\n";
					content += "Description: " + catalog.getDescription() + "\n";
					content += "Price: " + catalog.getPrice() + "\n";
					content += "Category: " + catalog.getCategory() + "\n";
					content += "Time Result: " + catalog.getTime_result() + "\n";
					content += "Preparation: " + catalog.getPreparation() + "\n";
					content += "Bio: " + catalog.getBio() + "\n" + "\n";
					
					tv.append(content);
					content = "";
				}
			}
			
			@Override
			public void onFailure(Call<List<Catalog>> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}