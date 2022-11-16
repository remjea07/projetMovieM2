package Controller;

import delegate.del;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
public class controle {
    @Autowired
    delegate.del del;

    @RequestMapping(value = "/getSchoolDetails/{movie}", method = RequestMethod.GET)
    public String getMovie(@PathVariable String movie) {
        System.out.println("Going to call student service to get data!");
        return del.callMovieServiceAndGetData(movie);
    }
}
