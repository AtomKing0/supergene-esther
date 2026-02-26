package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import h9.l;
import h9.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.r;
import s9.h;
import s9.j;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public c f19466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h<c> f19467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public l<? super File, k0> f19468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public p<? super File, ? super c.d, k0> f19469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public l<? super c.a, k0> f19470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public l<? super c.b, k0> f19471f;

    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.MediaStreamListenerFlow$streamStatusFlow$1", f = "MediaStreamListenerFlow.kt", l = {30}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<r<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19472j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19473k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$a, reason: collision with other inner class name */
        public static final class C0382a extends v implements l<File, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ r<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f19475g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0382a(r<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> rVar) {
                super(1);
                this.f19475g = rVar;
            }

            public final void a(@NotNull File file) {
                t.i(file, "file");
                this.f19475g.f(new c.C0384c(file, new c.d(0L, 0L)));
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(File file) {
                a(file);
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$b, reason: collision with other inner class name */
        public static final class C0383b extends v implements p<File, c.d, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ r<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f19476g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0383b(r<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> rVar) {
                super(2);
                this.f19476g = rVar;
            }

            public final void a(@NotNull File file, @NotNull c.d progress) {
                t.i(file, "file");
                t.i(progress, "progress");
                this.f19476g.f(new c.C0384c(file, progress));
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(File file, c.d dVar) {
                a(file, dVar);
                return k0.f35197a;
            }
        }

        public static final class c extends v implements l<c.a, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ r<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f19477g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(r<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> rVar) {
                super(1);
                this.f19477g = rVar;
            }

            public final void a(@NotNull c.a complete) {
                t.i(complete, "complete");
                this.f19477g.f(complete);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(c.a aVar) {
                a(aVar);
                return k0.f35197a;
            }
        }

        public static final class d extends v implements l<c.b, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ r<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> f19478g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(r<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> rVar) {
                super(1);
                this.f19478g = rVar;
            }

            public final void a(@NotNull c.b error) {
                t.i(error, "error");
                this.f19478g.f(error);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(c.b bVar) {
                a(bVar);
                return k0.f35197a;
            }
        }

        public static final class e extends v implements h9.a<k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ b f19479g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(b bVar) {
                super(0);
                this.f19479g = bVar;
            }

            public final void b() {
                this.f19479g.f19468c = null;
                this.f19479g.f19469d = null;
                this.f19479g.f19470e = null;
                this.f19479g.f19471f = null;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                b();
                return k0.f35197a;
            }
        }

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = b.this.new a(dVar);
            aVar.f19473k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> rVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(rVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19472j;
            if (i10 == 0) {
                u.b(obj);
                r rVar = (r) this.f19473k;
                b.this.f19468c = new C0382a(rVar);
                b.this.f19469d = new C0383b(rVar);
                b.this.f19470e = new c(rVar);
                b.this.f19471f = new d(rVar);
                e eVar = new e(b.this);
                this.f19472j = 1;
                if (r9.p.a(rVar, eVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    public b(@NotNull c initialStatus) {
        t.i(initialStatus, "initialStatus");
        this.f19466a = initialStatus;
        this.f19467b = j.f(new a(null));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(@NotNull c.b error) {
        t.i(error, "error");
        this.f19466a = error;
        l<? super c.b, k0> lVar = this.f19471f;
        if (lVar != null) {
            lVar.invoke(error);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void b(@NotNull File file, @NotNull c.d progress) {
        t.i(file, "file");
        t.i(progress, "progress");
        this.f19466a = new c.C0384c(file, progress);
        p<? super File, ? super c.d, k0> pVar = this.f19469d;
        if (pVar != null) {
            pVar.mo4invoke(file, progress);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void c(@NotNull c.a result) {
        t.i(result, "result");
        this.f19466a = result;
        l<? super c.a, k0> lVar = this.f19470e;
        if (lVar != null) {
            lVar.invoke(result);
        }
    }

    @NotNull
    public c d() {
        return this.f19466a;
    }

    @NotNull
    public final h<c> g() {
        return this.f19467b;
    }
}
