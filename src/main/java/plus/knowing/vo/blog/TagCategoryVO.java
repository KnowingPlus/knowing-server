package plus.knowing.vo.blog;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import plus.knowing.entity.BlogTagCategory;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class TagCategoryVO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @NotBlank
    private String name;

    @NonNull
    private Boolean shared;

    public TagCategoryVO(BlogTagCategory blogTagCategory) {
        this.id = blogTagCategory.getId();
        this.name = blogTagCategory.getName();
        this.shared = blogTagCategory.getShared();
    }
}
