package com.google.common.util.concurrent;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
final class s {
    static void a(Throwable th) {
        e5.o.j(th);
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
