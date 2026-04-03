package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import l5.e;
import l5.e0;
import l5.h;
import l5.r;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Firebase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: Firebase.kt */
    public static final class a<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f10328a = new a<>();

        @Override // l5.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 a(e eVar) {
            Object objD = eVar.d(e0.a(k5.a.class, Executor.class));
            t.h(objD, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return s1.b((Executor) objD);
        }
    }

    /* JADX INFO: compiled from: Firebase.kt */
    public static final class b<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f10329a = new b<>();

        @Override // l5.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 a(e eVar) {
            Object objD = eVar.d(e0.a(k5.c.class, Executor.class));
            t.h(objD, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return s1.b((Executor) objD);
        }
    }

    /* JADX INFO: compiled from: Firebase.kt */
    public static final class c<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f10330a = new c<>();

        @Override // l5.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 a(e eVar) {
            Object objD = eVar.d(e0.a(k5.b.class, Executor.class));
            t.h(objD, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return s1.b((Executor) objD);
        }
    }

    /* JADX INFO: compiled from: Firebase.kt */
    public static final class d<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f10331a = new d<>();

        @Override // l5.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 a(e eVar) {
            Object objD = eVar.d(e0.a(k5.d.class, Executor.class));
            t.h(objD, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return s1.b((Executor) objD);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List<l5.c<?>> getComponents() {
        l5.c cVarD = l5.c.e(e0.a(k5.a.class, k0.class)).b(r.j(e0.a(k5.a.class, Executor.class))).f(a.f10328a).d();
        t.h(cVarD, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        l5.c cVarD2 = l5.c.e(e0.a(k5.c.class, k0.class)).b(r.j(e0.a(k5.c.class, Executor.class))).f(b.f10329a).d();
        t.h(cVarD2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        l5.c cVarD3 = l5.c.e(e0.a(k5.b.class, k0.class)).b(r.j(e0.a(k5.b.class, Executor.class))).f(c.f10330a).d();
        t.h(cVarD3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        l5.c cVarD4 = l5.c.e(e0.a(k5.d.class, k0.class)).b(r.j(e0.a(k5.d.class, Executor.class))).f(d.f10331a).d();
        t.h(cVarD4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return v.n(cVarD, cVarD2, cVarD3, cVarD4);
    }
}
