package com.day.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.day.model.Employee3P;
import com.day.model.Flight;
import com.day.model.Luggage;
import com.day.model.Vehicle;
import com.day.service.Employee3PService;
import com.day.service.FlightService;
import com.day.service.LuggageService;
import com.day.service.VehicleService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class HomeController {
	
	@Autowired
	private VehicleService vser;
	@Autowired
	private Employee3PService e3pser;
	

	@Autowired
	private FlightService fser;
	
	@GetMapping("/home")
	public String gethome() {
		return "home";
	}
	
	@GetMapping("/")
	public String getslash() {return "home";}
	
	@GetMapping("/flight")
	public String getfligt() {return "flight";}
	
	@GetMapping("/Parkinghome")
	public String getParkinghome() {return "Parkinghome";}
	
	@GetMapping("/parking")
	public ModelAndView getform()
	{
		return new ModelAndView("parking","command",new Vehicle());
	}
	
	@RequestMapping(value= "proceesvehicleform" , method=RequestMethod.POST)
	public String getregister(@ModelAttribute Vehicle vehicle)
	{
		vser.savevehicle(vehicle);
		return "/home";
	}
	
	@GetMapping("/findvehicle")
	public String getfindvehicle()
	{
		return "findvehicle";
	}
	
	@RequestMapping("/findvehicleform")
	public String getvehicle(@RequestParam String vehicle_no,Model model)
	{
		
		Vehicle vehicle=vser.validate(vehicle_no);
		model.addAttribute("vehicle", vehicle);
		return "vehiclefindresult";
	}
	
	
	@RequestMapping("/list")
	public ModelAndView getlist()
	{
		List<Vehicle>list=vser.showall();
		return new ModelAndView("vdetails","vlist",list);
	}
	
	@RequestMapping("/deletevehicle/{vehicle_no}")
	public String deletevehicle(@PathVariable("vehicle_no")String vehicle_no)
	{
		vser.delete(vehicle_no);
		return "redirect:/list";
	}
	
	@RequestMapping("/searchvehicle/{vehicle_no}")
	public ModelAndView editstudent(@PathVariable("vehicle_no") String  vehicle_no)
	{
		Vehicle vehicle=vser.validate(vehicle_no);
		return new ModelAndView("update","command",vehicle);
	}
	
	
	 @RequestMapping(value="/updatevehicle", method=RequestMethod.POST)
	 public String update(@ModelAttribute Vehicle vehicle)
	 {
		 
		 vser.update(vehicle);
		 return "redirect:/list";
	 }
	
	 @GetMapping("/3rdpartyemployee")
	 public String get3rpartymodule() {
		 return "3rdpartyemployee";
	 }
	 
	 @GetMapping("/3rdpartyEmployeelogin")
	 public ModelAndView get3rdpartyempregistation() {
		 return new ModelAndView("3rdpartyEmployeelogin","command1",new Employee3P());
	 }
	 
	 @RequestMapping(value="/3pemployeeregistationform",method=RequestMethod.POST)
	 public String getprocess3pemp(@ModelAttribute Employee3P employee3P) {
		 e3pser.save(employee3P);
		 return "home";
	 }
	 
	 @RequestMapping("/3pemplist")
	 public ModelAndView get3emplist() {
		 List<Employee3P> emplist3 = e3pser.showall3pEmployee();
		 return new ModelAndView("3pempdetails","e3list",emplist3);
	 }
	 
	 
	

		@GetMapping("/addflight")
		public ModelAndView addFlight() {
			return new ModelAndView("addflight","command2",new Flight());
		}
	 
		@PostMapping("/proceesflightaddform")
		public String getsaveFlight(@ModelAttribute Flight flight) {
			fser.flightSave(flight);
			return "/home";
		}
		
		@RequestMapping("/flights")
		public ModelAndView getFlightList() {
			List<Flight> flist= fser.ShowallFlight();
			return new ModelAndView("fdetails","flightlist",flist);
		}
		
		
		@RequestMapping("/searchflight/{flight_no}")
		public ModelAndView editFlight(@PathVariable("flight_no") String  flight_no)
		{
			Flight flight=fser.findflight(flight_no);
			return new ModelAndView("flightupdate","command",flight);
		}
		
		
		 @PostMapping("/updateflight")
		 public String updateflight(@ModelAttribute Flight flight)
		 {
			 
			 fser.flightSave(flight);
			 return "redirect:/flights";
		 }
		
		 @RequestMapping("/deleteflight/{flight_no}")
		 public String deleteFlight(@PathVariable("flight_no")String flight_no)
			{
				fser.deleteFlight(flight_no);
				return "redirect:/flights";
			}
		 
		 @GetMapping("/findflights")
		 public String returnFindFlights(){
			 return "FindFlights";
		 }
		 
		 @PostMapping("/proceesflightfindform")
		 public ModelAndView processsflightfind(@RequestParam String source,@RequestParam String destination){
			 List<Flight> sdflightlist= fser.showFlightsource2destination(source, destination);
			 return new ModelAndView("flightquery","sdlist",sdflightlist);
		 }
		
		 
		 @Autowired 
		 LuggageService lser;
		 
		@GetMapping("/luggageform")
		public ModelAndView getluggageform() {
			return new ModelAndView("luggageform","command",new Luggage());
		}
		
		@PostMapping("/proceesluggageform")
		public String processluggaeform(@ModelAttribute Luggage luggage ) {
			lser.saveLuggage(luggage);
			return "home";
		}
		
		@GetMapping("/findluggage")
		public String findluggage(){
			return "findluggage";
		}
		@PostMapping("/processfindluggageform")
		public ModelAndView processfindluggageform(@RequestParam String passengerid) {
			List<Luggage> pluglist = lser.findluggagebyPassengerid(passengerid);
			return new ModelAndView("luggagebypassengerid","plist",pluglist);
		}
}
