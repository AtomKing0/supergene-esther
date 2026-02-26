package ea;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s {
    @NotNull
    public static final j a(@NotNull o0 sb, @NotNull kotlinx.serialization.json.a json) {
        kotlin.jvm.internal.t.i(sb, "sb");
        kotlin.jvm.internal.t.i(json, "json");
        return json.e().h() ? new r(sb, json) : new j(sb);
    }
}
