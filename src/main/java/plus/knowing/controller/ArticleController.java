package plus.knowing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import plus.knowing.annotation.Role;
import plus.knowing.constant.RoleEnum;
import plus.knowing.service.IArticleService;
import plus.knowing.vo.blog.ArticleQueryVO;
import plus.knowing.vo.blog.ArticleVO;
import plus.knowing.vo.generic.PageVO;
import plus.knowing.vo.sys.UserVO;

import java.util.List;

@RestController
@RequestMapping(path = "/articles")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;

    @Role(value = RoleEnum.Author)
    @PostMapping(path = "")
    public void addArticle(@RequestBody @Validated ArticleVO articleVO, @RequestAttribute UserVO user) {
        iArticleService.addArticle(articleVO, user);
    }

    @GetMapping(path = "")
    public List<ArticleVO> listArticles(ArticleVO articleVO) {
        return iArticleService.listArticles(articleVO);
    }

    @GetMapping(path = "/paging")
    public PageVO<ArticleVO> pagingListTags(ArticleQueryVO queryVO) {
        return iArticleService.pagingListTags(queryVO);
    }

    @GetMapping(path = "/{id}")
    public ArticleVO getInfo(@PathVariable Long id) {
        return iArticleService.get(id);
    }

    @Role(value = RoleEnum.Author)
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody @Validated ArticleVO articleVO, @RequestAttribute UserVO user) {
        iArticleService.update(id, articleVO, user);
    }
}
