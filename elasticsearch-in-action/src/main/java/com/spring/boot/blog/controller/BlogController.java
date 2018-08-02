/**
 * 
 */
package com.spring.boot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.blog.domain.es.EsBlog;
import com.spring.boot.blog.repository.es.EsBlogRepository;

/**
 * @author bazhonglbj
 *
 */

@RestController
@RequestMapping("/blogs")
public class BlogController {
	@Autowired
	private EsBlogRepository esBlogRepository;
	
	@GetMapping
	public List<EsBlog> list(@RequestParam(value="title") String title,
			@RequestParam(value="summary") String summary,
			@RequestParam(value="content") String content,
			@RequestParam(value="pageIndex", defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
	
		// 数据是在 Test 初始化
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
	
		return page.getContent();
	}
}

