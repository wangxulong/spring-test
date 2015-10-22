package com.wang.auth.sys.service;

import com.wang.auth.sys.dao.SysResourceDao;
import com.wang.auth.sys.entity.SysResource;
import com.wang.auth.sys.enumeration.SysResourceType;
import com.wang.dto.ResourceDto;
import com.wang.dto.TreeDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxl on 2015/10/12.
 */
@Service
@Transactional
public class SysResourceService {
    @Resource
    private SysResourceDao sysResourceDao;


    public List<SysResource> getAllFolder(){
        return sysResourceDao.findByParentId(0L);
    }
    //只有二级菜单
    public List<ResourceDto> getMenuList(){
        List<SysResource> folders = getAllFolder();
        List<ResourceDto> resourceDtos = new ArrayList<ResourceDto>();
        for(SysResource folder:folders){
            ResourceDto resourceDto = new ResourceDto();
            resourceDto.setParent(folder);
            resourceDto.setChildren(sysResourceDao.findByParentId(folder.getId()));
            resourceDtos.add(resourceDto);
        }

        return resourceDtos;
    }

    public  ResourceDto getButtonByMenu(Long parentId){
        SysResource menu = sysResourceDao.findOne(parentId);
        List<SysResource> buttons = sysResourceDao.findByTypeAndParentId(SysResourceType.BUTTON,parentId);
        return new ResourceDto(menu,buttons);
    }

    public void addSysRes(SysResource resource){
        //设置parentIds
        SysResource parent = sysResourceDao.findOne(resource.getParentId());
        resource.setParentIds(parent.getParentIds()+"-"+parent.getId());
        if(parent.getResourceCode().equals("0")){
            resource.setParentIds("1");
        }

        resource.setAvailable(true);
        sysResourceDao.save(resource);
    }

    public void deleteRes(Long... ids){
        for(Long id:ids){
            sysResourceDao.delete(id);
        }
    }


    public List<TreeDto>  getTreeData(Long parentId){
        List<SysResource> roots = sysResourceDao.findByParentId(parentId);
        List<TreeDto> trees = new ArrayList<TreeDto>();
        for(SysResource root:roots){
            List<SysResource> children = sysResourceDao.findByParentId(root.getId());
            TreeDto tree = new TreeDto();
            tree.setId(root.getId());
            tree.setText(root.getName());
            tree.setChildren(true);
            tree.setType("folder");
            if(children.isEmpty()){
                tree.setChildren(false);
                tree.setType("item");
            }
            trees.add(tree);
        }
        return trees;
    }

}
