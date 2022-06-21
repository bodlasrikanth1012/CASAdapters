package com.tt.service;

import com.tt.adapter.OperationalSupportSystem;
import com.tt.util.CASHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import static com.tt.util.Constants.CREATE;
import static com.tt.util.Constants.UPDATE;

@Service
public class OrchestrationImpl implements Orchestration{

    @Autowired
    private CASHelper casHelper;

    @Override
    public Object orchestrate(Object request, String operationType) {
        OperationalSupportSystem operationalSupportSystem = casHelper.retriveOSS(request);
        return ReflectionUtils.invokeMethod((ReflectionUtils.findMethod(OperationalSupportSystem.class,
                MethodMapping.valueOf(operationType).getOperation(),null)),
                operationalSupportSystem,request);
    }

    private enum MethodMapping{
        POST(CREATE),
        PATCH(UPDATE);
        private final String operation;

        MethodMapping(String operation){
            this.operation = operation;
        }
        public String getOperation(){
            return operation;
        }
    }
}
