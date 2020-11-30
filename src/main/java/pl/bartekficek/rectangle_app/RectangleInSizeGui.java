package pl.bartekficek.rectangle_app;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

@Route
public class RectangleInSizeGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;
    private TextArea textArea;

    @Autowired
    public RectangleInSizeGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textArea=new TextArea();
        textArea.setValue(rectangleRepo.getBigRectangles().toString());

        add(textArea);

    }


}
