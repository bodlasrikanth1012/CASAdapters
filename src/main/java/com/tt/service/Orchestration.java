package com.tt.service;

public interface Orchestration {
    Object orchestrate(Object request, String operationType);
}
