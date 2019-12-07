package kr.ac.sunmoon.client;

import java.awt.List;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;


public class Advertise_KJinteration extends Window{

	private final Panel formpanel = new Panel();
	private String [] kjinteractioncitylist = new String[16];
	
	public Advertise_KJinteration() {
		// TODO Auto-generated constructor stub
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(650);
		this.setHeight(500);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);

		formpanel.setFrame(true);
		formpanel.setTitle("Adbertise"); 
//	    formpanel.setBorder(false);  
	    formpanel.setWidth(650);
	    
//	    formpanel.add(createChart());
//	    this.add(formpanel);
	    this.add(createChart());
	}
	 public Chart createChart() {  
		  
	        final Chart chart = new Chart()  
	            .setType(Series.Type.PIE)  
	            .setChartTitleText("Statistics city of low KJ Interaction")  
//	            .setPlotBackgroundColor((String) null)  //그라데이션
	            .setPlotBorderWidth(null)  
	            .setPlotShadow(true)  
	            .setPiePlotOptions(new PiePlotOptions()  
	                .setAllowPointSelect(true)  
	                .setCursor(PlotOptions.Cursor.POINTER)  
	                .setPieDataLabels(new PieDataLabels()  
	                    .setConnectorColor("#000000")  
	                    .setEnabled(true)  
	                    .setColor("#000000")  
	                    .setFormatter(new DataLabelsFormatter() {  
	                        public String format(DataLabelsData dataLabelsData) {  
	                            return "<b>" + dataLabelsData.getPointName() + "</b>: " + dataLabelsData.getYAsDouble() + " %";  
	                        }  
	                    })  
	                )  
	            )  
	            .setLegend(new Legend()  
	                .setLayout(Legend.Layout.VERTICAL)  
	                .setAlign(Legend.Align.RIGHT)  
	                .setVerticalAlign(Legend.VerticalAlign.TOP)  
	                .setX(-100)  
	                .setY(100)  
	                .setFloating(true)  
	                .setBorderWidth(1)  
	                .setBackgroundColor("#FFFFFF")  
	                .setShadow(true)  
	            )  
	            .setToolTip(new ToolTip()  
	                .setFormatter(new ToolTipFormatter() {  
	                    public String format(ToolTipData toolTipData) {  
	                        return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";  
	                    }  
	                })  
	            );  
	  
	        chart.addSeries(chart.createSeries()  
	            .setName("Low KJ Interaction")  
	            .setPoints(new Point[]{  
	                new Point("Chungcheongnam-do", 0.06),  
	                new Point("Hokkaido", 1.5),  
	                new Point("Chubu", 3.78)  
	                    .setSliced(true)  
	                    .setSelected(true),  
	                new Point("Chugoku", 5.0),  
	                new Point("Gyeongsangbuk-", 9.5),  
	                new Point("Chungcheongbuk-", 13.8),
	                new Point("Seoul", 41.3),
	                new Point("Gyeonggi", 45.2)
	            })  
	        );  
	  
	        return chart;  
	    }  
}
