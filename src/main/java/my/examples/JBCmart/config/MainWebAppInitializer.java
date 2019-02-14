//package my.examples.JBCmart.config;
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//
//public class MainWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] { ApplicationConfig.class };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] { WebConfig.class };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//        encodingFilter.setEncoding("UTF-8");
//
//        return new Filter[]{encodingFilter};
//    }
//}
