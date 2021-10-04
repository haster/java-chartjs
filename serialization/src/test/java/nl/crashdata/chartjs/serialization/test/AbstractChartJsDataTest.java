package nl.crashdata.chartjs.serialization.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import nl.crashdata.chartjs.serialization.ChartJsObjectMapperFactory;
import nl.crashdata.chartjs.serialization.test.resources.TestResourcesMarker;

public class AbstractChartJsDataTest
{
	protected static String getExpectedUserCountOutputFromFile(String fileName) throws IOException
	{
		try (InputStream in = TestResourcesMarker.class.getResourceAsStream(fileName))
		{
			return new BufferedReader(new InputStreamReader(in)).lines()
				.collect(Collectors.joining("\n"));
		}
	}

	protected void assertOutputMatches(Serializable objectToMap, String expectedOutput)
			throws IOException
	{
		ObjectMapper chartjsMapper = ChartJsObjectMapperFactory.getObjectMapper(true);

		ObjectMapper defaultMapper = new ObjectMapper();
		defaultMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		defaultMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		JsonNode actual = defaultMapper.readTree(chartjsMapper.writeValueAsString(objectToMap));
		JsonNode expected = defaultMapper.readTree(expectedOutput);

		assertEquals(expected, actual);
	}
}
