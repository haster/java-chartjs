package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonValue;
import static nl.crashdata.chartjs.data.ChartJsFillMode.*;

/**
 * A value object to represent the fill-configuration for a chart, ie. how to fill the area under
 * a line or radar graph.
 * 
 * Gets serialised to a javascript string value. Corresponds to the {@code config.data.datasets[].fill} property.
 * 
 * @author haster
 *
 */
public final class ChartJsFill {
	
	public static final ChartJsFill DISABLED = new ChartJsFill();
	static {
		DISABLED.mode = ChartJsFillMode.DISABLED;
		DISABLED.boundary = null;
		DISABLED.datasetIndex = null;
	}

	private ChartJsFillMode mode;

	private ChartJsBoundaryType boundary;

	private Integer datasetIndex;
	
	private ChartJsFill() {}
	
	/**
	 * Sets the fill property to a value indicating it is disabled (ie, don't fill)
	 */
	public static ChartJsFill disabled() {
		return DISABLED;
	}
	
	/**
	 * Sets the fill property to a value indicating fill to a boundary.
	 * @param boundary The boundary to which the area needs to be filled.
	 */
	public static ChartJsFill boundary(ChartJsBoundaryType boundary) {
		ChartJsFill fill = new ChartJsFill();
		fill.mode = BOUNDARY;
		fill.boundary = boundary;
		fill.datasetIndex = null;
		return fill;
	}
	
	/**
	 * Sets the fill property to a value indicating fill to another dataset.
	 * @param datasetIndex the relative index of the dataset to which the area should be filled. Must be nonzero.
	 */
	public static ChartJsFill relativeIndex(int datasetIndex) {
		if (datasetIndex == 0) {
			throw new IllegalArgumentException("Relative dataset index can not be 0!");
		}
		ChartJsFill fill = new ChartJsFill();
		fill.mode = RELATIVE_DATASET_INDEX;
		fill.boundary = null;
		fill.datasetIndex = datasetIndex;
		return fill;
	}
	
	/**
	 * Sets the fill property to a value indicating fill to another dataset.
	 * @param datasetIndex the absolute index of the dataset to which the area should be filled. Must be strictly positive.
	 */
	public static ChartJsFill absoluteIndex(int datasetIndex) {
		if (datasetIndex == 0) {
			throw new IllegalArgumentException("Absolute dataset index can not be 0!");
		}
		if (datasetIndex < 0) {
			throw new IllegalArgumentException("Absolute dataset index can not negative!");
		}
		ChartJsFill fill = new ChartJsFill();
		fill.mode = ABSOLUTE_DATASET_INDEX;
		fill.boundary = null;
		fill.datasetIndex = datasetIndex;
		return fill;
	}

	@JsonValue
	String toJsonString() {
		switch (mode) {
			case ABSOLUTE_DATASET_INDEX:
				return String.format("%d", datasetIndex);
			case RELATIVE_DATASET_INDEX:
				return String.format("%+d", datasetIndex);
			case BOUNDARY:
				return toStringValue(boundary);
			case DISABLED:
				return "false";
			default:
				throw new IllegalStateException();
		}
	}
	
	private static String toStringValue(ChartJsBoundaryType boundary) {
		switch (boundary) {
			case START:
				return "start";
			case END:
				return "end";
			case ORIGIN:
				return "origin";
				default:
					throw new IllegalArgumentException("Unknown ChartJsBoundaryType: "+boundary);
		}
	}
}
