package com.devlink.me.cont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.devlink.dao.Certification;
import com.devlink.dao.Education;
import com.devlink.dao.Exp;
import com.devlink.dao.Frd;
import com.devlink.dao.Honor;
import com.devlink.dao.Img;
import com.devlink.dao.Language;
import com.devlink.dao.Member;
import com.devlink.dao.Patent;
import com.devlink.dao.Skill;
import com.devlink.dao.TestScore;
import com.devlink.me.service.Service;
import com.devlink.network.service.NetService;

@Controller
public class MeController {
	@Resource(name="meService")
	Service service;

	@Resource(name="netService")
	NetService netService;
	/*@RequestMapping(value="/viewmyprofile", method=RequestMethod.GET)
	public String viewMyProfile2() {
		return "me/viewMyProfile";
	}*/

	@RequestMapping(value="/viewmyprofile.do", method=RequestMethod.GET)
	public ModelAndView viewIntro(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session==null)
			return new ModelAndView("index");
		else{
			if(req.getSession(false).getAttribute("id")==null)
				return new ModelAndView("index");
		}
		ModelAndView mav = new ModelAndView("me/viewMyProfile");
		
		String id=(String)session.getAttribute("id");
		Member m = service.getIntro(id);
		ArrayList<Certification> certi=service.getCerti(id);
		ArrayList<Education> edu=service.getEdu(id);
		ArrayList<Exp> exp=service.getExp(id);
		ArrayList<Honor> honor=service.getHonor(id);
		ArrayList<Language> lang=service.getLang(id);
		ArrayList<Skill> skill=service.getSkill(id);
		ArrayList<Patent> patent =service.getPatent(id);
		ArrayList<TestScore> ts = service.getTestScore(id);
		int st=service.howSt(certi,edu,exp,honor,lang,skill,patent,ts);
		String color = service.howColor(st);
		String no=(String) req.getSession(false).getAttribute("no");
		ArrayList<Frd> frd= netService.getFrd(no);
		mav.addObject("frd",frd);
		mav.addObject("m", m);
		mav.addObject("certi", certi);
		mav.addObject("edu", edu);
		mav.addObject("exp", exp);
		mav.addObject("honor", honor);
		mav.addObject("lang", lang);
		mav.addObject("skill", skill);
		mav.addObject("patent", patent);
		mav.addObject("ts", ts);
		mav.addObject("st",st);
		mav.addObject("color",color);
		return mav;
	}

	@RequestMapping(value="/editintro.do", method=RequestMethod.POST)
	public String editIntro(HttpServletRequest req, Member m){
		String id=(String) req.getSession(false).getAttribute("id");
		m.setId(id);
		service.editIntro(m);
		return "result";
	}
	
	@RequestMapping(value="/addexp.do", method=RequestMethod.POST)
	public ModelAndView addExp(HttpServletRequest req, Exp e){
		ModelAndView mav = new ModelAndView("me/addExp");
		String id=(String) req.getSession(false).getAttribute("id");
		e.setNo(service.getNo(id));
		Exp exp=service.addExp(e);
		System.out.println(exp);
		mav.addObject("exp",exp);
		return mav;
	}

	@RequestMapping(value="/addedu.do", method=RequestMethod.POST)
	public ModelAndView addEdu(HttpServletRequest req, Education e){
		ModelAndView mav = new ModelAndView("me/addEdu");
		String id=(String) req.getSession(false).getAttribute("id");
		e.setNo(service.getNo(id));
		Education edu=service.addEdu(e);
		mav.addObject("edu",edu);
		return mav;
	}
	
	@RequestMapping(value="/addskill.do", method=RequestMethod.POST)
	public ModelAndView addSkill(HttpServletRequest req, Skill s){
		ModelAndView mav = new ModelAndView("me/addSkill");
		String id=(String) req.getSession(false).getAttribute("id");
		s.setNo(service.getNo(id));
		Skill skill=service.addSkill(s);
		mav.addObject("skill",skill);
		return mav;
	}
	
	@RequestMapping(value="/addlang.do", method=RequestMethod.POST)
	public ModelAndView addLang(HttpServletRequest req, Language l){
		ModelAndView mav = new ModelAndView("me/addLang");
		String id=(String) req.getSession(false).getAttribute("id");
		l.setNo(service.getNo(id));
		Language lang=service.addLang(l);
		mav.addObject("lang",lang);
		return mav;
	}
	
	@RequestMapping(value="/addhonor.do", method=RequestMethod.POST)
	public ModelAndView addHonor(HttpServletRequest req, Honor h){
		ModelAndView mav = new ModelAndView("me/addHonor");
		String id="id1";
		h.setNo(service.getNo(id));
		Honor honor=service.addHonor(h);
		mav.addObject("honor",honor);
		return mav;
	}
	@RequestMapping(value="/addcerti.do", method=RequestMethod.POST)
	public ModelAndView addCerti(HttpServletRequest req, Certification c){
		ModelAndView mav = new ModelAndView("me/addCerti");
		String id=(String) req.getSession(false).getAttribute("id");
		c.setNo(service.getNo(id));
		Certification certi=service.addCerti(c);
		mav.addObject("certi",certi);
		return mav;
	}
	
	@RequestMapping(value="/addpatent.do", method=RequestMethod.POST)
	public ModelAndView addPatent(HttpServletRequest req, Patent p){
		ModelAndView mav = new ModelAndView("me/addPatent");
		String id=(String) req.getSession(false).getAttribute("id");
		p.setNo(service.getNo(id));
		Patent patent=service.addPatent(p);
		mav.addObject("patent",patent);
		return mav;
	}
	
	@RequestMapping(value="/addts.do", method=RequestMethod.POST)
	public ModelAndView addTS(HttpServletRequest req, TestScore t){
		ModelAndView mav = new ModelAndView("me/addTs");
		String id=(String) req.getSession(false).getAttribute("id");
		System.out.println(t);
		t.setNo(service.getNo(id));
		TestScore testScore=service.addTs(t);
		System.out.println(testScore);
		mav.addObject("testScore",testScore);
		return mav;
	}
	
	@RequestMapping(value="/delpro.do", method=RequestMethod.GET)
	public String delPro(String no){
		service.delPro(no);
		return "redirect:viewmyprofile.do";
	}
	
	@RequestMapping(value="/proform.do")
	public String proForm(HttpServletRequest req, Img img) {
		HttpSession session = req.getSession(false);
		if(session==null)
			return "redirect:/";
		else{
			if(req.getSession(false).getAttribute("id")==null)
				return "redirect:/";
		}
		String id=(String) session.getAttribute("id");
		HashMap<String, String> isFile=null;
		isFile=service.getPath(id);
		if(isFile!=null) {
			File preFile =new File("D:\\javaEE\\maven\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\devlink\\resources\\img\\profile\\"+isFile.get("path"));
			File preFile2 =new File("C:\\Users\\KITRI\\OneDrive\\javaEE\\project\\devlink\\src\\main\\webapp\\resources\\img\\profile\\"+isFile.get("path"));//원드라이브쪽
			if(preFile.exists() ){
	            if(preFile.delete()){
	                System.out.println("파일삭제 성공");
	            }else{
	                System.out.println("파일삭제 실패");
	            }
	        }else{
	            System.out.println("파일이 존재하지 않습니다.");
	        }
			//원드라이브쪽 삭제
			if(preFile2.exists() ){
	            if(preFile2.delete()){
	                System.out.println("파일삭제 성공");
	            }else{
	                System.out.println("파일삭제 실패");
	            }
	        }else{
	            System.out.println("파일이 존재하지 않습니다.");
	        }
		}
		MultipartFile file = img.getFile();
		MultipartFile file2 = img.getFile();
		String name=id+file.getOriginalFilename().substring((file.getOriginalFilename()).indexOf("."));
		String path="D:\\javaEE\\maven\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\devlink\\resources\\img\\profile\\"+name;
		String path2="C:\\Users\\KITRI\\OneDrive\\javaEE\\project\\devlink\\src\\main\\webapp\\resources\\img\\profile\\"+name;
		/*String path = "resources\\img\\profile\\" + name;*/
		img.setPath(name);
		File f = new File(path);
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		img.setNo(service.getNo(id));
		service.addPath(img);
		session.setAttribute("path", name);
		//파일복사
		File in=new File("D:\\javaEE\\maven\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\devlink\\resources\\img\\profile\\"+name);
		File out=new File("C:\\Users\\KITRI\\OneDrive\\javaEE\\project\\devlink\\src\\main\\webapp\\resources\\img\\profile\\"+name);
	    try {
			FileInputStream input=new FileInputStream(in);
		    FileOutputStream output=new FileOutputStream(out);
		    int data=0;		    
		    while(data!=-1){
		    	data=input.read();
				output.write(data);
		    }		  
		    if(input!=null)
		    	input.close();
		    if(output!=null)
		    	output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:viewmyprofile.do";
	}
}