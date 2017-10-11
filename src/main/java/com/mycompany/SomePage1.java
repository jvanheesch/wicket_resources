package com.mycompany;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

public class SomePage1 extends WebPage {
    private static final long serialVersionUID = -8896769873107976128L;

    private static final String SOME_STYLE_SHEET_CSS = "SomeStyleSheet.css";

    @Override
    public void renderHead(IHeaderResponse response) {
        // note the scope parameter = any class in corresponding package
        response.render(CssHeaderItem.forReference(new CssResourceReference(WicketApplication.class, SOME_STYLE_SHEET_CSS)));
    }
}
