package org.example;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import griffon.core.artifact.GriffonView;
import griffon.lanterna.support.LanternaAction;
import griffon.lanterna.widgets.MutableButton;
import griffon.metadata.ArtifactProviderFor;
import org.codehaus.griffon.runtime.lanterna.artifact.AbstractLanternaGriffonView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;

import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.component.Table;

@ArtifactProviderFor(GriffonView.class)
public class SampleView extends AbstractLanternaGriffonView {
    private SampleModel model;
    private SampleController controller;

    public void setModel(SampleModel model) {
        this.model = model;
    }

    public void setController(SampleController controller) {
        this.controller = controller;
    }

    @Override
    public void initUI() {
        Window window = (Window) getApplication()
            .createApplicationContainer(Collections.<String, Object>emptyMap());
        getApplication().getWindowManager().attach("mainWindow", window);
        Panel panel = new Panel(Panel.Orientation.VERTICAL);

        final Label clickLabel = new Label(String.valueOf(model.getClickCount()));
        panel.addComponent(clickLabel);

        LanternaAction clickAction = toolkitActionFor(controller, "click");
        panel.addComponent(new MutableButton(clickAction));

        model.addPropertyChangeListener("clickCount", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                clickLabel.setText(String.valueOf(evt.getNewValue()));
            }
        });

        final Label interactionLabel = new Label(String.valueOf(model.getInteractionCount()));
        panel.addComponent(interactionLabel);

        LanternaAction interactionAction = toolkitActionFor(controller, "interact");
        panel.addComponent(new MutableButton(interactionAction));

        model.addPropertyChangeListener("interactionCount", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                interactionLabel.setText(String.valueOf(evt.getNewValue()));
            }
        });

        Table table = new Table(6);
        table.setColumnPaddingSize(5);
        
        Component[] row1 = new Component[6];
        row1[0] = new Label("Field-1");
        row1[1] = new Label("Field-2");
        row1[2] = new Label("Field-3");
        row1[3] = new Label("Field-4");
        row1[4] = new Label("Field-5");
        row1[5] = new Label("Field-6");
        
        table.addRow(row1);
        panel.addComponent(table);

        window.addComponent(panel);
    }
}