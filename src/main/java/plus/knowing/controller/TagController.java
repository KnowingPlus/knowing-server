package plus.knowing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import plus.knowing.service.ITagService;
import plus.knowing.vo.generic.PageVO;
import plus.knowing.vo.blog.TagQueryVO;
import plus.knowing.vo.blog.TagVO;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
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

    @GetMapping(path = "/popular")
    public List<TagVO> listPopularTags() {
        return iTagService.listPopularTags();
    }

    @GetMapping(path = "/paging")
    public PageVO<TagVO> pagingListTags(TagQueryVO queryVO) {
        return iTagService.pagingListTags(queryVO);
    }

    @GetMapping(path = "/{id}")
    public TagVO getTagInfo(@PathVariable Long id) {
        return iTagService.get(id);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody @Validated TagVO tagVO) {
        iTagService.update(id, tagVO);
    }
}
