package com.myrent.service.bsfc.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.myrent.data.entity.TbCsmTraveller;
import com.myrent.service.bs.UserService;
import com.myrent.service.bsfc.UserServiceFacade;
import com.myrent.vo.UserInfoVO;
import com.myrent.vo.user.UserVO;

@Service("userServiceFacadeBean")
public class UserServiceFacadeBean implements UserServiceFacade{

	@Resource(name="userServiceBean")
	private UserService userService;
	
//	@Resource(name="sysCodesServiceBean")
//	private SysCodesService sysCodesService;
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	public void create(UserVO vo){
		userService.createUser(vo);
		userService.delete(vo);
	}
	
	
	
	
    public void update(){
		
	}
	
    
    public void delete(){
		
  	}

	@Override
	public Map[] findAllUsers(UserVO vo) {
		
		Map [] map = userService.findAllUsers(vo);
		return map;
	}


	@Override
	public UserVO save(UserVO vo)
	{
		//UserVO v = userService.findUser(vo);
		return null;
	}


	@Override
	@Transactional
	public UserInfoVO getTravellerInfo(UserVO vo) {
		TbCsmTraveller traveller = userService.findTraveller(vo);
		if(traveller != null){
			UserInfoVO user = new UserInfoVO();
			
			String address = traveller.getAddress();	
			if(address != null){
				if(!address.equals("--")){
					String[] addr = address.split("-");
					user.setProvince(addr[0]);
					user.setCity(addr[1]);
					user.setCountry(addr[2]);
				}
			}
			user.setRealInfoStatus(traveller.getUserStatusCd());
			user.setHeadPhotoPath(traveller.getHeadPhoto());
			user.setRealPhotoPath(traveller.getRealPhoto());
			user.setDestHistory(traveller.getHistoryDestination());
			user.setDestFuture(traveller.getFutureDestination());
			user.setGender(traveller.getGenderCd() == null?"3":traveller.getGenderCd()); 
			if(traveller.getBirthday() != null){
				user.setBirthday(traveller.getBirthday());
			}
			user.setIdNum(traveller.getIdNum());
			user.setTourDeclaration(traveller.getTourDeclaration());
			user.setUserName(traveller.getUserName());	
			user.setOccupation(traveller.getOccupationCd());
			user.setUserId(traveller.getUserId());
			user.setNickName(traveller.getNickName());
			return user;
		}
		return null;
		
		
	}

	
	@Override
	@Transactional
	public void updateTravellerInfo(UserInfoVO vo) throws IOException {

		UserVO v = new UserVO();
		v.setUserId(vo.getUserId());
		TbCsmTraveller traveller = userService.findTraveller(v);
		if(traveller != null){
			MultipartFile realPhoto = vo.getRealPhoto();
			MultipartFile headPhoto = vo.getHeadPhoto();
			
			if (vo.validateImageFile(realPhoto)) {
				String fileUrl = vo.saveFile(realPhoto);
				traveller.setRealPhoto(vo.getRealPhoto() == null?traveller.getRealPhoto():fileUrl);
				
			};
			if (vo.validateImageFile(headPhoto)) {
				String fileUrl = vo.saveFile(headPhoto);	
				traveller.setHeadPhoto(vo.getHeadPhoto() == null?traveller.getHeadPhoto():fileUrl);
			};
			traveller.setUserStatusCd(vo.getRealInfoStatus() == null?traveller.getUserStatusCd():vo.getRealInfoStatus());
			traveller.setUserName(vo.getRealName() == null?traveller.getUserName():vo.getRealName());
			traveller.setIdNum(vo.getIdNum() == null?traveller.getIdNum():vo.getIdNum());
			
			traveller.setNickName(vo.getNickName() == null?traveller.getNickName():vo.getNickName());
			traveller.setAddress(vo.getAddress() == null?traveller.getAddress():vo.getAddress());
			if(traveller.getGenderCd() == null){
				traveller.setGenderCd("3");
			}
			else{
				traveller.setGenderCd(vo.getGender() == null?traveller.getGenderCd():vo.getGender());
			}
			
			if(traveller.getOccupationCd() == null){
				traveller.setOccupationCd("1");
			}
			else{
				traveller.setOccupationCd(vo.getOccupation() == null?traveller.getOccupationCd():vo.getOccupation());
			}
			traveller.setTourDeclaration(((vo.getTourDeclaration() == "")|| (vo.getTourDeclaration() == null))?traveller.getTourDeclaration():vo.getTourDeclaration());
			Timestamp dtime = new Timestamp(System.currentTimeMillis());
			traveller.setUpdateTime(dtime);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			if(!vo.getBirthday().equals("")){
				System.out.println("into getBirthday");
				String time = vo.getBirthday();
				time = time+" 00:00:00"; 
				Timestamp ts = Timestamp.valueOf(time);
				traveller.setBirthday(ts);
			}else if(traveller.getBirthday() != null){
				String time = sdf.format(traveller.getBirthday());
				time = time+" 00:00:00"; 
				Timestamp ts = Timestamp.valueOf(time);
				traveller.setBirthday(ts);
			}
		}
	}

	@Override
	public void updateDest(String tag, UserVO vo)
	{
		logger.trace("updateDest");
		TbCsmTraveller traveller = userService.findTraveller(vo);
		if(traveller != null){
			String s = tag.substring(0,1);
			String ss = tag.substring(0,2);

			if(s.equals("f")){
				if(!traveller.getFutureDestination().contains(tag.substring(1).trim())){
					traveller.setFutureDestination(traveller.getFutureDestination()+tag.substring(1).trim()+",");	
				}
			}
			else if(s.equals("h")){
				if(!traveller.getHistoryDestination().contains(tag.substring(1).trim())){
					traveller.setHistoryDestination(traveller.getHistoryDestination()+tag.substring(1).trim()+",");	
				}
			}
			else if(ss.equals("df")){
				traveller.setFutureDestination(traveller.getFutureDestination().replace(tag.substring(2)+",", ""));
			}
			else{
				traveller.setHistoryDestination(traveller.getHistoryDestination().replace(tag.substring(2)+",", ""));
			}
		}
		
	}




	@Override
	public void queryUserByAccount(UserVO vo) {
		userService.findUserByAccount(vo);
		
	}




	@Override
	public void createUser(UserVO vo) {
		
		userService.createUser(vo);
	}




	@Override
	public HashMap<String, UserVO> findUserDetails(UserVO vo) {
		// TODO Auto-generated method stub
		return userService.findUserDetails(vo);
	}




	@Override
	public UserVO updateUserStatus(UserVO vo) {
		// TODO Auto-generated method stub
		return userService.updateUserStatus(vo);
	}




	@Override
	public HashMap<String, UserVO> findUserByUserStatus(UserVO vo) {
		// TODO Auto-generated method stub
		return userService.findUserByUserStatus(vo);
	}




	@Override
	public UserVO findUserById(UserVO vo) {
		// TODO Auto-generated method stub
		return userService.findUserById(vo);
	}




	@Override
	public void updateHostelUser(UserVO vo) {
		// TODO Auto-generated method stub
		userService.updateHostelUser(vo);
	}

}
