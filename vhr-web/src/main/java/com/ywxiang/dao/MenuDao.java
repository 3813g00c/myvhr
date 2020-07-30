package com.ywxiang.dao;

import com.ywxiang.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/7/28 下午8:44
 */
@Repository
public interface MenuDao {
    /**
     * 通过主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条菜单
     *
     * @param record
     * @return
     */
    int insert(Menu record);

    /**
     * 插入选中的
     *
     * @param record
     * @return
     */
    int insertSelective(Menu record);

    /**
     * 通过主键查找
     *
     * @param id
     * @return
     */
    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 通过id查询所拥有的菜单
     *
     * @param hrid
     * @return
     */

    List<Menu> getMenusByHrId(Integer hrid);

    /**
     * 获取所有的菜单和权限
     *
     * @return
     */
    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);
}
