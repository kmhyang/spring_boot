package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	//전체조회 페이지
	@GetMapping("empList")
	public String getEmpList(Model model) {
		model.addAttribute("empList",empService.getEmpList());
		return "empList";
	}
	
	//단건조회 페이지
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO vo, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(vo));
		return "empInfo";
	}
	
	//등록 페이지
	@GetMapping("empInsert")
	public void empInsertForm(Model model) { //void : 경로를 기반하여 찾아옴.
		model.addAttribute("vo", new EmpVO());
	}
	
	//등록 처리
	//엑셀 파일 받아서 등록
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empService.insertEmpInfo(vo);
		return "redirect:empList";
	}
	
	//수정 페이지
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO vo, Model model) {
		model.addAttribute("empInfo",empService.getEmpInfo(vo));
		return "empUpdate";
	}
	
	//수정 처리
	
	//삭제
	@PostMapping("empDelete")
	public String empDelete(EmpVO vo) {
		empService.deleteEmpInfo(vo);
		return "redirect:empList";
	}
}
