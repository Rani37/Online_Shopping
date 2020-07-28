
package com.dxc.controllers;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.dao.AdminDao;
import com.dxc.pojo.Admin;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;
import com.dxc.service.AdminService;
@Controller
@RequestMapping("/views")
public class AdminController
{
	Admin a=new Admin();
	AdminService service=new AdminService();
	AdminDao dao= new AdminDao();
	@RequestMapping("/insert")
	public String add(@ModelAttribute Admin a,HttpSession session)
	{
	

		service.addAdmin(a);
		 String message="added";
		 session.setAttribute("message", message);
		 return"message";
	}

@RequestMapping("/login")//login
public String login(@ModelAttribute Admin a,HttpSession session)
{

boolean b=service.login(a);
System.out.println(b);

if(b==true) 
{
 return"op";
	}
else 
{
	String message="login unsucessful";
 session.setAttribute("message", message);
 return"message";
}
}	

//add product
@RequestMapping("/addproduct")
public String addproduct(@ModelAttribute Product p,HttpSession session )
{

System.out.println("going to add");
service.addproduct(p);
 String message="product added successfully!! :)";
session.setAttribute("message", message);
return "message";
	
}

//remove product
@RequestMapping("/remove")
public String remove(@ModelAttribute Customer c,HttpSession session)
{
int cid=c.getCid();

 boolean find=service.remove(cid);
if(find==true) {
 String message="removed";
 session.setAttribute("message", message);
 return"message";

} else {
String message="invalid id";
 session.setAttribute("message", message);
 return"message";
}

}

//delete product
@RequestMapping("/delete")
public String delete(@RequestParam int id,HttpSession session)
{
service.delete(id);
 String message="deleted";
 session.setAttribute("message", message);
 return"message";

}

//add customer.......
@RequestMapping("/addcustomer")
public String addproduct(@ModelAttribute Customer c,HttpSession session )
{
System.out.println("going to add");
service.addcustomer(c);
String message="customer added Successfully!! :)";
session.setAttribute("message", message);
return "message";

}

//display products....
@RequestMapping("/prod")
public String display(Model m) {
 List<Product> list=service.display();
 m.addAttribute("list", list);
return "showproducts";

}
//display customers
     @RequestMapping("/customerlist")
       public String show(Model m) {
    List<Customer> lis=service.show();
     m.addAttribute("lis",lis);
    return "customerlist";

}



}
