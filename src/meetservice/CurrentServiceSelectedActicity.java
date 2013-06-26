package meetservice;

import session.UserGlobal;
import business.Service;

import com.example.meetservice2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class CurrentServiceSelectedActicity extends Activity{
	
	private Service serviceSelected;
	private Button bViewStatistics, bScoreService;
	private TextView tvServiceName, tvServiceDescription;
	private RatingBar ratingbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_service_selected);
		
		bViewStatistics = (Button) findViewById(R.id.bViewStatistics);
		bScoreService = (Button) findViewById(R.id.bScoreService);
		tvServiceName = (TextView) findViewById(R.id.tServiceCurrentName);
		tvServiceDescription = (TextView) findViewById(R.id.tDescription);
		ratingbar = (RatingBar) findViewById(R.id.ratingcurrentservice);
		
		tvServiceDescription.setText(UserGlobal.serviceactual.getDescription());
		tvServiceName.setText(UserGlobal.serviceactual.getName());
		
		ratingbar.setStepSize((float) 0.5);
		ratingbar.setMax(5);
		
		if (UserGlobal.serviceactual.getNum_rating() > 0) {
			ratingbar.setRating(UserGlobal.serviceactual.getRating_acum()
					/ UserGlobal.serviceactual.getNum_rating());
		} else {
			ratingbar.setRating(0);
		}
		
		bViewStatistics.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CurrentServiceSelectedActicity.this,StatisticsServiceActivity.class);
				startActivity(intent);
				
			}
		});
		
		bScoreService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CurrentServiceSelectedActicity.this,ScoreServiceActivity.class);
				startActivity(intent);
			}
		});
		
	}

}
