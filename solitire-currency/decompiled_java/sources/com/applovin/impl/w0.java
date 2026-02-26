package com.applovin.impl;

import android.os.Handler;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f7660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f7661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f7662c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f7663d = new AtomicInteger();

    public interface b {
        void a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f7665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f7666c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            String str = this.f7664a;
            String str2 = ((c) obj).f7664a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.f7664a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f7664a + "', countdownStepMillis=" + this.f7666c + '}';
        }

        private c(String str, long j10, b bVar) {
            this.f7664a = str;
            this.f7666c = j10;
            this.f7665b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a() {
            return this.f7665b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b() {
            return this.f7666c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            return this.f7664a;
        }
    }

    public w0(Handler handler, com.applovin.impl.sdk.j jVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f7661b = handler;
        this.f7660a = jVar.I();
    }

    public void b() {
        HashSet<c> hashSet = new HashSet(this.f7662c);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7660a.a("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        }
        int iIncrementAndGet = this.f7663d.incrementAndGet();
        for (c cVar : hashSet) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7660a.a("CountdownManager", "Starting countdown: " + cVar.c() + " for generation " + iIncrementAndGet + "...");
            }
            a(cVar, iIncrementAndGet);
        }
    }

    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7660a.a("CountdownManager", "Stopping countdowns...");
        }
        this.f7663d.incrementAndGet();
        this.f7661b.removeCallbacksAndMessages(null);
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7660a.a("CountdownManager", "Removing all countdowns...");
        }
        c();
        this.f7662c.clear();
    }

    public void a(String str, long j10, b bVar) {
        if (j10 > 0) {
            if (this.f7661b != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7660a.a("CountdownManager", "Adding countdown: " + str);
                }
                this.f7662c.add(new c(str, j10, bVar));
                return;
            }
            throw new IllegalArgumentException("No handler specified.");
        }
        throw new IllegalArgumentException("Invalid step specified.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(c cVar, int i10) {
        b bVarA = cVar.a();
        if (bVarA.b()) {
            if (this.f7663d.get() == i10) {
                try {
                    bVarA.a();
                    a(cVar, i10);
                    return;
                } catch (Throwable th) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f7660a.a("CountdownManager", "Encountered error on countdown step for: " + cVar.c(), th);
                    }
                    a();
                    return;
                }
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7660a.k("CountdownManager", "Killing duplicate countdown from previous generation: " + cVar.c());
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7660a.a("CountdownManager", "Ending countdown for " + cVar.c());
        }
    }

    private void a(final c cVar, final int i10) {
        this.f7661b.postDelayed(new Runnable() { // from class: com.applovin.impl.ge
            @Override // java.lang.Runnable
            public final void run() {
                this.f5287a.b(cVar, i10);
            }
        }, cVar.b());
    }
}
