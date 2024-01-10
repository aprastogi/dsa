package com.rate.limiter;

public interface RateLimitStrategy {

    boolean grantAccess();
}
