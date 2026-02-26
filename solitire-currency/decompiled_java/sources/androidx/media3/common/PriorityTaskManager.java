package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.ironsource.v8;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class PriorityTaskManager {
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    private int highestPriority = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i10, int i11) {
            super("Priority too low [priority=" + i10 + ", highest=" + i11 + v8.i.f15839e);
        }
    }

    public void add(int i10) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i10));
            this.highestPriority = Math.max(this.highestPriority, i10);
        }
    }

    public void proceed(int i10) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i10) {
                this.lock.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int i10) {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.highestPriority == i10;
        }
        return z10;
    }

    public void proceedOrThrow(int i10) throws PriorityTooLowException {
        synchronized (this.lock) {
            if (this.highestPriority != i10) {
                throw new PriorityTooLowException(i10, this.highestPriority);
            }
        }
    }

    public void remove(int i10) {
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i10));
            this.highestPriority = this.queue.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.castNonNull(this.queue.peek())).intValue();
            this.lock.notifyAll();
        }
    }
}
