/**
 * @filename:ContributionServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.usrweb.dao.*;
import com.example.usrweb.dao.mapDao.ContributionHasImageDao;
import com.example.usrweb.entity.*;
import com.example.usrweb.entity.mapEntiry.ContributionHasImage;
import com.example.usrweb.service.ContributionService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 稿件服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class ContributionServiceImpl extends ServiceImpl<ContributionDao, Contribution> implements ContributionService  {

    @Autowired
    ContributionDao contributionDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    ContributionHasImageDao contributionHasImageDao;
    @Autowired
    UserDao userDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    public Integer insertContribution(Contribution contribution){
        List<String> imagePathList = contribution.getImagePathList();
        contributionDao.insert(contribution);
        Long id = contributionDao.selectById(contribution).getId();

        for (String imagePath:imagePathList){
            // 在image表插入
            System.out.println("------------------------------------------------------------"+imagePath);
            Image image = new Image();
            image.setPath(imagePath);
            imageDao.insert(image);
            Long imageId = imageDao.selectById(image).getId();

            // 在关联表插入
            ContributionHasImage contributionHasImage = new ContributionHasImage();
            contributionHasImage.setImageId(imageId);
            contributionHasImage.setContributionId(id);
            contributionHasImageDao.insert(contributionHasImage);
        }
        return 1;
    }

    public Contribution getContributionById(Long id){
        Contribution contribution = contributionDao.selectById(id);
        String userId = contribution.getUserId();

        // 获取图片
        QueryWrapper<ContributionHasImage> queryWrapper0 = new QueryWrapper<>();
        queryWrapper0.eq("contribution_id", id);
        List<ContributionHasImage> contributionHasImageList = contributionHasImageDao.selectList(queryWrapper0);
        List<String> list = new ArrayList<>();
        for (ContributionHasImage hasImage:contributionHasImageList){
            list.add(imageDao.selectById(hasImage.getImageId()).getPath());
        }
        contribution.setImagePathList(list);

        // 获取用户名
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        User user = userDao.selectOne(queryWrapper);
        Integer type = user.getUserFlag();

        // 学生
        if (type == 1){
            QueryWrapper<Student> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("student_id", userId);
            contribution.setUserName(
                    studentDao.selectOne(queryWrapper1).getChineseName());
        }else {
            QueryWrapper<Teacher> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("teacher_id", userId);
            contribution.setUserName(
                    teacherDao.selectOne(queryWrapper2).getChineseName());
        }

        return contribution;
    }

    public List<Contribution> getContributionInfo(Contribution contr){
        QueryWrapper<Contribution> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(contr);

        List<Contribution> contributionList = contributionDao.selectList(queryWrapper);
        List<Contribution> contributions = new ArrayList<>();
        for (Contribution contribution:contributionList){
            contributions.add(getContributionById(contribution.getId()));
        }

        return contributions;
    }

    public Integer deleteContributionById(Long id){
        Contribution contribution = contributionDao.selectById(id);
        contributionDao.deleteById(contribution);

        // 删除稿件与图片的关联信息
        QueryWrapper<ContributionHasImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("contribution_id", id);
        List<ContributionHasImage> contributionHasImageList = contributionHasImageDao.selectList(queryWrapper);
        for (ContributionHasImage hasImage:contributionHasImageList){
            hasImage.setDeleteFlag(1);
            contributionHasImageDao.deleteById(hasImage);
        }

        return 1;
    }
}