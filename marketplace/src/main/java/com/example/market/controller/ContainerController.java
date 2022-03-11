package com.example.market.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.repo.ContainerRepository;
import com.example.market.repo.ImageRepository;
import com.example.market.repo.UserRepository;
import com.example.market.service.ContainerService;

@Controller
@RestController
@RequestMapping("/container")
public class ContainerController {

	
	@Autowired
	private TT tt;
	private int port;

	@Autowired
	private ContainerRepository containerRepository;
	private UserRepository userRepository;
	private ImageRepository imageRepository;
	@Autowired
	private ContainerService containerService;

	/*
	 * @GetMapping("/container/{imageId}") public String one(@PathVariable String
	 * imageId) { String port = null; String[] lines = {
	 * "docker run --name demo -d -P " + imageId }; String[] lines2 = {
	 * "docker inspect --format '{{ (index (index .NetworkSettings.Ports \"80/tcp\") 0).HostPort }}' demo"
	 * };
	 * 
	 * try { tt.executeCommands(lines); port = tt.executeCommands(lines2); } catch
	 * (IOException | InterruptedException e) { e.printStackTrace(); } return
	 * String.valueOf(port); }
	 */

	@PostMapping("/parseJson/{imageId}/{userId}")
	public String parser(@RequestBody String imageId, String userId) {
		return userId;
		}
	}
 


	
	
	
		/*try {
			logger.info("container= " + container);
			JSONObject jObj = (JSONObject) parser.parse((jsonString));
			String name = jObj.get("name").toString();
			String port = jObj.get("port").toString();
			User user = jObj.get("user").toString();
			Image image = jObj.get("image").toString();

			logger.info("name= " + name + " ,port= " + port + " ,user= " + user, "image=" + image);
			return "Your container is " + name + " and port is " + port + " image is" + image + "user is" + user;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "Parse Error Try Again";
		}
	}*/



/*
 * @GetMapping("/launch/{id}") public Container getContainerById(Long id) {
 * 
 * String[] lines = { "docker run -d -P nginx" }; String[] lines2 = {
 * "docker inspect --format '{{ (index (index .NetworkSettings.Ports \"80/tcp\") 0).HostPort }}' bennani"
 * }; try { tt.executeCommands(lines); port = tt.executeCommand(lines2); } catch
 * (IOException | InterruptedException e) { e.printStackTrace(); }
 * 
 * Container container = containerRepository.findById(id).orElseThrow(() -> new
 * ContainerNotFoundException(id)); containerRepository.save(container); return
 * container;
 * 
 * // set container attributes /* Container container= new Container();
 * 
 * container.setPort(8080); Optional<User> user= userRepository.findById((long)
 * 1); container.setUser(user); Image image =
 * imageRepository.findByName("store"); container.setImage(image);
 * containerRepository.save(container); return container;
 */

/*
 * public URL parseUrl(String s) throws Exception { URL u = new URL(s); return
 * new URI( u.getProtocol(), u.getAuthority(), u.getPath(), u.getQuery(),
 * u.getRef()). toURL(); }
 */
