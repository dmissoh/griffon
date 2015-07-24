package org.example;

import griffon.core.artifact.GriffonController;
import griffon.metadata.ArtifactProviderFor;
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController;

import griffon.transform.Threading;

@ArtifactProviderFor(GriffonController.class)
public class SampleController extends AbstractGriffonController {
	
    private SampleModel model;

    public void setModel(SampleModel model) {
        this.model = model;
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    public void click() {
        model.setClickCount(model.getClickCount() + 1);
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    public void interact() {
        model.setInteractionCount(model.getInteractionCount() + 1);
    }
}