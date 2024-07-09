package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleService {

    /*
        查询所有角色&条件进行查询
     */
    public List<Role> findAllRole(Role role);

    /*
        根据角色id 查询角色关联的菜单信息 ID [1,2,3,5,9]
     */
    public List<Integer> findMenuByRoleId(Integer roleId);


    /*
       为角色分配菜单信息
    */
    public void roleContextMenu(RoleMenuVO roleMenuVO);

    /*
        删除角色
     */
    public void deleteRole(Integer roleId);

}
