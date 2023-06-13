package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpList();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO vo);	
	
	//등록
	public int insertEmp(EmpVO vo);
	
	//수정
	public int updateEmp(EmpVO vo);
	
	//삭제
	public int deleteEmp(EmpVO vo);
}
