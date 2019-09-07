/**
 * @filename:AttendanceServiceImpl 2019年9月1日
 * @project USR Web  V1.0
 * Copyright(c) 2018 LiChao Co. Ltd. 
 * All right reserved. 
 */
package com.example.usrweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usrweb.entity.Attendance;
import com.example.usrweb.dao.AttendanceDao;
import com.example.usrweb.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 签到服务实现层</P>
 * @version: V1.0
 * @author: LiChao
 * 
 */
@Service
public class AttendanceServiceImpl  extends ServiceImpl<AttendanceDao, Attendance> implements AttendanceService  {
    @Autowired
    AttendanceDao attendanceDao;

    public List<Attendance> selectPageWP(Attendance attendance, Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<Attendance>();
        Page<Attendance> page = new Page<>(pageNum, pageSize);
        List<Attendance> attendanceList;
        queryWrapper.setEntity(attendance);
        IPage<Attendance> iPage = attendanceDao.selectPage(page, queryWrapper);
        attendanceList = iPage.getRecords();
        attendanceList.forEach(System.out::println);

        return attendanceList;
    }

    public Integer insertAttendance(Attendance attendance){
        attendance.setStartTime(new Date());
        attendanceDao.insert(attendance);
        System.out.println("1111111111111111" + attendance.getStartTime());
        return 1;
    }

    public Integer updateAttendance(Attendance attendance){
        /*UpdateWrapper<Attendance> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("end_time", new Date());
        attendanceDao.update(attendance, updateWrapper);*/

        attendance.setEndTime(new Date());
        attendanceDao.updateById(attendance);

        return 1;
    }
}