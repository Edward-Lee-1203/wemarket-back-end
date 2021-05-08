package com.finalmobile.wemarket.service.impl;

import com.finalmobile.wemarket.models.Shipper;
import com.finalmobile.wemarket.models.User;
import com.finalmobile.wemarket.repository.ShipperRepository;
import com.finalmobile.wemarket.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    final UserRepository userRepository;

    final ShipperRepository shipperRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, ShipperRepository shipperRepository) {
        this.userRepository = userRepository;
        this.shipperRepository = shipperRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> users = userRepository.findByUsername(username);
        Optional<Shipper> shippers = shipperRepository.findByUsername(username);

        if (!shippers.isEmpty()) {
            Shipper shipper = shippers.orElseThrow(() -> new UsernameNotFoundException
                    ("Account not found with username or email " + username));
            return UserDetailsImpl.build(shipper);
        } else {
            User user = users.orElseThrow(() -> new UsernameNotFoundException
                    ("Account not found with username or email " + username));
            return UserDetailsImpl.build(user);
        }
    }
}
