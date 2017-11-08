package com.mycompany.mounting;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;

import java.util.Arrays;

/**
 * http://wicketinaction.com/2011/07/wicket-1-5-mounting-resources/
 * https://github.com/martin-g/blogs/tree/master/request-mappers/src/main/java/com/wicketinaction/requestmappers/resources/images
 */
public class ImageResourcesPage extends WebPage {
    private static final long serialVersionUID = 5469589539962066182L;

    /**
     * The image names for which dynamic images will be generated
     */
    private static final String[] IMAGE_NAMES = new String[]{"one", "two", "three"};

    public ImageResourcesPage(PageParameters parameters) {
        super(parameters);

        ResourceReference imagesResourceReference = new ImageResourceReference();
        PageParameters imageParameters = new PageParameters();

        ListView<String> listView = new ListView<String>("list", Arrays.asList(IMAGE_NAMES)) {
            private static final long serialVersionUID = -37086421349451694L;

            @Override
            protected void populateItem(ListItem<String> item) {
                String imageName = item.getModelObject();
                imageParameters.set("name", imageName);

                // generates nice looking url (the mounted one) to the current image
                CharSequence urlForWordAsImage = this.getRequestCycle().urlFor(imagesResourceReference, imageParameters);
                ExternalLink link = new ExternalLink("link", urlForWordAsImage.toString());
                link.setBody(Model.of(imageName));
                item.add(link);
            }
        };
        this.add(listView);
    }
}
