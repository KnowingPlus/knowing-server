package plus.knowing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import plus.knowing.service.ITagService;
import plus.knowing.vo.TagVO;

import java.util.List;

@RestController
@RequestMapping(path = "/tag")
public class TagController {

    @Autowired
    private ITagService iTagService;

    @PostMapping(path = "")
    public void addTag(@RequestBody @Validated TagVO tagVO) {
        iTagService.addTag(tagVO);
    }

    @GetMapping(path = "")
    public List<TagVO> listTags(TagVO tagVO) {
        return iTagService.listTags(tagVO);
    }
}