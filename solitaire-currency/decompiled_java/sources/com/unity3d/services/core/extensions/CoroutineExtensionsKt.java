package com.unity3d.services.core.extensions;

import h9.a;
import h9.p;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.a0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: CoroutineExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineExtensionsKt {

    @NotNull
    private static final ConcurrentHashMap<Object, v0<?>> deferreds = new ConcurrentHashMap<>();

    @NotNull
    private static final AtomicBoolean deferredsCleanLaunched = new AtomicBoolean();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineExtensions.kt */
    @f(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2", f = "CoroutineExtensions.kt", l = {50}, m = "invokeSuspend")
    public static final class AnonymousClass2<T> extends l implements p<o0, d<? super T>, Object> {
        final /* synthetic */ p<o0, d<? super T>, Object> $action;
        final /* synthetic */ Object $key;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CoroutineExtensions.kt */
        @f(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$1", f = "CoroutineExtensions.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
            int label;

            /* JADX INFO: renamed from: com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: CoroutineExtensions.kt */
            public static final class C04981 extends v implements h9.l<Map.Entry<Object, v0<?>>, Boolean> {
                public static final C04981 INSTANCE = new C04981();

                public C04981() {
                    super(1);
                }

                @Override // h9.l
                @NotNull
                public final Boolean invoke(@NotNull Map.Entry<Object, v0<?>> it) {
                    t.i(it, "it");
                    return Boolean.valueOf(it.getValue().i());
                }
            }

            public AnonymousClass1(d<? super AnonymousClass1> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                Set<Map.Entry<Object, v0<?>>> setEntrySet = CoroutineExtensionsKt.getDeferreds().entrySet();
                t.h(setEntrySet, "deferreds.entries");
                a0.H(setEntrySet, C04981.INSTANCE);
                CoroutineExtensionsKt.getDeferredsCleanLaunched().set(false);
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Object obj, p<? super o0, ? super d<? super T>, ? extends Object> pVar, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$key = obj;
            this.$action = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$key, this.$action, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                v0<?> v0VarB = CoroutineExtensionsKt.getDeferreds().get(this.$key);
                if (v0VarB == null || !v0VarB.isActive()) {
                    v0VarB = null;
                }
                if (v0VarB == null) {
                    v0VarB = k.b(o0Var, null, null, new CoroutineExtensionsKt$memoize$2$deferred$2(this.$action, null), 3, null);
                    CoroutineExtensionsKt.getDeferreds().put(this.$key, v0VarB);
                }
                if (CoroutineExtensionsKt.getDeferreds().size() > 100 && !CoroutineExtensionsKt.getDeferredsCleanLaunched().getAndSet(true)) {
                    k.d(o0Var, null, null, new AnonymousClass1(null), 3, null);
                }
                this.label = 1;
                obj = v0VarB.i0(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            o0 o0Var = (o0) this.L$0;
            v0<?> v0VarB = CoroutineExtensionsKt.getDeferreds().get(this.$key);
            if (v0VarB == null || !Boolean.valueOf(v0VarB.isActive()).booleanValue()) {
                v0VarB = null;
            }
            if (v0VarB == null) {
                v0VarB = k.b(o0Var, null, null, new CoroutineExtensionsKt$memoize$2$deferred$2(this.$action, null), 3, null);
                CoroutineExtensionsKt.getDeferreds().put(this.$key, v0VarB);
                k0 k0Var = k0.f35197a;
            } else {
                t.h(v0VarB, "deferreds[key]?.takeIf {…o { deferreds[key] = it }");
            }
            v0<?> v0Var = v0VarB;
            if (CoroutineExtensionsKt.getDeferreds().size() > 100 && !CoroutineExtensionsKt.getDeferredsCleanLaunched().getAndSet(true)) {
                k.d(o0Var, null, null, new AnonymousClass1(null), 3, null);
            }
            r.c(0);
            Object objI0 = v0Var.i0(this);
            r.c(1);
            return objI0;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super T> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @NotNull
    public static final ConcurrentHashMap<Object, v0<?>> getDeferreds() {
        return deferreds;
    }

    @NotNull
    public static final AtomicBoolean getDeferredsCleanLaunched() {
        return deferredsCleanLaunched;
    }

    @Nullable
    public static final <T> Object memoize(@NotNull Object obj, @NotNull p<? super o0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        return p0.f(new AnonymousClass2(obj, pVar, null), dVar);
    }

    private static final <T> Object memoize$$forInline(Object obj, p<? super o0, ? super d<? super T>, ? extends Object> pVar, d<? super T> dVar) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(obj, pVar, null);
        r.c(0);
        Object objF = p0.f(anonymousClass2, dVar);
        r.c(1);
        return objF;
    }

    @NotNull
    public static final <R> Object runReturnSuspendCatching(@NotNull a<? extends R> block) {
        Object objB;
        t.i(block, "block");
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(block.invoke());
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(u.a(th));
        }
        if (v8.t.h(objB)) {
            return v8.t.b(objB);
        }
        Throwable thE = v8.t.e(objB);
        return thE != null ? v8.t.b(u.a(thE)) : objB;
    }

    @NotNull
    public static final <R> Object runSuspendCatching(@NotNull a<? extends R> block) {
        kotlin.jvm.internal.t.i(block, "block");
        try {
            t.a aVar = v8.t.f35208b;
            return v8.t.b(block.invoke());
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            return v8.t.b(u.a(th));
        }
    }
}
