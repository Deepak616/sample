package com.tcs.controller;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.gson.Gson;
import com.tcs.util.RestTemplateUtil;

@Controller
public class LoginController {
	
	@RequestMapping(value="/googleLogin",method=RequestMethod.GET)
	@ResponseBody public void googleLogin(HttpServletRequest httpReq,HttpServletResponse httpRes) throws IOException{
		String url = new GoogleBrowserClientRequestUrl("949758076650-4f9g5t3g69iekgbp7imlbo97krri1d0p.apps.googleusercontent.com", 
				"http://localhost:8085/AngSpringOauth/rest/googleAuthenticate",Arrays.asList("https://www.googleapis.com/auth/userinfo.email",
						"https://www.googleapis.com/auth/userinfo.profile")).setState("/profile").setResponseTypes(Arrays.asList("code")).build();
		httpRes.setStatus(302);
		httpRes.getWriter().println(url);
		
	}
	
	@RequestMapping(value="/googleAuthenticate",method=RequestMethod.GET)
	@ResponseBody public String googleAuthenticate(HttpServletRequest httpReq,HttpServletResponse httpRes) throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException{
		System.out.println("code "+httpReq.getParameter("code"));
		RestTemplate resTemplate=RestTemplateUtil.restTemplate();
		Map<String,Object> reqData=new HashMap<String,Object>();
		reqData.put("code", httpReq.getParameter("code"));
		reqData.put("client_id","949758076650-4f9g5t3g69iekgbp7imlbo97krri1d0p.apps.googleusercontent.com");
		reqData.put("client_secret","YB53fX7yqaEl_Mgf5b5qA2zh");
		reqData.put("redirect_uri","http://localhost:8085/AngSpringOauth/googleSuccessLogin");
		reqData.put("grant_type","authorization_code");
		String url="https://www.ultimatix.net";
		HttpEntity<Map<String,Object>> reqEntity=new HttpEntity<>(reqData);
		ResponseEntity<Map> response=resTemplate.exchange(url,HttpMethod.POST,reqEntity,Map.class);
		
		System.out.println("response from google "+response.getBody());
		
		return new Gson().toJson("successfully authenticated from google");
	}

}
