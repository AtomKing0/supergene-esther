package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.InitializationState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AwaitInitialization.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface AwaitInitialization {

    /* JADX INFO: compiled from: AwaitInitialization.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(AwaitInitialization awaitInitialization, long j10, z8.d dVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i10 & 1) != 0) {
                j10 = Long.MAX_VALUE;
            }
            return awaitInitialization.invoke(j10, dVar);
        }
    }

    @Nullable
    Object invoke(long j10, @NotNull z8.d<? super InitializationState> dVar);
}
