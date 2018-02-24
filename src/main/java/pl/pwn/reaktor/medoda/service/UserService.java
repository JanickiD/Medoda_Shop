//package pl.pwn.reaktor.medoda.service;
//
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import pl.pwn.reaktor.medoda.model.Role;
//import pl.pwn.reaktor.medoda.model.User;
//import pl.pwn.reaktor.medoda.repository.RoleRepository;
//import pl.pwn.reaktor.medoda.repository.UserRepository;
//
//
//@Service
//public class UserService {
//	
//	private UserRepository userRepository;
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
//			RoleRepository roleRepository) {
//		super();
//		this.userRepository = userRepository;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//		this.roleRepository = roleRepository;
//	}
//	
//	
//	public User addUserWithRoleUser(User user) {
//
//		user.setActive(true);
//
//		Role role = getUserRole();
//
//		user.setRole(role);
//		user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
//
//		return userRepository.save(user);
//	}
//	
//	private Role getUserRole() {
//		Role role = roleRepository.findByRole("User");
//		if (Objects.isNull(role)) {
//			role = roleRepository.save(new Role("User"));
//		}
//		return role;
//	}
//	
//
//}
