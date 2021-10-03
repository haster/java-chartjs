# java-chartjs
[![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fnl%2Fcrashdata%2Fjava-chartjs%2Fjava-chartjs%2Fmaven-metadata.xml)](https://mvnrepository.com/artifact/nl.crashdata.java-chartjs)
![license](https://img.shields.io/github/license/haster/java-chartjs.svg)

Java-chartjs provides you with a way to configure and use [ChartJs](https://github.com/chartjs/Chart.js) from Java and Java-based web frameworks such as Apache Wicket.

# Usage example
In Java:
```java
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
	
String chartJsConfigAsJson = ChartJsObjectMapperFactory.getObjectMapper(true).writeValueAsString(config.build());
```

In HTML/Javascript
```javascript
var ctx = document.getElementById('graphPanel').getContext('2d');
new Chart(ctx, chartJsConfigAsJson);
```

If you use Wicket, you can go straight from building the config to displaying it in the provided SimpleGraphPanel:
```java
public GraphPage()
{
	add(new SimpleGraphPanel("graphPanel", getChartJsConfigModel(), Model.of("My graph")));
}
```
See the tests of the `java-chartjs-wicket` module for more examples.

# Maven Central
Java-chartjs is available from Maven Central. Simply add the relevant artifacts to your dependencies.

```xml
<dependency>
	<groupId>nl.crashdata.java-chartjs</groupId>
	<artifactId>java-chartjs-data</artifactId>
	<version>2.2.0</version>
</dependency>
```

`java-chartjs-data` contains a set of POJOs annotated with [Jackson](https://github.com/FasterXML/jackson) annotations for easy serialization.
It also contains a set of builders to help in creating a full ChartJsConfig.

`java-chartjs-serialization` contains helper code for easy serialization of config based on `java-chartjs-data` classes to a JSON config object for chartjs.

`java-chartjs-wicket` contains a simple wicket `SimpleGraphPanel`, as well as up-to-date [ChartJs](https://github.com/chartjs/Chart.js) and [moment.js](https://github.com/moment/moment/) libraries and assorted `ResourceReferences`.


# ChartJs versions

java-chartjs  |  Chart.js  |  moment.js
--------------|------------|------------
 2.2.x        | 2.9.3      | 2.27.0
 2.1.x        | 2.9.3      | 2.27.0
 2.0.x        | 2.8.0      | 2.24.0
 1.0.0        | 2.8.0      | 2.24.0
 0.9x         | 2.7.2      | 2.22.2
 0.80         | 2.7.2      | 2.21.0
 0.70         | 2.7.2      | 2.21.0
 
 
 
