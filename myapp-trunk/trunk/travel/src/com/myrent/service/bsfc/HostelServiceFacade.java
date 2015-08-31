package com.myrent.service.bsfc;

import com.myrent.vo.HostelVO;

public interface HostelServiceFacade {
	public void create(HostelVO vo);
	public HostelVO findHostel(HostelVO vo);
	public void updateHostelStatus(HostelVO vo);
}
