package com.myrent.service.bs.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbCsmHostelBO;
import com.myrent.data.entity.TbCsmTraveller;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.entity.TbSysRoleBO;
import com.myrent.data.model.QueryResult;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.UserService;
import com.myrent.utils.MD5Encoder;
import com.myrent.utils.UUIDUtil;
import com.myrent.vo.VOManager;
import com.myrent.vo.user.UserVO;

@Service("userServiceBean")
public class UserServiceBean extends DAOImpl<TbCsmUserBO> implements
		UserService {

	//CREATE USERS
	public UserVO createUser(UserVO vo) {
		
		TbCsmUserBO userBO = null;
		String queryString = null;
		queryString = "from TbSysRoleBO t where t.roleName = ?1";
		Query query = em.createQuery(queryString);
		
		if("1".equals(vo.getUserTypeCd())){
			userBO = new TbCsmTraveller();
			userBO.setUserStatusCd("1"); //正常
			userBO.setUserTypeCd("1");
			query.setParameter(1, "ROLE_USER");
			
		}else if("2".equals(vo.getUserTypeCd())){//SET SPECIFIC PROPERTIES
			userBO = new TbCsmHostelBO();
			userBO.setUserStatusCd("1");//审核中
			userBO.setUserTypeCd("2");
			TbCsmHostelBO hostel = (TbCsmHostelBO)userBO;
			hostel.setHostelStatusCd("1");
			query.setParameter(1, "ROLE_HOSTEL");
		}
		
		//SET COMMON PROPERTIES
		//ADD ROLES
		List list = query.getResultList();
		userBO.getRoles().add((TbSysRoleBO)list.get(0));
		userBO.setUserId(UUIDUtil.generateUUID());
		userBO.setAccount(vo.getAccount());
		userBO.setPassword(MD5Encoder.encode(vo.getPassword()));
		userBO.setEmail(vo.getEmail());
		userBO.setUserTypeCd(vo.getUserTypeCd());
		this.save(userBO);
		vo.setTbCsmUserBO(userBO);
		return vo;
	}

	public Map[] findAllUsers(UserVO vo) {

		LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
		String whereJPQL = "";
		// Object[] params = {"%ad%","admin@gmail.com"};
		// orderBy.put("userName", "desc");

		QueryResult<TbCsmUserBO> result = queryJpqlPagedEntity(0, 10,
				whereJPQL, null, orderBy);
		List<Map> list = new ArrayList<>();

		for (TbCsmUserBO user : result.getResultList()) {
			System.out.print(user.getUserName() + " , ");
			Set<TbSysRoleBO> roles = user.getRoles();

			Map map = new HashMap();
	    	map.put("userName", user.getUserName());
	    	list.add(map);
			for (TbSysRoleBO role : roles) {
				System.out.println(role.getRoleName());
			}

		}

		// query join
		String jpql = "select t1.userName from TbCsmUserBO t1";

		
		Map[] a = new Map[list.size()];
		return list.toArray(a);
		
	}
	
	public HashMap<String, UserVO> findUserDetails(UserVO vo) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
		String whereJPQL = "";
		// Object[] params = {"%ad%","admin@gmail.com"};
		// orderBy.put("userName", "desc");

		QueryResult<TbCsmUserBO> result = queryJpqlPagedEntity(0, 10,
				whereJPQL, null, orderBy);
		VOManager voManager = new VOManager();

		HashMap<String, UserVO> map = new HashMap<String, UserVO>();
		for (TbCsmUserBO user : result.getResultList()) {
			UserVO vo1 = new UserVO();
			String userId = user.getUserId();
			vo1 = voManager.getUserDetail(user);
			map.put(userId, vo1);
		}
		// query join
		String jpql = "select t1.userName from TbCsmUserBO t1";
		return map;
	}


	@Override
	public TbCsmUserBO findUser(UserVO vo)
	{
		Query query = em
				.createQuery("SELECT T FROM TbCsmUserBO T WHERE T.userId = ?1");
		query.setParameter(1, vo.getUserId());
		List<TbCsmUserBO> result = query.getResultList();
		if(result.size() != 0){
			return result.get(0);
		}
		return null;
	}

	@Override
	public TbCsmTraveller findTraveller(UserVO vo) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("SELECT T FROM TbCsmTraveller T WHERE T.userId = ?1");
		query.setParameter(1, vo.getUserId());
		List<TbCsmTraveller> result = query.getResultList();
		if(result.size() != 0){
			return result.get(0);
		}
		return null;
	}

	@Override
	public void findUserByAccount(UserVO vo) {
		// TODO Auto-generated method stub
		String account = vo.getAccount();
		String queryString = "from TbCsmUserBO t where t.account = ?1";
		Query query = em.createQuery(queryString);
		query.setParameter(1, account);
		List<TbCsmUserBO> list = query.getResultList();
		if(null != list && list.size() >= 1)
			vo.setTbCsmUserBO(list.get(0));
		
	}

	@Override
	public UserVO updateUserStatus(UserVO vo) {
		// TODO Auto-generated method stub
		
		TbCsmUserBO bo = find(vo.getUserId());
		bo.setUserStatusCd(vo.getUserStatus());
		update(bo);
		return null;
	}

	@Override
	public  HashMap<String, UserVO>  findUserByUserStatus(UserVO vo) {
		// TODO Auto-generated method stub
		String status = vo.getUserStatus();
		String queryString = "from TbCsmUserBO t where t.userStatusCd = ?1";
		Query query = em.createQuery(queryString);
		query.setParameter(1, status);
		
		 HashMap<String, UserVO>  userVOMap = new HashMap<String, UserVO> ();
		List<TbCsmUserBO> list = query.getResultList();
		VOManager manager = new VOManager();
		for (TbCsmUserBO user : list){
			UserVO vo1 = manager.getUserDetail(user);
			userVOMap.put(user.getUserId(), vo1);
		}
		
		return userVOMap;
	}

	public UserVO findUserById(UserVO vo)
	{
		TbCsmUserBO bo=find(vo.getUserId());
		VOManager vm=new VOManager();
		return vm.getUserDetail(bo);
	}
	
	
	public void updateHostelUser(UserVO vo){
		TbCsmUserBO bo=find(vo.getUserId());
		bo.setHeadPhoto(vo.getHeadPhoto());
		bo.setEmail(vo.getEmail());
		bo.setUserId(vo.getUserId());
		bo.setPhone(vo.getMobileNum());
		bo.setNickName(vo.getNickname());
		update(bo);
	}
}
