package com.cos.blog.test;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path = "/dummy/join")
	public String joinUser(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 성공";
	}
	
	@GetMapping(path = "/dummy/user/{id}")
	public User getUser(@PathVariable(name = "id") int id) {
		//반듯이 있는경우 :: User user = userRepository.findById(id).get(); 
		//반대의경우 :: Optional<User> user = userRepository.findById(id);		
		//return이 User타입이 아닌이유?
		//findById(id)를 하여 회원을 찾지 못하면 null을 리턴하는데 그러면 문제가 있으니까
		//Optional로 감싸서 리턴할테니까 null체크 해라

		User user = userRepository.findById(id).orElseGet(() -> {
			return new User();
		});
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				// TODO Auto-generated method stub
//				return new User();
//			}			
//		});

//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//					// TODO Auto-generated method stub
//					return new IllegalArgumentException("해당유저가 없습니다.");
//				}
//			});
		
		//예전에는 Gson같은걸로 바꿔서 Json으로 return했는데
		//스프링부트는 MessageConvertor가 필요시 jackson을 호출해서 json으로 변경 후 return
		return user;		
	}
	
	@GetMapping(path = "/dummy/users")
	public List<User> getUsetList(){
		List<User> user = userRepository.findAll();
		return user;
	}
	
	///dummy/user/page?page=0
	@GetMapping(path = "/dummy/user/page")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> userPages = userRepository.findAll(pageable);
		
		List<User> user = userPages.getContent();
		return user;
	}
	
	@Transactional //더티체킹(수정하지않아도 update가 됨)
	@PutMapping(path = "/dummy/user/{id}")
	public User updateUser(@PathVariable(name = "id") int id, @RequestBody User reqUser) {
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저가 없습니다.");
		});
		
		user.setEmail(reqUser.getEmail());
//		User updateUser = userRepository.save(user);
		
		//더티체킹 @Transactional을 붙이면 함수종료시 자동 영속성 컨텍스트에있는 것을 flush하여 commit
		return user;		
	}
	
	
	@DeleteMapping(path = "/dummy/user/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		try {
			userRepository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return "해당 사용자 없음11";
		}
		
		return "삭제완료";
	}
}
