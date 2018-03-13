package nl.crashdata.chartjs.colors;

import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

public final class ChartJsRGBAColor
{
	public static final ChartJsRGBAColor RED = new ChartJsRGBAColor(255, 99, 132);

	public static final ChartJsRGBAColor ORANGE = new ChartJsRGBAColor(255, 159, 64);

	public static final ChartJsRGBAColor YELLOW = new ChartJsRGBAColor(255, 205, 86);

	public static final ChartJsRGBAColor GREEN = new ChartJsRGBAColor(75, 192, 192);

	public static final ChartJsRGBAColor BLUE = new ChartJsRGBAColor(54, 162, 235);

	public static final ChartJsRGBAColor PURPLE = new ChartJsRGBAColor(153, 102, 255);

	public static final ChartJsRGBAColor GREY = new ChartJsRGBAColor(201, 203, 207);

	private final short red;

	private final short green;

	private final short blue;

	private final short alpha;

	public ChartJsRGBAColor(int red, int green, int blue)
	{
		this(red, green, blue, 100);
	}

	public ChartJsRGBAColor(int red, int green, int blue, int alpha)
	{
		this.red = ensureValidColourValue(red);
		this.green = ensureValidColourValue(green);
		this.blue = ensureValidColourValue(blue);
		this.alpha = ensureValidAlphaValue(alpha);
	}

	public short getRed()
	{
		return red;
	}

	public short getGreen()
	{
		return green;
	}

	public short getBlue()
	{
		return blue;
	}

	public short getAlpha()
	{
		return alpha;
	}

	public ChartJsRGBAColor withRed(short red)
	{
		return new ChartJsRGBAColor(red, getGreen(), getBlue(), getAlpha());
	}

	public ChartJsRGBAColor withGreen(short green)
	{
		return new ChartJsRGBAColor(getRed(), green, getBlue(), getAlpha());
	}

	public ChartJsRGBAColor withBlue(short blue)
	{
		return new ChartJsRGBAColor(getRed(), getGreen(), blue, getAlpha());
	}

	public ChartJsRGBAColor withAlpha(short alpha)
	{
		return new ChartJsRGBAColor(getRed(), getGreen(), getBlue(), alpha);
	}

	@JsonValue
	public String toJsonString()
	{
		return String.format(Locale.ROOT, "rgba(%d, %d, %d, %1.1f)", red, green, blue,
			alpha / 100.0f);
	}

	@Override
	public String toString()
	{
		return String.format(Locale.ROOT, "%s(%d, %d, %d, %1.1f)", getClass().getSimpleName(), red,
			green, blue, alpha);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ChartJsRGBAColor)
		{
			ChartJsRGBAColor other = (ChartJsRGBAColor) obj;
			return this.red == other.red && this.green == other.green && this.blue == other.blue
				&& this.alpha == other.alpha;
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(red, green, blue, alpha);
	}

	public static short ensureValidColourValue(int value)
	{
		if (value >= 0 && value <= 255)
			return (short) value;
		throw new IllegalArgumentException("Colour value should be between 0 and 255, inclusive");
	}

	public static short ensureValidAlphaValue(int value)
	{
		if (value >= 0 && value <= 100)
			return (short) value;
		throw new IllegalArgumentException("Alpha value should be between 0 and 100, inclusive");
	}
}
