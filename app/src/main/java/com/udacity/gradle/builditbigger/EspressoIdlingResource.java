package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingResource;

/**
 * Created by Francesco on 13/05/2018.
 */

public class EspressoIdlingResource {

    private static final String RESOURCE = "MAIN";

    public static GetJokeIdlingResource mCountingIdlingResource =
            new GetJokeIdlingResource(RESOURCE);

    public static void increment(){
        mCountingIdlingResource.increment();
    }

    public static void decrement(){
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource(){
        return mCountingIdlingResource;
    }
}
