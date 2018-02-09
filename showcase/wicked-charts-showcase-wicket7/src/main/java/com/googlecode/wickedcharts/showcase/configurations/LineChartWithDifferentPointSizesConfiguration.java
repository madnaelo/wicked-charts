package com.googlecode.wickedcharts.showcase.configurations;

import java.util.Arrays;
import java.util.Collections;

import com.googlecode.wickedcharts.chartjs.chartoptions.AxesScale;
import com.googlecode.wickedcharts.chartjs.chartoptions.ChartType;
import com.googlecode.wickedcharts.chartjs.chartoptions.Data;
import com.googlecode.wickedcharts.chartjs.chartoptions.Dataset;
import com.googlecode.wickedcharts.chartjs.chartoptions.Hover;
import com.googlecode.wickedcharts.chartjs.chartoptions.HoverMode;
import com.googlecode.wickedcharts.chartjs.chartoptions.Options;
import com.googlecode.wickedcharts.chartjs.chartoptions.ScaleLabel;
import com.googlecode.wickedcharts.chartjs.chartoptions.Scales;
import com.googlecode.wickedcharts.chartjs.chartoptions.Title;
import com.googlecode.wickedcharts.chartjs.chartoptions.TooltipMode;
import com.googlecode.wickedcharts.chartjs.chartoptions.Tooltips;
import com.googlecode.wickedcharts.chartjs.chartoptions.colors.SimpleColor;
import com.googlecode.wickedcharts.showcase.configurations.base.ShowcaseConfiguration;

@SuppressWarnings("serial")
public class LineChartWithDifferentPointSizesConfiguration extends ShowcaseConfiguration {
	public LineChartWithDifferentPointSizesConfiguration() {
		super();
    	setType(ChartType.LINE);
		
		Data data = new Data()
				.setLabels(Arrays.asList("January", "February", "March", "April", "May", "June", "July"));
		setData(data);
		
		Dataset dataset1 = new Dataset()
				.setLabel("dataset - big points")
				.setBackgroundColor(SimpleColor.RED)
				.setBorderColor(SimpleColor.RED)
				.setData(randomIntegerList(7))
				.setPointRadius(Collections.nCopies(7, "15"))
				.setPointHoverRadius("10")
				.setFill(false);
		
		
		Dataset dataset2 = new Dataset()
				.setLabel("dataset - individual point sizes")
				.setBackgroundColor(SimpleColor.BLUE)
				.setBorderColor(SimpleColor.BLUE)
				.setBorderDash(Arrays.asList("5", "5"))
				.setPointRadius(Arrays.asList("2", "4", "6", "18", "0", "12", "20"))
				.setData(randomIntegerList(7))
				.setFill(false);
		
		Dataset dataset3 = new Dataset()
				.setLabel("dataset - large pointHoverRadius")
				.setBackgroundColor(SimpleColor.GREEN)
				.setBorderColor(SimpleColor.GREEN)
				.setData(randomIntegerList(7))
				.setPointHoverRadius("30")
				.setFill(false);
		
		
		Dataset dataset4 = new Dataset()
			.setLabel("dataset - large pointHitRadius")
			.setBackgroundColor(SimpleColor.YELLOW)
			.setBorderColor(SimpleColor.YELLOW)
			.setData(randomIntegerList(7))
			.setPointHitRadius("20")
			.setFill(false);
		
		data.setDatasets(Arrays.asList(dataset1,dataset2,dataset3, dataset4));
		
		Options options = new Options()
				.setResponsive(true)
				.setTitle(new Title()
						.setDisplay(true)
						.setText("Chart.js Line Chart with Different Point Sizes"))
				.setTooltips(new Tooltips()
						.setMode(TooltipMode.INDEX)
						.setIntersect(false))
				.setHover(new Hover()
						.setMode(HoverMode.NEAREST)
						.setIntersect(true))
				.setScales(new Scales()
						.setXAxes(new AxesScale()
								.setDisplay(true)
								.setScaleLabel(new ScaleLabel()
										.setDisplay(true)
										.setLabelString("Month")))
						.setYAxes(new AxesScale()
								.setDisplay(true)
								.setScaleLabel(new ScaleLabel()
										.setDisplay(true)
										.setLabelString("Value"))))
				;
		setOptions(options);
	}
}
