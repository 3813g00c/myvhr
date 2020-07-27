package com.ywxiang.service.impl;

import com.ywxiang.dao.HrDao;
import com.ywxiang.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ywxiang
 * @date 2020/7/25 下午3:31
 */
@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrDao hrDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrDao.loadUserByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("同户名不存在");
        }
        hr.setRoles(hrDao.getHrRolesById(hr.getId()));
        return hr;
    }
}
