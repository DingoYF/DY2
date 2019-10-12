package com.jt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest
@RunWith(SpringRunner.class) //执行主启动类
public class SpringbootTest {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void testFind() {
		//		System.out.println(userMapper.selectList(null));
		// 条件构造器
		//		主要拼接where条件
		//		筛选其中不为null的属性充当where条件
		User user=new User();
		user.setAge(3000);
		QueryWrapper<User> queryWrapper=new QueryWrapper<>(user); 
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list);
	}

	@Test
	public void testFindGreter() {
		//		System.out.println(userMapper.selectList(null));
		// 条件构造器
		//		主要拼接where条件
		//		筛选其中不为null的属性充当where条件
		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("sex","女")
		.lt("age", 18)
		.or()
		.eq("sex", "女")
		.gt("age", "2000");
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list);
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setName("孙悟空")
		.setAge(18)
		.setSex("神");
		userMapper.insert(user);
		System.out.println("入库成功!!!!");
		//		userMapper.insert(user);
	}

	@Test
	public void testDelete() {
		//		QueryWrapper queryWrapper=new QueryWrapper<User>();
		//		queryWrapper.eq("name", "孙悟空");
		//		userMapper.delete(queryWrapper);
		List<Integer> ids=new ArrayList<>();
		ids.add(53);
		ids.add(54);
		ids.add(55);
		userMapper.deleteBatchIds(ids);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(57)
		.setName("操作成功")
		.setAge(19)
		.setSex("男");
		userMapper.updateById(user);
	}
	
	@Test
	public void testUpdate1() {
		User user = new User();
		user.setName("更新3").setAge(2000);
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name", "更新2");
		userMapper.update(user, updateWrapper);
	}
}
