package com.sanqing.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.bean.Vote;
import com.sanqing.bean.VoteOption;
import com.sanqing.dao.VoteDAO;
import com.sanqing.dao.VoteOptionDAO;
import com.sanqing.daoFactory.VoteDAOFactory;
import com.sanqing.daoFactory.VoteOptionDAOFactory;

public class AddVoteAction extends ActionSupport {
	private int channel;		// 封装channel参数
	private String voteName;	// 封装voteName参数
	private String[] voteOption;// 封装voteOption参数

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public String[] getVoteOption() {
		return voteOption;
	}

	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}

	public String execute() throws Exception {
		
		System.out.println(voteName);
		System.out.println(voteOption);
		
//		if(channel == 0 && ("").equals(voteName) && ("").equals(voteOption)) {
		if(voteName == null  && voteName == null || voteName.length() <= 0) {
			HttpServletRequest request = ServletActionContext.getRequest();
			
			request.setAttribute("msg","请输入内容,不要留下空白");
			return this.ERROR;
		}
		
	
		
		else{
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();//获得VoteDAO实例
		VoteOptionDAO voteOptionDAO = 
			VoteOptionDAOFactory.getVoteOptionDAOInstance();//获得voteOption实例
		//首先保存投票，然后再保存投票选项
		Vote vote = new Vote();
		vote.setChannelID(channel);
		vote.setVoteName(voteName);
		voteDAO.addVote(vote);
		//查询投票ID
		int voteID = voteDAO.findVoteByName(voteName).getVoteID();
		//保存投票选项
		for(String voteOptionName : voteOption) {
			VoteOption vp = new VoteOption();
			vp.setVoteID(voteID);
			vp.setVoteOptionName(voteOptionName);
			voteOptionDAO.addVoteOption(vp);
		}
		return this.SUCCESS;
		}
	}
	
}


