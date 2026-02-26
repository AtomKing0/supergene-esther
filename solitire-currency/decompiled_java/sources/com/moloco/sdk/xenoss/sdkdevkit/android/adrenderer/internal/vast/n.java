package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface n {

    public static final class a {
        public static /* synthetic */ void a(n nVar, List list, z zVar, Integer num, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
            }
            if ((i10 & 2) != 0) {
                zVar = null;
            }
            if ((i10 & 4) != 0) {
                num = null;
            }
            if ((i10 & 8) != 0) {
                str = null;
            }
            nVar.a(list, zVar, num, str);
        }

        public static /* synthetic */ void b(n nVar, List list, z zVar, Integer num, String str, List list2, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0481a.f fVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackClick");
            }
            nVar.b(list, (i10 & 2) != 0 ? null : zVar, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str, list2, aVar, fVar);
        }
    }

    void a(@NotNull List<String> list, @Nullable z zVar, @Nullable Integer num, @Nullable String str);

    void b(@NotNull List<String> list, @Nullable z zVar, @Nullable Integer num, @Nullable String str, @NotNull List<a.AbstractC0481a.c> list2, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, @NotNull a.AbstractC0481a.f fVar);
}
