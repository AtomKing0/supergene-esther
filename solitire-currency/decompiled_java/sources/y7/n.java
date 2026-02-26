package y7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpClientPlugin.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final g8.a<g8.b> f36750a = new g8.a<>("ApplicationPluginRegistry");

    @NotNull
    public static final g8.a<g8.b> a() {
        return f36750a;
    }

    @NotNull
    public static final <B, F> F b(@NotNull s7.a aVar, @NotNull m<? extends B, F> plugin) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(plugin, "plugin");
        F f10 = (F) c(aVar, plugin);
        if (f10 != null) {
            return f10;
        }
        throw new IllegalStateException("Plugin " + plugin + " is not installed. Consider using `install(" + plugin.getKey() + ")` in client config first.");
    }

    @Nullable
    public static final <B, F> F c(@NotNull s7.a aVar, @NotNull m<? extends B, F> plugin) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(plugin, "plugin");
        g8.b bVar = (g8.b) aVar.getAttributes().d(f36750a);
        if (bVar != null) {
            return (F) bVar.d(plugin.getKey());
        }
        return null;
    }
}
