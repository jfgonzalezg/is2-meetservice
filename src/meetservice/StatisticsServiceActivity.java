package meetservice;

import session.UserGlobal;
import business.Score;
import business.Service;
import business.Statistics;
import dao.ScoreDAO;
import dao.ServiceDAO;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meetservice2.R;



public class StatisticsServiceActivity extends Activity {
	
	
	private ServiceDAO servicedao;
	private business.Service service;
	
	private TextView calidad;
	private TextView costo;
	private TextView puntualidad;
	private TextView culminacion;
	private TextView atencion;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_statistics);
		
		calidad = (TextView) findViewById(R.id.TextViewStatcal);
		costo = (TextView) findViewById(R.id.TextViewStatcosto);
		puntualidad = (TextView) findViewById(R.id.TextViewStatpuntua);
		culminacion = (TextView) findViewById(R.id.TextViewStatculm);
		atencion = (TextView) findViewById(R.id.textViewStatatencion);
		
		service = UserGlobal.serviceactual;
		
		calidad.setText(" "+(service.getCalcalidad()/service.getNum_rating()));
		costo.setText(" "+(service.getCalcalidad()/service.getNum_rating()));
		puntualidad.setText(" "+(service.getCalcalidad()/service.getNum_rating()));
		culminacion.setText(" "+(service.getCalcalidad()/service.getNum_rating()));
		atencion.setText(" "+(service.getCalcalidad()/service.getNum_rating()));
	}
	
	
	
}
