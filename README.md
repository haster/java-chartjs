# java-chartjs
[![Maven metadata URI](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/nl/crashdata/java-chartjs/java-chartjs/maven-metadata.xml.svg)](https://repo1.maven.org/maven2/nl/crashdata/java-chartjs/java-chartjs/)
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

SimpleChartJsLinearAxisConfigBuilder yAxisBuilder =
	optionsBuilder.scalesConfig().withLinearYAxisConfig();
yAxisBuilder.withDisplay(true).labelConfig().withDisplay(true).withLabelString(
	"active users");
	
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

# Maven Central
Java-chartjs is available from Maven Central. Simply add the relevant artifacts to your dependencies.

```xml
<dependency>
	<groupId>nl.crashdata.java-chartjs</groupId>
	<artifactId>java-chartjs-data</artifactId>
	<version>1.0.0</version>
</dependency>
```

`java-chartjs-data` contains a set of POJOs annotated with [Jackson](https://github.com/FasterXML/jackson) annotations for easy serialization.
It also contains a set of builders to help in creating a full ChartJsConfig.

`java-chartjs-serialization` contains helper code for easy serialization of config based on `java-chartjs-data` classes to a JSON config object for chartjs.

`java-chartjs-wicket` contains a simple wicket `SimpleGraphPanel`, as well as up-to-date [ChartJs](https://github.com/chartjs/Chart.js) and [moment.js](https://github.com/moment/moment/) libraries and assorted `ResourceReferences`.


# ChartJs versions

java-chartjs  |  Chart.js  |  moment.js
--------------|------------|------------
 0.70         | 2.7.2      | 2.21.0
 0.80         | 2.7.2      | 2.21.0
 0.9x         | 2.7.2      | 2.22.2
 1.0.0        | 2.8.0      | 2.24.0
 
 
 