package com.jt.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain=true)
//设置对象与表的关联关系,如果表名与对象名称一致,可以省略不写
@TableName
public class User implements Serializable{
	
	/* 1.对象与表进行关联,通过自定义注解
	 * 2.对象的属性和表字段的关联, 自定义注解
     * 3.定义公共的接口,编辑公共接口的方法,谁用谁继承
	 * 4.将用户的操作转化成sql
	 *  */	
	
	private static final long serialVersionUID = -5117489130652559686L;
	
	@TableId(type=IdType.AUTO)
	private Integer id; //主键自增
//	@TableField(value="字段名称")     字段名称与域名称相同时,不必写此注解
	private String name;
	private Integer age;
	private String sex;

}
