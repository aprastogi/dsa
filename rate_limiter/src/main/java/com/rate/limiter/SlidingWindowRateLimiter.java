package com.rate.limiter;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowRateLimiter implements RateLimitStrategy{

    private final int limit; // Maximum number of requests allowed within the time window
    private final int windowSeconds; // Duration of the time window in seconds
    private final Queue<Instant> requestQueue; // Queue to store request timestamps

    public SlidingWindowRateLimiter(int limit, int windowSeconds) {
        this.limit = limit;
        this.windowSeconds = windowSeconds;
        this.requestQueue = new ArrayDeque<>();
    }

    @Override
    public boolean grantAccess() {
        clearExpiredRequests(); // Clear expired requests from the queue

        if (requestQueue.size() < limit) {
            requestQueue.offer(Instant.now()); // Add current request timestamp to the queue
            return true; // Request is allowed
        } else {
            return false; // Request is not allowed
        }
    }

    private void clearExpiredRequests() {
        Instant now = Instant.now();
        Instant windowStart = now.minusSeconds(windowSeconds);

        while (!requestQueue.isEmpty() && requestQueue.peek().isBefore(windowStart)) {
            requestQueue.poll(); // Remove expired requests from the queue
        }
    }
}
