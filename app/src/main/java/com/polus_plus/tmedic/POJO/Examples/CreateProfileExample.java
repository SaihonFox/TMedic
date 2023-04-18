package com.polus_plus.tmedic.POJO.Examples;

import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.UserProfile.CreateProfile;
import com.polus_plus.tmedic.SharedPrefs.AllData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateProfileExample {
	public void example() {
		TextView tv = new TextView(null);
		
		CreateProfile createProfile = new CreateProfile(2, "ABOBA", "LN", "MN", "Febr", "Tractor", "HOT BEBRA");
		Call<CreateProfile> createProfileCall = RetrofitAPI.api().CreateProfile(AllData.timeToken, createProfile);
		createProfileCall.enqueue(new Callback<CreateProfile>() {
			@Override
			public void onResponse(Call<CreateProfile> call, Response<CreateProfile> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				CreateProfile createProfile1 = response.body();
				tv.append("ID: " + createProfile1.getId() + "\n");
				tv.append("Name: " + createProfile1.getFirstname() + "\n");
				tv.append("Lastname: " + createProfile1.getLastname() + "\n");
				tv.append("Middlename: " + createProfile1.getMiddlename() + "\n");
				tv.append("Bith: " + createProfile1.getBith() + "\n");
				tv.append("Pol: " + createProfile1.getPol() + "\n");
				tv.append("Image: " + createProfile1.getImage() + "\n");
			}
			
			@Override
			public void onFailure(Call<CreateProfile> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}