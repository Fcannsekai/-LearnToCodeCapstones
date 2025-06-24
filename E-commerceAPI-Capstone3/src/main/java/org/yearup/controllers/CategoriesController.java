package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

@RestController                // Marks this class as a REST controller now can handle HTTP requests and return JSON
@RequestMapping("/categories")  // Sets the base URL for this controller all methods will now respond to urls with /catagories
@CrossOrigin  // Allows cross-origin requests to access my api and is necessary for front end testing
public class CategoriesController
{
    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    @Autowired  // Constructor injection of the DAOs
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao)
    {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    @GetMapping  // GET http://localhost:8080/categories
    public List<Category> getAll()
    {
        return categoryDao.getAll(); //temp errors going to be gone once i set up the DAO classes
    }

    @GetMapping("{id}")  // GET http://localhost:8080/categories/{id}
    public Category getById(@PathVariable int id)
    {
        return categoryDao.getById(id);
    }

    @GetMapping("{categoryId}/products")  // GET http://localhost:8080/categories/{categoryId}/products
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
        return productDao.getByCategoryId(categoryId);
    }

    @PostMapping  // POST http://localhost:8080/categories
    @PreAuthorize("hasRole('ADMIN')")  // Only Admins can add categories
    public Category addCategory(@RequestBody Category category)
    {
        return categoryDao.create(category);
    }

    @PutMapping("{id}")  
    @PreAuthorize("hasRole('ADMIN')")  // Only Admins can update categories
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        category.setCategoryId(id);
        categoryDao.update(category);
    }

    @DeleteMapping("{id}")  // DELETE http://localhost:8080/categories/{id}
    @PreAuthorize("hasRole('ADMIN')")  // Only Admins can delete categories
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.delete(id);
    }
}