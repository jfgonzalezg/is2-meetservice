package meetservice;



import com.example.meetservice2.R;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QualifyServiceActivity extends Activity implements android.widget.RadioGroup.OnCheckedChangeListener{
	
	private Button sendCalification;
	private RadioGroup rgPuntualidad, rgCalidad, rgAtencion, rgCulminacion, rgCosto;


	int punt, aten, cal, culm, cos;
			
	private ProgressDialog pDialog;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_qualify_service);
		rgPuntualidad = (RadioGroup)findViewById(R.id.rbPunt);
		rgCalidad = (RadioGroup)findViewById(R.id.rbCal);
		rgAtencion = (RadioGroup)findViewById(R.id.rbAten);
		rgCulminacion = (RadioGroup)findViewById(R.id.rbCum);
		rgCosto = (RadioGroup)findViewById(R.id.rbCos);

		sendCalification = (Button)findViewById(R.id.Sendbutton);
		
		rgPuntualidad.setOnCheckedChangeListener(this);
		rgCalidad.setOnCheckedChangeListener(this);
		rgAtencion.setOnCheckedChangeListener(this);
		rgCulminacion.setOnCheckedChangeListener(this);
		rgCosto.setOnCheckedChangeListener(this);
		

		
		//score.setComment(comm);
		
	}
			
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		//final Calification score = new Calification();
		//final CalificationDAO scoredao = new CalificationDAO();
		EditText edittext;
		String txt;
		
		switch(checkedId){
		case R.id.P1:
			edittext = (EditText) findViewById(R.id.P1);
			txt = edittext.getText().toString();
			punt = Integer.parseInt(txt);
			break;
		case R.id.P2:
			edittext = (EditText) findViewById(R.id.P2);
			txt = edittext.getText().toString();
			punt = Integer.parseInt(txt);
			break;
		case R.id.P3:
			edittext = (EditText) findViewById(R.id.P3);
			txt = edittext.getText().toString();
			punt = Integer.parseInt(txt);
			break;
		case R.id.P4:
			edittext = (EditText) findViewById(R.id.P4);
			txt = edittext.getText().toString();
			punt = Integer.parseInt(txt);
			break;
		case R.id.P5:
			edittext = (EditText) findViewById(R.id.P5);
			txt = edittext.getText().toString();
			punt = Integer.parseInt(txt);
			break;
		default:
			Toast toast = Toast.makeText(getApplicationContext(),"Por favor califique la Puntualidad en la prestación del Servicio", Toast.LENGTH_SHORT);
			View textview = toast.getView();
			LinearLayout lay = new LinearLayout(getApplicationContext());
			lay.setOrientation(LinearLayout.HORIZONTAL);
			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(android.R.drawable.ic_menu_info_details);
			lay.addView(view);
			lay.addView(textview);
			toast.setView(lay);
			toast.show();
		}
		
		switch(checkedId){
		case R.id.C1:
			edittext = (EditText) findViewById(R.id.C1);
			txt = edittext.getText().toString();
			cal = Integer.parseInt(txt);
			break;
		case R.id.C2:
			edittext = (EditText) findViewById(R.id.C2);
			txt = edittext.getText().toString();
			cal = Integer.parseInt(txt);
			break;
		case R.id.C3:
			edittext = (EditText) findViewById(R.id.C3);
			txt = edittext.getText().toString();
			cal = Integer.parseInt(txt);
			break;
		case R.id.C4:
			edittext = (EditText) findViewById(R.id.C4);
			txt = edittext.getText().toString();
			cal = Integer.parseInt(txt);
			break;
		case R.id.C5:
			edittext = (EditText) findViewById(R.id.C5);
			txt = edittext.getText().toString();
			cal = Integer.parseInt(txt);
			break;
		default:
			Toast toast = Toast.makeText(getApplicationContext(),"Por favor califique la Calidad del Servicio", Toast.LENGTH_SHORT);
			View textview = toast.getView();
			LinearLayout lay = new LinearLayout(getApplicationContext());
			lay.setOrientation(LinearLayout.HORIZONTAL);
			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(android.R.drawable.ic_menu_info_details);
			lay.addView(view);
			lay.addView(textview);
			toast.setView(lay);
			toast.show();
		}
		
		switch(checkedId){
		case R.id.A1:
			edittext = (EditText) findViewById(R.id.A1);
			txt = edittext.getText().toString();
			aten = Integer.parseInt(txt);
			break;
		case R.id.A2:
			edittext = (EditText) findViewById(R.id.A2);
			txt = edittext.getText().toString();
			aten = Integer.parseInt(txt);
			break;
		case R.id.A3:
			edittext = (EditText) findViewById(R.id.A3);
			txt = edittext.getText().toString();
			aten = Integer.parseInt(txt);
			break;
		case R.id.A4:
			edittext = (EditText) findViewById(R.id.A4);
			txt = edittext.getText().toString();
			aten = Integer.parseInt(txt);
			break;
		case R.id.A5:
			edittext = (EditText) findViewById(R.id.A5);
			txt = edittext.getText().toString();
			aten = Integer.parseInt(txt);
			break;
		default:
			Toast toast = Toast.makeText(getApplicationContext(),"Por favor califique la Atención durante el servicio", Toast.LENGTH_SHORT);
			View textview = toast.getView();
			LinearLayout lay = new LinearLayout(getApplicationContext());
			lay.setOrientation(LinearLayout.HORIZONTAL);
			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(android.R.drawable.ic_menu_info_details);
			lay.addView(view);
			lay.addView(textview);
			toast.setView(lay);
			toast.show();
		}
		
		switch(checkedId){
		case R.id.Cu1:
			edittext = (EditText) findViewById(R.id.Cu1);
			txt = edittext.getText().toString();
			culm = Integer.parseInt(txt);
			break;
		case R.id.Cu2:
			edittext = (EditText) findViewById(R.id.Cu2);
			txt = edittext.getText().toString();
			culm = Integer.parseInt(txt);
			break;
		case R.id.Cu3:
			edittext = (EditText) findViewById(R.id.Cu3);
			txt = edittext.getText().toString();
			culm = Integer.parseInt(txt);
			break;
		case R.id.Cu4:
			edittext = (EditText) findViewById(R.id.Cu4);
			txt = edittext.getText().toString();
			culm = Integer.parseInt(txt);
			break;
		case R.id.Cu5:
			edittext = (EditText) findViewById(R.id.Cu5);
			txt = edittext.getText().toString();
			culm = Integer.parseInt(txt);
			break;
		default:
			Toast toast = Toast.makeText(getApplicationContext(),"Por favor califique la Culminación del Servicio", Toast.LENGTH_SHORT);
			View textview = toast.getView();
			LinearLayout lay = new LinearLayout(getApplicationContext());
			lay.setOrientation(LinearLayout.HORIZONTAL);
			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(android.R.drawable.ic_menu_info_details);
			lay.addView(view);
			lay.addView(textview);
			toast.setView(lay);
			toast.show();
		}
		
		switch(checkedId){
		case R.id.Co1:
			edittext = (EditText) findViewById(R.id.Co1);
			txt = edittext.getText().toString();
			cos = Integer.parseInt(txt);
			break;
		case R.id.Co2:
			edittext = (EditText) findViewById(R.id.Co2);
			txt = edittext.getText().toString();
			cos = Integer.parseInt(txt);
			break;
		case R.id.Co3:
			edittext = (EditText) findViewById(R.id.Co3);
			txt = edittext.getText().toString();
			cos = Integer.parseInt(txt);
			break;
		case R.id.Co4:
			edittext = (EditText) findViewById(R.id.Co4);
			txt = edittext.getText().toString();
			cos = Integer.parseInt(txt);
			break;
		case R.id.Co5:
			edittext = (EditText) findViewById(R.id.Co5);
			txt = edittext.getText().toString();
			cos = Integer.parseInt(txt);
			break;
		default:
			Toast toast = Toast.makeText(getApplicationContext(),"Por favor califique la Costo del Servicio", Toast.LENGTH_SHORT);
			View textview = toast.getView();
			LinearLayout lay = new LinearLayout(getApplicationContext());
			lay.setOrientation(LinearLayout.HORIZONTAL);
			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(android.R.drawable.ic_menu_info_details);
			lay.addView(view);
			lay.addView(textview);
			toast.setView(lay);
			toast.show();
		}
		
		sendCalification.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				/*score.setPunctuality(punt);
				score.setQuality(cal);	
				score.setAttention(aten);
				score.setFulfillment(culm);
				score.setCost(cos);
				score.setComment(comm);
				
				scoredao.setScore(score);*/
			}
		});
	}
}