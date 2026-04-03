package ea;

import java.util.Map;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SchemaCache.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<SerialDescriptor, Map<a<Object>, Object>> f25498a = t.a(1);

    /* JADX INFO: compiled from: SchemaCache.kt */
    public static final class a<T> {
    }

    @Nullable
    public final <T> T a(@NotNull SerialDescriptor descriptor, @NotNull a<T> key) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(key, "key");
        Map<a<Object>, Object> map = this.f25498a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    @NotNull
    public final <T> T b(@NotNull SerialDescriptor descriptor, @NotNull a<T> key, @NotNull h9.a<? extends T> defaultValue) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(defaultValue, "defaultValue");
        T t10 = (T) a(descriptor, key);
        if (t10 != null) {
            return t10;
        }
        T tInvoke = defaultValue.invoke();
        c(descriptor, key, tInvoke);
        return tInvoke;
    }

    public final <T> void c(@NotNull SerialDescriptor descriptor, @NotNull a<T> key, @NotNull T value) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        Map<SerialDescriptor, Map<a<Object>, Object>> map = this.f25498a;
        Map<a<Object>, Object> mapA = map.get(descriptor);
        if (mapA == null) {
            mapA = t.a(1);
            map.put(descriptor, mapA);
        }
        mapA.put(key, value);
    }
}
