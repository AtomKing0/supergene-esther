package i8;

import io.sentry.protocol.SentryThread;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CopyOnWriteHashMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26632a = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, SentryThread.JsonKeys.CURRENT);

    @NotNull
    private volatile /* synthetic */ Object current = r0.g();

    @Nullable
    public final V a(@NotNull K key) {
        t.i(key, "key");
        return (V) ((Map) this.current).get(key);
    }
}
