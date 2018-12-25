package com.example.demo.controller;

import com.example.demo.module.Book;
import com.example.demo.module.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhanghongjie
 * @date 2018/12/14
 * @descrition
 */
@Controller
@RequestMapping(value = "/readingList")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    /**
     * 构造函数
     * @param readingListRepository {@link ReadingListRepository} 对象
     */
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    /**
    * 根据路径里指定的读者，从仓库获取Book列表。随后将这个列表塞入模型，用的键是“books”，
     * 最后返回readingList作为呈现模型的视图逻辑名称
    */
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {



        List<Book> readingList = readingListRepository.findByReader(reader);

        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    /**
     * 将请求正文里的数据绑定到一个Book对象上，该 方法把Book对象的Reader属性设置为读者的姓名，
     * 随后通过仓库的save方法保存修改后的Book对象，最后重定向到/{reader}
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
}
