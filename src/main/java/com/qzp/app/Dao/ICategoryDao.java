package com.qzp.app.Dao;





import com.qzp.app.entity.Category;

import java.util.List;

/**
 * ͼ���������ݷ��ʲ�ӿ�
 * @author dhc
 * @version V1.0
 * @date 17/7/22
 */
public interface ICategoryDao {

    /**
     * ��ѯ�����е�ͼ�����
     * @return
     */
    List<Category> listCategories();
}
