/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericcrud;

import dao.impl.CategoryDAO;
import model.entity.Category;

/**
 *
 * @author HP 240 G6
 */
public class GenericCRUD {

    /**
     * @param args the command line argumentsddddd
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category(3, "Category 3");
        
        categoryDAO.create(category);
        System.out.println("Good look");
    }

}
