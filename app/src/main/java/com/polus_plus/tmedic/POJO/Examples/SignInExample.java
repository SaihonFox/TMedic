package com.polus_plus.tmedic.POJO.Examples;

import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.User.SignIn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInExample {
	public void example() {
		TextView tv = new TextView(null);
		
		Call<SignIn> signInCall = RetrofitAPI.api().SignIn("jemkaplayed@gmail.com", "");
		signInCall.enqueue(new Callback<SignIn>() {
			@Override
			public void onResponse(Call<SignIn> call, Response<SignIn> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				SignIn signIn = response.body();
				tv.setText(signIn.getToken());
			}
			
			@Override
			public void onFailure(Call<SignIn> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}