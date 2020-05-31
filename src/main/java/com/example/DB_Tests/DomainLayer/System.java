package com.example.DB_Tests.DomainLayer;

import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import com.example.DB_Tests.ServiceLayer.ProxyAccountingSystem;
import com.example.DB_Tests.ServiceLayer.ProxyTaxSystem;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class System {

    static public boolean initialized = false;
    static public ProxyAccountingSystem accountingSystem;
    static public ProxyTaxSystem taxSystem;

    /**
     * UC 1.1
     */
    @EventListener(ApplicationReadyEvent.class)
    public static void InitializeSystem(){
        if (!initialized){
            try{
                Subscriber subscriber = MyFactory.createSubscriber("ohad", "pass", "ohad nave");
                subscriber.makeSystemManagerActive();
                accountingSystem = new ProxyAccountingSystem();
                taxSystem = new ProxyTaxSystem();
                connectOuterServices();
                initialized = true;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void connectOuterServices(){
        try{
            taxSystem.connect();
            accountingSystem.connect();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
