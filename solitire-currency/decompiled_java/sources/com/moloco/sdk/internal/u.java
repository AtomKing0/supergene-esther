package com.moloco.sdk.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface u {

    public static final class a {
        public static /* synthetic */ boolean a(u uVar, String str, long j10, q qVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i10 & 4) != 0) {
                qVar = null;
            }
            return uVar.a(str, j10, qVar);
        }
    }

    boolean a(@NotNull String str, long j10, @Nullable q qVar);
}
