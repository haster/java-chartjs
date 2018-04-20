package nl.crashdata.chartjs.data;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.SortedMap;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.crashdata.chartjs.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLinearAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsLocalDateAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsOptionsBuilder;
import org.junit.jupiter.api.Test;

public class ChartJsDataTest
{
	@Test
	public void basicObjectMapping() throws JsonProcessingException
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

		assertOutputMatches(config.build(), getExpectedUserCountOutput());
	}

	private void assertOutputMatches(Serializable objectToMap, String expectedOutput)
			throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		assertEquals(expectedOutput, mapper.writeValueAsString(objectToMap));
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

	private static String getExpectedUserCountOutput()
	{
		// @formatter:off
		return "{\n" + "  data : {\n" + "    datasets : [ {\n" + "      label : \"activeUsers\",\n"
			+ "      borderColor : \"rgba(54, 162, 235, 1.0)\",\n" + "      fill : \"false\",\n"
			+ "      data : [ {\n" + "        x : \"2018-01-01\",\n" + "        y : 10\n"
			+ "      }, {\n" + "        x : \"2018-01-02\",\n" + "        y : 1\n" + "      }, {\n"
			+ "        x : \"2018-01-03\",\n" + "        y : 5\n" + "      }, {\n"
			+ "        x : \"2018-01-04\",\n" + "        y : 15\n" + "      }, {\n"
			+ "        x : \"2018-01-05\",\n" + "        y : 21\n" + "      }, {\n"
			+ "        x : \"2018-01-06\",\n" + "        y : 28\n" + "      }, {\n"
			+ "        x : \"2018-01-07\",\n" + "        y : 3\n" + "      }, {\n"
			+ "        x : \"2018-01-08\",\n" + "        y : 7\n" + "      }, {\n"
			+ "        x : \"2018-01-09\",\n" + "        y : 11\n" + "      }, {\n"
			+ "        x : \"2018-01-10\",\n" + "        y : 17\n" + "      }, {\n"
			+ "        x : \"2018-01-11\",\n" + "        y : 27\n" + "      }, {\n"
			+ "        x : \"2018-01-12\",\n" + "        y : 30\n" + "      }, {\n"
			+ "        x : \"2018-01-13\",\n" + "        y : 8\n" + "      }, {\n"
			+ "        x : \"2018-01-14\",\n" + "        y : 23\n" + "      }, {\n"
			+ "        x : \"2018-01-15\",\n" + "        y : 19\n" + "      }, {\n"
			+ "        x : \"2018-01-16\",\n" + "        y : 18\n" + "      }, {\n"
			+ "        x : \"2018-01-17\",\n" + "        y : 25\n" + "      }, {\n"
			+ "        x : \"2018-01-18\",\n" + "        y : 4\n" + "      } ]\n" + "    } ]\n"
			+ "  },\n" + "  options : {\n" + "    responsive : true,\n" + "    tooltips : {\n"
			+ "      mode : \"index\",\n" + "      intersect : false\n" + "    },\n"
			+ "    hover : {\n" + "      mode : \"nearest\",\n" + "      intersect : true\n"
			+ "    },\n" + "    scales : {\n" + "      xAxis : {\n" + "        display : true,\n"
			+ "        scaleLabel : {\n" + "          display : true,\n"
			+ "          labelString : \"days\"\n" + "        },\n" + "        ticks : {\n"
			+ "          min : \"2018-01-01\"\n" + "        },\n"
			+ "        position : \"bottom\",\n" + "        type : \"time\"\n" + "      },\n"
			+ "      yAxis : {\n" + "        display : true,\n" + "        scaleLabel : {\n"
			+ "          display : true,\n" + "          labelString : \"active users\"\n"
			+ "        },\n" + "        ticks : { },\n" + "        position : \"bottom\",\n"
			+ "        type : \"linear\"\n" + "      },\n" + "      xAxes : [ {\n"
			+ "        display : true,\n" + "        scaleLabel : {\n"
			+ "          display : true,\n" + "          labelString : \"days\"\n" + "        },\n"
			+ "        ticks : {\n" + "          min : \"2018-01-01\"\n" + "        },\n"
			+ "        position : \"bottom\",\n" + "        type : \"time\"\n" + "      } ],\n"
			+ "      yAxes : [ {\n" + "        display : true,\n" + "        scaleLabel : {\n"
			+ "          display : true,\n" + "          labelString : \"active users\"\n"
			+ "        },\n" + "        ticks : { },\n" + "        position : \"bottom\",\n"
			+ "        type : \"linear\"\n" + "      } ]\n" + "    }\n" + "  },\n"
			+ "  type : \"line\"\n" + "}";
		// @formatter:on
	}
}
