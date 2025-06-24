package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @GetMapping("{id}")  // GET {id}
    public Category getById(@PathVariable int id) {
        try {
            var category = categoryDao.getById(id); //Method used to validate

            if (category == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            return category;
        }
        catch (ResponseStatusException ex) {   // changes response code -> 204 "Nothing here :(" "GET"
            throw ex;
        }
    }

    @GetMapping("{categoryId}/products")  // GET {categoryId}/products
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
        return productDao.listByCategoryId(categoryId);
    }

    @PostMapping  // POST
    @PreAuthorize("hasRole('ADMIN')")    // Only Admins can add categories
    @ResponseStatus(HttpStatus.CREATED) // changes the response code -> 201 "POST"
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

    @DeleteMapping("{id}")  // DELETE {id}
    @PreAuthorize("hasRole('ADMIN')")  // Only Admins can delete categories
    @ResponseStatus(HttpStatus.NO_CONTENT) //changes the response code -> 204 "DELETE"
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.delete(id);
    }
}