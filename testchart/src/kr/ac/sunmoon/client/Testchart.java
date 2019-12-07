package kr.ac.sunmoon.client;

import com.google.gwt.i18n.client.*;  
import com.google.gwt.core.client.EntryPoint;  
import com.google.gwt.user.client.ui.RootPanel;  
import org.moxieapps.gwt.highcharts.client.*;  
import org.moxieapps.gwt.highcharts.client.labels.*;  
import org.moxieapps.gwt.highcharts.client.plotOptions.*;  

public class Testchart implements EntryPoint {
	public void onModuleLoad() {
		
         RootPanel.get().add(createChart());  
    }  
  
    public Chart createChart() {  
  
        final Chart chart = new Chart()  
            .setType(Series.Type.PIE)  
            .setChartTitleText("Browser market shares at a specific website, 2010")  
            .setPlotBackgroundColor((String) null)  
            .setPlotBorderWidth(null)  
            .setPlotShadow(false)
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
            .setName("Browser share")  
            .setPoints(new Point[]{  
                new Point("Firefox", 45.0),  
                new Point("IE", 26.8),  
                new Point("Chrome", 12.8)  
                    .setSliced(true)  
                    .setSelected(true),  
                new Point("Safari", 8.5),  
                new Point("Opera", 6.2),  
                new Point("Others", 0.7)  
            })  
        );  
        chart.setWidth(150);
        chart.setHeight(150);
        
        return chart;  
    }  
}