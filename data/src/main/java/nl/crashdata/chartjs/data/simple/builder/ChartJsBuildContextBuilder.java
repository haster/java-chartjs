package nl.crashdata.chartjs.data.simple.builder;

@Deprecated
public interface ChartJsBuildContextBuilder<C> extends SimpleChartJsBuilder<C>
{
	@Override
	default C build()
	{
		return build(new BuildContext());
	}

	@Override
	C build(BuildContext context);
}
