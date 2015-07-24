package org.example;

import griffon.core.artifact.ArtifactManager;
import griffon.core.test.GriffonUnitRule;
import griffon.core.test.TestFor;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

@TestFor(SampleController.class)
public class SampleControllerTest {
    static {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
    }

    @Inject
    private ArtifactManager artifactManager;

    private SampleController controller;

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule();

    @Test
    public void executeClickAction() {
        // given:
        SampleModel model = artifactManager.newInstance(SampleModel.class);
        controller.setModel(model);

        // when:
        controller.invokeAction("click");
        await().atMost(2, SECONDS);

        // then:
        assertEquals(1, model.getClickCount());
    }
}
