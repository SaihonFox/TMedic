package com.polus_plus.tmedic.POJO.Examples;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.polus_plus.tmedic.POJO.RetrofitAPI;
import com.polus_plus.tmedic.POJO.UserProfile.Avatar;
import com.polus_plus.tmedic.SharedPrefs.AllData;

import java.io.ByteArrayOutputStream;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvatarExample {
	public void example() {
		TextView tv = new TextView(null);
		ImageView iv = new ImageView(null);
		
		File file = new File("");
		Call<Avatar> createProfileCall = RetrofitAPI.api().Avatar(AllData.timeToken, RequestBody.create(MediaType.parse("image/*"), file));
		createProfileCall.enqueue(new Callback<Avatar>() {
			@Override
			public void onResponse(Call<Avatar> call, Response<Avatar> response) {
				if(!response.isSuccessful()) {
					tv.setText("Code: " + response.code() + "\nMsg: " + response.message());
					return;
				}
				
				tv.setText(response.code());
			}
			
			@Override
			public void onFailure(Call<Avatar> call, Throwable t) {
				tv.setText("Errors: " + t.getMessage());
			}
		});
	}
	
	public byte[] getBytes(ImageView imageView) {
		try {
			Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
			byte[] bytesData = stream.toByteArray();
			stream.close();
			return bytesData;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}