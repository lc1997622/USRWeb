package com.example.usrweb.Generator;


import com.github.flying.cattle.mdg.entity.BasisInfo;
import com.github.flying.cattle.mdg.util.EntityInfoUtil;
import com.github.flying.cattle.mdg.util.Generator;
import com.github.flying.cattle.mdg.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LiChao
 * @date ：Created in 2019/8/31 22:36
 * @description：Generator for Project
 * @modified By：
 * @version: 1.0$
 */

public class MyGenerator {
    public static final String PROJECT = "USR Web";
    public static final String AUTHOR = "LiChao";
    public static final String VERSION = "V1.0";
    // 数据库连接信息：连接URL、用户名、秘密、数据库名
    public static final String URL = "jdbc:mysql://localhost:3306/lab?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    public static final String NAME = "root";
    public static final String PASS = "lc1997622";
    public static final String DATABASE = "lab";

    public static final String TIME = "2019年9月1日";
    // 路径信息，分开路径方便聚合工程项目，微服务项目
    public static final String ENTITY_URL = "com.example.usrweb.entity";
    public static final String DAO_URL = "com.example.usrweb.dao";
    public static final String XML_URL = "com.example.usrweb.dao.impl";
    public static final String SERVICE_URL = "com.example.usrweb.service";
    public static final String SERVICE_IMPL_URL = "com.example.usrweb.service.impl";
    public static final String CONTROLLER_URL = "com.example.usrweb.web";

    //是否是Swagger配置
    public static final String IS_SWAGGER = "true";

    public static void main(String[] args) {

        // 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
        String TABLE = "";
        String CLASSCOMMENT = "";
        String AGILE = "";
        Map<String,String> tables = new HashMap<>();
        tables.put("book","图书");
        tables.put("course","课程");
        tables.put("image","图片");
        tables.put("achievement","成果");
        tables.put("attendance","签到");
        tables.put("borrow","借阅");
        tables.put("contribution","稿件");
        tables.put("copyright","著作权");
        tables.put("data","资料");
        tables.put("dictionary_item","字典项目");
        tables.put("dictionary_type","字典类型");
        tables.put("edu_reform","教改");
        tables.put("international","国际交流信息");
        tables.put("paper","论文");
        tables.put("patent","专利");
        tables.put("project","项目");
        tables.put("recruit","招生信息");
        tables.put("student","学生");
        tables.put("teacher","教师");
        tables.put("textbook","教材");
        tables.put("user","用户");


        for (Map.Entry<String,String> tablemap:tables.entrySet()){
            TABLE = tablemap.getKey();
            CLASSCOMMENT = tablemap.getValue();
            AGILE = System.currentTimeMillis() + "";

            BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
                    DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL,IS_SWAGGER);
            bi.setTable(TABLE);
            bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
            bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
            bi.setEntityComment(CLASSCOMMENT);
            try {
                bi = EntityInfoUtil.getInfo(bi);
                String fileUrl = "D:\\New\\Project\\USRWeb\\src\\main\\java\\";
                String aa1 = Generator.createEntity(fileUrl, bi).toString();
                String aa2 = Generator.createDao(fileUrl, bi).toString();
                String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
                String aa4 = Generator.createService(fileUrl, bi).toString();
                String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
                String aa6 = Generator.createController(fileUrl, bi).toString();
                String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();

                System.out.println(aa1);
                System.out.println(aa2);
                System.out.println(aa3);
                System.out.println(aa4);
                System.out.println(aa5);
                System.out.println(aa6);
                System.out.println(aa7);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
