package com.qzp.app.Category.service.impl;



import com.qzp.app.Category.service.ICategoryService;

import com.qzp.app.Dao.ICategoryDao;
import com.qzp.app.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dhc
 * @version V1.0
 * @date 17/7/22
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> listCategories() {
        try {
            return categoryDao.listCategories();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
