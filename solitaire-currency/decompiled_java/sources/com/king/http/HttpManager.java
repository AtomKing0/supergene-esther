package com.king.http;

import androidx.annotation.Keep;
import com.king.http.HttpHeaders;
import com.king.http.HttpTask;
import com.king.usdk.logger.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class HttpManager implements HttpTask.Listener {
    private final ExecutorService mExecutorService;
    private long mHttpState;
    private final Logger mLogger;
    private final Map<Long, Future<?>> mFutureMap = new ConcurrentHashMap();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final String mClassName = "[com.king.http.HttpManager] ";

    public HttpManager(long j10, long j11, int i10, boolean z10) {
        this.mHttpState = j10;
        this.mLogger = new Logger(j11, z10);
        this.mExecutorService = i10 == 0 ? Executors.newCachedThreadPool() : Executors.newFixedThreadPool(i10);
    }

    private native void on_data(long j10, long j11, byte[] bArr, int i10);

    private native void on_response(long j10, long j11, int i10, int i11, int i12, HttpHeaders.Header[] headerArr, int i13, String str, int i14, int i15);

    public void addHeader(HttpHeaders httpHeaders, String str, String str2) {
        httpHeaders.add(str, str2);
    }

    public void cancelTask(long j10) {
        this.mLogger.i("[com.king.http.HttpManager] : Cancelling task with requestId: " + j10);
        Future<?> futureRemove = this.mFutureMap.remove(Long.valueOf(j10));
        if (futureRemove == null) {
            this.mLogger.i("[com.king.http.HttpManager] : Cancelling task failed because future does not exist.");
        } else {
            futureRemove.cancel(true);
        }
    }

    public HttpHeaders createHeaders() {
        return new HttpHeaders();
    }

    public HttpTask createTask(long j10, int i10, String str, int i11, boolean z10, HttpHeaders httpHeaders, byte[] bArr) {
        this.mLogger.i("[com.king.http.HttpManager] : I'm creating the task!");
        try {
            return new HttpTask(this.mLogger, j10, this, i10, str, i11, z10, httpHeaders, bArr);
        } catch (Exception e10) {
            this.mLogger.e("[com.king.http.HttpManager] " + e10.toString());
            return null;
        }
    }

    public void executeTask(HttpTask httpTask) {
        this.mFutureMap.put(Long.valueOf(httpTask.getRequestId()), this.mExecutorService.submit(httpTask));
    }

    public void handleCompletedTask(long j10) {
        this.mFutureMap.remove(Long.valueOf(j10));
    }

    @Override // com.king.http.HttpTask.Listener
    public void onData(long j10, byte[] bArr, int i10) {
        this.lock.readLock().lock();
        try {
            long j11 = this.mHttpState;
            if (j11 != 0) {
                on_data(j11, j10, bArr, i10);
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // com.king.http.HttpTask.Listener
    public void onResponse(long j10, int i10, int i11, int i12, HttpHeaders.Header[] headerArr, int i13, String str, int i14, int i15) {
        this.lock.readLock().lock();
        try {
            long j11 = this.mHttpState;
            if (j11 != 0) {
                on_response(j11, j10, i10, i11, i12, headerArr, i13, str, i14, i15);
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void shutDown() {
        this.mLogger.i("[com.king.http.HttpManager] : Shutting down executor service");
        this.mExecutorService.shutdownNow();
        this.lock.writeLock().lock();
        try {
            this.mLogger.i("[com.king.http.HttpManager] : The HttpState is being invalidated. Value set to 0 (zero)");
            this.mHttpState = 0L;
            this.lock.writeLock().unlock();
            this.mLogger.shutdown();
            this.mFutureMap.clear();
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            throw th;
        }
    }
}
