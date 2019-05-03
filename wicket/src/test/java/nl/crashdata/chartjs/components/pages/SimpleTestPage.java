package nl.crashdata.chartjs.components.pages;

import java.time.LocalDate;
import java.time.Month;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import nl.crashdata.chartjs.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.components.panels.SimpleGraphPanel;
import nl.crashdata.chartjs.data.ChartJsBoundaryType;
import nl.crashdata.chartjs.data.ChartJsConfig;
import nl.crashdata.chartjs.data.ChartJsFill;
import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.ChartJsTimeUnit;
import nl.crashdata.chartjs.data.simple.SimpleChartJsXYDataPoint;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLinearAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLocalDateAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsOptionsBuilder;

public class SimpleTestPage extends WebPage
{
	private static final long serialVersionUID = 1L;

	public SimpleTestPage(PageParameters params) 
	{
		add(new SimpleGraphPanel<ChartJsConfig<?>>("userGraph", Model.of(createActiveUsersConfig())));
		add(new SimpleGraphPanel<ChartJsConfig<?>>("pagesGraph", Model.of(createPagesViewedConfig())));
	}
	
	
	private ChartJsConfig<?> createActiveUsersConfig() 
	{
		SimpleChartJsConfigBuilder<SimpleChartJsXYDataPoint<LocalDate, Integer>> config =
				SimpleChartJsConfigBuilder.lineChart();

			SortedMap<LocalDate, Integer> dataPoints = createUserCountMap();

			config.data()
				.addDataset()
				.withDataPoints(dataPoints.entrySet(), SimpleChartJsXYDataPoint::new)
				.withLabel("activeUsers")
				.withFill(ChartJsFill.boundary(ChartJsBoundaryType.START))
				.withBorderColor(ChartJsRGBAColor.BLUE);

			LocalDate smallestXValue = dataPoints.firstKey();

			SimpleChartJsOptionsBuilder optionsBuilder = config.options();
			optionsBuilder.withResponsive(true);
			optionsBuilder.hoverConfig().withIntersect(true).withMode(ChartJsInteractionMode.NEAREST);
			optionsBuilder.tooltipConfig().withIntersect(false).withMode(ChartJsInteractionMode.INDEX);
			SimpleChartJsLocalDateAxisConfigBuilder xAxisBuilder =
				optionsBuilder.scalesConfig().withLocalDateXAxisConfig();
			xAxisBuilder.withDisplay(true).labelConfig().withDisplay(true).withLabelString("days");
			xAxisBuilder.tickConfig().withForcedMinimum(smallestXValue);
			xAxisBuilder.timeConfig().withTimeUnit(ChartJsTimeUnit.DAY).withStepSize(7);
			SimpleChartJsLinearAxisConfigBuilder yAxisBuilder =
				optionsBuilder.scalesConfig().withLinearYAxisConfig();
			yAxisBuilder.withDisplay(true)
				.labelConfig()
				.withDisplay(true)
				.withLabelString("active users");
			
			return config.build();
	}
	
	private ChartJsConfig<?> createPagesViewedConfig() 
	{
		SimpleChartJsConfigBuilder<SimpleChartJsXYDataPoint<LocalDate, Integer>> config =
				SimpleChartJsConfigBuilder.lineChart();

			SortedMap<LocalDate, Integer> pageViewDataPoints = createPageviewMap();
			
			SortedMap<LocalDate, Integer> uniquePagesDataPoints = createUniquePagesViewedMap();

			config.data()
				.addDataset()
				.withDataPoints(pageViewDataPoints.entrySet(), SimpleChartJsXYDataPoint::new)
				.withLabel("pageviews")
				.withFill(ChartJsFill.relativeIndex(1))
				.withBorderColor(ChartJsRGBAColor.YELLOW);
			config.data()
			.addDataset()
			.withDataPoints(uniquePagesDataPoints.entrySet(), SimpleChartJsXYDataPoint::new)
			.withLabel("unique pages viewed")
			.withFill(ChartJsFill.boundary(ChartJsBoundaryType.ORIGIN))
			.withBorderColor(ChartJsRGBAColor.ORANGE);

			SimpleChartJsOptionsBuilder optionsBuilder = config.options();
			optionsBuilder.withResponsive(true);
			optionsBuilder.hoverConfig().withIntersect(true).withMode(ChartJsInteractionMode.NEAREST);
			optionsBuilder.tooltipConfig().withIntersect(false).withMode(ChartJsInteractionMode.INDEX);
			SimpleChartJsLocalDateAxisConfigBuilder xAxisBuilder =
				optionsBuilder.scalesConfig().withLocalDateXAxisConfig();
			xAxisBuilder.withDisplay(true).labelConfig().withDisplay(true).withLabelString("days");
			xAxisBuilder.timeConfig().withTimeUnit(ChartJsTimeUnit.DAY).withStepSize(7);
			SimpleChartJsLinearAxisConfigBuilder yAxisBuilder =
				optionsBuilder.scalesConfig().withLinearYAxisConfig();
			yAxisBuilder.withDisplay(true)
				.labelConfig()
				.withDisplay(true)
				.withLabelString("pageviews");
			
			return config.build();
	}
	
	private static SortedMap<LocalDate, Integer> createUserCountMap()
	{
		SortedMap<LocalDate, Integer> dataPoints = new TreeMap<>();
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 1), 10);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 2), 1);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 3), 5);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 4), 15);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 5), 21);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 6), 28);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 7), 3);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 8), 7);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 9), 11);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 10), 17);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 11), 27);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 12), 30);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 13), 8);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 14), 23);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 15), 19);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 16), 18);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 17), 25);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 18), 4);
		return dataPoints;
	}
	
	private static SortedMap<LocalDate, Integer> createPageviewMap()
	{
		SortedMap<LocalDate, Integer> dataPoints = new TreeMap<>();
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 1), 100);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 2), 101);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 3), 50);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 4), 150);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 5), 210);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 6), 280);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 7), 30);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 8), 70);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 9), 110);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 10), 170);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 11), 270);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 12), 300);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 13), 80);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 14), 230);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 15), 190);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 16), 180);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 17), 250);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 18), 40);
		return dataPoints;
	}
	
	private static SortedMap<LocalDate, Integer> createUniquePagesViewedMap()
	{
		SortedMap<LocalDate, Integer> dataPoints = new TreeMap<>();
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 1), 40);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 2), 34);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 3), 21);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 4), 32);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 5), 12);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 6), 18);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 7), 5);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 8), 8);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 9), 10);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 10), 15);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 11), 23);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 12), 56);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 13), 9);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 14), 28);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 15), 15);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 16), 21);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 17), 19);
		dataPoints.put(LocalDate.of(2018, Month.JANUARY, 18), 7);
		return dataPoints;
	}
}
