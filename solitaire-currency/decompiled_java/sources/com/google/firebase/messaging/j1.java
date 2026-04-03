package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.m1;

/* JADX INFO: compiled from: WithinAppServiceBinder.java */
/* JADX INFO: loaded from: classes3.dex */
class j1 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10441a;

    /* JADX INFO: compiled from: WithinAppServiceBinder.java */
    interface a {
        Task<Void> a(Intent intent);
    }

    j1(a aVar) {
        this.f10441a = aVar;
    }

    void c(final m1.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.f10441a.a(aVar.f10456a).addOnCompleteListener(new androidx.media3.exoplayer.dash.offline.a(), new OnCompleteListener() { // from class: com.google.firebase.messaging.i1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                aVar.d();
            }
        });
    }
}
