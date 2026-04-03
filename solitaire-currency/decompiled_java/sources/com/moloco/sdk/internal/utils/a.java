package com.moloco.sdk.internal.utils;

import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.moloco.sdk.internal.utils.a$a, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.utils.CoroutineUtilsKt$withReentrantLock$2", f = "CoroutineUtils.kt", l = {54, 37}, m = "invokeSuspend")
    public static final class C0332a<T> extends l implements p<o0, z8.d<? super T>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18831j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18832k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18833l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ y9.a f18834m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ h9.l<z8.d<? super T>, Object> f18835n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0332a(y9.a aVar, h9.l<? super z8.d<? super T>, ? extends Object> lVar, z8.d<? super C0332a> dVar) {
            super(2, dVar);
            this.f18834m = aVar;
            this.f18835n = lVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super T> dVar) {
            return ((C0332a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C0332a(this.f18834m, this.f18835n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            y9.a aVar;
            h9.l<z8.d<? super T>, Object> lVar;
            y9.a aVar2;
            Throwable th;
            Object objE = a9.d.e();
            int i10 = this.f18833l;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    aVar = this.f18834m;
                    lVar = this.f18835n;
                    this.f18831j = aVar;
                    this.f18832k = lVar;
                    this.f18833l = 1;
                    if (aVar.e(null, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        aVar2 = (y9.a) this.f18831j;
                        try {
                            u.b(obj);
                            aVar2.g(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            aVar2.g(null);
                            throw th;
                        }
                    }
                    lVar = (h9.l) this.f18832k;
                    y9.a aVar3 = (y9.a) this.f18831j;
                    u.b(obj);
                    aVar = aVar3;
                }
                this.f18831j = aVar;
                this.f18832k = null;
                this.f18833l = 2;
                Object objInvoke = lVar.invoke(this);
                if (objInvoke == objE) {
                    return objE;
                }
                aVar2 = aVar;
                obj = objInvoke;
                aVar2.g(null);
                return obj;
            } catch (Throwable th3) {
                aVar2 = aVar;
                th = th3;
                aVar2.g(null);
                throw th;
            }
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull y9.a aVar, @NotNull h9.l<? super z8.d<? super T>, ? extends Object> lVar, @NotNull z8.d<? super T> dVar) {
        f fVar = new f(aVar);
        return dVar.getContext().get(fVar) != null ? lVar.invoke(dVar) : i.g(new e(fVar), new C0332a(aVar, lVar, null), dVar);
    }
}
