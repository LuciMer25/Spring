package com.yedam.app.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> selectDeptAll();

	public DeptVO selectDeptInfo(DeptVO deptVO);

	public int insertDeptInfo(DeptVO DeptVO);

	public int updateDeptInfo(@Param("") int deptno,
			        @Param("dept") DeptVO deptVO);

	public int deletedeptInfo(int deptno);
}
