package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.fenye.Page;
import com.sanqing.fenye.Result;
import com.sanqing.po.Article;
import com.sanqing.service.ArticleService;

public class ShowUserAllArticle extends ActionSupport{
	private ArticleService articleService;
	private int currentPage;
	private String username;
	private String search;

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public String execute() throws Exception {
		System.out.print("iamhere");
		if(username == null || "".equals(username)) {
			//����Ҫ���session
			Map session = ActionContext.getContext().getSession();
			//���username
			username = (String) session.get("username");
		}
		
		//ͨ������ҵ���߼��������ɲ�ѯ
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);
		
		Result result = articleService.showUserArticleByPage(username, page);
		page = result.getPage();
		List<Article> all = result.getList();
		List critiqueCounts = new ArrayList();
		
		for(Article article : all) {
			critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
		}
		
		//�Ѳ�ѯ���Ľ��������һ����Χ��request
		HttpServletRequest request = ServletActionContext.getRequest();
//        String title = (String) request.getAttribute("search");
		System.out.print(search);
		if("".equals(search)) {
			request.setAttribute("msg", "����������");
			return this.ERROR;
		}
		else{
			
		List<Article> list = articleService.showByArticleLike(search);
		
		request.setAttribute("all", list);
		request.setAttribute("page", page);
		request.setAttribute("critiqueCounts",critiqueCounts);
		return this.SUCCESS;
	}
	
}
	}
