package io.javabrains.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.repository.BaseEventsRepository;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient.Builder webClientBuilder;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	BaseEventsRepository repository;
	Logger logger = LoggerFactory.getLogger(CatalogResource.class);

	@RequestMapping("/{userId}")
	//public List<EvtBaseEventsMaster> getCatalog(@PathVariable("userId") String userId) {
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		/*
		 * UserRating userRating =
		 * restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" +
		 * userId, UserRating.class);
		 * 
		 * return userRating.getRatings().stream() .map(rating -> { Movie movie =
		 * restTemplate.getForObject("http://movie-info-service/movies/" +
		 * rating.getMovieId(), Movie.class); return new CatalogItem(movie.getName(),
		 * movie.getDescription(), rating.getRating()); })
		 * .collect(Collectors.toList());
		 */
		
		List<String>  services=discoveryClient.getServices();
		UserRating userRating= restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
		
		//With RestTemplate
		return userRating.getRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
		

		//With WebClient
		/*return ratings.stream().map(rating -> {
			Movie movie =webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovieId())
					.retrieve()
					.bodyToMono( Movie.class)
					.block();
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
		 */
		
		//List<EvtBaseEventsMaster> baseEvents = repository.findAll();
		// return baseEvents;
	}
}

/*
 * Alternative WebClient way Movie movie =
 * webClientBuilder.build().get().uri("http://localhost:8082/movies/"+
 * rating.getMovieId()) .retrieve().bodyToMono(Movie.class).block();
 */