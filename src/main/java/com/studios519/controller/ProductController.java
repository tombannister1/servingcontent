package com.studios519.controller;

import javax.validation.Valid;

import com.studios519.repository.ProductRepository;
import com.studios519.service.ProductService;
import com.studios519.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.studios519.model.Product;
import com.studios519.repository.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/admin/product", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("products",productRepository.findAll());
        modelAndView.setViewName("admin/products/showTable");
        return modelAndView;
    }

    @RequestMapping(path="/admin/product/add/", method = RequestMethod.POST) // Map ONLY GET Requests
    public ModelAndView store(@Valid Product product, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/products/showAdd");
        } else {
            productService.saveProduct(product);
            modelAndView.addObject("successMessage", "Product has been created successfully");
            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("admin/products/showTable");
        }
        return modelAndView;
    }

    @RequestMapping(path="/admin/product/addproduct", method = RequestMethod.GET) // Map ONLY GET Requests
    public ModelAndView addView() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Product product = new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("admin/products/showAdd");
        return modelAndView;
    }

    @GetMapping(path="/admin/product/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        // This returns a JSON or XML with the users
        return productRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(path = "/admin/product/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {

        productService.deleteByid(id);

        return "success";
    }

    @RequestMapping(path = "/admin/product/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("product",productRepository.findOne(id));
        modelAndView.setViewName("admin/products/showEdit");
        return modelAndView;
    }

    @RequestMapping(path = "/admin/product/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid Product product, BindingResult bindingResult, @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/products/showEdit");
        } else {
            productService.update(product);
            modelAndView.addObject("successMessage", "Product has been created successfully");
            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("admin/products/showTable");
        }
        return modelAndView;
    }

}
