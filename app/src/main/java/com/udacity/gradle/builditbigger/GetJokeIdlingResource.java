package com.udacity.gradle.builditbigger;

/**
 * Created by Francesco on 13/05/2018.
 */

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicInteger;

public class GetJokeIdlingResource implements IdlingResource {

    private final String mResourceName;
    private final AtomicInteger counter = new AtomicInteger(0);
    private volatile ResourceCallback mCallback;

    public GetJokeIdlingResource(String mResourceName) {
        this.mResourceName = mResourceName;
    }

    @Override
    public String getName() {
        return mResourceName;
    }

    @Override
    public boolean isIdleNow() {
        return counter.get() == 0;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.mCallback = callback;
    }

    public void increment(){
        counter.getAndIncrement();
    }

    public void decrement(){
        int counterVal = counter.decrementAndGet();
        if(counterVal == 0){
            if(null != mCallback){
                mCallback.onTransitionToIdle();
            }
        }

        if(counterVal < 0){
            throw new IllegalArgumentException("counter corrupted");
        }
    }
}
