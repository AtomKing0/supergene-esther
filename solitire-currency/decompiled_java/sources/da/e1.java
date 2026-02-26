package da;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<List<KType>, v8.t<KSerializer<T>>> f24563a = new ConcurrentHashMap<>();
}
