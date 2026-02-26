package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import h9.p;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: RepeatOnLifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    /* JADX INFO: compiled from: RepeatOnLifecycle.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<o0, z8.d<? super k0>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: RepeatOnLifecycle.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ o0 $$this$coroutineScope;
            final /* synthetic */ p<o0, z8.d<? super k0>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, o0 o0Var, p<? super o0, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = o0Var;
                this.$block = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, dVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 221
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, p<? super o0, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                n2 immediate = e1.c().getImmediate();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, o0Var, this.$block, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(immediate, anonymousClass1, this) == objE) {
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
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Nullable
    public static final Object repeatOnLifecycle(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        if (!(state != Lifecycle.State.INITIALIZED)) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        }
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return k0.f35197a;
        }
        Object objF = p0.f(new AnonymousClass3(lifecycle, state, pVar, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @Nullable
    public static final Object repeatOnLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, dVar);
        return objRepeatOnLifecycle == a9.d.e() ? objRepeatOnLifecycle : k0.f35197a;
    }
}
