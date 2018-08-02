/**
 * 
 */
package com.spring.boot.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.boot.blog.domain.es.EsBlog;

/**
 * esblog库接口
 * @author bazhonglbj
 *
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

	/**
	 * 分页查询博客（去重）
	 * @param title
	 * @param summary
	 * @param content
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}

