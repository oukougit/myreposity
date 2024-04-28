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

public class ShowAllArticle extends ActionSupport{
	private ArticleService articleService;
	private int currentPage;
	private String search;

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
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
		
		
		//通过调用业务逻辑组件来完成查询
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(10);
		
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		List<Article> all = result.getList();
		
		List critiqueCounts = new ArrayList();
		for(Article article : all) {
			critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
		}
		
		//把查询到的结果保存在一个范围，request
		HttpServletRequest request = ServletActionContext.getRequest();
       
		System.out.print(search);
		if("".equals(search)) {
			request.setAttribute("msg", "请输入内容");
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
