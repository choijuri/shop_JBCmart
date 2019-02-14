package my.examples.JBCmart.controller;


import lombok.RequiredArgsConstructor;
import my.examples.JBCmart.domain.Category;
import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.service.CategoryService;
import my.examples.JBCmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    //상품등록 관리자
    @GetMapping("/product")
    public String productform(Model model){
        List<Category> categories = categoryService.getCategoryAll();
        model.addAttribute("categories", categories);
        return "admin/productform";
    }

    @PostMapping("/product")
    public String product(
            @RequestParam(name = "productId") String productId,
            @RequestParam(name = "productName") String productName,
            @RequestParam(name = "productPrice") Long productPrice,
            @RequestParam(name = "categoryId") Long categoryId,
            @RequestParam(name = "image") MultipartFile[] images){

        Assert.hasText(productId,"상품코드");
        Assert.hasText(productName,"상품이름");

        // 로그인을 한 사용자 정보는 Security필터에서 SecurityContextHolder의 ThreadLocal에 저장된다.
        // 그래서 같은 쓰레드상이라면 로그인한 정보를 읽어들일 수 있다.
        //ShopSecurityUser securityUser =(ShopSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductPrice(productPrice);

        productService.addProduct(product, categoryId);

        return "redirect:/main";
    }

    //상품등록 관리자
    @GetMapping("/productdetailform1")
    public String productdetailform1(Model model){
        List<Product> products = productService.getProductAll();
        model.addAttribute("products", products);
        return "admin/productdetailform1";
    }





}
