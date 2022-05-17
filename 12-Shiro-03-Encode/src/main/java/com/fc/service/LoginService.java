package com.fc.service;

import java.util.Map;

public interface LoginService {
    Map<String, String> getPasswordByUsername(String username);
}
