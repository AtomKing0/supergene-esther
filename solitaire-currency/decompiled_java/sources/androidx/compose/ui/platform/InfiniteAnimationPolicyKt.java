package androidx.compose.ui.platform;

import androidx.compose.runtime.MonotonicFrameClockKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteAnimationPolicyKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.ui.platform.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", l = {65}, m = "invokeSuspend")
    static final class AnonymousClass2<R> extends kotlin.coroutines.jvm.internal.l implements h9.l<z8.d<? super R>, Object> {
        final /* synthetic */ h9.l<Long, R> $onFrame;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(h9.l<? super Long, ? extends R> lVar, z8.d<? super AnonymousClass2> dVar) {
            super(1, dVar);
            this.$onFrame = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.$onFrame, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                v8.u.b(obj);
                h9.l<Long, R> lVar = this.$onFrame;
                this.label = 1;
                obj = MonotonicFrameClockKt.withFrameNanos(lVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return obj;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super R> dVar) {
            return ((AnonymousClass2) create(dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    @Nullable
    public static final <R> Object withInfiniteAnimationFrameNanos(@NotNull h9.l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) dVar.getContext().get(InfiniteAnimationPolicy.Key);
        return infiniteAnimationPolicy == null ? MonotonicFrameClockKt.withFrameNanos(lVar, dVar) : infiniteAnimationPolicy.onInfiniteOperation(new AnonymousClass2(lVar, null), dVar);
    }
}
