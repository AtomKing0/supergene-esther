package com.king.store;

import androidx.annotation.Keep;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BillingQueue extends ThreadPoolExecutor {
    public BillingQueue() {
        super(1, 1, 180L, TimeUnit.SECONDS, new PriorityBlockingQueue(10));
    }
}
