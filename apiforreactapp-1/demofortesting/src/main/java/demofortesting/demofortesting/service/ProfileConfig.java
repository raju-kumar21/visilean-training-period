package demofortesting.demofortesting.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
    
    @Value(value = "${my.prop}")
    private String myProp;

    @Profile(value = {"default"})
    @Bean(name = "myProp")
    public String createBeanForDefault(){
       
        return myProp;
    }
hi every one last night hapen a situation with my friend a fake account on social media try to making fool to my friend but jocking is my friend was very good in own field .his field is cyber security also he had exprience working of MP cyber cell also solve a case regarding social media My intension to shae this intancion  to be care full on internet and safe use
    @Profile(value = {"dev"})
    @Bean(name = "myProp")
    public String createBeanForDev(){
       
        return myProp;
    }

    @Profile(value = {"prod"})
    @Bean(name = "myProp")
    public String createBeanForProd(){
       
        return myProp;
    }


}