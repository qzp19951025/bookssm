package com.qzp.app.Category.action;



import com.qzp.app.Category.service.ICategoryService;
import com.qzp.app.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhc
 * @version V1.0
 * @date 17/7/22
 */
@Controller
@Scope("prototype")
@RequestMapping("/categoryAction")
public class CategoryAction {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/listCategories")
    @ResponseBody
    public List<Category> listCategories(){
        List<Category> newList = new ArrayList<Category>();
        List<Category> oldList = categoryService.listCategories();
        for (Category category : oldList){
            if(category.getPid() != null){
                category.setUrl("/bookssm/bookAction/listBooksByCategory.do?cid="+category.getCid());
                category.setTarget("body");
            }
            newList.add(category);
        }
        return newList;
    }
}
