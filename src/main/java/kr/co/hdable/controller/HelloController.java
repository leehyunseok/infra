package kr.co.hdable.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import kr.co.hdable.mybatis.service.Service;
import kr.co.hdable.mybatis.vo.Parent;
import kr.co.hdable.vo.Article;
import kr.co.hdable.vo.JsonViewChart;
import kr.co.hdable.vo.VoTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Autowired
	private Service service  ;

//	Default
	@RequestMapping(value = "/welcome" , method = RequestMethod.GET)
	public String printWelcome( ModelMap model){
		model.addAttribute("message","Infra Guide");

		return "hello";
	}
	
//	RequestParameter
	@RequestMapping(value = "/showName" , method = RequestMethod.GET)
	public String printWelcome( @RequestParam(value="name",required=false, defaultValue="World") String name, ModelMap model){
		model.addAttribute("message", name);

		return "hello";
	}
	
	

//	RESTFul
	@RequestMapping(value = "/welcome/{name}",  method = RequestMethod.GET) 
	public String printWelcomeRest(@PathVariable String name , ModelMap model){	
		
		model.addAttribute("message",name);
		return "hello";
	}	
	

//	JsonView
	@RequestMapping(value="/jsonView")
	public String jsonView(ModelMap map) {

		List<String> lists = new ArrayList<String>();

		lists.add("shellsn");
		lists.add("shellsn2");
		lists.add("shellsn3");

		map.addAttribute("grid",lists);
		map.addAttribute("checkState","require");
		
		
		return "jsonView";
	}

//	JsonView
	@RequestMapping(value="/jsonViewObject")
	public String jsonViewObject(ModelMap map) {

		List<VoTest> lists = new ArrayList<VoTest>();

		VoTest voTest = new VoTest();
		VoTest voTest2 = new VoTest();
		
		voTest.setName("한글");
		voTest.setDepat("훈민");
		
		lists.add(voTest);
		
		voTest2.setName("eng");
		voTest2.setDepat("engPart");
		
		lists.add(voTest2);
		
		map.addAttribute("grid",lists);
		map.addAttribute("shellsn","infra");

		return "jsonView";
	}
	
//	JsonViewChart
	@RequestMapping(value="/jsonViewChart")
	public String jsonViewChart(ModelMap map) {

		List<JsonViewChart> lists = new ArrayList<JsonViewChart>();

		JsonViewChart jsonViewChart1 = new JsonViewChart();
		JsonViewChart jsonViewChart2 = new JsonViewChart();
		
		jsonViewChart1.setName("jane") ;
		jsonViewChart1.setData(new Integer[]{3,4,5});
		
		jsonViewChart2.setName("john") ;
		jsonViewChart2.setData(new Integer[]{4,2,6}) ;
		
		
		lists.add(jsonViewChart1);
		
		
		lists.add(jsonViewChart2);
		
		map.addAttribute("grid",lists);

		return "jsonView";
	}
	
//	HighChart
	@RequestMapping(value="/highChart")
	public String highChart() {
		return "highChart" ;
	}
	
	
//	PDFView
//	http://localhost:8080/mvcWeb/get.json
//	http://localhost:8080/mvcWeb/get.pdf
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public LinkedList<Article> get(Model model) {                 
				
		LinkedList<Article> articles = new LinkedList<Article>();
		
		Article art1 = new Article();

		List<String> categories = new ArrayList<String>();
		List<String> tags = new ArrayList<String>();
		
		categories.add("stock");
		categories.add("fund");
		
		tags.add("stock");
		tags.add("fund");

		art1.setTitle("hdable");
		art1.setUrl("http://www.hdable.co.kr");
		art1.setCategories(categories);
		art1.setTags(tags);
		
		articles.add(art1);
		
		model.addAttribute("articles",articles);
		
		return articles;
	}
	
	/* ERROR */
	@RequestMapping(value = "/myBatis" , method = RequestMethod.GET  )
	public String jsonGetMyBatis(ModelMap map ) {
		
	List<Parent> parents = service.selectAllParent()  ;
				
		map.addAttribute("grid",parents);

		
		return "jsonView" ;
	}
	
	

}
