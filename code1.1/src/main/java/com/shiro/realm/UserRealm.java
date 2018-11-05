package com.shiro.realm;

import com.biqi.constant.BaseConstant;
import com.biqi.dao.*;
import com.biqi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
  *  说明：重写realm的方法
  *  xiebq 2018/7/26
  */
@Slf4j
//@Component
public class UserRealm extends AuthorizingRealm {

    //注入角色权限等表
     @Autowired
     private PermissionDao permissionDao;
     @Autowired
     private RoleDao roleDao;
     @Autowired
     private RoleToPermissionDao roleToPermissionDao;
     @Autowired
     private UserDao userDao;
     @Autowired
     private UserToRoleDao userToRoleDao;


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        User userInfo  = (User)principals.getPrimaryPrincipal();
        UserToRole userToRole = new UserToRole();
        userToRole.setUserId(userInfo.getId());
        List<UserToRole> roleList = userToRoleDao.select(userToRole);

        //获取role表和权限表-->设置到realm中去
        List<Role> roles = new ArrayList<>(roleList.size());
        //List<Role> roles = roleDao.selectAll();
        roleList.forEach(item->{
            roles.add(roleDao.selectByPrimaryKey(item.getRoleId()));
        });

        roles.forEach(item->{
            authorizationInfo.addRole(item.getRoleName());
            RoleToPermission roleToPermission = new RoleToPermission();
            roleToPermission.setStatus(BaseConstant.STATUS.YES);
            roleToPermission.setRoleId(item.getId());
            List<RoleToPermission> select = roleToPermissionDao.select(roleToPermission);
            for (RoleToPermission itemRoleToPermission : select) {
                Permission permission = permissionDao.selectByPrimaryKey(itemRoleToPermission.getPermissionId());
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        });
        System.out.println(authorizationInfo.toString());
        return authorizationInfo;
    }


    /**
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //得到用户名
        String username = (String)token.getPrincipal();
        //得到密码这里返回的是不是String 是char的数组
//        String password = (String)token.getCredentials();
        System.out.println("username:"+username);
        //得到用户名或者密码
        User user = new User();
        user.setName(username);
        User selectOne = userDao.selectOne(user);
        if (null == selectOne){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                username,
                //密码
                selectOne.getPassword(),
                //salt=username+salt//md5加盐算法
                //ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                //realm name
                getName()
        );

        return authenticationInfo;
    }
}
