package com.myrent.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.myrent.data.entity.TbBizOrderBO;
import com.myrent.data.entity.TbBizPaymentBO;
import com.myrent.data.entity.TbBizRefoundBO;
import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.entity.TbBizRouteDetailBO;
import com.myrent.data.entity.TbBizRouteNodeBO;
import com.myrent.data.entity.TbBizRouteTypeBO;
import com.myrent.data.entity.TbCsmHostelBO;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.entity.TbSysResourceBO;
import com.myrent.vo.user.UserVO;

public class VOManager {

	public RouteVO addroute(TbBizRouteBO oneroute) {
		RouteVO route = new RouteVO();
		route.setRouteid(oneroute.getRouteId());
		route.setName(oneroute.getRouteName());
		route.setDes(oneroute.getDescription());
		route.setcTime(oneroute.getCreateTime());
		route.seteTime(oneroute.getUpdateTime());
		route.setStatus(oneroute.getRouteStatusCd());
		route.setFailReason(oneroute.getFailReason());
		route.setThemeImageUrl(oneroute.getThemeImage());
		List<NodeVO> ns = new ArrayList<NodeVO>();
		Set<TbBizRouteNodeBO> nodes = oneroute.getRouteNodes();
		for (Iterator<TbBizRouteNodeBO> nodeiterator = nodes.iterator(); nodeiterator
				.hasNext();) {
			TbBizRouteNodeBO day = nodeiterator.next();
			NodeVO node = new NodeVO();
			node.setName(day.getNodeName());
			node.setDescription(day.getDescription());
			node.setAccommodation(day.getAccommodation());
			node.setKeywords(day.getKeywords());
			node.setSequence(day.getSequentialNum());
			node.setIpath(day.getImageUrl());
			ns.add(node);
		}
		List<DetailVO> ds = new ArrayList<DetailVO>();
		SortByday sort = new SortByday();
		Collections.sort(ns, sort);
		String days = "";
		List<String> cars = new ArrayList<String>();
		Set<TbBizRouteDetailBO> details = oneroute.getDetails();
		for (TbBizRouteDetailBO o : details) {
			days = o.getDayOfWeek();
			break;
		}
		for (Iterator<TbBizRouteDetailBO> detailiterator = details.iterator(); detailiterator
				.hasNext();) {
			TbBizRouteDetailBO detail = detailiterator.next();
			DetailVO detailVO = getDetailVO(detail);
			cars.add(trasfercar(detail.getVehicle().getBrand()));
			ds.add(detailVO);
		}
		route.setNodes(ns);
		route.setDetails(ds);
		String[] dayofweek = days.split("");
		route.setDayofweek(dayofweek);
		String[] car = new String[cars.size()];
		route.setCars(cars.toArray(car));
		HostelVO vo = getHostel(oneroute.getHostel());
		route.setHotel(vo);
		return route;
	}

	public RouteVO getRouteDetail(TbBizRouteBO oneroute) {
		RouteVO route = new RouteVO();
		TbBizRouteTypeBO routeTypeBO = oneroute.getRouteType();
		RouteTypeVO routeType = new RouteTypeVO();
		routeType.setRouteTypeId(routeTypeBO.getRouteTypeId());
		routeType.setDescrition(routeTypeBO.getDescrition());
		routeType.setRouteName(routeTypeBO.getRouteName());
		route.setRouteid(oneroute.getRouteId());
		route.setName(oneroute.getRouteName());
		route.setDes(oneroute.getDescription());
		route.setcTime(oneroute.getCreateTime());
		route.seteTime(oneroute.getUpdateTime());
		route.setStatus(oneroute.getRouteStatusCd());
		route.setThemeImageUrl(oneroute.getThemeImage());
		route.setRoutetype(routeType.getRouteTypeId());
		List<NodeVO> ns = new ArrayList<NodeVO>();
		Set<TbBizRouteNodeBO> nodes = oneroute.getRouteNodes();
		for (Iterator<TbBizRouteNodeBO> nodeiterator = nodes.iterator(); nodeiterator
				.hasNext();) {
			TbBizRouteNodeBO day = nodeiterator.next();
			NodeVO node = new NodeVO();
			node.setName(day.getNodeName());
			node.setDescription(day.getDescription());
			node.setAccommodation(day.getAccommodation());
			node.setKeywords(day.getKeywords());
			node.setSequence(day.getSequentialNum());
			node.setIpath(day.getImageUrl());
			ns.add(node);
		}
		List<DetailVO> ds = new ArrayList<DetailVO>();
		SortByday sort = new SortByday();
		Collections.sort(ns, sort);
		String days = "";
		List<String> cars = new ArrayList<String>();
		Set<TbBizRouteDetailBO> details = oneroute.getDetails();
		for (TbBizRouteDetailBO o : details) {
			days = o.getDayOfWeek();
			break;
		}
		for (Iterator<TbBizRouteDetailBO> detailiterator = details.iterator(); detailiterator
				.hasNext();) {
			TbBizRouteDetailBO detail = detailiterator.next();
			DetailVO detailVO = getDetailVO(detail);
			ds.add(detailVO);
		}
		route.setNodes(ns);
		route.setDetails(ds);
		String[] dayofweek = days.split("");
		route.setDayofweek(dayofweek);
		String[] car = new String[cars.size()];
		// route.setCars(cars.toArray(car));
		HostelVO vo = getHostel(oneroute.getHostel());
		route.setHotel(vo);
		return route;
	}

	public HostelVO getHostel(TbCsmHostelBO bo) {
		String id = bo.getUserId();
		String manage = bo.getManager();
		String phone = bo.getManagerPhone();
		String address = bo.getAddress();
		String hostelname = bo.getHostelName();
		String hosteltelephonenum = bo.getHostelTelephoneNum();
		String registernum = bo.getRegisterNum();
		String manageridentitynum = bo.getManagerIdentityNum();
		String alipayaccount = bo.getAlipayAccount();
		String wechataccount = bo.getWechatAccount();
		String licenseImageUrl = bo.getBusinessLicenceImg();
		String idImageUrl = bo.getManagerIdentityImg();
		HostelVO vo = new HostelVO();
		vo.setId(id);
		vo.setManagername(manage);
		vo.setManagerphone(phone);
		vo.setAddress(address);
		vo.setAlipayaccount(alipayaccount);
		vo.setHostelname(hostelname);
		vo.setHosteltelephonenum(hosteltelephonenum);
		vo.setManageridentitynum(manageridentitynum);
		vo.setWechataccount(wechataccount);
		vo.setRegisternum(registernum);
		vo.setLicensenum(bo.getBusinessLicenseNum());
		vo.setHostelstatus(bo.getHostelStatusCd());
		vo.setHeadImageUrl(bo.getHeadPhoto());
		vo.setLicenseImageUrl(licenseImageUrl);
		vo.setIdImageUrl(idImageUrl);
		vo.setIdbackImageUrl(bo.getManagerIdentityImgBack());
		return vo;
	}

	public DetailVO getDetailVO(TbBizRouteDetailBO detail) {
		DetailVO detailVO = new DetailVO();
		detailVO.setId(detail.getDetailId());
		detailVO.setLimit(detail.getTourGroupLimit());
		detailVO.setPrice(detail.getPrice());
		detailVO.setVehiclename(detail.getVehicle().getBrand());
		detailVO.setLaunchday(detail.getDayOfWeek());
		detailVO.setsTimes(detail.getStartTime());
		detailVO.seteTimes(detail.getEndTime());
		detailVO.setNumber(detail.getVehicle().getPersons());
		return detailVO;
	}

	public SysResourceVO getResource(TbSysResourceBO bo) {

		SysResourceVO vo = new SysResourceVO();
		String id = bo.getResourceId();
		String name = bo.getResourceName();
		String url = bo.getUrl();
		String resourceStatusCd = bo.getResourceStatusCd();
		vo.setResourceId(id);
		vo.setResourceName(name);
		vo.setResourceStatusCd(resourceStatusCd);
		vo.setUrl(url);
		return vo;
	}

	private String trasfercar(String name) {
		String type = null;
		switch (name) {
		case "轿车":
			type = "1";
			break;
		case "商务车":
			type = "2";
			break;
		case "大巴":
			type = "3";
			break;
		case "自行车":
			type = "4";
			break;
		}
		return type;
	}

	public UserVO getUserDetail(TbCsmUserBO bo) {
		UserVO vo = new UserVO();
		vo.setUserId(bo.getUserId());
		vo.setAccount(bo.getAccount());
		vo.setAddress(bo.getAddress());
		vo.setcTime(bo.getCreateTime());
		vo.setuTime(bo.getUpdateTime());
		vo.setEmail(bo.getEmail());
		vo.setGender(bo.getGenderCd());
		vo.setHeadPhoto(bo.getHeadPhoto());
		vo.setNickname(bo.getNickName());
		vo.setPassword(bo.getPassword());
		vo.setMobileNum(bo.getPhone());
		vo.setRealPhoto(bo.getRealPhoto());
		vo.setRealName(bo.getUserName());
		vo.setUserStatus(bo.getUserStatusCd());
		vo.setUserTypeCd(bo.getUserTypeCd());

		return vo;
	}

	public OrderVO getOrderVO(TbBizOrderBO bo) {
		OrderVO vo = new OrderVO();
		vo.setOrderid(bo.getOrderId());
		vo.setTravelDate(bo.getTravelDate().toString());
		vo.setContactName(bo.getContactPersonName());
		vo.setContactNumber(bo.getContactNumber());
		vo.setContactEmail(bo.getContactEmail());
		vo.setContactGender(bo.getContactPersonGenderCd());
		vo.setcTime(bo.getCreateTime());
		vo.setPrice(bo.getPrice());
		vo.setStatus(bo.getOrderStatusCd());
		vo.setType(bo.getTourTypeCd());
		vo.setUserId(bo.getCreateUser().getUserId());
		vo.setNumOfAdult(bo.getAdultsCount());
		vo.setNumOfChild(bo.getChildrenCount());
		vo.setRemarks(bo.getRemarks());
		if (bo.getPayments().size() != 0) {
			System.out.println(bo.getPayments().iterator().next()
					.getPaymentId());
			vo.setPaymentExist(true);
		} else {
			vo.setPaymentExist(false);
		}
		DetailVO dvo = getDetailVO(bo.getRouteDetail());
		vo.setDetail(dvo);
		TbBizRouteBO oneroute = bo.getRouteDetail().getRoute();
		RouteVO route = new RouteVO();
		route.setRouteid(oneroute.getRouteId());
		route.setName(oneroute.getRouteName());
		route.setDes(oneroute.getDescription());
		dvo.setInfo(route);
		return vo;
	}

	public RefundVO getRefundVO(TbBizRefoundBO bo) {
		RefundVO vo = new RefundVO();
		vo.setOrderId(bo.getRefoundId());
		vo.setRefundAmount(bo.getRefoundAmt());
		vo.setRefundReason(bo.getRefoundReason());
		vo.setRefundStatus(bo.getRefoundStatusCd());
		// vo.setPayment(getPaymentVO(bo.getPayment()));
		vo.setcTime(bo.getRefoundTime().toString());
		return vo;
	}

	public PaymentVO getPaymentVO(TbBizPaymentBO bo) {
		PaymentVO vo = new PaymentVO();
		vo.setOrder(getOrderVO(bo.getOrder()));
		vo.setPaidAmt(bo.getPaidAmt().toString());
		vo.setcTime(Double.valueOf(bo.getCreateTime()));
		vo.setOrderId(getOrderVO(bo.getOrder()).getOrderid());
		vo.setPaymentId(bo.getPaymentId());
		vo.setPaymentStatus(bo.getPaymentStatusCd());
		vo.setUser(getUserDetail(bo.getCreateUser()));
		vo.setuTime(bo.getUpdateTime());
		vo.setUserId(getUserDetail(bo.getCreateUser()).getUserId());
		return vo;
	}
}
