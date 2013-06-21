package meetservice;

import business.Calification;

import com.example.meetservice2.R;

import dao.CalificationDAO;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CalificationActivity extends Activity {
	
	private Button sendCalification;
	private RadioGroup rgPuntualidad, rgCalidad, rgAtencion, rgCulminacion, rgCosto;
	private RadioButton rbPun01, rbPun02, rbPun03, rbPun04, rbPun05;
	private RadioButton rbCal01, rbCal02, rbCal03, rbCal04, rbCal05;
	private RadioButton rbAten01, rbAten02, rbAten03,rbAten04, rbAten05;
	private RadioButton rbCul01, rbCul02, rbCul03, rbCul04, rbCul05;
	private RadioButton rbCos01, rbCos02, rbCos03, rbCos04, rbCos05;
	
	private Calification calification;
	private CalificationDAO calificationdao;
	private ProgressDialog pDialog;
	
    /** Called when the activity is first created. */
   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        
        sendCalification = (Button) findViewById(R.id.Sendbutton) ;
        
        sendCalification.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View v){
        		
        		registerNew(v);
        	}
        });
    }*/
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calificacion);
		rgPuntualidad = (RadioGroup)findViewById(R.id.rbPunt);
		rbPun01 = (RadioButton)findViewById(R.id.P1); 
		rbPun02 = (RadioButton)findViewById(R.id.P2);
		rbPun03 = (RadioButton)findViewById(R.id.P3);
		rbPun04 = (RadioButton)findViewById(R.id.P4);
		rbPun05 = (RadioButton)findViewById(R.id.P5);
		rgCalidad = (RadioGroup)findViewById(R.id.rbCal);
		rbCal01 = (RadioButton)findViewById(R.id.C1);
		rbCal02 = (RadioButton)findViewById(R.id.C2);
		rbCal03 = (RadioButton)findViewById(R.id.C3);
		rbCal04 = (RadioButton)findViewById(R.id.C4);
		rbCal05 = (RadioButton)findViewById(R.id.C5);
		rbCal01 = (RadioButton)findViewById(R.id.C1);		
		rgAtencion = (RadioGroup)findViewById(R.id.rbAten);
		rbAten01 = (RadioButton)findViewById(R.id.A1);
		rbAten02 = (RadioButton)findViewById(R.id.A2);
		rbAten03 = (RadioButton)findViewById(R.id.A3);
		rbAten04 = (RadioButton)findViewById(R.id.A4);
		rbAten05 = (RadioButton)findViewById(R.id.A5);
		rgCulminacion = (RadioGroup)findViewById(R.id.rbCum);
		rbCul01 = (RadioButton)findViewById(R.id.Cu1);
		rbCul02 = (RadioButton)findViewById(R.id.Cu2);
		rbCul03 = (RadioButton)findViewById(R.id.Cu3);
		rbCul04 = (RadioButton)findViewById(R.id.Cu4);
		rbCul05 = (RadioButton)findViewById(R.id.Cu5);
		rgCosto = (RadioGroup)findViewById(R.id.rbCos);
		rbCos01 = (RadioButton)findViewById(R.id.Co1);
		rbCos02 = (RadioButton)findViewById(R.id.Co2);
		rbCos03 = (RadioButton)findViewById(R.id.Co3);
		rbCos04 = (RadioButton)findViewById(R.id.Co4);
		rbCos05 = (RadioButton)findViewById(R.id.Co5);
		
		sendCalification = (Button)findViewById(R.id.Sendbutton);
		sendCalification.setOnClickListener((OnClickListener) this);
		
	}
    
	public void onClick(View v){
		if(v.getId()==R.id.Sendbutton){
			int opcion1 = rgPuntualidad.getCheckedRadioButtonId();
			Log.d("1Act", "Opción " + opcion1);
			if(opcion1 > 0){
				Intent intent = new Intent(this, EstatisticsActivity.class);
				intent.putExtra("Opcion Elegida", opcion1);
				startActivity(intent);
			}
			else{
				Toast t = new Toast(this);
				t.setText(R.string.mensaje_error_calificaciones);
				t.setDuration(Toast.LENGTH_LONG);
				t.show();	
			}
			int opcion2 = rgCalidad.getCheckedRadioButtonId();
			Log.d("2Act", "Opción " + opcion2);
			if(opcion2 > 0){
				Intent intent = new Intent(this, EstatisticsActivity.class);
				intent.putExtra("Opcion Elegida", opcion2);
				startActivity(intent);
			}
			else{
				Toast t = new Toast(this);
				t.setText(R.string.mensaje_error_calificaciones);
				t.setDuration(Toast.LENGTH_LONG);
				t.show();	
			}
			int opcion3 = rgAtencion.getCheckedRadioButtonId();
			Log.d("3Act", "Opción " + opcion3);
			if(opcion3 > 0){
				Intent intent = new Intent(this, EstatisticsActivity.class);
				intent.putExtra("Opcion Elegida", opcion3);
				startActivity(intent);
			}
			else{
				Toast t = new Toast(this);
				t.setText(R.string.mensaje_error_calificaciones);
				t.setDuration(Toast.LENGTH_LONG);
				t.show();	
			}
			int opcion4 = rgCulminacion.getCheckedRadioButtonId();
			Log.d("2Act", "Opción " + opcion4);
			if(opcion4 > 0){
				Intent intent = new Intent(this, EstatisticsActivity.class);
				intent.putExtra("Opcion Elegida", opcion4);
				startActivity(intent);
			}
			else{
				Toast t = new Toast(this);
				t.setText(R.string.mensaje_error_calificaciones);
				t.setDuration(Toast.LENGTH_LONG);
				t.show();	
			}
			
			int opcion5 = rgPuntualidad.getCheckedRadioButtonId();
			Log.d("2Act", "Opción " + opcion5);
			if(opcion5 > 0){
				Intent intent = new Intent(this, EstatisticsActivity.class);
				intent.putExtra("Opcion Elegida", opcion5);
				startActivity(intent);
			}
			else{
				Toast t = new Toast(this);
				t.setText(R.string.mensaje_error_calificaciones);
				t.setDuration(Toast.LENGTH_LONG);
				t.show();	
			}
		}
	}
}