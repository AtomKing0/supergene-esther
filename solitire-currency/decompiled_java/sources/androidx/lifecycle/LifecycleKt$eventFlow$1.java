package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.r;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {444}, m = "invokeSuspend")
final class LifecycleKt$eventFlow$1 extends kotlin.coroutines.jvm.internal.l implements p<r<? super Lifecycle.Event>, z8.d<? super k0>, Object> {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleKt$eventFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Lifecycle.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        final /* synthetic */ LifecycleEventObserver $observer;
        final /* synthetic */ Lifecycle $this_eventFlow;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            super(0);
            this.$this_eventFlow = lifecycle;
            this.$observer = lifecycleEventObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$this_eventFlow.removeObserver(this.$observer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LifecycleKt$eventFlow$1(Lifecycle lifecycle, z8.d<? super LifecycleKt$eventFlow$1> dVar) {
        super(2, dVar);
        this.$this_eventFlow = lifecycle;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, dVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            final r rVar = (r) this.L$0;
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.i
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    rVar.f(event);
                }
            };
            this.$this_eventFlow.addObserver(lifecycleEventObserver);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_eventFlow, lifecycleEventObserver);
            this.label = 1;
            if (r9.p.a(rVar, anonymousClass1, this) == objE) {
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
    public final Object mo4invoke(@NotNull r<? super Lifecycle.Event> rVar, @Nullable z8.d<? super k0> dVar) {
        return ((LifecycleKt$eventFlow$1) create(rVar, dVar)).invokeSuspend(k0.f35197a);
    }
}
