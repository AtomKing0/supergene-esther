package m8;

import java.lang.reflect.Type;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TypeInfoJvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final boolean a(@NotNull Object obj, @NotNull KClass<?> type) {
        t.i(obj, "<this>");
        t.i(type, "type");
        return g9.a.a(type).isInstance(obj);
    }

    @NotNull
    public static final a b(@NotNull Type reifiedType, @NotNull KClass<?> kClass, @Nullable KType kType) {
        t.i(reifiedType, "reifiedType");
        t.i(kClass, "kClass");
        return new a(kClass, reifiedType, kType);
    }
}
