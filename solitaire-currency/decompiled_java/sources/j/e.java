package j;

import a0.i;
import a0.o;
import a0.s;
import android.content.Context;
import ga.e;
import ga.z;
import j.c;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.c;
import v.j;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface e {

    /* JADX INFO: compiled from: ImageLoader.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Context f28552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private v.c f28553b = i.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private l<? extends t.c> f28554c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private l<? extends n.a> f28555d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private l<? extends e.a> f28556e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private c.d f28557f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private j.b f28558g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        private o f28559h = new o(false, false, false, 0, null, 31, null);

        /* JADX INFO: renamed from: j.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageLoader.kt */
        static final class C0591a extends v implements h9.a<t.c> {
            C0591a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final t.c invoke() {
                return new c.a(a.this.f28552a).a();
            }
        }

        /* JADX INFO: compiled from: ImageLoader.kt */
        static final class b extends v implements h9.a<n.a> {
            b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final n.a invoke() {
                return s.f61a.a(a.this.f28552a);
            }
        }

        /* JADX INFO: compiled from: ImageLoader.kt */
        static final class c extends v implements h9.a<z> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f28562g = new c();

            c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z invoke() {
                return new z();
            }
        }

        public a(@NotNull Context context) {
            this.f28552a = context.getApplicationContext();
        }

        @NotNull
        public final e b() {
            Context context = this.f28552a;
            v.c cVar = this.f28553b;
            l<? extends t.c> lVarA = this.f28554c;
            if (lVarA == null) {
                lVarA = n.a(new C0591a());
            }
            l<? extends t.c> lVar = lVarA;
            l<? extends n.a> lVarA2 = this.f28555d;
            if (lVarA2 == null) {
                lVarA2 = n.a(new b());
            }
            l<? extends n.a> lVar2 = lVarA2;
            l<? extends e.a> lVarA3 = this.f28556e;
            if (lVarA3 == null) {
                lVarA3 = n.a(c.f28562g);
            }
            l<? extends e.a> lVar3 = lVarA3;
            c.d dVar = this.f28557f;
            if (dVar == null) {
                dVar = c.d.f28550b;
            }
            c.d dVar2 = dVar;
            j.b bVar = this.f28558g;
            if (bVar == null) {
                bVar = new j.b();
            }
            return new h(context, cVar, lVar, lVar2, lVar3, dVar2, bVar, this.f28559h, null);
        }
    }

    @NotNull
    v.c a();

    @Nullable
    Object b(@NotNull v.i iVar, @NotNull z8.d<? super j> dVar);

    @NotNull
    v.e c(@NotNull v.i iVar);

    @Nullable
    t.c d();

    @NotNull
    b getComponents();
}
