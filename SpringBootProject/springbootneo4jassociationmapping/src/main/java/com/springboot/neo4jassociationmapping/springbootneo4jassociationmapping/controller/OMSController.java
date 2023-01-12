package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.controller;

import java.util.Collection;
// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel.Address;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel.Customer;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel.Product;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo.AddressRepo;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo.ApplicationProperties;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo.CustomProductProperties;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo.CustomProperties;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo.CustomerRepo;
import com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.repo.ProductRepo;

@RestController
public class OMSController {
    
    // @Lazy
    // @Autowired
    private CustomerRepo customerRepo;

    // @Autowired
    private ProductRepo productRepo;

  
    // @Autowired
    private AddressRepo addressRepo;

    // @Autowired
    Neo4jTemplate neo4jTemplate;
    
    // @Lazy
    // @Autowired
    private ApplicationProperties appPro;

    // @Lazy
    // @Autowired
    CustomProperties customProperties;

    // @Lazy
    // @Autowired
    CustomProductProperties customProductProperties;




    
    // @PostConstruct
    // public void purchase()
    // {
    //     List<Product> products = new ArrayList<>();
    //     products.add(new Product(1, "Bike", 1,8000));
    //     products.add(new Product(2, "AC", 1,20000));

    //     Customer customer=new Customer();
    //         customer.setId(3);
    //         customer.setName("Rakesh");
    //         customer.setAddress(new String[]{"Delhi","Bihar"});
    //         customer.setProducts(products);
    //     customerRepo.save(customer);
    // }
    @Autowired
    public OMSController(CustomerRepo customerRepo, ProductRepo productRepo, AddressRepo addressRepo,
            Neo4jTemplate neo4jTemplate, ApplicationProperties appPro, CustomProperties customProperties,
            CustomProductProperties customProductProperties) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.addressRepo = addressRepo;
        this.neo4jTemplate = neo4jTemplate;
        this.appPro = appPro;
        this.customProperties = customProperties;
        this.customProductProperties = customProductProperties;
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer)
    {
        neo4jTemplate.save(customer);
        return "Customer... Added...";
    }

    @GetMapping("/getCustomer")
    public List<Customer> getCustomer()
    {
        return customerRepo.findAll();
    }

    @GetMapping("/getOrderByName/{name}")
    public List<Product> getCustomerByName(@PathVariable String name)
    {
        return productRepo.findByName(name);
    }

    @GetMapping("/getCustomerByCityName/{name}")
    public List<Address> getCustomerByCityName(@PathVariable String name)
    {
        return addressRepo.findByCity(name);
    }

    @GetMapping("/getCustomerByStateName/{name}")
    public List<Address> getCustomerByStateName(@PathVariable String name)
    {
        return addressRepo.findByState(name);
    }

    @GetMapping("/appPro")
    public void getMyData()
    {
        System.out.println("Display Data of My Properties File..");
        System.out.println("property1 :"+appPro.getProperty1());
        System.out.println("property2 :"+appPro.getProperty2());
        System.out.println("Display Data of My Custom Properties File..");
        System.out.println("My Name Is :"+customProperties.getName()+" "+customProperties.getSurname());
        System.out.println("My Product Name : "+customProductProperties.getName());
    }

    @GetMapping("/getAllUser")
    public Collection<Customer> getAllUser()
    {
        return customerRepo.getAllUser();
    }

}
