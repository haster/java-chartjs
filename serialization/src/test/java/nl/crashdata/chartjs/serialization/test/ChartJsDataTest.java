package nl.crashdata.chartjs.serialization.test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.SortedMap;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.crashdata.chartjs.data.ChartJsBoundaryType;
import nl.crashdata.chartjs.data.ChartJsFill;
import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.ChartJsTimeUnit;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.SimpleChartJsXYDataPoint;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLinearAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLocalDateAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsOptionsBuilder;
import nl.crashdata.chartjs.serialization.ChartJsObjectMapperFactory;
import org.junit.jupiter.api.Test;

public class ChartJsDataTest extends AbstractChartJsDataTest
{
	@Test
	public void basicObjectMapping() throws IOException
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

		assertOutputMatches(config.build(), getExpectedUserCountOutputFromFile("output.js"));
	}

	@Test
	public void basicMappingWithCallbackFunctions() throws IOException
	{
		SimpleChartJsConfigBuilder<SimpleChartJsXYDataPoint<LocalDate, Integer>> config =
			SimpleChartJsConfigBuilder.lineChart();

		SortedMap<LocalDate, Integer> dataPoints = createUserCountMap();

		config.data()
			.addDataset()
			.withDataPoints(dataPoints.entrySet(), SimpleChartJsXYDataPoint::new)
			.withLabel("activeUsers");
		config.options().legendConfig().onClick().withBody("var apple = 'monkey'; return;");
		config.options()
			.legendConfig()
			.onHover()
			.withBody("var banana = 'bear'; return;")
			.withDefaultExecute(false);
		config.options()
			.legendConfig()
			.onLeave()
			.withBody("var cherry = 'cat'; return;")
			.withDefaultHandlerBodySupplier(() -> "var myLeave = 'true';");

		ObjectMapper chartjsMapper = ChartJsObjectMapperFactory.getObjectMapper(true);
		String configAsString = chartjsMapper.writeValueAsString(config.build());

		assertThat(configAsString, containsString("var apple = 'monkey'; return;"));
		assertThat(configAsString, containsString("var banana = 'bear'; return;"));
		assertThat(configAsString, containsString("var cherry = 'cat'; return;"));
		assertThat(configAsString,
			containsString("Chart.defaults.line.legend.onClick.call(this, event, item);"));
		assertThat(configAsString,
			not(containsString("Chart.defaults.line.legend.onHover.call(this, event, item);")));
		assertThat(configAsString,
			not(containsString("Chart.defaults.line.legend.onLeave.call(this, event, item);")));
		assertThat(configAsString, containsString("var myLeave = 'true';"));
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
}
