package kotlin.reflect;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KClassesImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class KClassesImplKt {
    @Nullable
    public static final String getQualifiedOrSimpleName(@NotNull KClass<?> kClass) {
        t.i(kClass, "<this>");
        return kClass.getQualifiedName();
    }
}
