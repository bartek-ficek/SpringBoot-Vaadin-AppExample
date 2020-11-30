package pl.bartekficek.rectangle_app;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleInSizeGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private final com.vaadin.flow.component.textfield.TextField textFieldSize;
    private com.vaadin.flow.component.button.Button buttonSmallerPerimeter;
    private com.vaadin.flow.component.button.Button buttonBiggerPerimeter;
    private TextArea textAreaResult;

    @Autowired
    public RectangleInSizeGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        this.textFieldSize = new TextField("Write rectangle perimeter");

        buttonBiggerPerimeter = new com.vaadin.flow.component.button.Button("Show greater than written");
        buttonSmallerPerimeter = new com.vaadin.flow.component.button.Button("Show smaller than written");

        buttonBiggerPerimeter.addClickListener(clickEvent -> textAreaResult.setValue(rectangleRepo.getBigRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));
        buttonSmallerPerimeter.addClickListener(clickEvent -> textAreaResult.setValue(rectangleRepo.getSmallRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));

        textAreaResult = new TextArea("Result");

        add(textFieldSize);
        add(buttonBiggerPerimeter);
        add(buttonSmallerPerimeter);
        add(textAreaResult);
    }
}
