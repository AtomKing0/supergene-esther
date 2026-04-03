package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SharedPreferencesQueue.java */
/* JADX INFO: loaded from: classes3.dex */
final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f10491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10493c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f10495e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("internalQueue")
    @VisibleForTesting
    final ArrayDeque<String> f10494d = new ArrayDeque<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("internalQueue")
    private boolean f10496f = false;

    private y0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f10491a = sharedPreferences;
        this.f10492b = str;
        this.f10493c = str2;
        this.f10495e = executor;
    }

    @GuardedBy("internalQueue")
    private boolean c(boolean z10) {
        if (z10 && !this.f10496f) {
            j();
        }
        return z10;
    }

    @WorkerThread
    static y0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        y0 y0Var = new y0(sharedPreferences, str, str2, executor);
        y0Var.e();
        return y0Var;
    }

    @WorkerThread
    private void e() {
        synchronized (this.f10494d) {
            this.f10494d.clear();
            String string = this.f10491a.getString(this.f10492b, "");
            if (!TextUtils.isEmpty(string) && string.contains(this.f10493c)) {
                String[] strArrSplit = string.split(this.f10493c, -1);
                if (strArrSplit.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f10494d.add(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void i() {
        synchronized (this.f10494d) {
            this.f10491a.edit().putString(this.f10492b, h()).commit();
        }
    }

    private void j() {
        this.f10495e.execute(new Runnable() { // from class: com.google.firebase.messaging.x0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10488a.i();
            }
        });
    }

    public boolean b(@NonNull String str) {
        boolean zC;
        if (TextUtils.isEmpty(str) || str.contains(this.f10493c)) {
            return false;
        }
        synchronized (this.f10494d) {
            zC = c(this.f10494d.add(str));
        }
        return zC;
    }

    @Nullable
    public String f() {
        String strPeek;
        synchronized (this.f10494d) {
            strPeek = this.f10494d.peek();
        }
        return strPeek;
    }

    public boolean g(@Nullable Object obj) {
        boolean zC;
        synchronized (this.f10494d) {
            zC = c(this.f10494d.remove(obj));
        }
        return zC;
    }

    @NonNull
    @GuardedBy("internalQueue")
    public String h() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f10494d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(this.f10493c);
        }
        return sb.toString();
    }
}
