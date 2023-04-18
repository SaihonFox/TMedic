package com.polus_plus.tmedic.POJO;

import com.polus_plus.tmedic.POJO.Catalog.Catalog;
import com.polus_plus.tmedic.POJO.News.News;
import com.polus_plus.tmedic.POJO.User.SendCode;
import com.polus_plus.tmedic.POJO.User.SignIn;
import com.polus_plus.tmedic.POJO.UserOrder.Order;
import com.polus_plus.tmedic.POJO.UserOrder.OrderID;
import com.polus_plus.tmedic.POJO.UserOrder.Orders;
import com.polus_plus.tmedic.POJO.UserProfile.Avatar;
import com.polus_plus.tmedic.POJO.UserProfile.CreateProfile;
import com.polus_plus.tmedic.POJO.UserProfile.UpdateProfile;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface JSONPlaceHolderAPI {
	//----------User----------//
	@POST("/api/sendCode")
	Call<SendCode> SendCode(@Header("email") String email);
	
	@POST("/api/signin")
	Call<SignIn> SignIn(@Header("email") String email, @Header("code") String code);
	
	//----------Catalog----------//
	@GET("/api/catalog")
	Call<List<Catalog>> getCatalog();
	
	//----------News----------//
	@GET("/api/news")
	Call<List<News>> getNews();
	
	//----------UserProfile----------//
	@Headers({"Accept: application/json"})
	@POST("/api/createProfile")
	Call<CreateProfile> CreateProfile(@Header("Authorization") String token, @Body CreateProfile jsonObject);
	
	@Headers({"Accept: application/json"})
	@PUT("/api/updateProfile")
	Call<CreateProfile> UpdateProfile(@Header("Authorization") String token, @Body UpdateProfile updateProfile);
	
	@Headers({"Accept: multipart/form-data"})
	@POST("/api/avatar")
	Call<Avatar> Avatar(@Header("Authorization") String token, @Body RequestBody binary);
	
	//----------UserOrder----------//
	@Headers({"Accept: application/json"})
	@POST("/api/order")
	Call<OrderID> Order(@Header("Authorization") String token, @Body Order order);
	
	@Headers({"Accept: application/json"})
	@GET("/api/orders")
	Call<List<Orders>> Orders(@Header("Authorization") String token);
}