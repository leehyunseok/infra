package kr.co.hdable.mybatis.service.impl;

import java.util.List;

import kr.co.hdable.mybatis.mapper.Mapper;
import kr.co.hdable.mybatis.service.Service;
import kr.co.hdable.mybatis.vo.Child;
import kr.co.hdable.mybatis.vo.Parent;

import org.springframework.beans.factory.annotation.Autowired;


public class ServiceImpl implements Service {
	
	@Autowired 
	private Mapper mapper;

	public List<Parent> selectAllParent(){
		return mapper.selectAllParent();
	}
	
	public Parent selectParent(int id){
		return mapper.selectParent(id);
	}
	
	public int insertParent(Parent parent){
		return mapper.insertParent(parent);
	}

	public List<Child> selectAllChildren(int parnetId){
		return mapper.selectAllChildren(parnetId);
	}
	
	public Child selectChild(int id){
		return mapper.selectChild(id);
	}
	
	public int insertchild(Child child){
		return mapper.insertchild(child);
	}
}
