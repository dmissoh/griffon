import griffon.util.AbstractMapResourceBundle;

import javax.annotation.Nonnull;
import java.util.Map;

import static java.util.Arrays.asList;
import static griffon.util.CollectionUtils.map;

public class Config extends AbstractMapResourceBundle {
    @Override
    protected void initialize(@Nonnull Map<String, Object> entries) {
        map(entries)
            .e("application", map()
                .e("title", "My First Steps")
                .e("startupGroups", asList("firststeps"))
                .e("autoShutdown", true)
            )
            .e("mvcGroups", map()
                .e("firststeps", map()
                    .e("model", "org.example.SampleModel")
                    .e("view", "org.example.SampleView")
                    .e("controller", "org.example.SampleController")
                )
            );
    }
}