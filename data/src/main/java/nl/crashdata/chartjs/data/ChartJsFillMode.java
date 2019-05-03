package nl.crashdata.chartjs.data;

/**
 * The 'mode' of the fill-property value. Does not correspond directly to an actual json value in the config.
 * 
 * See chartjs docs for the {@code data.datasets[].fill}-property.
 * 
 * @author haster
 *
 */
public enum ChartJsFillMode {
	ABSOLUTE_DATASET_INDEX, RELATIVE_DATASET_INDEX, BOUNDARY, DISABLED;
}
