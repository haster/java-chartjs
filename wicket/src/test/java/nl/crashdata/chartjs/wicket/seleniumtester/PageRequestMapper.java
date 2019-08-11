package nl.crashdata.chartjs.wicket.seleniumtester;

import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.IRequestMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;

public class PageRequestMapper
    implements IRequestMapper
{

    private IPageLoader loader;

    private String path;

    public PageRequestMapper( IPageLoader loader, String path )
    {
        this.loader = loader;
        this.path = path;
    }

    @Override
    public IRequestHandler mapRequest( Request request )
    {
        if ( request.getUrl().getPath().equals( path ) )
        {
            return new RenderPageRequestHandler( new PageProvider( loader.getPage() ) );
        }
        return null;
    }

    @Override
    public int getCompatibilityScore( Request request )
    {
        if ( request.getUrl().getPath().equals( path ) )
        {
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @Override
    public Url mapHandler( IRequestHandler requestHandler )
    {
        return null;
    }

}
