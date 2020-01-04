package org.pioneercoders.web.controllers.common;

import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.response.Response;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messageBundle")
public class MessageBundleController {

	//private static final String FAILED = "failed";

	private static final String SUCCESS = "success";
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Response getMessageBundle() {
    	Response response = ResponseUtil.createResponse(true, SUCCESS, msgProps);
        return response;
    }
    
}
