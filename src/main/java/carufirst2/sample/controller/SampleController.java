package carufirst2.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import carufirst2.sample.service.SampleService;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());

	// Check-up @Resource annotation and name attributes IOS
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/openSampleBoardList.do")
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap)  throws Exception  {
		ModelAndView mv = new ModelAndView("/sample/boardList");
		log.debug("interceptor test");
		List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);
		
		return mv;
	}
}
