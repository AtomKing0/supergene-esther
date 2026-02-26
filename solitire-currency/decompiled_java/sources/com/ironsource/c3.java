package com.ironsource;

import com.ironsource.f3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface c3 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0252a f11491a = new C0252a(null);

        /* JADX INFO: renamed from: com.ironsource.c3$a$a, reason: collision with other inner class name */
        public static final class C0252a {
            private C0252a() {
            }

            public /* synthetic */ C0252a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final c3 a() {
                return new b(b.f11497f, new ArrayList());
            }

            @NotNull
            public final c3 b(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(b.f11495d, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }

            @NotNull
            public final c3 c(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(b.f11500i, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }

            @NotNull
            public final c3 d(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(401, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }

            @NotNull
            public final c3 e(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(b.f11499h, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }

            @NotNull
            public final c3 f(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(b.f11496e, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }

            @NotNull
            public final c3 a(@NotNull f3.j errorCode, @NotNull f3.k errorReason) {
                kotlin.jvm.internal.t.i(errorCode, "errorCode");
                kotlin.jvm.internal.t.i(errorReason, "errorReason");
                return new b(403, kotlin.collections.v.q(errorCode, errorReason));
            }

            @NotNull
            public final c3 a(boolean z10) {
                return z10 ? new b(b.f11501j, new ArrayList()) : new b(b.f11502k, new ArrayList());
            }

            @NotNull
            public final c3 a(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(b.f11498g, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f11492a = new b();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f11493b = 401;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f11494c = 403;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f11495d = 404;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f11496e = 405;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f11497f = 406;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f11498g = 407;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f11499h = 408;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f11500i = 409;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f11501j = 410;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final int f11502k = 411;

            private b() {
            }
        }

        @NotNull
        public static final c3 a() {
            return f11491a.a();
        }

        @NotNull
        public static final c3 b(@NotNull g3... g3VarArr) {
            return f11491a.b(g3VarArr);
        }

        @NotNull
        public static final c3 c(@NotNull g3... g3VarArr) {
            return f11491a.c(g3VarArr);
        }

        @NotNull
        public static final c3 d(@NotNull g3... g3VarArr) {
            return f11491a.d(g3VarArr);
        }

        @NotNull
        public static final c3 e(@NotNull g3... g3VarArr) {
            return f11491a.e(g3VarArr);
        }

        @NotNull
        public static final c3 f(@NotNull g3... g3VarArr) {
            return f11491a.f(g3VarArr);
        }

        @NotNull
        public static final c3 a(@NotNull f3.j jVar, @NotNull f3.k kVar) {
            return f11491a.a(jVar, kVar);
        }

        @NotNull
        public static final c3 a(boolean z10) {
            return f11491a.a(z10);
        }

        @NotNull
        public static final c3 a(@NotNull g3... g3VarArr) {
            return f11491a.a(g3VarArr);
        }
    }

    public static final class b implements c3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<g3> f11504b;

        public b(int i10, @NotNull List<g3> arrayList) {
            kotlin.jvm.internal.t.i(arrayList, "arrayList");
            this.f11503a = i10;
            this.f11504b = arrayList;
        }

        @Override // com.ironsource.c3
        public void a(@NotNull j3 analytics) {
            kotlin.jvm.internal.t.i(analytics, "analytics");
            analytics.a(this.f11503a, this.f11504b);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f11505a = new a(null);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final c3 a() {
                return new b(201, new ArrayList());
            }

            @NotNull
            public final c3 b() {
                return new b(206, new ArrayList());
            }

            @NotNull
            public final c3 a(@NotNull f3.j errorCode, @NotNull f3.k errorReason, @NotNull f3.f duration) {
                kotlin.jvm.internal.t.i(errorCode, "errorCode");
                kotlin.jvm.internal.t.i(errorReason, "errorReason");
                kotlin.jvm.internal.t.i(duration, "duration");
                return new b(203, kotlin.collections.v.q(errorCode, errorReason, duration));
            }

            @NotNull
            public final c3 a(@NotNull g3 duration) {
                kotlin.jvm.internal.t.i(duration, "duration");
                return new b(202, kotlin.collections.v.q(duration));
            }

            @NotNull
            public final c3 a(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(204, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f11506a = new b();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f11507b = 201;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f11508c = 202;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f11509d = 203;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f11510e = 204;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f11511f = 205;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f11512g = 206;

            private b() {
            }
        }

        @NotNull
        public static final c3 a() {
            return f11505a.a();
        }

        @NotNull
        public static final c3 b() {
            return f11505a.b();
        }

        @NotNull
        public static final c3 a(@NotNull f3.j jVar, @NotNull f3.k kVar, @NotNull f3.f fVar) {
            return f11505a.a(jVar, kVar, fVar);
        }

        @NotNull
        public static final c3 a(@NotNull g3 g3Var) {
            return f11505a.a(g3Var);
        }

        @NotNull
        public static final c3 a(@NotNull g3... g3VarArr) {
            return f11505a.a(g3VarArr);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f11513a = new a(null);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final c3 a() {
                return new b(101, new ArrayList());
            }

            @NotNull
            public final c3 b() {
                return new b(112, new ArrayList());
            }

            @NotNull
            public final b c() {
                return new b(105, new ArrayList());
            }

            @NotNull
            public final c3 a(@NotNull f3.f duration) {
                kotlin.jvm.internal.t.i(duration, "duration");
                return new b(103, kotlin.collections.v.q(duration));
            }

            @NotNull
            public final c3 b(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(110, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }

            @NotNull
            public final c3 a(@NotNull f3.j errorCode, @NotNull f3.k errorReason) {
                kotlin.jvm.internal.t.i(errorCode, "errorCode");
                kotlin.jvm.internal.t.i(errorReason, "errorReason");
                return new b(109, kotlin.collections.v.q(errorCode, errorReason));
            }

            @NotNull
            public final c3 a(@NotNull f3.j errorCode, @NotNull f3.k errorReason, @NotNull f3.f duration, @NotNull f3.l loaderState) {
                kotlin.jvm.internal.t.i(errorCode, "errorCode");
                kotlin.jvm.internal.t.i(errorReason, "errorReason");
                kotlin.jvm.internal.t.i(duration, "duration");
                kotlin.jvm.internal.t.i(loaderState, "loaderState");
                return new b(104, kotlin.collections.v.q(errorCode, errorReason, duration, loaderState));
            }

            @NotNull
            public final c3 a(@NotNull g3 ext1) {
                kotlin.jvm.internal.t.i(ext1, "ext1");
                return new b(111, kotlin.collections.v.q(ext1));
            }

            @NotNull
            public final c3 a(@NotNull g3... entity) {
                kotlin.jvm.internal.t.i(entity, "entity");
                return new b(102, kotlin.collections.v.q(Arrays.copyOf(entity, entity.length)));
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f11514a = new b();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f11515b = 101;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f11516c = 102;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f11517d = 103;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f11518e = 104;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f11519f = 105;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f11520g = 109;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f11521h = 110;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f11522i = 111;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f11523j = 112;

            private b() {
            }
        }

        @NotNull
        public static final c3 a() {
            return f11513a.a();
        }

        @NotNull
        public static final c3 b() {
            return f11513a.b();
        }

        @NotNull
        public static final b c() {
            return f11513a.c();
        }

        @NotNull
        public static final c3 a(@NotNull f3.f fVar) {
            return f11513a.a(fVar);
        }

        @NotNull
        public static final c3 b(@NotNull g3... g3VarArr) {
            return f11513a.b(g3VarArr);
        }

        @NotNull
        public static final c3 a(@NotNull f3.j jVar, @NotNull f3.k kVar) {
            return f11513a.a(jVar, kVar);
        }

        @NotNull
        public static final c3 a(@NotNull f3.j jVar, @NotNull f3.k kVar, @NotNull f3.f fVar, @NotNull f3.l lVar) {
            return f11513a.a(jVar, kVar, fVar, lVar);
        }

        @NotNull
        public static final c3 a(@NotNull g3 g3Var) {
            return f11513a.a(g3Var);
        }

        @NotNull
        public static final c3 a(@NotNull g3... g3VarArr) {
            return f11513a.a(g3VarArr);
        }
    }

    void a(@NotNull j3 j3Var);
}
