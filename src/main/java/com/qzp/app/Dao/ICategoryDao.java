package com.qzp.app.Dao;





import com.qzp.app.entity.Category;

import java.util.List;

/**
 * 图书分类的数据访问层接口
 * @author dhc
 * @version V1.0
 * @date 17/7/22
 */
public interface ICategoryDao {

    /**
     * 查询出所有的图书分类
     * @return
     */
    List<Category> listCategories();
}
