package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: GetAuthTokenListener.java */
/* JADX INFO: loaded from: classes3.dex */
class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f10321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<g> f10322b;

    public e(i iVar, TaskCompletionSource<g> taskCompletionSource) {
        this.f10321a = iVar;
        this.f10322b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.h
    public boolean a(Exception exc) {
        this.f10322b.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.h
    public boolean b(z5.d dVar) {
        if (!dVar.k() || this.f10321a.f(dVar)) {
            return false;
        }
        this.f10322b.setResult(g.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}
