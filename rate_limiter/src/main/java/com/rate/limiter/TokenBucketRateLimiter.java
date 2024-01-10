package com.rate.limiter;

import java.time.Instant;

public class TokenBucketRateLimiter implements RateLimitStrategy{

    private final int capacity; // Maximum number of tokens the bucket can hold
    private final int refillRate; // Tokens to be added per second
    private int tokens; // Current number of tokens in the bucket
    private Instant lastRefillTime; // Last time the bucket was refilled

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity; // Initially, the bucket is full
        this.lastRefillTime = Instant.now(); // Initialize with current time
    }

    @Override
    public boolean grantAccess() {
        refillTokens(); // Refill the bucket with tokens
        if (tokens > 0) {
            tokens--; // Consume a token
            return true; // Request is allowed
        } else {
            return false; // Request is not allowed
        }
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long timeElapsed = now.getEpochSecond() - lastRefillTime.getEpochSecond();
        int tokensToAdd = (int) (timeElapsed * refillRate);
        // Calculate tokens to add based on refill rate
        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd);
            // Refill the bucket up to its capacity
            lastRefillTime = now; // Update the last refill time
        }
    }
}
