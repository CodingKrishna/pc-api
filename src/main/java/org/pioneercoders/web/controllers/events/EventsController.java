package org.pioneercoders.web.controllers.events;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.events.EventParticipantsDto;
import org.pioneercoders.dto.events.EventsDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.events.EventsService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/event")
public class EventsController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	EventsService eventsService;
	
	@RequestMapping(value = "/eventslist", method = RequestMethod.GET)
	public @ResponseBody Response getAllEvents() {
		Response response = new Response();
		try {
			List<EventsDto> eventsList= eventsService.getAllEvents();
			if(eventsList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, eventsList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.events.list"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/eventpaticipant", method = RequestMethod.POST)
	public @ResponseBody Response addEventParticipant(@RequestBody EventParticipantsDto eventParticipantsDto) {
		Response response = new Response();
		try {
			if(eventParticipantsDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, eventsService.createEventParticipants(eventParticipantsDto));
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.eventparticipants.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/eventparticipantslist", method = RequestMethod.GET)
	public @ResponseBody Response getAllEventParticipants() {
		Response response = new Response();
		try {
			List<EventParticipantsDto> eventParticipantsList= eventsService.getAllEventPaticipants();
			if(eventParticipantsList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,eventParticipantsList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.eventparticipants.list"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/eventparticipantsbyuserid", method = RequestMethod.GET)
	public @ResponseBody Response getAllBatchDetailsByCourseId(@RequestParam("userId") Long userId) {
		Response response = new Response();
		try {
			List<EventParticipantsDto> eventParticipantsList= eventsService.getEventParticipantsByUserId(userId);
			if(eventParticipantsList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,eventParticipantsList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.eventparticipants.listbyuserid"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	
}
