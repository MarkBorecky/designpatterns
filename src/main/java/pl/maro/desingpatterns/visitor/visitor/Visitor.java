package pl.maro.desingpatterns.visitor.visitor;

import pl.maro.desingpatterns.visitor.shapes.Circle;
import pl.maro.desingpatterns.visitor.shapes.CompoundShape;
import pl.maro.desingpatterns.visitor.shapes.Dot;
import pl.maro.desingpatterns.visitor.shapes.Rectangle;

public interface Visitor {
    String export(Exportable... exportables);
    String visit(Dot dot);

    String visit(Circle circle);

    String visit(Rectangle rectangle);

    String visit(CompoundShape compoundShape);
}
