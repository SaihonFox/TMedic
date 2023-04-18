package com.polus_plus.tmedic.POJO.Examples;

import android.content.Context;
import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.UserOrder.Orders;
import com.polus_plus.tmedic.SharedPrefs.AllData;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersExample {
	public void example() {
		TextView tv = new TextView(null);
		
		Call<List<Orders>> objectCall = RetrofitAPI.api().Orders(AllData.timeToken);
		objectCall.enqueue(new Callback<List<Orders>>() {
			@Override
			public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				List<Orders> ordersList = response.body();
				ordersList.sort(Comparator.comparingInt(Orders::getId));
				
				String content = "length: " + ordersList.size() + "\n" + "\n";
				for(Orders order : ordersList) {
					content += "ID: " + order.getId() + "\n";
					content += "PatientID: " + order.getPatient_id() + "\n";
					content += "CreatedAT: " + order.getCreated_at() + "\n";
					content += "UpdatedAT: " + order.getUpdated_at() + "\n";
					content += "OrderID: " + order.getOrder_id() + "\n";
					content += "CatalogID: " + order.getCatalog_id() + "\n";
					content += "Price: " + order.getPrice() + "\n" + "\n";
					//-----Patient
					content += "-----Patient-----\n";
					content += "Patient ID: " + order.getPatient().getId() + "\n";
					content += "Patient Name: " + order.getPatient().getName() + "\n";
					content += "Patient CreatedAT: " + order.getPatient().getCreated_at() + "\n";
					content += "Patient UpdatedAT: " + order.getPatient().getUpdated_at() + "\n" + "\n";
					//-----Order
					content += "-----Order-----\n";
					content += "Order CreatedAT: " + order.getOrder().getCreated_at() + "\n";
					content += "Order UpdatedAT: " + order.getOrder().getUpdated_at() + "\n";
					content += "Order ID: " + order.getOrder().getId() + "\n";
					content += "Order Address: " + order.getOrder().getAddress() + "\n";
					content += "Order DateTime: " + order.getOrder().getDate_time() + "\n";
					content += "Order Phone: " + order.getOrder().getPhone() + "\n";
					content += "Order Comment: " + order.getOrder().getComment() + "\n" + "\n";
					//-----Item
					content += "-----Item-----\n";
					content += "Item Name: " + order.getItem().getName() + "\n";
					content += "Item Category: " + order.getItem().getCategory() + "\n";
					content += "Item Price: " + order.getItem().getPrice() + "\n";
					content += "Item Description: " + order.getItem().getDescription() + "\n";
					content += "Item CreatedAT: " + order.getItem().getCreated_at() + "\n";
					content += "Item UpdatedAT: " + order.getItem().getUpdated_at() + "\n";
					content += "Item ID: " + order.getItem().getId() + "\n";
					content += "Item TimeResult: " + order.getItem().getTime_result() + "\n";
					content += "Item Preparation: " + order.getItem().getPreparation() + "\n";
					content += "Item Bio: " + order.getItem().getBio() + "\n" + "\n";
					content += "--------------------\n";
					
					tv.append(content);
					content = "";
				}
			}
			
			@Override
			public void onFailure(Call<List<Orders>> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}