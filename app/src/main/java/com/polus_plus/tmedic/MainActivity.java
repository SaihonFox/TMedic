package com.polus_plus.tmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
	EditText editText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = findViewById(R.id.editText);
		
		ImageView iv = findViewById(R.id.imageView);
		EditText et = findViewById(R.id.editTextText);
		et.setText(Arrays.toString(getBytes(iv)));
		showDialog();
	}
	
	public void showDialog() {
		Calendar calendar = Calendar.getInstance();
		new DatePickerDialog(MainActivity.this, (view1, year, month, dayOfMonth) -> {
			String date = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
					.withLocale(new Locale("ru"))
					.format(LocalDate.of(year, month + 1, dayOfMonth));
			date = date.substring(0, date.length() - 3);
			editText.setText(date);
		}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
				.show();
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