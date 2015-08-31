package com.myrent.service.bs;

import java.util.HashMap;
import java.util.Map;

import com.myrent.data.entity.TbCsmTraveller;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.model.dao.DAO;
import com.myrent.vo.user.UserVO;

public interface UserService extends DAO<TbCsmUserBO> {
	
	public UserVO createUser(UserVO vo);
	
	public Map[] findAllUsers(UserVO vo);
	
	public TbCsmUserBO findUser(UserVO vo);
	
	public TbCsmTraveller findTraveller(UserVO vo);

	public void findUserByAccount(UserVO vo);
	
	public HashMap<String, UserVO> findUserDetails(UserVO vo);
	
	public UserVO updateUserStatus(UserVO vo);
	
	public  HashMap<String, UserVO>  findUserByUserStatus(UserVO vo);
	
	public UserVO findUserById(UserVO vo);
	public void updateHostelUser(UserVO vo);
}
