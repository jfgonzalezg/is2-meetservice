package com.example.async;


import com.example.meetservice2.NewRegActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

class AsyncRegister extends AsyncTask< String, String, String > {
	
	private ProgressDialog pDialog;  
	String user,pass;

	 private Activity activity;
     private ProgressDialog dialog;
     private Context context;

     public AsyncRegister(Activity activity){
         this.activity = activity;
         this.context = activity;
         this.dialog = new ProgressDialog(activity);
         this.dialog.setTitle("");
         this.dialog.setMessage("");
         if(!this.dialog.isShowing()){
             this.dialog.show();
         }
     }
    protected void onPreExecute() {
    	//para el progress dialog
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Enviando...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

	protected String doInBackground(String... params) {
		//obtnemos usr y pass
		user=params[0];
		pass=params[1];
        
		//enviamos y recibimos y analizamos los datos en segundo plano.
		if (true){    		    		
			return "ok"; //login valido
		}else{    		
			return "err"; //login invalido     	          	  
		}
    	
	}
   
	/*Una vez terminado doInBackground segun lo que halla ocurrido 
	pasamos a la sig. activity
	o mostramos error*/
    protected void onPostExecute(String result) {

       pDialog.dismiss();//ocultamos progess dialog.
       
    }

}
