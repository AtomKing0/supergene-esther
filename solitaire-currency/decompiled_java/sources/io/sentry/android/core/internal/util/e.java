package io.sentry.android.core.internal.util;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class e {
    @Nullable
    public static String a(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName != null ? canonicalName : obj.getClass().getSimpleName();
    }
}
