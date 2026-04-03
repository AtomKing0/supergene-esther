package com.unity3d.ads.core.extensions;

import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.r;
import r9.u;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: FlowExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowExtensionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1, reason: invalid class name */
    /* JADX INFO: compiled from: FlowExtensions.kt */
    @f(c = "com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1", f = "FlowExtensions.kt", l = {15, 17}, m = "invokeSuspend")
    static final class AnonymousClass1<T> extends l implements p<r<? super T>, d<? super k0>, Object> {
        final /* synthetic */ boolean $active;
        final /* synthetic */ p<a<k0>, d<? super k0>, Object> $block;
        final /* synthetic */ h<T> $this_timeoutAfter;
        final /* synthetic */ long $timeoutMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FlowExtensions.kt */
        @f(c = "com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1", f = "FlowExtensions.kt", l = {10}, m = "invokeSuspend")
        static final class C04941 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ r<T> $$this$channelFlow;
            final /* synthetic */ h<T> $this_timeoutAfter;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C04941(h<? extends T> hVar, r<? super T> rVar, d<? super C04941> dVar) {
                super(2, dVar);
                this.$this_timeoutAfter = hVar;
                this.$$this$channelFlow = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C04941(this.$this_timeoutAfter, this.$$this$channelFlow, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    h<T> hVar = this.$this_timeoutAfter;
                    final r<T> rVar = this.$$this$channelFlow;
                    i<? super T> iVar = new i() { // from class: com.unity3d.ads.core.extensions.FlowExtensionsKt.timeoutAfter.1.1.1
                        @Override // s9.i
                        @Nullable
                        public final Object emit(T t10, @NotNull d<? super k0> dVar) {
                            Object objP = rVar.p(t10, dVar);
                            return objP == a9.d.e() ? objP : k0.f35197a;
                        }
                    };
                    this.label = 1;
                    if (hVar.collect(iVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                u.a.a(this.$$this$channelFlow, null, 1, null);
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C04941) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: FlowExtensions.kt */
        /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.a implements a<k0> {
            AnonymousClass2(Object obj) {
                super(0, obj, r.class, "close", "close(Ljava/lang/Throwable;)Z", 8);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                u.a.a((r) this.receiver, null, 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(long j10, boolean z10, p<? super a<k0>, ? super d<? super k0>, ? extends Object> pVar, h<? extends T> hVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$timeoutMillis = j10;
            this.$active = z10;
            this.$block = pVar;
            this.$this_timeoutAfter = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$timeoutMillis, this.$active, this.$block, this.$this_timeoutAfter, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            r rVar;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                v8.u.b(obj);
                rVar = (r) this.L$0;
                k.d(rVar, null, null, new C04941(this.$this_timeoutAfter, rVar, null), 3, null);
                long j10 = this.$timeoutMillis;
                this.L$0 = rVar;
                this.label = 1;
                if (y0.a(j10, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    return k0.f35197a;
                }
                rVar = (r) this.L$0;
                v8.u.b(obj);
            }
            if (this.$active) {
                p<a<k0>, d<? super k0>, Object> pVar = this.$block;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(rVar);
                this.L$0 = null;
                this.label = 2;
                if (pVar.mo4invoke(anonymousClass2, this) == objE) {
                    return objE;
                }
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r<? super T> rVar, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(rVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @NotNull
    public static final <T> h<T> timeoutAfter(@NotNull h<? extends T> hVar, long j10, boolean z10, @NotNull p<? super a<k0>, ? super d<? super k0>, ? extends Object> block) {
        t.i(hVar, "<this>");
        t.i(block, "block");
        return j.j(new AnonymousClass1(j10, z10, block, hVar, null));
    }

    public static /* synthetic */ h timeoutAfter$default(h hVar, long j10, boolean z10, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return timeoutAfter(hVar, j10, z10, pVar);
    }
}
