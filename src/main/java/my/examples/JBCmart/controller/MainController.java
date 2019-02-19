package my.examples.JBCmart.controller;

import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.domain.User;
import my.examples.JBCmart.security.ShopSecurityUser;
import my.examples.JBCmart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class MainController {
    @Autowired
    AdminService adminService;

//    @GetMapping("/main")
////    public String main(
////            @RequestParam(name ="page",required = false,defaultValue = "1") int page,
////            @RequestParam(name = "searchKind", required = false) String searchKind,
////            @RequestParam(name = "searchStr",required = false) String searchStr,
////            Model model
////        ){
////        // 로그인을 한 사용자 정보는 Security필터에서 SecurityContextHolder의 ThreadLocal에 저장된다.
////        // 그래서 같은 쓰레드상이라면 로그인한 정보를 읽어들일 수 있다.
////        // authentication.principal
////        ShopSecurityUser securityUser =
////                (ShopSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////
////        return "index";
////    }

    @GetMapping("/")
    public String de(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(name ="page",required = false,defaultValue = "1") int page,
            @RequestParam(name = "searchKind", required = false) String searchKind,
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            @RequestParam(name = "searchStr",required = false) String searchStr,
            Model model
    ){
        // 로그인을 한 사용자 정보는 Security필터에서 SecurityContextHolder의 ThreadLocal에 저장된다.
        // 그래서 같은 쓰레드상이라면 로그인한 정보를 읽어들일 수 있다.
        // authentication.principal

        model.addAttribute("isLogin",(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))? true : false);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());


        List<Product> products = adminService.getProducts(page, categoryId,searchKind,searchStr);
        model.addAttribute("products",products);
        return "index";
    }

//    @GetMapping("/main")
//    public String main(Model model){
//        List<Product> products = productService.getProductAll();
//        model.addAttribute("products",products);
//        return "index";
//    }

}
