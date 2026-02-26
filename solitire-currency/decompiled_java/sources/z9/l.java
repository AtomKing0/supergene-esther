package z9;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class l {
    @Nullable
    public static final KSerializer<? extends Object> a(@NotNull KClass<Object> kClass, @NotNull List<? extends KType> list, @NotNull List<? extends KSerializer<Object>> list2) {
        return m.d(kClass, list, list2);
    }

    @NotNull
    public static final KSerializer<Object> b(@NotNull fa.c cVar, @NotNull KType kType) {
        return m.e(cVar, kType);
    }

    @Nullable
    public static final KSerializer<Object> c(@NotNull fa.c cVar, @NotNull KType kType) {
        return m.g(cVar, kType);
    }

    @Nullable
    public static final <T> KSerializer<T> d(@NotNull KClass<T> kClass) {
        return m.h(kClass);
    }

    @Nullable
    public static final List<KSerializer<Object>> e(@NotNull fa.c cVar, @NotNull List<? extends KType> list, boolean z10) {
        return m.i(cVar, list, z10);
    }
}
