package com.example.demo.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.ClounmnInfoDao;
import com.example.demo.dao.FormClounmnInfoDao;
import com.example.demo.dao.FormDetailsDao;
import com.example.demo.entitys.ClounmnInfo;
import com.example.demo.entitys.FormClounmnInfo;
import com.example.demo.entitys.FormDetails;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Controller
public class MangeInfoController {
    private static Logger log = Logger.getLogger(MangeInfoController.class);
	
	@Autowired
	ClounmnInfoDao clounmnInfoDao;
	
	@Autowired
	FormClounmnInfoDao formClounmnInfoDao;
	
	@Autowired
	FormDetailsDao formDetailsDao;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ClounmnInfo get(@PathVariable("id") Integer id) {
		return clounmnInfoDao.findById(id);
	}
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String list(@PathVariable("id") Integer form_id, Model model) {
		List<FormClounmnInfo> findList = formClounmnInfoDao.findList(form_id);
		model.addAttribute("lists", findList);
		model.addAttribute("form_name", findList.get(0).getForm_name());
		return "form01";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String list(HttpServletRequest req, Model model, String form_name) {
		try {
			Map<String, String> map = new LinkedHashMap<String, String>();
			Enumeration<String> names = req.getParameterNames();
			while (names.hasMoreElements()) {
				String key = (String) names.nextElement();
				map.put(key, req.getParameter(key));
			}
			String jsonString = JSON.toJSONString(map);
			FormDetails formDetails = new FormDetails();
			formDetails.setForm_name(form_name);
			formDetails.setFrom_details(jsonString);
			formDetailsDao.insertEnetity(formDetails);
			return "success";
		} catch (Exception e) {
			log.info(e);
			return "fail";
		}
	}
	
	@RequestMapping(value = "/getFormDetails/{id}", method = RequestMethod.GET)
	public String getFormDetails(@PathVariable("id") Integer form_id, Model model) {
		FormDetails formDetails = formDetailsDao.getEntity(form_id);
		model.addAttribute("formDetails", formDetails.getFrom_details());
		return "form2";
	}
	
	@RequestMapping(value = "/addSet", method = RequestMethod.POST)
	public String getFormDetails(Model model) {
		return "form3";
	}
}
