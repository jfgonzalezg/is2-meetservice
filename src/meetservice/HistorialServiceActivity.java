package meetservice;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import business.Service;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.meetservice2.R;

import dao.ServiceDAO;

public class HistorialServiceActivity extends Activity{
	
	private ListView historicallist;
	private ServiceDAO servdao;
	private ArrayList serviceslist;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historial_services);
		// Show the Up button in the action bar.
		
		//AsyncLoadList async = new AsyncLoadList(this);
		//async.execute("?");
	}
	
	class AsyncLoadList extends AsyncTask<String, String, String>{
		
		Context mcontext;
		boolean available;
		String[] listitems;
		ArrayList<Service> serviceslist;
		
		public AsyncLoadList(Context context){
			
			mcontext = context;
		}
		
		public void onPreExecute(){
			
			servdao = new ServiceDAO();
			serviceslist = new ArrayList<Service>();
			historicallist = (ListView) findViewById(R.id.listHistoricalServices);
			listitems = new String[serviceslist.size()];
			
			
			historicallist.setAdapter(new ArrayAdapter<String>(mcontext,
					android.R.layout.simple_list_item_1,listitems));
			
			historicallist.setOnItemClickListener(new OnItemClickListener(){
				
				public void onItemClick(AdapterView<?> parent,View view, 
						int position, long id){
					
					for(Iterator<Service> iterator=serviceslist.iterator();
							iterator.hasNext();){
						
						Service service = (Service) iterator.next();
						
						if(listitems[position].equals((service.getName()))){
							
							
						}
						
						
					}
				}
				
				
			});
			
			
			
			
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
