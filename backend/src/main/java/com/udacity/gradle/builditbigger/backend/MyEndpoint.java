package com.udacity.gradle.builditbigger.backend;

import com.example.jokes.MyJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "gotJokes")
    public MyBeanList gotJokes() {

        MyJokes jokes = new MyJokes();

        MyBeanList myBeanList = new MyBeanList();
        myBeanList.setData(jokes.getJokes());

        return myBeanList;

    }

    @ApiMethod(name = "gotJoke")
    public MyBean gotJoke() {
        MyJokes jokes = new MyJokes();

        MyBean response = new MyBean();

        response.setData(jokes.getJoke());

        return response;

    }


}
