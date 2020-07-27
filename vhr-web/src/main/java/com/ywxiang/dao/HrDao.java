package com.ywxiang.dao;

import com.ywxiang.entity.Hr;
import com.ywxiang.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hr Dao层
 *
 * @author ywxiang
 * @date 2020/7/25 下午2:41
 */
@Repository
public interface HrDao {
    /**
     * 通过di删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     *
     * @param record
     * @return
     */
    int insert(Hr record);

    /**
     * 通过选择的插入
     *
     * @param record
     * @return
     */
    int insertSelective(Hr record);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Hr selectByPrimaryKey(Integer id);

    /**
     * 通过选择的更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Hr record);

    /**
     * 通过主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Hr record);

    /**
     * 通过用户名加载
     * @param username
     * @return
     */
    Hr loadUserByUsername(String username);

    /**
     * 通过id获取权限
     *
     * @param id
     * @return
     */
    List<Role> getHrRolesById(Integer id);

    /**
     * 查询所有用户
     * @param hrid
     * @param keywords
     * @return
     */
    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    /**
     * 1
     * @param id
     * @return
     */
    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    /**
     * 更新密码
     *
     * @param hrid
     * @param encodePass
     * @return
     */
    Integer updatePasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    /**
     * 更新userface
     * @param url
     * @param id
     * @return
     */
    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);
}
