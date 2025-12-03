package a.syrov.api.service;

import a.syrov.api.dao.UserRepository;
import a.syrov.api.entity.sec.DotaUserPrincipal;
import a.syrov.api.entity.sec.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DotaUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public DotaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new DotaUserPrincipal(user);
    }
}
