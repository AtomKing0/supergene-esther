package hb;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdaEmbedView.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f26517a = new LinkedHashMap();

    @NotNull
    public final Map<String, Object> a() {
        return this.f26517a;
    }

    @NotNull
    public final c b(@NotNull String key, @NotNull String value) {
        t.j(key, "key");
        t.j(value, "value");
        this.f26517a.put(key, value);
        return this;
    }
}
