package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: GetIdListener.java */
/* JADX INFO: loaded from: classes3.dex */
class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource<String> f10323a;

    public f(TaskCompletionSource<String> taskCompletionSource) {
        this.f10323a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.h
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.h
    public boolean b(z5.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f10323a.trySetResult(dVar.d());
        return true;
    }
}
