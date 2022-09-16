package pl.maro.desingpatterns.visitor.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.maro.desingpatterns.visitor.visitor.Exportable;
import pl.maro.desingpatterns.visitor.visitor.Visitor;

@Getter
@Setter
@AllArgsConstructor
public class Dot implements Shape, Exportable {
    private int id;
    private int x;
    private int y;

    @Override
    public void move(int x, int y) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void draw() {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public String export(Visitor visitor) {
        return visitor.visit(this);
    }
}
