package com.tt.util;

import com.tt.adapter.OperationalSupportSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.tt.util.Constants.ABV;
import static com.tt.util.Constants.NSTV;

@Component
public class CASHelper {

    @Autowired
    private ApplicationContext applicationContext;
    public OperationalSupportSystem retriveOSS(Object request) {
        OperationalSupportSystem operationalSupportSystem = null;
        switch(ABV){
            case ABV:
                operationalSupportSystem = applicationContext.getBean(com.tt.adapter.ABV.class);
                break;
            case NSTV:
                operationalSupportSystem = applicationContext.getBean(com.tt.adapter.NSTV.class);
                break;
            default:
                break;
        }
        return operationalSupportSystem;
    }
}
