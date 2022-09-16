package pl.maro.desingpatterns.visitor.shapes;

import lombok.Getter;
import lombok.Setter;
import pl.maro.desingpatterns.visitor.visitor.Exportable;
import pl.maro.desingpatterns.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompoundShape implements Shape, Exportable {
    private int id;
    private List<Exportable> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

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

    public void add(Exportable exportable) {
        children.add(exportable);
    }
}
