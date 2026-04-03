package com.unity3d.ads.adplayer;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.x;
import kotlinx.coroutines.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Invocation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Invocation {

    @NotNull
    private final x<k0> _isHandled;

    @NotNull
    private final x<Object> completableDeferred;

    @NotNull
    private final String location;

    @NotNull
    private final Object[] parameters;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.Invocation$handle$2, reason: invalid class name */
    /* JADX INFO: compiled from: Invocation.kt */
    @f(c = "com.unity3d.ads.adplayer.Invocation$handle$2", f = "Invocation.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements h9.l<z8.d<? super k0>, Object> {
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.Invocation$handle$3, reason: invalid class name */
    /* JADX INFO: compiled from: Invocation.kt */
    @f(c = "com.unity3d.ads.adplayer.Invocation$handle$3", f = "Invocation.kt", l = {23}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.l<z8.d<Object>, Object> $handler;
        int label;
        final /* synthetic */ Invocation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(h9.l<? super z8.d<Object>, ? extends Object> lVar, Invocation invocation, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$handler = lVar;
            this.this$0 = invocation;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass3(this.$handler, this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    h9.l<z8.d<Object>, Object> lVar = this.$handler;
                    this.label = 1;
                    obj = lVar.invoke(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                this.this$0.completableDeferred.O(obj);
            } catch (Throwable th) {
                this.this$0.completableDeferred.c(th);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public Invocation(@NotNull String location, @NotNull Object[] parameters) {
        t.i(location, "location");
        t.i(parameters, "parameters");
        this.location = location;
        this.parameters = parameters;
        this._isHandled = z.b(null, 1, null);
        this.completableDeferred = z.b(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object handle$default(Invocation invocation, h9.l lVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = new AnonymousClass2(null);
        }
        return invocation.handle(lVar, dVar);
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final Object[] getParameters() {
        return this.parameters;
    }

    @Nullable
    public final Object getResult(@NotNull z8.d<Object> dVar) {
        return this.completableDeferred.i0(dVar);
    }

    @Nullable
    public final Object handle(@NotNull h9.l<? super z8.d<Object>, ? extends Object> lVar, @NotNull z8.d<? super k0> dVar) {
        x<k0> xVar = this._isHandled;
        k0 k0Var = k0.f35197a;
        xVar.O(k0Var);
        k.d(p0.a(dVar.getContext()), null, null, new AnonymousClass3(lVar, this, null), 3, null);
        return k0Var;
    }

    @NotNull
    public final v0<k0> isHandled() {
        return this._isHandled;
    }
}
