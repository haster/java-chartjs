package nl.crashdata.chartjs.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.crashdata.chartjs.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLinearAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLocalDateAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsOptionsBuilder;
import nl.crashdata.chartjs.serialization.ChartJsObjectMapperFactory;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import resources.TestResourcesMarker;

public class ChartJsDataTest
{
	@Test
	public void basicObjectMapping() throws JSONException, IOException
	{
		SimpleChartJsConfigBuilder<LocalDate, Integer> config =
			SimpleChartJsConfigBuilder.lineChart();

		SortedMap<LocalDate, Integer> dataPoints = createUserCountMap();

		config.data()
			.addDataset()
			.withDataPoints(dataPoints)
			.withLabel("activeUsers")
			.withBorderColor(ChartJsRGBAColor.BLUE);

		LocalDate smallestXValue = dataPoints.firstKey();

		SimpleChartJsOptionsBuilder<LocalDate, Integer> optionsBuilder = config.options();
		optionsBuilder.withResponsive(true);
		optionsBuilder.hoverConfig().withIntersect(true).withMode(ChartJsInteractionMode.NEAREST);
		optionsBuilder.tooltipConfig().withIntersect(false).withMode(ChartJsInteractionMode.INDEX);
		SimpleChartJsLocalDateAxisConfigBuilder xAxisBuilder =
			optionsBuilder.scalesConfig().withLocalDateXAxisConfig();
		xAxisBuilder.withDisplay(true).labelConfig().withDisplay(true).withLabelString("days");
		xAxisBuilder.tickConfig().withForcedMinimum(smallestXValue);
		SimpleChartJsLinearAxisConfigBuilder yAxisBuilder =
			optionsBuilder.scalesConfig().withLinearYAxisConfig();
		yAxisBuilder.withDisplay(true).labelConfig().withDisplay(true).withLabelString(
			"active users");

		assertOutputMatches(config.build(), getExpectedUserCountOutputFromFile());
	}

	private void assertOutputMatches(Serializable objectToMap, String expectedOutput)
			throws JsonProcessingException, JSONException
	{
		ObjectMapper mapper = ChartJsObjectMapperFactory.createObjectMapper(true);

		JSONAssert.assertEquals(expectedOutput, mapper.writeValueAsString(objectToMap),
			JSONCompareMode.STRICT);
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

	private static String getExpectedUserCountOutputFromFile() throws IOException
	{
		try (InputStream in = TestResourcesMarker.class.getResource("../output.js").openStream())
		{
			return new BufferedReader(new InputStreamReader(in)).lines()
				.collect(Collectors.joining("\n"));
		}
	}
}
