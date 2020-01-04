package org.pioneercoders.web.controllers.hr;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.hr.PricingPlansDto;
import org.pioneercoders.dto.hr.PricingPlansTrnDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.PricingPlansService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/pricingplans")
public class PricingPlansController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	PricingPlansService pricingPlansService;
	
	@RequestMapping(value = "/addpricingplan", method = RequestMethod.POST)
	public @ResponseBody
	Response addPricingPlane(@RequestBody PricingPlansDto planeDto) {
		Response response = new Response();
		try {
			if (planeDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						pricingPlansService.createPricingPlaneRecord(planeDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.pricingplans.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;

	}

	@RequestMapping(value = "/getpricingplans", method = RequestMethod.GET)
	public @ResponseBody
	Response getPricingPlans() {
		Response response = new Response();
		List<PricingPlansDto> dto = null;
		try {
			dto = pricingPlansService.getPricingPlaneDetailsList();
			if(dto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, dto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.pricingplans.list"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/addpricingtrnplan", method = RequestMethod.POST)
	public @ResponseBody
	Response addPricingPlaneTrnData(@RequestBody PricingPlansTrnDto planeTrnDto) {
		Response response = new Response();
		try {
			if (planeTrnDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						pricingPlansService.createPricingPlaneTrnRecord(planeTrnDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.pricingplantrn.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getpricingplansbyhrid", method = RequestMethod.GET)
	public @ResponseBody
	Response getPricingPlansTrnDetailsByHrId(
			@RequestParam(value = "hrId") Long hrId) {
		Response response = new Response();
		PricingPlansTrnDto pricingPlansTrnDto = null;
		try {
			pricingPlansTrnDto = pricingPlansService.getPricingPlaneTrnDetailsByHrId(hrId);
			if (pricingPlansTrnDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS, pricingPlansTrnDto);
			} else {
				response = ResponseUtil.createResponse(true, FAILED, msgProps.get("error.pricingplans.listbyhrid") + hrId);
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}


}
