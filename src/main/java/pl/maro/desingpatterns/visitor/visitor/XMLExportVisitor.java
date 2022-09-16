package pl.maro.desingpatterns.visitor.visitor;


import pl.maro.desingpatterns.visitor.shapes.Circle;
import pl.maro.desingpatterns.visitor.shapes.CompoundShape;
import pl.maro.desingpatterns.visitor.shapes.Dot;
import pl.maro.desingpatterns.visitor.shapes.Rectangle;

import java.util.Arrays;
import java.util.stream.Collectors;

public class XMLExportVisitor implements Visitor {

    @Override
    public String export(Exportable... exportables) {
        var formattedShapes = Arrays.stream(exportables)
                .map(exportable -> exportable.export(this))
                .collect(Collectors.joining("\n"));

        return """
                <!xml version="1.0" encoding="utf-8"?>
                %s""".formatted(formattedShapes);
    }

    @Override
    public String visit(Dot dot) {
        return """
                <dot>
                    <id>%d</id>
                    <x>%d</x>
                    <y>%d</y>
                </dot>""".formatted(dot.getId(), dot.getX(), dot.getY());
    }

    @Override
    public String visit(Circle circle) {
        return """
                <circle>
                    <id>%d</id>
                    <x>%d</x>
                    <y>%d</y>
                    <radius>%d</radius>
                </circle>""".formatted(circle.getId(), circle.getX(), circle.getY(), circle.getRadius());
    }

    @Override
    public String visit(Rectangle rectangle) {
        return """
                <rectangle>
                    <id>%d</id>
                    <x>%d</x>
                    <y>%d</y>
                    <width>%d</width>
                    <height>%d</height>
                </rectangle>""".formatted(rectangle.getId(), rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public String visit(CompoundShape compoundShape) {
        var body = compoundShape.getChildren().stream()
                .map(exportable -> exportable.export(this))
                .map(s -> "    %s".formatted(s.replace("\n", "\n    ")))
                .collect(Collectors.joining("\n"));
        return """
                <compound_graphic>
                    <id>%d</id>
                %s
                </compound_graphic>""".formatted(compoundShape.getId(), body);
    }
}
