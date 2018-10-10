package nl.crashdata.chartjs.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ChartJsObjectMapperFactory
{
	private static final ObjectMapper INDENT_INSTANCE;
	static
	{
		INDENT_INSTANCE = new ObjectMapper();
		INDENT_INSTANCE.registerModule(new JavaTimeModule());
		INDENT_INSTANCE.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
		INDENT_INSTANCE.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		INDENT_INSTANCE.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		INDENT_INSTANCE.configure(SerializationFeature.INDENT_OUTPUT, true);
		INDENT_INSTANCE.disable(MapperFeature.AUTO_DETECT_CREATORS,
			MapperFeature.AUTO_DETECT_FIELDS, MapperFeature.AUTO_DETECT_GETTERS,
			MapperFeature.AUTO_DETECT_IS_GETTERS);
	}

	private static final ObjectMapper NOINDENT_INSTANCE;
	static
	{
		NOINDENT_INSTANCE = new ObjectMapper();
		NOINDENT_INSTANCE.registerModule(new JavaTimeModule());
		NOINDENT_INSTANCE.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
		NOINDENT_INSTANCE.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		NOINDENT_INSTANCE.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		NOINDENT_INSTANCE.configure(SerializationFeature.INDENT_OUTPUT, false);
		NOINDENT_INSTANCE.disable(MapperFeature.AUTO_DETECT_CREATORS,
			MapperFeature.AUTO_DETECT_FIELDS, MapperFeature.AUTO_DETECT_GETTERS,
			MapperFeature.AUTO_DETECT_IS_GETTERS);
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
