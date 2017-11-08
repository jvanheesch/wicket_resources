package com.mycompany;

import com.mycompany.mounting.ImageResourceReference;
import com.mycompany.mounting.ImageResourcesPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {
    @Override
    protected void init() {
        super.init();

        this.mountResource("/images/${name}", new ImageResourceReference());
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return ImageResourcesPage.class;
    }
}
