/**
 * @filename:ImageController 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2020 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.aid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.flying.cattle.mdg.aid.JsonResult;
import com.github.flying.cattle.mdg.aid.PageParam;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 图片API接口层</P>
 * @version: V1.0
 * @author: LiChao
 *
 */
public class AbstractController<S extends IService<T>,T>{
	
	@Autowired
    protected S baseService;

	protected JsonResult<T> result = new JsonResult<T>();
	/**
	 * @explain 查询对象  <swagger GET请求>
	 * @param   对象参数：id
	 * @return  JsonResult
	 * @author  LiChao
	 * @time    2019年4月9日
	 */
	@GetMapping("/getById")
	@ApiOperation(value = "获取对象", notes = "作者：LiChao")
	@ApiImplicitParam(paramType="path", name = "id", value = "对象id", required = true, dataType = "Long")
	public JsonResult<T> getUserById(Long id){
		T obj=baseService.getById(id);
		if (null!=obj ) {
			 result.success(obj);
		}else {
			 result.error("查询对象不存在！");
		}
		return result;
	}
	
	/**
	 * @explain 删除对象
	 * @param   对象参数：id
	 * @return  JsonResult
	 * @author  LiChao
	 * @time    2019年4月9日
	 */
	@PostMapping("/deleteById")
	@ApiOperation(value = "删除", notes = "作者：LiChao")
	@ApiImplicitParam(paramType="query", name = "id", value = "对象id", required = true, dataType = "Long")
	public JsonResult<T> deleteById(Long id){
		JsonResult<T> result=new JsonResult<T>();
		T obj=baseService.getById(id);
		if (null!=obj) {
		  boolean rsg = baseService.removeById(id);
		  if (rsg) {
			    result.success("删除成功");
		  }else {
			   result.error("删除失败！");
		  }
		}else {
			 result.error("删除的对象不存在！");
		}
		return result;
	}
	
	/**
	 * @explain 添加
	 * @param   对象参数：T
	 * @return  Boolean
	 * @author  LiChao
	 * @time    2019年4月9日
	 */
	@PostMapping("/insert")
	@ApiOperation(value = "添加", notes = "作者：LiChao")
	public JsonResult<T> insert(T entity){
		JsonResult<T> result=new JsonResult<T>();
		if (null!=entity) {
			boolean rsg = baseService.save(entity);
			if (rsg) {
				  result.success("添加成功");
			  }else {
				  result.error("添加失败！");
			  }
		}else {
			result.error("请传入正确参数！");
		}
		return result;
	}
	
	/**
	 * @explain 修改
	 * @param   对象参数：T
	 * @return  Boolean
	 * @author  LiChao
	 * @time    2019年4月9日
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "作者：LiChao")
	public JsonResult<T> update(T entity){
		JsonResult<T> result=new JsonResult<T>();
		if (null!=entity) {
			boolean rsg = baseService.updateById(entity);
			if (rsg) {
				  result.success("修改成功");
			  }else {
				  result.error("修改失败！");
			  }
		}else {
			result.error("请传入正确参数！");
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询用户   
	 * @param   对象参数：AppPage<User>
	 * @return  PageInfo<User>
	 * @author  LiChao
	 * @time    2019年5月20日
	 */
	@PostMapping("/getPages")
	@ApiOperation(value = "分页查询", notes = "分页查询返回[IPage<T>],作者：LiChao")
	public JsonResult<IPage<T>> getUserPages(T entity, @RequestParam(required = false) Integer pageNum, @RequestParam(required = false)Integer pageSize){
	    if (pageNum == null){
	        pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 100;
        }
        System.out.println(entity.toString());
		JsonResult<IPage<T>> returnPage=new JsonResult<IPage<T>>();
		Page<T> page=new Page<T>(pageNum,pageSize);
		QueryWrapper<T> queryWrapper =new QueryWrapper<T>();
		queryWrapper.setEntity(entity);
		//分页数据
		IPage<T> pageData=baseService.page(page, queryWrapper);
		returnPage.success(pageData);
		
		return returnPage;
	}
}
