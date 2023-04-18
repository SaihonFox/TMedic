package com.polus_plus.tmedic.POJO.Examples;

import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.User.SendCode;
import com.polus_plus.tmedic.POJO.UserOrder.Orders;
import com.polus_plus.tmedic.SharedPrefs.AllData;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendCodeExample {
	public void example() {
		TextView tv = new TextView(null);
		
		Call<SendCode> sendCodeCall = RetrofitAPI.api().SendCode("jemkaplayed@gmail.com");
		sendCodeCall.enqueue(new Callback<SendCode>() {
			@Override
			public void onResponse(Call<SendCode> call, Response<SendCode> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				SendCode sendCode = response.body();
				tv.setText(sendCode.getMessage());
			}
			
			@Override
			public void onFailure(Call<SendCode> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}