package ea;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: createMapForCache.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t {
    @NotNull
    public static final <K, V> Map<K, V> a(int i10) {
        return new ConcurrentHashMap(i10);
    }
}
