package com.devglan.springboothibernatelogin;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import java.util.zip.DataFormatException;

import java.util.zip.Deflater;

import java.util.zip.Inflater;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.http.ResponseEntity.BodyBuilder;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devglan.springboothibernatelogin.*;










@RestController




public class HomeController {
	
	@Autowired
	  private UserRepository userRepository;
	@Autowired
	ImageRepository imageRepository;
	
	private BCryptPasswordEncoder bce = new BCryptPasswordEncoder();

	@GetMapping("/users")
	
	 public  Iterable<User> getAllUsers() {
	    return userRepository.findAll();
	  }

	
	
	
	@PostMapping("user/get")
	public String getUser(@RequestBody User user) {
		Iterable<User> users =  userRepository.findAll();
		
		Boolean user_not_exist = true;

		
		for(User user_:users)
		{
			if(bce.matches(user.getPassword(), user_.getPassword()) && user_.getEmail().equals(user.getEmail()))
			{
				user_not_exist=false;
				break;
			}
		}
		if(user_not_exist)
		{
			return "not found";	
		}
		else
		{
			return "User found";
		}		
		
	
	
	
}
	
	@GetMapping("get/user/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		
	Optional<User> s=userRepository.findById(id);
	
		return s;
		
	}
	
	
	@PostMapping("/uploadlocal")
	public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path path = Paths.get("C:\\Users\\1591415\\Downloads\\spring-boot-hibernate-login\\sb2.txt" + fileName);
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/files/download/")
				.path(fileName)
				.toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}
	
	
	
	
	  @PostMapping("/uploaddb")
	 public ResponseEntity<Object> uplaodImage(@RequestParam("file") MultipartFile file) throws IOException {
		 
		 
		         System.out.println("Original Image Byte Size - " + file.getBytes().length);
		 
		         User  img = new User(compressBytes(file.getBytes()));
		
		         userRepository.save(img);
		          return ResponseEntity.status(HttpStatus.OK).build();
		 
		     }
	   
	  
	  @PostMapping(value="user/create1",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
		public User setUser(@RequestPart(value="user1",required=true) @Valid User user  , @RequestParam("file") MultipartFile file)  throws Exception{
			
			user.setPassword(bce.encode(user.getPassword()));
			user.setFile(compressBytes(file.getBytes()));
			    User user_=userRepository.save(user);
			    
			    return user_;
			
			}
	  
	  
	  
			
			
	  
	  
	  
		
	  
	  
	  
	  
	
	
	  public static byte[] compressBytes(byte[] data) {

	        Deflater deflater = new Deflater();

	        deflater.setInput(data);
	        deflater.finish();

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

	        byte[] buffer = new byte[1024];

	        while (!deflater.finished()) {

	            int count = deflater.deflate(buffer);

	            outputStream.write(buffer, 0, count);

	        }

	        try {

	            outputStream.close();

	        } catch (IOException e) {

	        }

	        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

	        return outputStream.toByteArray();

	    }
	
	
	
	

}
