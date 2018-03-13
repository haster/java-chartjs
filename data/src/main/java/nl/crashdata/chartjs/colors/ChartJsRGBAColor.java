package nl.crashdata.chartjs.colors;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An immutable value object to represent colors for chartjs. Gets serialised to a javascript
 * {@code rgba} object.
 *
 * @author haster
 */
public final class ChartJsRGBAColor implements Serializable
{
	private static final long serialVersionUID = 1L;

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

	/**
	 * Parameters should be in the range 0-255, inclusive. The resulting object will have an alpha
	 * value of 100%
	 */
	public ChartJsRGBAColor(int red, int green, int blue)
	{
		this(red, green, blue, 100);
	}

	/**
	 * Parameters should be in the range 0-255, inclusive. Alpha should be in the range 0-100,
	 * inclusive.
	 */
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

	/**
	 * Creates a new ChartJsRGBAColor object with the given value for its red component and the
	 * values for the other colors from the current object.
	 *
	 * @param red
	 *            A value between 0 and 255, inclusive.
	 */
	public ChartJsRGBAColor withRed(int red)
	{
		return new ChartJsRGBAColor(red, getGreen(), getBlue(), getAlpha());
	}

	/**
	 * Creates a new ChartJsRGBAColor object with the given value for its green component and the
	 * values for the other colors from the current object.
	 *
	 * @param green
	 *            A value between 0 and 255, inclusive.
	 */
	public ChartJsRGBAColor withGreen(int green)
	{
		return new ChartJsRGBAColor(getRed(), green, getBlue(), getAlpha());
	}

	/**
	 * Creates a new ChartJsRGBAColor object with the given value for its blue component and the
	 * values for the other colors from the current object.
	 *
	 * @param blue
	 *            A value between 0 and 255, inclusive.
	 */
	public ChartJsRGBAColor withBlue(int blue)
	{
		return new ChartJsRGBAColor(getRed(), getGreen(), blue, getAlpha());
	}

	/**
	 * Creates a new ChartJsRGBAColor object with the given value for its alpha component and the
	 * values for the other colors from the current object.
	 *
	 * @param alpha
	 *            A value between 0 and 100, inclusive.
	 */
	public ChartJsRGBAColor withAlpha(int alpha)
	{
		return new ChartJsRGBAColor(getRed(), getGreen(), getBlue(), alpha);
	}

	/**
	 * @return this object as javascript {@code rgba} object, for example
	 *         {@code "rgba(25, 125, 208, 0.35)"}
	 */
	@JsonValue
	public String toJsonString()
	{
		return String.format(Locale.ROOT, "rgba(%d, %d, %d, %1.1f)", red, green, blue,
			alpha / 100.0f);
	}

	@Override
	public String toString()
	{
		return String.format(Locale.ROOT, "%s(%d, %d, %d, %d)", getClass().getSimpleName(), red,
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

	/**
	 * Used by the constructors to ensure the provided color values are valid.
	 *
	 * @throws IllegalArgumentException
	 *             if the given value is outside the [0-255] range.
	 */
	public static short ensureValidColourValue(int value)
	{
		if (value >= 0 && value <= 255)
			return (short) value;
		throw new IllegalArgumentException("Colour value should be between 0 and 255, inclusive");
	}

	/**
	 * Used by the constructors to ensure the provided alpha values are valid.
	 *
	 * @throws IllegalArgumentException
	 *             if the given value is outside the [0-100] range.
	 */
	public static short ensureValidAlphaValue(int value)
	{
		if (value >= 0 && value <= 100)
			return (short) value;
		throw new IllegalArgumentException("Alpha value should be between 0 and 100, inclusive");
	}
}
