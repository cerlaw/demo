package com.example.demo.module;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhanghongjie
 * @date 2018/12/14
 * @descrition 把book对象持久化到数据库的仓库
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);

}
