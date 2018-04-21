# java-chartjs
[![Maven metadata URI](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/nl/crashdata/java-chartjs/java-chartjs/maven-metadata.xml.svg)](https://repo1.maven.org/maven2/nl/crashdata/java-chartjs/java-chartjs/)
![license](https://img.shields.io/github/license/haster/java-chartjs.svg)

Java-chartjs provides you with a way to configure and use [ChartJs](https://github.com/chartjs/Chart.js) from Java and Java-based web frameworks such as Apache Wicket.

# Usage
Java-chartjs is available from maven central. Simply add the relevant artifacts to your dependencies.

```xml
<groupId>nl.crashdata.java-chartjs</groupId>
<artifactId>java-chartjs-data</artifactId>
<version>0.70</version>
```

`java-chartjs-data` contains a set of POJOs annotated with [Jackson](https://github.com/FasterXML/jackson) annotations for easy serialization.
It also contains a set of builders to help in creating a full ChartJsConfig.

`java-chartjs-serialization` contains helper code for easy serialization of config based on `java-chartjs-data` classes to a JSON config object for chartjs.

`java-chartjs-wicket` contains a simple wicket `SimpleGraphPanel`, as well as up-to-date [ChartJs](https://github.com/chartjs/Chart.js) and [moment.js](https://github.com/moment/moment/) libraries and assorted `ResourceReferences`,  