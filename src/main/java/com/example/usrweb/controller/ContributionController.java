/**
 * @filename:ContributionController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.controller;

import com.example.usrweb.aid.AbstractController;
import com.example.usrweb.config.ResponseFormat;
import com.example.usrweb.entity.Contribution;
import com.example.usrweb.service.ContributionService;
import com.example.usrweb.service.impl.ContributionServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 稿件API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
@Api(description = "稿件",value="稿件" )
@RestController
@RequestMapping("/contribution")
public class ContributionController extends AbstractController<ContributionService,Contribution>{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ContributionServiceImpl contributionService;

	@ApiOperation(value = "插入稿件信息(新闻动态、通知通告、学术活动)", notes = "作者：ZhuDengji")
	@PostMapping("/insertContribution")
	public Object insertContribution(Contribution contribution){
		Integer i;
		try {
			i = contributionService.insertContribution(contribution);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000, null);
		}
		return ResponseFormat.retParam(200, null);
	}

	/*@ApiOperation(value = "根据id查询稿件信息(新闻动态、通知通告、学术活动)", notes = "作者：ZhuDengji")
	@PostMapping("/getContributionById")
	public Object getContributionById(@RequestParam @ApiParam(value = "稿件id") Long id){
		Contribution contribution;
		try {
			contribution = contributionService.getContributionById(id);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000, null);
		}
		return ResponseFormat.retParam(200, contribution);
	}*/

	@ApiOperation(value = "查询稿件信息(新闻动态、通知通告、学术活动)", notes = "作者：ZhuDengji")
	@GetMapping("/getNewsInfo")
	public Object getContributionInfo(Contribution contribution){
		List<Contribution> contributionList;
		try {
			contributionList = contributionService.getContributionInfo(contribution);
		}catch (Exception e){
			System.out.println(e);
			return ResponseFormat.retParam(1000, null);
		}
		return ResponseFormat.retParam(200, contributionList);
	}

}