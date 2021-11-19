package nl.crashdata.chartjs.serialization.test;

import java.io.IOException;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsConfigBuilder;
import org.junit.jupiter.api.Test;

public class BarChartSampleTest extends AbstractChartJsDataTest
{
	@Test
	public void vertBarChartSample() throws IOException
	{
		List<String> labels =
			List.of("January", "February", "March", "April", "May", "June", "July");
		List<Integer> datapoints1 = List.of(10, 15, -1, 24, 31, -4, 3);
		List<Integer> datapoints2 = List.of(11, 2, 34, -17, -22, 13, 0);

		ChartJsRGBAColor red = new ChartJsRGBAColor(255, 99, 132);
		ChartJsRGBAColor blue = new ChartJsRGBAColor(54, 162, 235);

		SimpleChartJsConfigBuilder<Integer> config = SimpleChartJsConfigBuilder.barChart();
		config.data().withLabels(labels);
		config.data()
			.addDataset()
			.withBorderColor(red)
			.withBackgroundColor(red.withAlpha(50))
			.withDataPoints(datapoints1)
			.withLabel("Dataset 1");
		config.data()
			.addDataset()
			.withBorderColor(blue)
			.withBackgroundColor(blue.withAlpha(50))
			.withDataPoints(datapoints2)
			.withLabel("Dataset 2");
		config.options().withResponsive(true);
		config.options().pluginsConfig().legendConfig().withPosition(ChartJsPosition.TOP);
		config.options()
			.pluginsConfig()
			.titleConfig()
			.addText("Chart.js Bar Chart")
			.withDisplay(true);

		assertOutputMatches(config.build(),
			getExpectedOutputFromFile("barchart-sample.js"));
	}
}
