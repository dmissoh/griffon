package org.example;

import griffon.core.artifact.GriffonModel;
import griffon.metadata.ArtifactProviderFor;
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonModel;

@ArtifactProviderFor(GriffonModel.class)
public class SampleModel extends AbstractGriffonModel {

    private int clickCount = 0;

    private int interactionCount = 1;

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        firePropertyChange("clickCount", this.clickCount, this.clickCount = clickCount);
    }

    public int getInteractionCount() {
        return interactionCount;
    }

    public void setInteractionCount(int interactionCount) {
        firePropertyChange("interactionCount", this.interactionCount, this.interactionCount = interactionCount);
    }
}