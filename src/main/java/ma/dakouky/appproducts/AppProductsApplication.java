package ma.dakouky.appproducts;

import ma.dakouky.appproducts.entites.Product;
import ma.dakouky.appproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppProductsApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(AppProductsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Chaise",220,8));
        //productRepository.save(new Product(null,"Table",3844,4));
        //productRepository.save(new Product(null,"Mirror",730,11));

        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());

        });

        Product product = productRepository.findById(Long.valueOf(2)).get();
        System.out.println("-------------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuanitity());
        System.out.println("------1-------");


        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("-------2--------");

        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("-------3--------");

        List<Product> productList3 = productRepository.findByPriceGreaterThan(720);
        productList3.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-------4--------");

        List<Product> productList4 = productRepository.searchByPrice(720);
        productList4.forEach(p->{
            System.out.println(p);
        });
    }
}
