package com.online.purchase.controller;


import com.online.purchase.model.Category;
import com.online.purchase.model.Product;
import com.online.purchase.model.User;
import com.online.purchase.repository.CategoryRepository;
import com.online.purchase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EntityManager entityManager;


    @RequestMapping("/category/list")
    public String getCategoryList(ModelMap model){

        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user=userRepository.findUserByUsername(auth.getName());
            String role = user.getUsername();
            model.addAttribute("role", role);

        }
        catch(Exception e){

        }
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";

    }

    @RequestMapping("/category/{id}/save")
    public String categorySave(ModelMap model, @PathVariable("id") long id){
        if(id == 0){
            Category category = new Category();
            model.addAttribute("category", category);
        }
        else {
            Category category = categoryRepository.getOne(id);
            model.addAttribute("category", category);
        }

        return "addCategory";

    }

    @PostMapping("/category/save")
    public String save(Category category){


        categoryRepository.save(category);

        return "redirect:/category/list";
    }

    @RequestMapping("/category/{id}/delete")
    public String delete(@PathVariable("id") long id){


        categoryRepository.deleteById(id);

        return "redirect:/category/list";

    }

    @PostMapping("/category/edit")
    public String edit(Category category){
        String baseQuery = "update category set name = "+category.getName()+"where id="+category.getId()+";";
        Query query = entityManager.createNativeQuery(baseQuery);
        query.executeUpdate();

        return "redirect:/category/list";
    }



}
