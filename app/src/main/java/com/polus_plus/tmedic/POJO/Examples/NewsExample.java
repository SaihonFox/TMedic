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

public class NewsExample {
	public void example() {
		TextView tv = new TextView(null);
		
		Call<List<News>> newsCall = RetrofitAPI.api().getNews();
		newsCall.enqueue(new Callback<List<News>>() {
			@Override
			public void onResponse(Call<List<News>> call, Response<List<News>> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				List<News> newsList = response.body();
				newsList.sort(Comparator.comparingInt(News::getId));
				
				String content = "length: " + newsList.size() + "\n";
				for(News news : newsList) {
					content += "ID: " + news.getId() + "\n";
					content += "Name: " + news.getName() + "\n";
					content += "Description: " + news.getDescription() + "\n";
					content += "Price: " + news.getPrice() + "\n";
					content += "Image: " + news.getImage() + "\n" + "\n";
					
					tv.append(content);
					content = "";
				}
			}
			
			@Override
			public void onFailure(Call<List<News>> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}