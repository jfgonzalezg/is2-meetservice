package meetservice;

import business.Score;
import business.Statistics;
import dao.ScoreDAO;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.meetservice2.R;



public class StatisticsServiceActivity extends Activity {
	
	
	private ScoreDAO scoredao;
	private Score score;
	private Statistics statistics;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_statistics);
		
		LinearLayout statistic = (LinearLayout) findViewById(R.id.Statistics);
		
	/*	statistic.addView(tchart);
		
		Series bar = new Bar(tchart.getChart());
		tchart.getAxes().getBottom().setIncrement(1);
		bar.add(123,"Puntualidad",Color.green);
		bar.add(456,"Calidad",Color.blue);
		bar.add(789,"Atencion",Color.yellow);
		bar.add(101112,"Cumplimiento",Color.red);
		bar.add(131415,"Costo",Color.orange);*/
		
	}
	
}
