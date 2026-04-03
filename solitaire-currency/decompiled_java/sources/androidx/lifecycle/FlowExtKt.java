package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import h9.p;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.r;
import r9.u;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: FlowExt.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    /* JADX INFO: compiled from: FlowExt.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {91}, m = "invokeSuspend")
    static final class AnonymousClass1<T> extends kotlin.coroutines.jvm.internal.l implements p<r<? super T>, z8.d<? super k0>, Object> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ s9.h<T> $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FlowExt.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend")
        static final class C01281 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ r<T> $$this$callbackFlow;
            final /* synthetic */ s9.h<T> $this_flowWithLifecycle;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01281(s9.h<? extends T> hVar, r<? super T> rVar, z8.d<? super C01281> dVar) {
                super(2, dVar);
                this.$this_flowWithLifecycle = hVar;
                this.$$this$callbackFlow = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C01281(this.$this_flowWithLifecycle, this.$$this$callbackFlow, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    s9.h<T> hVar = this.$this_flowWithLifecycle;
                    final r<T> rVar = this.$$this$callbackFlow;
                    s9.i<? super T> iVar = new s9.i() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                        @Override // s9.i
                        @Nullable
                        public final Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
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
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C01281) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, s9.h<? extends T> hVar, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, dVar);
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
                u.b(obj);
                r rVar2 = (r) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C01281 c01281 = new C01281(this.$this_flowWithLifecycle, rVar2, null);
                this.L$0 = rVar2;
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c01281, this) == objE) {
                    return objE;
                }
                rVar = rVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rVar = (r) this.L$0;
                u.b(obj);
            }
            u.a.a(rVar, null, 1, null);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r<? super T> rVar, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(rVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @NotNull
    public static final <T> s9.h<T> flowWithLifecycle(@NotNull s9.h<? extends T> hVar, @NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state) {
        return s9.j.f(new AnonymousClass1(lifecycle, state, hVar, null));
    }

    public static /* synthetic */ s9.h flowWithLifecycle$default(s9.h hVar, Lifecycle lifecycle, Lifecycle.State state, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(hVar, lifecycle, state);
    }
}
