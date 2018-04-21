package nl.crashdata.chartjs.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ChartJsObjectMapperFactory
{
	/**
	 * Returns an {@link ObjectMapper} configured with the right modules and settings to give the
	 * correct output for a chartjs config.
	 *
	 * @param indentOutput
	 *            Whether or not to indent output (pretty print). Indenting is useful when you want
	 *            to show the output to humans but has no value for chartjs itself.
	 */
	public static ObjectMapper createObjectMapper(boolean indentOutput)
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, indentOutput);
		mapper.disable(MapperFeature.AUTO_DETECT_CREATORS, MapperFeature.AUTO_DETECT_FIELDS,
			MapperFeature.AUTO_DETECT_GETTERS, MapperFeature.AUTO_DETECT_IS_GETTERS);

		return mapper;
	}
}
