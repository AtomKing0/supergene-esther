package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: TopicsSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
class e1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f10396i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f10398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0 f10399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FirebaseMessaging f10400d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f10402f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c1 f10404h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("pendingOperations")
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f10401e = new ArrayMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f10403g = false;

    private e1(FirebaseMessaging firebaseMessaging, j0 j0Var, c1 c1Var, e0 e0Var, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f10400d = firebaseMessaging;
        this.f10398b = j0Var;
        this.f10404h = c1Var;
        this.f10399c = e0Var;
        this.f10397a = context;
        this.f10402f = scheduledExecutorService;
    }

    private void b(b1 b1Var, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.f10401e) {
            String strE = b1Var.e();
            if (this.f10401e.containsKey(strE)) {
                arrayDeque = this.f10401e.get(strE);
            } else {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                this.f10401e.put(strE, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    @WorkerThread
    private static <T> void c(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            e = e10;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e11);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e12) {
            e = e12;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    @WorkerThread
    private void d(String str) throws IOException {
        c(this.f10399c.l(this.f10400d.blockingGetToken(), str));
    }

    @WorkerThread
    private void e(String str) throws IOException {
        c(this.f10399c.m(this.f10400d.blockingGetToken(), str));
    }

    @VisibleForTesting
    static Task<e1> f(final FirebaseMessaging firebaseMessaging, final j0 j0Var, final e0 e0Var, final Context context, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.d1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e1.j(context, scheduledExecutorService, firebaseMessaging, j0Var, e0Var);
            }
        });
    }

    static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e1 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, j0 j0Var, e0 e0Var) throws Exception {
        return new e1(firebaseMessaging, j0Var, c1.b(context, scheduledExecutorService), e0Var, context, scheduledExecutorService);
    }

    private void k(b1 b1Var) {
        synchronized (this.f10401e) {
            String strE = b1Var.e();
            if (this.f10401e.containsKey(strE)) {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f10401e.get(strE);
                TaskCompletionSource<Void> taskCompletionSourcePoll = arrayDeque.poll();
                if (taskCompletionSourcePoll != null) {
                    taskCompletionSourcePoll.setResult(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.f10401e.remove(strE);
                }
            }
        }
    }

    private void p() {
        if (i()) {
            return;
        }
        t(0L);
    }

    boolean g() {
        return this.f10404h.c() != null;
    }

    synchronized boolean i() {
        return this.f10403g;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean l(com.google.firebase.messaging.b1 r7) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.e1.l(com.google.firebase.messaging.b1):boolean");
    }

    void m(Runnable runnable, long j10) {
        this.f10402f.schedule(runnable, j10, TimeUnit.SECONDS);
    }

    @VisibleForTesting
    Task<Void> n(b1 b1Var) {
        this.f10404h.a(b1Var);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        b(b1Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    synchronized void o(boolean z10) {
        this.f10403g = z10;
    }

    void q() {
        if (g()) {
            p();
        }
    }

    Task<Void> r(String str) {
        Task<Void> taskN = n(b1.f(str));
        q();
        return taskN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (h() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        return true;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean s() throws java.io.IOException {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            com.google.firebase.messaging.c1 r0 = r2.f10404h     // Catch: java.lang.Throwable -> L2b
            com.google.firebase.messaging.b1 r0 = r0.c()     // Catch: java.lang.Throwable -> L2b
            if (r0 != 0) goto L19
            boolean r0 = h()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L16
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L2b
        L16:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            r0 = 1
            return r0
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r1 = r2.l(r0)
            if (r1 != 0) goto L22
            r0 = 0
            return r0
        L22:
            com.google.firebase.messaging.c1 r1 = r2.f10404h
            r1.e(r0)
            r2.k(r0)
            goto L0
        L2b:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.e1.s():boolean");
    }

    void t(long j10) {
        m(new f1(this, this.f10397a, this.f10398b, Math.min(Math.max(30L, 2 * j10), f10396i)), j10);
        o(true);
    }

    Task<Void> u(String str) {
        Task<Void> taskN = n(b1.g(str));
        q();
        return taskN;
    }
}
