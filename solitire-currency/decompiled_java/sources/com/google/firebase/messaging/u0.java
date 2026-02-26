package com.google.firebase.messaging;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestDeduplicator.java */
/* JADX INFO: loaded from: classes3.dex */
class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f10475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<String, Task<String>> f10476b = new ArrayMap();

    /* JADX INFO: compiled from: RequestDeduplicator.java */
    interface a {
        Task<String> start();
    }

    u0(Executor executor) {
        this.f10475a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task c(String str, Task task) throws Exception {
        synchronized (this) {
            this.f10476b.remove(str);
        }
        return task;
    }

    /* JADX WARN: Multi-variable type inference failed */
    synchronized Task<String> b(final String str, a aVar) {
        Task<String> task = this.f10476b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Making new request for: " + str);
        }
        Task taskContinueWithTask = aVar.start().continueWithTask(this.f10475a, new Continuation() { // from class: com.google.firebase.messaging.t0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f10472a.c(str, task2);
            }
        });
        this.f10476b.put(str, taskContinueWithTask);
        return taskContinueWithTask;
    }
}
