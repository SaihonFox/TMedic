package com.polus_plus.tmedic.POJO.Examples;

import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.UserOrder.Order;
import com.polus_plus.tmedic.POJO.UserOrder.OrderID;
import com.polus_plus.tmedic.POJO.UserOrder.OrderPatients;
import com.polus_plus.tmedic.POJO.UserOrder.OrderPatientsItems;
import com.polus_plus.tmedic.SharedPrefs.AllData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderExample {
	public void example() {
		TextView tv = new TextView(null);
		
		OrderPatientsItems[] orderPatientsItems = { new OrderPatientsItems(2, "8800") };
		OrderPatients[] orderPatients = { new OrderPatients("Nime", orderPatientsItems) };
		Order order = new Order("adr", "data time", "Pone", "Kom", orderPatients);
		Call<OrderID> orderIDCall = RetrofitAPI.api().Order(AllData.timeToken, order);
		orderIDCall.enqueue(new Callback<OrderID>() {
			@Override
			public void onResponse(Call<OrderID> call, Response<OrderID> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				tv.setText("OrderID: " + response.body().getOrder_id());
			}
			
			@Override
			public void onFailure(Call<OrderID> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}