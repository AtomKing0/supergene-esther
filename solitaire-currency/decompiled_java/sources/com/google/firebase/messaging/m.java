package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import io.sentry.protocol.SentryStackFrame;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: FcmBroadcastProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f10446c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private static m1 f10447d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f10449b = new androidx.media3.exoplayer.dash.offline.a();

    public m(Context context) {
        this.f10448a = context;
    }

    private static Task<Integer> e(Context context, Intent intent, boolean z10) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        m1 m1VarF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z10) {
            return m1VarF.c(intent).continueWith(new androidx.media3.exoplayer.dash.offline.a(), new Continuation() { // from class: com.google.firebase.messaging.l
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return m.g(task);
                }
            });
        }
        if (w0.b().e(context)) {
            h1.f(context, m1VarF, intent);
        } else {
            m1VarF.c(intent);
        }
        return Tasks.forResult(-1);
    }

    private static m1 f(Context context, String str) {
        m1 m1Var;
        synchronized (f10446c) {
            if (f10447d == null) {
                f10447d = new m1(context, str);
            }
            m1Var = f10447d;
        }
        return m1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer g(Task task) throws Exception {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer h(Context context, Intent intent) throws Exception {
        return Integer.valueOf(w0.b().g(context, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer i(Task task) throws Exception {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task j(Context context, Intent intent, boolean z10, Task task) throws Exception {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z10).continueWith(new androidx.media3.exoplayer.dash.offline.a(), new Continuation() { // from class: com.google.firebase.messaging.k
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return m.i(task2);
            }
        }) : task;
    }

    @KeepForSdk
    public Task<Integer> k(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return l(this.f10448a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> l(final Context context, final Intent intent) {
        boolean z10 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z11 = (intent.getFlags() & 268435456) != 0;
        return (!z10 || z11) ? Tasks.call(this.f10449b, new Callable() { // from class: com.google.firebase.messaging.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m.h(context, intent);
            }
        }).continueWithTask(this.f10449b, new Continuation() { // from class: com.google.firebase.messaging.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return m.j(context, intent, z11, task);
            }
        }) : e(context, intent, z11);
    }
}
