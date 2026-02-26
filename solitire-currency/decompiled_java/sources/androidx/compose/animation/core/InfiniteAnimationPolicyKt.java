package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import h9.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteAnimationPolicyKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
    public static final class AnonymousClass2<R> extends v implements l<Long, R> {
        final /* synthetic */ l<Long, R> $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(l<? super Long, ? extends R> lVar) {
            super(1);
            this.$onFrame = lVar;
        }

        public final R invoke(long j10) {
            return this.$onFrame.invoke(Long.valueOf(j10 / 1000000));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Long l10) {
            return invoke(l10.longValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", l = {31}, m = "invokeSuspend")
    static final class C08062<R> extends kotlin.coroutines.jvm.internal.l implements l<z8.d<? super R>, Object> {
        final /* synthetic */ l<Long, R> $onFrame;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08062(l<? super Long, ? extends R> lVar, z8.d<? super C08062> dVar) {
            super(1, dVar);
            this.$onFrame = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new C08062(this.$onFrame, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                l<Long, R> lVar = this.$onFrame;
                this.label = 1;
                obj = MonotonicFrameClockKt.withFrameNanos(lVar, this);
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

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super R> dVar) {
            return ((C08062) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Nullable
    public static final <R> Object withInfiniteAnimationFrameMillis(@NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) {
        return withInfiniteAnimationFrameNanos(new AnonymousClass2(lVar), dVar);
    }

    private static final <R> Object withInfiniteAnimationFrameMillis$$forInline(l<? super Long, ? extends R> lVar, z8.d<? super R> dVar) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(lVar);
        r.c(0);
        Object objWithInfiniteAnimationFrameNanos = withInfiniteAnimationFrameNanos(anonymousClass2, dVar);
        r.c(1);
        return objWithInfiniteAnimationFrameNanos;
    }

    @Nullable
    public static final <R> Object withInfiniteAnimationFrameNanos(@NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) dVar.getContext().get(InfiniteAnimationPolicy.Key);
        return infiniteAnimationPolicy == null ? MonotonicFrameClockKt.withFrameNanos(lVar, dVar) : infiniteAnimationPolicy.onInfiniteOperation(new C08062(lVar, null), dVar);
    }
}
