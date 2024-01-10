package com.rate.limiter;

public class RateLimiter {

    private final RateLimitStrategy rateLimitStrategy;

    public RateLimiter(RateLimitStrategy rateLimitStrategy){
        this.rateLimitStrategy = rateLimitStrategy;
    }

    public int allowRequest(){
        if(rateLimitStrategy.grantAccess()){
            return Response.OK;
        }
        return Response.TOO_MANY_REQUEST;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(new TokenBucketRateLimiter(4, 2));
        System.out.println(rateLimiter.allowRequest());
    }
}
