package my.examples.JBCmart.controller;


import lombok.RequiredArgsConstructor;
import my.examples.JBCmart.domain.Category;
import my.examples.JBCmart.domain.ImageFile;
import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.domain.ProductDetail;
import my.examples.JBCmart.service.CategoryService;
import my.examples.JBCmart.service.ImageFileService;
import my.examples.JBCmart.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ImageFileService imageFileService;

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


        if(images != null && images.length > 0) {
            for (MultipartFile image : images) {
                if (image != null && image.getSize() > 0) {
                    ImageFile imageFile = new ImageFile();
                    imageFile.setLength(image.getSize());
                    imageFile.setMimeType(image.getContentType());
                    imageFile.setName(image.getOriginalFilename());
                    // 파일 저장
                    // /tmp/2019/2/12/123421-12341234-12341234-123423142
                    String saveFileName = saveFile(image);

                    imageFile.setSaveFileName(saveFileName); // save되는 파일명
                    product.addImageFile(imageFile);
                }
            }
        }
        productService.addProduct(product, categoryId);
        return "redirect:/main";
    }



    //상품상세등록 관리자
    @GetMapping("/productdetailform1")
    public String productdetailform1(Model model){
        List<Product> products = productService.getProductAll();
        model.addAttribute("products", products);
        return "admin/productdetailform1";
    }

    @PostMapping("/productdetailform1")
    public String product(
            @RequestParam(name = "productColor") String productColor,
            @RequestParam(name = "productSize") String productSize,
            @RequestParam(name = "productPrice") Long productPrice,
            @RequestParam(name = "productId") String productId,
            @RequestParam(name = "productQuantity") Long productQuantity)
           {

        // Assert.hasText(productId,"상품코드");
        // Assert.hasText(productName,"상품이름");

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductColor(productColor);
        productDetail.setProductSize(productSize);
        productDetail.setProductQuantity(productQuantity);
       // productDetail.setProduct();


        //productService.addProduct(product, categoryId);
        return "redirect:/main";
    }




    @GetMapping("/images/{id}")
    @ResponseBody // 컨트롤러안에서 직접 response를 이용하여 결과를 출력할 때 사용
    public void downloadImage(
            @PathVariable(name = "id") Long id,
            HttpServletResponse response
    ) {
        ImageFile imageFile = imageFileService.getImageFile(id);
        response.setContentType(imageFile.getMimeType());

        try(FileInputStream fis = new FileInputStream(imageFile.getSaveFileName());
            OutputStream out = response.getOutputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;

            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer, 0, readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private String saveFile(MultipartFile image) {
        String dir = "/tmp/";
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.MONTH) + 1);
        dir = dir + "/";
        dir = dir + calendar.get(Calendar.DAY_OF_MONTH);
        dir = dir + "/";
        File dirFile = new File(dir);
        dirFile.mkdirs(); // 디렉토리가 없을 경우 만든다. 퍼미션이 없으면 생성안될 수 있다.
        dir = dir + UUID.randomUUID().toString();

        try(FileOutputStream fos = new FileOutputStream(dir);
            InputStream in = image.getInputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                fos.write(buffer, 0, readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return dir;
    }





}
