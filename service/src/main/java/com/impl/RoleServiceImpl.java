package com.impl;

import com.api.RoleService;
import com.entity.Role;
import com.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
