package mate.academy.service;

import mate.academy.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
