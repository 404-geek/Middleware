package com.kapture.middleware.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.kapture.middleware.DataModel.SourceConf;
import com.kapture.middleware.DataModel.UserConf;
import com.kapture.middleware.Repositories.SourceConfRepository;
import com.kapture.middleware.Repositories.UserConfRepository;



@Controller
public class ViewController {
	
	
	
	@Autowired
	SourceConfRepository sourceConfRepository;
	
	@Autowired
	UserConfRepository userConfRepository;
	

	@GetMapping("/login")
    public String showForm(com.kapture.middleware.DataModel.Login login) {
        return "index";
   }

    @PostMapping("/View/login")
    public String validateLoginInfo(Model model, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult, HttpServletRequest request) {
        if(login.getUserName().equalsIgnoreCase("poonam") && login.getPassword().equalsIgnoreCase("makwana"))
        {
        	HttpSession session = request.getSession();
        	
        	request.setAttribute("message", "");
        			return "HomePage";
        }
        
        else
        {
        	request.setAttribute("message", "Incorrect Credntials...Please login again");
            return "index";
        }
    }
    
    @RequestMapping("/View/Logout")
    public String logout(Model model, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse Response) {
        
        	HttpSession session = request.getSession();
        	session.invalidate();
        	request.setAttribute("logout", "yes");
        	
        	
           return "index";
        
    }
    
    @RequestMapping(value = "/View/AddNewSourceConfView")
    public String addNewSourceConfView(Model model, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult, HttpServletRequest request) {
    	
    	HttpSession session=request.getSession(false);  
        if(session!=null){
    	SourceConf sourceConf = new SourceConf();
    	model.addAttribute("SourceConf", sourceConf);
    	return "AddNewSourceConf";
        }
        else
        {
        	request.setAttribute("message", "Please login first");
        	return "index";
        }
    }
    
    @RequestMapping("/View/EditSourceConfView")
    public String editSourceConf(HttpServletRequest request, Model model, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult) {
    	HttpSession session=request.getSession(false);  
        if(session!=null){
    	
		List<SourceConf> sourceConfList = sourceConfRepository.findAll();
		List<String> apinameslist = new ArrayList<String>();
		for(int i = 0; i < sourceConfList.size(); i ++)
		{
			apinameslist.add(sourceConfList.get(i).getName()); 
		}
		SourceConf sourceConf = new SourceConf();
    	model.addAttribute("SourceConf", sourceConf);
		model.addAttribute("apinameslist", apinameslist);
		return "EditSourceConf";
        }
        else
        {
        	request.setAttribute("message", "Please login first");
        	return "index";
        }
	}
    
    @RequestMapping("/View/EditUserConfView")
    public String editUserConf(HttpServletRequest request, Model model ,@Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult) {
	
    	HttpSession session=request.getSession(false);  
        if(session!=null){
		List<UserConf> userConfList = userConfRepository.findAll();
		List<String> apinameslist = new ArrayList<String>();
		for(int i = 0; i < userConfList.size(); i ++)
		{
			apinameslist.add(userConfList.get(i).getApiname()); 
		}
		UserConf userConf = new UserConf();
    	model.addAttribute("UserConf", userConf);
		model.addAttribute("apinameslist", apinameslist);
		return "EditUserConf";
        }
        else
        {
        	request.setAttribute("message", "Please login first");
        	return "index";
        }
	}
    
    @RequestMapping(value = "/View/AddNewUserConfView")
    public String addNewUserConfView(Model model, HttpServletRequest request, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult) {
    	
    	HttpSession session=request.getSession(false);  
        if(session!=null){
    	List<SourceConf> sourceConfList = sourceConfRepository.findAll();
		List<String> apinameslist = new ArrayList<String>();
		for(int i = 0; i < sourceConfList.size(); i ++)
		{
			apinameslist.add(sourceConfList.get(i).getName()); 
		}
		SourceConf sourceConf = new SourceConf();
    	model.addAttribute("SourceConf", sourceConf);
		model.addAttribute("apinameslist", apinameslist);
    	UserConf userConf = new UserConf();
    	model.addAttribute("UserConf", userConf);
    	return "AddNewUserConf";
        }
        else
        {
        	request.setAttribute("message", "Please login first");
        	return "index";
        }
    }
    
    @RequestMapping("/View/AddNewUserConf")
    public String addNewUserConf(Model model, @ModelAttribute("UserConf")UserConf userConf, HttpServletRequest request, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult)
    {
    	HttpSession session=request.getSession(false);  
        if(session!=null){
    	UserConf user = userConfRepository.findByApiname(userConf.getApiname());
    	if(user == null)
    	{
    	request.setAttribute("UserConfExists", "");
    	if(userConf!=null && userConf.getKeycreds()!=null && userConf.getKeycreds().get(0).getCreds()!=null)
    	{
    	for(int j = 0; j < userConf.getKeycreds().size(); j ++)
    	{
    	for(int i = 0; i < userConf.getKeycreds().get(j).getCreds().size(); i++)
    	{	 	
    		//System.out.println(j+"   "+i +"    "+userConf.getKeycreds().get(j).getCreds().get(i).getKey());

    		if(userConf.getKeycreds().get(j).getCreds().get(i).getKey() == null)
    		{
    			userConf.getKeycreds().get(j).getCreds().remove(i);
    		}
    	}
    	}
    	userConfRepository.save(userConf);
    	}
    	return "HomePage";
    	}
    	else
    	{
    		request.setAttribute("UserConfExists", "This APIName is Already Registered");
    		List<SourceConf> sourceConfList = sourceConfRepository.findAll();
    		List<String> apinameslist = new ArrayList<String>();
    		for(int i = 0; i < sourceConfList.size(); i ++)
    		{
    			apinameslist.add(sourceConfList.get(i).getName()); 
    		}
    		SourceConf sourceConf = new SourceConf();
        	model.addAttribute("SourceConf", sourceConf);
    		model.addAttribute("apinameslist", apinameslist);
        	model.addAttribute("UserConf", userConf);
    		return "AddNewUserConf";
    	}
    }
    else
    {
    	request.setAttribute("message", "Please login first");
    	return "index";
    }
    }
    
    
    @RequestMapping(value = "/View/GetSourceConf", method = { RequestMethod.GET }, produces="application/json")
    public @ResponseBody SourceConf getSourceConf(String apiname, HttpServletRequest request) {
		
    	HttpSession session=request.getSession(false);  
        if(session!=null){
		SourceConf sourceConf = sourceConfRepository.findByName(apiname);
		//System.out.println(sourceConf.getDataEndPoints().getLabel());
		return sourceConf;
        }
        else {
        	SourceConf sourcenull = new SourceConf();
        	return sourcenull;
        }
        
        
        
	}
    
    
    
    @RequestMapping(value = "/View/GetUserConf", method = { RequestMethod.GET }, produces="application/json")
    public @ResponseBody UserConf getUserConf(String apiname, HttpServletRequest request) {
		
    	HttpSession session=request.getSession(false);  
        if(session!=null){
		UserConf userConf = userConfRepository.findByApiname(apiname);
		//System.out.println(sourceConf.getDataEndPoints().getLabel());
		return userConf;
        }
        else {
        	UserConf usernull = new UserConf();
        	return usernull;
        }
    
	}
    
    @RequestMapping("/View/AddNewSourceConf")
    public String addNewSourceConf(Model model, @ModelAttribute("SourceConf")SourceConf sourceConf, HttpServletRequest request, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult)
    {
    	HttpSession session=request.getSession(false);  
        if(session!=null){
    	//System.out.println(sourceConf.getDataEndPoints().getLabel());
    	//DataEndPoints dataEndPoints = new DataEndPoints();
        //dataEndPoints = dataEndPoints.builder().label(sourceConf.getDataEndPoints().getLabel()).url(sourceConf.getDataEndPoints().getUrl()).method(sourceConf.getDataEndPoints().getMethod()).build();
    	SourceConf source = sourceConfRepository.findByName(sourceConf.getName());
    	if(source == null)
    	{
    	request.setAttribute("SourceConfExists", "");
    	sourceConfRepository.save(sourceConf);
    	return "HomePage";
    	}
    	else
    	{
    		request.setAttribute("SourceConfExists", "This APIName is Already Registered");
    		return "AddNewSourceConf";
    	}
    }
    else
    {
    	request.setAttribute("message", "Please login first");
    	return "index";
    }
    }
    
    @RequestMapping(value = "/View/EditSourceConf", method = RequestMethod.POST)
    public String editSourceConf(Model model, @ModelAttribute("SourceConf")SourceConf sourceConf, HttpServletRequest request, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult)
    {
    	//while(sourceConf.getAuthEndPoints().getParams().remove(null))
    	//{}
    	//sourceConf.getAuthEndPoints().getParams().removeIf(Objects::isNull);
    	HttpSession session=request.getSession(false);  
        if(session!=null){
    	String btnname = request.getParameter("action");
    	if(btnname.equalsIgnoreCase("save")) {
    	if(sourceConf!=null && sourceConf.getAuthEndPoints()!=null && sourceConf.getDataEndPoints()!=null)
    	{
    	for(int i = 0; i < sourceConf.getAuthEndPoints().getParams().size(); i++)
    	{	 	
    		//System.out.println(sourceConf.getAuthEndPoints().getParams().get(i).getKey());
    		if(sourceConf.getAuthEndPoints().getParams().get(i).getKey() == null)
    		{
    				sourceConf.getAuthEndPoints().getParams().remove(i);
    				//System.out.println(i);
    		}
    	}
    	sourceConfRepository.deleteByName(sourceConf.getName());
		sourceConfRepository.save(sourceConf);	
    	}
    	}
    	if(btnname.equalsIgnoreCase("delete"))
        	sourceConfRepository.deleteByName(sourceConf.getName());
       return "HomePage";
    }
    else
    {
    	request.setAttribute("message", "Please login first");
    	return "index";
    }
    }
    
    @RequestMapping("/View/EditUserConf")
    public String editUserConf(Model model, @ModelAttribute("UserConf")UserConf userConf, HttpServletRequest request, @Valid com.kapture.middleware.DataModel.Login login, BindingResult bindingResult)
    {
    	HttpSession session=request.getSession(false);  
        if(session!=null){
        	String btnname = request.getParameter("action");
        	if(btnname.equalsIgnoreCase("save")) {
        		if(userConf!=null && userConf.getKeycreds()!=null && userConf.getKeycreds().get(0).getCreds()!=null)
        		{
        			for(int j = 0; j < userConf.getKeycreds().size(); j ++)
        			{
        				for(int i = 0; i < userConf.getKeycreds().get(j).getCreds().size(); i++)
        				{	 	
        					//System.out.println(j+"   "+i +"    "+userConf.getKeycreds().get(j).getCreds().get(i).getKey());

        					if(userConf.getKeycreds().get(j).getCreds().get(i).getKey() == null)
        					{
        						userConf.getKeycreds().get(j).getCreds().remove(i);
        					}
        				}
        			}
        			userConfRepository.deleteByApiname(userConf.getApiname());
        			userConfRepository.save(userConf);
        		}
        	}
        	if(btnname.equalsIgnoreCase("delete"))
        		userConfRepository.deleteByApiname(userConf.getApiname());
        	return "HomePage";
    	
    
    }
    else
    {
    	request.setAttribute("message", "Please login first");
    	return "index";
    }
    }
    
}
