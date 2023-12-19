package mate.academy.service;

import lombok.RequiredArgsConstructor;
import mate.academy.model.Role;
import mate.academy.repository.role.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.findRoleByRoleName(Role.RoleName.valueOf(roleName));
    }
}
