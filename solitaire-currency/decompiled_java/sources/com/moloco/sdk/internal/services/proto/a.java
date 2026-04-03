package com.moloco.sdk.internal.services.proto;

import com.moloco.sdk.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.proto.a$a, reason: collision with other inner class name */
    public static final class C0331a {
        public static /* synthetic */ String a(a aVar, t tVar, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeUserAdInteractionExt");
            }
            if ((i11 & 2) != 0) {
                i10 = 10;
            }
            return aVar.a(tVar, i10);
        }
    }

    @NotNull
    String a(@NotNull t tVar, int i10);
}
