package delegate;

import java.util.Date;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class del {
    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get Movie in the System ", response = Iterable.class, tags = "getMovieTitre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succes"),})
    @HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
    public String callMovieServiceAndGetData(String titre) {
        System.out.println("Getting Movie details for " + titre);
        String response = restTemplate
                .exchange("http://localhost:8098/getMovieTitre/{titre}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, titre).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - movie Name -  " + titre + " :::  Student Details " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    @ApiOperation(value = "Get Movie in the System ", response = Iterable.class, tags = "getMovieTitre")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "not authorized"),})
    private String callMovieServiceAndGetData_Fallback(String titre) {
        System.out.println("Student Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Movie Service at this moment. Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
