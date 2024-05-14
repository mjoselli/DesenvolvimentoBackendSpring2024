package com.example.thymeleafTemplates;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class BlogPostController {
    private ArrayList<BlogPost> blogPosts =
            new ArrayList<BlogPost>();

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("blogPosts", blogPosts);
        return "index";
    }

    @GetMapping("/add-post")
    public String showAddPostForm(BlogPost blogPost) {
        return "add-post";
    }

    @PostMapping("/add-post")
    public String addPost(BlogPost blogPost, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-post";
        }
        blogPost.setDate(new Date());
        blogPosts.add(blogPost);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        BlogPost blogPost = blogPosts.get(id);
        model.addAttribute("blogPost", blogPost);
        return "update-post";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        blogPosts.remove(id);
        return "redirect:/";
    }

}
