package com.polus_plus.tmedic.POJO.Examples;

import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.UserProfile.CreateProfile;
import com.polus_plus.tmedic.POJO.UserProfile.UpdateProfile;
import com.polus_plus.tmedic.SharedPrefs.AllData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfileExample {
	public void example() {
		TextView tv = new TextView(null);
		
		UpdateProfile updateProfile = new UpdateProfile("ABOBA - U", "LN - U", "MN - U", "Febr - U", "Tractor - U");
		Call<CreateProfile> updateProfileCall = RetrofitAPI.api().UpdateProfile(AllData.timeToken, updateProfile);
		updateProfileCall.enqueue(new Callback<CreateProfile>() {
			@Override
			public void onResponse(Call<CreateProfile> call, Response<CreateProfile> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				CreateProfile updateProfile1 = response.body();
				tv.append("ID: " + updateProfile1.getId() + "\n");
				tv.append("Name: " + updateProfile1.getFirstname() + "\n");
				tv.append("Lastname: " + updateProfile1.getLastname() + "\n");
				tv.append("Middlename: " + updateProfile1.getMiddlename() + "\n");
				tv.append("Bith: " + updateProfile1.getBith() + "\n");
				tv.append("Pol: " + updateProfile1.getPol() + "\n");
				tv.append("Image: " + updateProfile1.getImage() + "\n");
			}
			
			@Override
			public void onFailure(Call<CreateProfile> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
}