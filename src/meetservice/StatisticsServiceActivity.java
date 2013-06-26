package meetservice;

import business.Score;
import business.Statistics;
import dao.ScoreDAO;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.meetservice2.R;
import com.steema.teechart.TChart;
import com.steema.teechart.drawing.Color;
import com.steema.teechart.styles.Bar;
import com.steema.teechart.styles.Series;
/*import com.steema.teechart.axis.Axes;
import com.steema.teechart.axis.Axis;
import com.steema.teechart.drawing.Color;
import com.steema.teechart.drawing.Point;
import com.steema.teechart.drawing.StringAlignment;
import com.steema.teechart.events.ChartMouseEvent;
import com.steema.teechart.events.ChartMouseListener;
import com.steema.teechart.styles.Area;
import com.steema.teechart.styles.Line;
import com.steema.teechart.styles.PointerStyle;
import com.steema.teechart.styles.Series;
import com.steema.teechart.styles.SeriesMarks;
import com.steema.teechart.styles.SeriesXYPoint;
import com.steema.teechart.styles.Shape;
import com.steema.teechart.styles.VerticalAxis;
import com.steema.teechart.tools.Annotation;
import com.steema.teechart.tools.MarksTip;
import com.steema.teechart.tools.AnnotationPosition;*/


public class StatisticsServiceActivity extends Activity {
	
	private TChart tchart;
	private ScoreDAO scoredao;
	private Score score;
	private Statistics statistics;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_statistics);
		
		LinearLayout statistic = (LinearLayout) findViewById(R.id.Statistics);
		
		statistic.addView(tchart);
		
		Series bar = new Bar(tchart.getChart());
		tchart.getAxes().getBottom().setIncrement(1);
		bar.add(123,"Puntualidad",Color.green);
		bar.add(456,"Calidad",Color.blue);
		bar.add(789,"Atencion",Color.yellow);
		bar.add(101112,"Cumplimiento",Color.red);
		bar.add(131415,"Costo",Color.orange);
		
	}
	
}
