package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    //list.html
    @GetMapping
    public String ShowlistBook(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books/list";
    }

    //add.html
    @GetMapping("/add")
    public String AddBookPage(Model model){
        model.addAttribute("book", new Book());
        return "books/add";
    }

    //save -> /books
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book){
        service.saveBook(book);
        return "redirect:/books";
    }
    
    //edit.html
    @GetMapping("/edit/{id}")
    public String EditBookPage(@PathVariable Long id, Model model){
        model.addAttribute("book",service.getBookById(id));
        return "books/edit";
    }

    //update -> /books
    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable Long id , @ModelAttribute Book book) {
        book.setId(id);
        service.updateBook(book);
        return "redirect:/books";
    }
    
    //delete.html
    @GetMapping("/delete/{id}")
    public String DeletePage(@PathVariable Long id, Model model) {
        model.addAttribute("book",service.getBookById(id));
        return "books/delete";
    }
    
    //delete -> /books
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }
    
}