package my.examples.JBCmart.controller;

import lombok.RequiredArgsConstructor;
import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
@RequiredArgsConstructor
public class ViewController {
    private final ProductService productService;


    @GetMapping("/{productId}")
    public String view(@PathVariable(name = "productId") String productId,
                       Model model){
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "views/product";
    }
}
