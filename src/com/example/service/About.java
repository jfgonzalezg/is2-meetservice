package com.example.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

public class About extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		AssetManager assetManager = getAssets();
		InputStream inputStream = null;
		try{
			inputStream = assetManager.open("about/MeetService");
			String text = cargarArchivoTexto(inputStream);
			textView.setText(text);
		}catch(IOException e){
			textView.setText("No se puede cargar el archivo");
		}finally{
			if(inputStream != null)
				try{
					inputStream.close();
				}catch(IOException e){
					textView.setText("No se puede cerrar el archivo");
				}
		}
	}
	
	public String cargarArchivoTexto(InputStream inputStream) throws IOException{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] bytes = new byte[4096];
		int len = 0;
		while((len = inputStream.read(bytes)) > 0)
			byteStream.write(bytes, 0, len);
		return new String(byteStream.toByteArray(), "UTF8");
	}
}