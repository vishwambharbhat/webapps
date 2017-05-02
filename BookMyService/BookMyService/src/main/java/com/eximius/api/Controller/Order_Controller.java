package com.eximius.api.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.eximius.api.models.OrderModel;

import com.eximius.api.services.Order_Service;

@RestController
@RequestMapping("/Order_details")
public class Order_Controller {
	@Autowired
	Order_Service orderService;
	
	@RequestMapping(value="/orders", method=RequestMethod.GET,headers="Accept=application/json")
	public List<OrderModel> getAllEngineers(){
		List<OrderModel> users=orderService.getAllOrders();
		
		return users;
	}

	@RequestMapping(value="/orders/bycontact/{contact}", method=RequestMethod.GET,headers="Accept=application/json")
	public List<OrderModel> getAllOrders(@PathVariable long contact){
		List<OrderModel> users=orderService.getAllOrdersByContact(contact);
		
		return users;
	}

	
	@RequestMapping(value="/orders/pincode/{pincode}", method=RequestMethod.GET,headers="Accept=application/json")
	public List<OrderModel> getAllEngineers(@PathVariable long pincode){
		List<OrderModel> users=orderService.getAllOrders(pincode);
		
		return users;
	}
	
	@RequestMapping(value="/orders/{orderId}",method=RequestMethod.GET,headers="Accept=application/json")
	public OrderModel getOrderById(@PathVariable long orderId){
		
		OrderModel user=orderService.getOrderById(orderId);
		return user;
	}
	
	@RequestMapping(value="/orders/delete/{orderId}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public void  deleteOrderById(@PathVariable long orderId){
		
		orderService.deleteOrderById(orderId);
		
	}
	
	
	//@RequestMapping(value="/add/",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	@POST
	@RequestMapping("/orders/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
		public OrderModel insertOrder(@RequestBody OrderModel order){
		System.out.println("hello");
		 return orderService.addOrder(order);
	
		}
		
		@PUT
		@RequestMapping("/orders/update/{orderId}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public OrderModel updateOrderById(@PathVariable long orderId,@RequestBody OrderModel um){
			um.setOrderId(orderId);
			return orderService.updateOrderById(um);
		}
}
