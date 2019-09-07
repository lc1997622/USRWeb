/**
 * @filename:ContributionServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.usrweb.dao.ImageDao;
import com.example.usrweb.dao.mapDao.ContributionHasImageDao;
import com.example.usrweb.entity.Contribution;
import com.example.usrweb.dao.ContributionDao;
import com.example.usrweb.entity.Image;
import com.example.usrweb.entity.mapEntiry.ContributionHasImage;
import com.example.usrweb.service.ContributionService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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

    public Integer insertContribution(Contribution contribution){
        List<String> imagePathList = contribution.getImagePathList();
        contributionDao.insert(contribution);
        long id = contribution.getId();

        for (String imagePath:imagePathList){
            // 在image表插入
            Image image = new Image();
            image.setPath(imagePath);
            imageDao.insert(image);
            Long imageId = image.getId();

            // 在关联表插入
            ContributionHasImage contributionHasImage = new ContributionHasImage();
            contributionHasImage.setImageId(imageId);
            contributionHasImage.setContributionId(id);
            contributionHasImageDao.insert(contributionHasImage);
        }
        return 1;
    }

    /*public Contribution getContributionById(Long id){

        Contribution contribution = contributionDao.selectById(id);

        QueryWrapper<ContributionHasImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        List<ContributionHasImage> contributionHasImageList = contributionHasImageDao.selectList(queryWrapper);

        contribution.setImagePathList(null);
        for (ContributionHasImage hasImage:contributionHasImageList){
            contribution.getImagePathList().add(imageDao.selectById(hasImage.getImageId()).getPath());
        }
        return contribution;
    }*/

    public List<Contribution> getContributionInfo(Contribution contr){
        QueryWrapper<Contribution> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(contr);

        List<Contribution> contributionList = contributionDao.selectList(queryWrapper);
        /*List<Contribution> contributions = null;
        for (Contribution contribution:contributionList){
            contributions.add(getContributionById(contribution.getId()));
        }
        return contributions;*/
        return contributionList;
    }

}