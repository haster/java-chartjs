package nl.crashdata.chartjs.data.simple.builder;

/**
 * Simple super interface for all SimpleChartJs*Builders to ensure to all have an {@link #isValid()}
 * and {@link #build()} method.
 *
 * @author haster
 * @param <C>
 *            The type of SimpleChartJs configuration object this builder builds.
 */
public interface SimpleChartJsBuilder<C>
{
	/**
	 * Returns {@code true} if the state of this builder, including all its delegate builders, is
	 * ready to build. "Ready to build" means that this builder, including all its delegate
	 * builders, is in such a state that {@link #build()} would return a viable SimpleChartJs
	 * configuration object.
	 */
	boolean isValid();

	/**
	 * Builds a valid {@code C} such that {@code builder.build() != builder.build()}.
	 *
	 * @return a valid {@code C} if and only if {@link #isValid()} returns true.
	 * @throws IllegalStateException
	 *             if called when {@link #isValid()} returns false
	 */
	C build() throws IllegalStateException;
}
