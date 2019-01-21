/**
 * 
 */
package com.mediaocen.assessement.prokabaddi.service.impl;

import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediaocen.assessement.prokabaddi.entity.Ground;
import com.mediaocen.assessement.prokabaddi.repository.GroundRepository;
import com.mediaocen.assessement.prokabaddi.repository.MatchSchedulerRepository;
import com.mediaocen.assessement.prokabaddi.service.GroundService;

/**
 * @author Gokul
 *
 */
@Service("groundService")
public class GroundImpl implements GroundService {

	@Autowired
	private GroundRepository groundRepo;

	@Autowired
	private MatchSchedulerRepository schedulerRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mediaocen.assessement.prokabaddi.service.GroundService#registerGround()
	 */
	@Override
	public Response registerGround(Ground ground) {
		if (ground.getName() != null) {
			groundRepo.save(ground);
			return Response.ok(ground).build();
		} else {
			return Response.noContent().build();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mediaocen.assessement.prokabaddi.service.GroundService#getGround()
	 */
	@Override
	public List<Ground> getGround() {
		List<Ground> groindList = groundRepo.findAll();
		return groindList;
	}

	@Override
	public Ground updateGround(Ground ground) {
		Ground updatedGround = groundRepo.save(ground);
		return updatedGround;
	}

	@Override
	public Response unRegisterGround(HttpHeaders headers) {
		String grounId = headers.getRequestHeader("ID").get(0);
		long id = Long.parseLong(grounId);
		schedulerRepo.deleteAll();
		groundRepo.deleteById(id);
		return Response.ok().build();
	}

}
