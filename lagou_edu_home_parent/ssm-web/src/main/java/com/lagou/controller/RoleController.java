package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.service.MemuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
        查询所有角色(条件)
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> allRole = roleService.findAllRole(role);

        return new ResponseResult(true,200,"查询所有角色成功",allRole);

    }

    /*
        查询所有的父子菜单信息（分配菜单的第一个接口）
     */

    @Autowired
    private MemuService memuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){

        //-1表示查询所有父子级菜单
        List<Menu> menuList = memuService.findSubMenuListByPid(-1);

        //响应数据
        Map<String,Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);

        return new ResponseResult(true,200,"查询所有的父子菜单信息成功",map);
    }

     /*
        根据角色id 查询角色关联的菜单信息 ID [1,2,3,5,9]
     */
     @RequestMapping("/findMenuByRoleId")
     public ResponseResult findMenuByRoleId(Integer roleId){

         List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);

         return new ResponseResult(true,200,"查询角色关联的菜单信息成功",menuByRoleId);

     }

     /*
         为角色分配菜单
      */
     @RequestMapping("/RoleContextMenu")
     public ResponseResult roleContextMenu(@RequestBody RoleMenuVO roleMenuVO){

         roleService.roleContextMenu(roleMenuVO);
         return new ResponseResult(true,200,"响应成功",null);

     }

     /*
         删除角色
      */
     @RequestMapping("/deleteRole")
     public ResponseResult deleteRole(Integer id){

         roleService.deleteRole(id);
         return new ResponseResult(true,200,"删除角色成功",null);

     }


}
