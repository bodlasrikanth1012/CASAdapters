package com.tt.adapter;

import org.springframework.stereotype.Service;

import static com.tt.util.Constants.*;


@Service(ABV)
public class ABV implements OperationalSupportSystem {
    @Override
    public Object create(Object request) {
        return "Its ABV-CREATE";
    }

    @Override
    public Object update(Object request) {
    	return "Its ABV-UPDATE";
    }
}
