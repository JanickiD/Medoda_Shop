<<<<<<< HEAD
package pl.pwn.reaktor.medoda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.pwn.reaktor.medoda.model.Role;
import pl.pwn.reaktor.medoda.model.User;
import pl.pwn.reaktor.medoda.repository.RoleRepository;
import pl.pwn.reaktor.medoda.repository.UserRepository;
import pl.pwn.reaktor.medoda.model.UserFilter;


@Service
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private RoleRepository roleRepository;
	private EntityManager entityManager;
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleRepository = roleRepository;
	}
	
	public User addUserWithRoleUser(User user) {

		user.setActive(true);

		Role role = getUserRole();

		user.setRole(role);
		user.setPass(bCryptPasswordEncoder.encode(user.getPass()));

		return userRepository.save(user);
	}
	
	private Role getUserRole() {
		Role role = roleRepository.findByRole("User");
		if (Objects.isNull(role)) {
			role = roleRepository.save(new Role("User"));
		}
		return role;
	}
	
	public User changePass(User user) {
		User userById = getUserById(user.getId());
		userById.setPass(bCryptPasswordEncoder.encode(user.getPass()));
		return userRepository.save(userById);
	}
	
	public User getUserById(long id) {
		return userRepository.findOne(id);
	}
	
	public User editUser(User user) {
		User userById = getUserById(user.getId());
		user.setPass(userById.getPass());
		return userRepository.save(user);
	}

	public void delete(long id) {
		userRepository.delete(id);
	}
	
	public Page<User> getByFilter(UserFilter userFilter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
		Root<User> user = query.from(User.class);
		List<Predicate> criteria = new ArrayList<Predicate>();

		Optional.ofNullable(userFilter.getName()).filter(name -> !name.isEmpty())
				.ifPresent(name -> criteria.add(criteriaBuilder.like(user.get("name"), "%"+name+"%")));

		if (userFilter.getLastName() != null && !userFilter.getLastName().isEmpty()) {
			criteria.add(criteriaBuilder.like(user.get("lastName"), "%"+userFilter.getLastName()+"%"));
		}
		if (Objects.nonNull(userFilter.getMail()) && !userFilter.getMail().isEmpty()) {
			criteria.add(criteriaBuilder.like(user.get("email"), "%"+userFilter.getMail()+"%"));
		}
		CriteriaQuery<User> select = query.select(user).where(criteria.toArray(new Predicate[criteria.size()]));

		TypedQuery<User> typedQuery = entityManager.createQuery(query);
		typedQuery.setFirstResult(pageable.getPageNumber());
		typedQuery.setMaxResults(pageable.getPageSize());
		List<User> resultUsers = typedQuery.getResultList();

		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		countQuery.select(criteriaBuilder.count(countQuery.from(User.class)))
				.where(criteria.toArray(new Predicate[criteria.size()]));
		
		Long total = entityManager.createQuery(countQuery).getSingleResult();

		Page<User> page = new PageImpl<>(resultUsers, pageable, total);
		return page;
	}
	
	public Page<User> getAll(Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);
//		List<Article> articleList = articles.getContent();

//		articleList
//			.stream()
//			.map(article -> article.setContent(article
//									.getContent()
//									.substring(0, article.getContent().length()>=100 ? 100:article.getContent().length()));

//		for (Article article : articleList){
//			article.setContent(article
//					.getContent()
//					.substring(0, article.getContent().length()>=100 ? 100:article.getContent().length()));
//		}
		return users;
	}
	

}
=======
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
>>>>>>> 9f4fa9eeb3b79b7035b69f16926919e5e5bd6fec
