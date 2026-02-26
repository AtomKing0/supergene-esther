package com.unity3d.services.core.domain;

import androidx.exifinterface.media.ExifInterface;
import com.unity3d.services.core.domain.task.InitializationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: ResultExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ResultExtensionsKt {
    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrNull(Object obj) {
        Throwable thE = t.e(obj);
        kotlin.jvm.internal.t.o(3, ExifInterface.LONGITUDE_EAST);
        if (thE instanceof Exception) {
            return (E) thE;
        }
        return null;
    }

    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrThrow(Object obj) {
        Throwable thE = t.e(obj);
        kotlin.jvm.internal.t.o(3, ExifInterface.LONGITUDE_EAST);
        if (thE instanceof Exception) {
            return (E) thE;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }

    @Nullable
    public static final InitializationException getInitializationExceptionOrNull(@NotNull Object obj) {
        Throwable thE = t.e(obj);
        if (thE instanceof InitializationException) {
            return (InitializationException) thE;
        }
        return null;
    }

    @NotNull
    public static final InitializationException getInitializationExceptionOrThrow(@NotNull Object obj) {
        Throwable thE = t.e(obj);
        if (thE instanceof InitializationException) {
            return (InitializationException) thE;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }
}
