package pl.maro.desingpatterns.visitor;

import pl.maro.desingpatterns.visitor.shapes.Circle;
import pl.maro.desingpatterns.visitor.shapes.CompoundShape;
import pl.maro.desingpatterns.visitor.shapes.Dot;
import pl.maro.desingpatterns.visitor.shapes.Rectangle;
import pl.maro.desingpatterns.visitor.visitor.JSONExportVisitor;
import pl.maro.desingpatterns.visitor.visitor.XMLExportVisitor;

public class Main {
    public static void main(String[] args) {

        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        var xmlExportVisitor = new XMLExportVisitor();
        var xml = xmlExportVisitor.export(circle, compoundShape);
        System.out.println(xml);
        System.out.println();

        var jsonExportVisitor = new JSONExportVisitor();
        var json = jsonExportVisitor.export(circle, compoundShape);
        System.out.println(json);
    }
}