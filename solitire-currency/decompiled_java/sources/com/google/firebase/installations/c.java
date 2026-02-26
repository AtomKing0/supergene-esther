package com.google.firebase.installations;

import a6.d;
import a6.f;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.d;
import io.sentry.protocol.SentryStackFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import l5.x;

/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements x5.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f10299m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ThreadFactory f10300n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i5.e f10301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a6.c f10302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z5.c f10303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f10304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<z5.b> f10305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x5.g f10306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f10307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ExecutorService f10308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f10309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("this")
    private String f10310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("FirebaseInstallations.this")
    private Set<y5.a> f10311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final List<h> f10312l;

    /* JADX INFO: compiled from: FirebaseInstallations.java */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f10313a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f10313a.getAndIncrement())));
        }
    }

    /* JADX INFO: compiled from: FirebaseInstallations.java */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f10315b;

        static {
            int[] iArr = new int[f.b.values().length];
            f10315b = iArr;
            try {
                iArr[f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10315b[f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10315b[f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f10314a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10314a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    c(final i5.e eVar, @NonNull w5.b<u5.i> bVar, @NonNull ExecutorService executorService, @NonNull Executor executor) {
        this(executorService, executor, eVar, new a6.c(eVar.j(), bVar), new z5.c(eVar), i.c(), new x(new w5.b() { // from class: x5.c
            @Override // w5.b
            public final Object get() {
                return com.google.firebase.installations.c.y(eVar);
            }
        }), new x5.g());
    }

    private String A(z5.d dVar) {
        if ((!this.f10301a.l().equals("CHIME_ANDROID_SDK") && !this.f10301a.t()) || !dVar.m()) {
            return this.f10306f.a();
        }
        String strF = o().f();
        return TextUtils.isEmpty(strF) ? this.f10306f.a() : strF;
    }

    private z5.d B(z5.d dVar) throws d {
        a6.d dVarD = this.f10302b.d(l(), dVar.d(), t(), m(), (dVar.d() == null || dVar.d().length() != 11) ? null : o().i());
        int i10 = b.f10314a[dVarD.e().ordinal()];
        if (i10 == 1) {
            return dVar.s(dVarD.c(), dVarD.d(), this.f10304d.b(), dVarD.b().c(), dVarD.b().d());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
    }

    private void C(Exception exc) {
        synchronized (this.f10307g) {
            Iterator<h> it = this.f10312l.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void D(z5.d dVar) {
        synchronized (this.f10307g) {
            Iterator<h> it = this.f10312l.iterator();
            while (it.hasNext()) {
                if (it.next().b(dVar)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void E(String str) {
        this.f10310j = str;
    }

    private synchronized void F(z5.d dVar, z5.d dVar2) {
        if (this.f10311k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator<y5.a> it = this.f10311k.iterator();
            while (it.hasNext()) {
                it.next().a(dVar2.d());
            }
        }
    }

    private Task<g> f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new e(this.f10304d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task<String> g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new f(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private void h(h hVar) {
        synchronized (this.f10307g) {
            this.f10312l.add(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void v(boolean z10) {
        z5.d dVarB;
        z5.d dVarR = r();
        try {
            if (dVarR.i() || dVarR.l()) {
                dVarB = B(dVarR);
            } else {
                if (!z10 && !this.f10304d.f(dVarR)) {
                    return;
                }
                dVarB = k(dVarR);
            }
            u(dVarB);
            F(dVarR, dVarB);
            if (dVarB.k()) {
                E(dVarB.d());
            }
            if (dVarB.i()) {
                C(new d(d.a.BAD_CONFIG));
            } else if (dVarB.j()) {
                C(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                D(dVarB);
            }
        } catch (d e10) {
            C(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void x(final boolean z10) {
        z5.d dVarS = s();
        if (z10) {
            dVarS = dVarS.p();
        }
        D(dVarS);
        this.f10309i.execute(new Runnable() { // from class: x5.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f36211a.v(z10);
            }
        });
    }

    private z5.d k(@NonNull z5.d dVar) throws d {
        a6.f fVarE = this.f10302b.e(l(), dVar.d(), t(), dVar.f());
        int i10 = b.f10315b[fVarE.b().ordinal()];
        if (i10 == 1) {
            return dVar.o(fVarE.c(), fVarE.d(), this.f10304d.b());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i10 != 3) {
            throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
        E(null);
        return dVar.r();
    }

    private synchronized String n() {
        return this.f10310j;
    }

    private z5.b o() {
        return this.f10305e.get();
    }

    @NonNull
    public static c p() {
        return q(i5.e.k());
    }

    @NonNull
    public static c q(@NonNull i5.e eVar) {
        Preconditions.checkArgument(eVar != null, "Null is not a valid value of FirebaseApp.");
        return (c) eVar.i(x5.e.class);
    }

    private z5.d r() {
        z5.d dVarD;
        synchronized (f10299m) {
            com.google.firebase.installations.b bVarA = com.google.firebase.installations.b.a(this.f10301a.j(), "generatefid.lock");
            try {
                dVarD = this.f10303c.d();
            } finally {
                if (bVarA != null) {
                    bVarA.b();
                }
            }
        }
        return dVarD;
    }

    private z5.d s() {
        z5.d dVarD;
        synchronized (f10299m) {
            com.google.firebase.installations.b bVarA = com.google.firebase.installations.b.a(this.f10301a.j(), "generatefid.lock");
            try {
                dVarD = this.f10303c.d();
                if (dVarD.j()) {
                    dVarD = this.f10303c.b(dVarD.t(A(dVarD)));
                }
            } finally {
                if (bVarA != null) {
                    bVarA.b();
                }
            }
        }
        return dVarD;
    }

    private void u(z5.d dVar) {
        synchronized (f10299m) {
            com.google.firebase.installations.b bVarA = com.google.firebase.installations.b.a(this.f10301a.j(), "generatefid.lock");
            try {
                this.f10303c.b(dVar);
            } finally {
                if (bVarA != null) {
                    bVarA.b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        x(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ z5.b y(i5.e eVar) {
        return new z5.b(eVar);
    }

    private void z() {
        Preconditions.checkNotEmpty(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(i.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(i.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @Override // x5.e
    @NonNull
    public Task<g> a(final boolean z10) {
        z();
        Task<g> taskF = f();
        this.f10308h.execute(new Runnable() { // from class: x5.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f36207a.x(z10);
            }
        });
        return taskF;
    }

    @Override // x5.e
    @NonNull
    public Task<String> getId() {
        z();
        String strN = n();
        if (strN != null) {
            return Tasks.forResult(strN);
        }
        Task<String> taskG = g();
        this.f10308h.execute(new Runnable() { // from class: x5.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f36209a.w();
            }
        });
        return taskG;
    }

    @Nullable
    String l() {
        return this.f10301a.m().b();
    }

    @VisibleForTesting
    String m() {
        return this.f10301a.m().c();
    }

    @Nullable
    String t() {
        return this.f10301a.m().e();
    }

    @SuppressLint({"ThreadPoolCreation"})
    c(ExecutorService executorService, Executor executor, i5.e eVar, a6.c cVar, z5.c cVar2, i iVar, x<z5.b> xVar, x5.g gVar) {
        this.f10307g = new Object();
        this.f10311k = new HashSet();
        this.f10312l = new ArrayList();
        this.f10301a = eVar;
        this.f10302b = cVar;
        this.f10303c = cVar2;
        this.f10304d = iVar;
        this.f10305e = xVar;
        this.f10306f = gVar;
        this.f10308h = executorService;
        this.f10309i = executor;
    }
}
