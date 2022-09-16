package pl.maro.desingpatterns.visitor.visitor;

import pl.maro.desingpatterns.visitor.shapes.Circle;
import pl.maro.desingpatterns.visitor.shapes.CompoundShape;
import pl.maro.desingpatterns.visitor.shapes.Dot;
import pl.maro.desingpatterns.visitor.shapes.Rectangle;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JSONExportVisitor implements Visitor {

    @Override
    public String export(Exportable... exportables) {
        return Arrays.stream(exportables)
                .map(exportable -> exportable.export(this))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String visit(Dot dot) {
        return """
                "dot": {
                    "id": %d
                    "x": %d
                    "y": %d
                }""".formatted(dot.getId(), dot.getX(), dot.getY());
    }

    @Override
    public String visit(Circle circle) {
        return """
                "circle": {
                    "id": %d
                    "x": %d
                    "y": %d
                    "radius": %d
                }""".formatted(circle.getId(), circle.getX(), circle.getY(), circle.getRadius());
    }

    @Override
    public String visit(Rectangle rectangle) {
        return """
                "rectangle": {
                    "id": %d
                    "x": %d
                    "y": %d
                    "width": %d
                    "height": %d
                }""".formatted(rectangle.getId(), rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public String visit(CompoundShape compoundShape) {
        var body = compoundShape.getChildren().stream()
                .map(exportable -> exportable.export(this))
                .map(s -> "    %s".formatted(s.replace("\n", "\n    ")))
                .collect(Collectors.joining("\n"));
        return """
                "compound_graphic": {
                    "id": %d
                %s
                }""".formatted(compoundShape.getId(), body);
    }
}
