package nl.crashdata.chartjs.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ChartJsObjectMapperFactory
{
	private static final ObjectMapper INDENT_INSTANCE;
	static
	{
		INDENT_INSTANCE = JsonMapper.builder()
			.addModule(new JavaTimeModule())
			.defaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL,
				JsonInclude.Include.NON_NULL))
			.configure(JsonWriteFeature.QUOTE_FIELD_NAMES, false)
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.configure(SerializationFeature.INDENT_OUTPUT, true)
			.disable(MapperFeature.AUTO_DETECT_CREATORS, MapperFeature.AUTO_DETECT_FIELDS,
				MapperFeature.AUTO_DETECT_GETTERS, MapperFeature.AUTO_DETECT_IS_GETTERS)
			.build();
	}

	private static final ObjectMapper NOINDENT_INSTANCE;
	static
	{
		NOINDENT_INSTANCE = JsonMapper.builder()
			.addModule(new JavaTimeModule())
			.defaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL,
				JsonInclude.Include.NON_NULL))
			.configure(JsonWriteFeature.QUOTE_FIELD_NAMES, false)
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.configure(SerializationFeature.INDENT_OUTPUT, false)
			.disable(MapperFeature.AUTO_DETECT_CREATORS, MapperFeature.AUTO_DETECT_FIELDS,
				MapperFeature.AUTO_DETECT_GETTERS, MapperFeature.AUTO_DETECT_IS_GETTERS)
			.build();
	}

	/**
	 * Returns an {@link ObjectMapper} configured with the right modules and settings to give the
	 * correct output for a chartjs config.
	 *
	 * @param indentOutput
	 *            Whether or not to indent output (pretty print). Indenting is useful when you want
	 *            to show the output to humans but has no value for chartjs itself.
	 */
	public static ObjectMapper getObjectMapper(boolean indentOutput)
	{
		return indentOutput ? INDENT_INSTANCE : NOINDENT_INSTANCE;
	}
}
