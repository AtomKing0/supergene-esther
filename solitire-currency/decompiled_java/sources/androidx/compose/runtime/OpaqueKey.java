package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OpaqueKey.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OpaqueKey {

    @NotNull
    private final String key;

    public OpaqueKey(@NotNull String key) {
        t.i(key, "key");
        this.key = key;
    }

    public static /* synthetic */ OpaqueKey copy$default(OpaqueKey opaqueKey, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = opaqueKey.key;
        }
        return opaqueKey.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final OpaqueKey copy(@NotNull String key) {
        t.i(key, "key");
        return new OpaqueKey(key);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpaqueKey) && t.d(this.key, ((OpaqueKey) obj).key);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpaqueKey(key=" + this.key + ')';
    }
}
