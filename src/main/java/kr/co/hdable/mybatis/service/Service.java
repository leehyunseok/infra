package kr.co.hdable.mybatis.service;

import java.util.List;

import kr.co.hdable.mybatis.vo.Child;
import kr.co.hdable.mybatis.vo.Parent;


public interface Service {

	public List<Parent> selectAllParent() ;
	public Parent selectParent(int id) ;
	public int insertParent(Parent parent) ;
	public List<Child> selectAllChildren(int parnetId) ;
	public Child selectChild(int id) ;
	public int insertchild(Child child) ;
}
