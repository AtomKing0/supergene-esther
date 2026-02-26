package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class bx {
    public static /* synthetic */ void a(jt jtVar, Runnable runnable, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postReleaseTask");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        jtVar.a(runnable, j10);
    }
}
