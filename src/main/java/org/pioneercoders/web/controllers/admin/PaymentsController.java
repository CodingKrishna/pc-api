package org.pioneercoders.web.controllers.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.pioneercoders.dto.admin.PaymentsDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.admin.PaymentsService;
import org.pioneercoders.utils.ResponseUtil;
import org.pioneercoders.web.controllers.user.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="payments")
public class PaymentsController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	PaymentsService paymentsService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	 public @ResponseBody Response addPayment(@RequestBody PaymentsDto paymentsDto, HttpServletRequest request){
		System.out.println(paymentsDto);
		Response response = new Response();
		try {
			PaymentsDto finalPaymentsDto = paymentsService.insertPayment(paymentsDto);
			if(finalPaymentsDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,finalPaymentsDto);
			}else{
				response = ResponseUtil.createResponse(false, SUCCESS, msgProps.get("error.payment.creationfailed"));
			}
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	 }
	@RequestMapping(value="byuserid",method=RequestMethod.POST)
	public @ResponseBody Response getPaymentsByUserId(@RequestParam(value="userid")Long userId){
		Response response = new Response();
		try {
			if(userId!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,paymentsService.getPaymentsByUserId(userId));
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.payment.paymentsbyuserid")+userId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
		
	}
	
	@RequestMapping(value="totalpaymentsbydates", method=RequestMethod.GET)
	@ResponseBody
	public Response  getTotalPaymentsByDates(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate){
		Response response = new Response();
		try{
			response = ResponseUtil.createResponse(true, SUCCESS, paymentsService.getPayListByDate(startDate, endDate));
	
		}catch(ServiceException e){
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	
	
}
