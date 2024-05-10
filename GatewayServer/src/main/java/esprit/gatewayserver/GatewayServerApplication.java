package esprit.gatewayserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@EnableConfigurationProperties
@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	//Static route configuration
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder){
      return  routeLocatorBuilder.routes()
			  .route(r -> r.path("/produit/**").uri("http://localhost:9090/"))
			  .route(r -> r.path("/stock").uri("http://localhost:8089/"))
			  .build();
	}

	//Dynamic Route configuration
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator (ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties){
		return  new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	}

}





