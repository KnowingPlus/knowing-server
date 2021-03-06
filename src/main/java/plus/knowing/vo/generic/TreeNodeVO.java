package plus.knowing.vo.generic;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TreeNodeVO<T> {

    private String id;

    private String name;

    private TypeEnum type;

    private T data;

    private List<TreeNodeVO<?>> children;

    public TreeNodeVO(String id, String name, TypeEnum type, T data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public void addChild(TreeNodeVO<?> child) {
        if (Objects.isNull(children)) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public enum  TypeEnum {
        TagCategory,
        Tag,
        ;
    }
}
