package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f20983a = Dp.m3673constructorimpl(48);

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastIconKt$VastIcon$1$1", f = "VastIcon.kt", l = {21}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20984j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20985k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastIconKt$VastIcon$1$1$1", f = "VastIcon.kt", l = {}, m = "invokeSuspend")
        public static final class C0450a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20986j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20987k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0450a(h9.a<k0> aVar, z8.d<? super C0450a> dVar) {
                super(2, dVar);
                this.f20987k = aVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C0450a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0450a(this.f20987k, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f20986j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.f20987k.invoke();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h9.a<k0> aVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f20985k = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f20985k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20984j;
            if (i10 == 0) {
                u.b(obj);
                z8.g main = com.moloco.sdk.internal.scheduling.c.a().getMain();
                C0450a c0450a = new C0450a(this.f20985k, null);
                this.f20984j = 1;
                if (kotlinx.coroutines.i.g(main, c0450a, this) == objE) {
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

    public static final class b extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j f20988g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20989h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20990i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Modifier f20991j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f20992k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f20993l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, h9.a<k0> aVar, h9.a<k0> aVar2, Modifier modifier, int i10, int i11) {
            super(2);
            this.f20988g = jVar;
            this.f20989h = aVar;
            this.f20990i = aVar2;
            this.f20991j = modifier;
            this.f20992k = i10;
            this.f20993l = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            i.a(this.f20988g, this.f20989h, this.f20990i, this.f20991j, composer, this.f20992k | 1, this.f20993l);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j r21, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r22, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a, h9.a, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
