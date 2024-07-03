package kr.mvc.controller;

import lombok.Data;

@Data
public class ModelAndView { // 호출 방식과 view 파일명 기억
	private boolean isRedirect = false; // spring은 redirect 기본값이 false
	private String viewName = "";

}
