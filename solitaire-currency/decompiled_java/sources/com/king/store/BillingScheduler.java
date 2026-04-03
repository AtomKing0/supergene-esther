package com.king.store;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BillingScheduler {
    public static c mCurrentState = c.NOT_SETUP;
    private static AtomicLong sequenceCounter = new AtomicLong();
    private Runnable mCancelCallback;
    private c mNewBillingState;
    private Queue<Runnable> taskQueue = new ConcurrentLinkedQueue();
    private boolean mDebugLog = false;
    private String mDebugTag = BillingScheduler.class.toString();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            if ((BillingScheduler.this.mNewBillingState == c.DISCONNECTED || BillingScheduler.this.mNewBillingState == c.DISPOSED) && BillingScheduler.this.getCurrentState() == c.NOT_SETUP) {
                BillingScheduler.this.logDebug("Trying to disconnect or dispose on a resource not setup. Will ignore.");
                z10 = true;
            } else {
                z10 = false;
            }
            if (BillingScheduler.this.mNewBillingState == BillingScheduler.this.getCurrentState()) {
                BillingScheduler.this.logDebug("Trying to change to same state, will ignore.");
                z10 = true;
            }
            if (BillingScheduler.this.mNewBillingState != null && BillingScheduler.this.getCurrentState() == c.DISPOSED) {
                BillingScheduler.this.logDebug("Trying to change state when resource disposed, will ignore.");
                z10 = true;
            }
            if (BillingScheduler.this.mNewBillingState != c.CONNECTED && BillingScheduler.this.getCurrentState() == c.NOT_SETUP) {
                BillingScheduler.this.logDebug("Trying to change state when resource not setup, will ignore.");
                z10 = true;
            }
            if (z10) {
                if (BillingScheduler.this.mCancelCallback != null) {
                    BillingScheduler.this.mCancelCallback.run();
                    return;
                }
                return;
            }
            Iterator it = BillingScheduler.this.taskQueue.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            if (BillingScheduler.this.mNewBillingState != null) {
                BillingScheduler billingScheduler = BillingScheduler.this;
                billingScheduler.setCurrentState(billingScheduler.mNewBillingState);
            }
        }
    }

    public class b extends FutureTask<b> implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f17135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f17136b;

        public b(d dVar, Runnable runnable) {
            super(runnable, null);
            this.f17135a = dVar;
            this.f17136b = BillingScheduler.sequenceCounter.getAndIncrement();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iC = this.f17135a.c() - bVar.d();
            return iC != 0 ? iC : (int) (this.f17136b - bVar.c());
        }

        public long c() {
            return this.f17136b;
        }

        public int d() {
            return this.f17135a.c();
        }
    }

    public enum c {
        CONNECTED,
        DISCONNECTED,
        DISPOSED,
        PURCHASE_ONGOING,
        PURCHASE_FINISHED,
        NOT_SETUP
    }

    public enum d {
        HIGH(0),
        MEDIUM(1),
        LOW(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17149a;

        d(int i10) {
            this.f17149a = i10;
        }

        int c() {
            return this.f17149a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logDebug(String str) {
        if (this.mDebugLog) {
            Log.d(this.mDebugTag, str);
        }
    }

    private void logError(String str) {
        Log.e(this.mDebugTag, "In-app billing error: " + str);
    }

    public void addAction(Runnable runnable) {
        this.taskQueue.add(runnable);
    }

    public void addCancelListener(Runnable runnable) {
        this.mCancelCallback = runnable;
    }

    public void enableDebugLogging(boolean z10) {
        this.mDebugLog = z10;
    }

    public c getCurrentState() {
        return mCurrentState;
    }

    public void setCurrentState(c cVar) {
        mCurrentState = cVar;
    }

    public boolean submit(BillingQueue billingQueue) {
        if (billingQueue.isShutdown()) {
            logError("The executor is shutdown, will ignore this execute request.");
            return false;
        }
        if (this.taskQueue.isEmpty()) {
            logError("Task queue is empty, will ignore this execute request.");
            return false;
        }
        c cVar = this.mNewBillingState;
        billingQueue.execute(new b(cVar != null ? d.HIGH : (cVar == null || cVar != c.PURCHASE_FINISHED) ? d.LOW : d.MEDIUM, new a()));
        return true;
    }

    public void willChangeStateTo(c cVar) {
        this.mNewBillingState = cVar;
    }
}
