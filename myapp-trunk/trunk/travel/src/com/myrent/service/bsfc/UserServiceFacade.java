package com.myrent.service.bsfc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.myrent.data.model.service.FacadeService;
import com.myrent.vo.UserInfoVO;
import com.myrent.vo.user.UserVO;

public interface UserServiceFacade extends FacadeService{
	public Map [] findAllUsers(UserVO vo);
	public HashMap<String, UserVO> findUserDetails(UserVO vo);
	public UserVO save(UserVO vo);
	public UserInfoVO getTravellerInfo(UserVO vo);
	public void updateTravellerInfo(UserInfoVO vo) throws IOException;
	public void updateDest(String tag, UserVO vo);
	public void queryUserByAccount(UserVO vo);
	public void createUser(UserVO vo);
	public UserVO updateUserStatus(UserVO vo);
	public HashMap<String, UserVO> findUserByUserStatus(UserVO vo);
	public UserVO findUserById(UserVO vo);
	public void updateHostelUser(UserVO vo);
}
