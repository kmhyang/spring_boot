package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	//전체조회
	public List<EmpVO> getEmpList();
	//단건조회
	public EmpVO getEmpInfo(EmpVO vo);
	//등록
	public int insertEmpInfo(EmpVO vo);
	//수정
	public int updateEmpInfo(EmpVO vo);
	//삭제
	public int deleteEmpInfo(EmpVO vo);
}
