package androidx.privacysandbox.ads.adservices.appsetid;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AppSetId.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSetId {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;

    @NotNull
    private final String id;
    private final int scope;

    /* JADX INFO: compiled from: AppSetId.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public AppSetId(@NotNull String id, int i10) {
        t.i(id, "id");
        this.id = id;
        this.scope = i10;
        boolean z10 = true;
        if (i10 != 1 && i10 != 2) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Scope undefined.".toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) obj;
        return t.d(this.id, appSetId.id) && this.scope == appSetId.scope;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getScope() {
        return this.scope;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.scope;
    }

    @NotNull
    public String toString() {
        return "AppSetId: id=" + this.id + ", scope=" + (this.scope == 1 ? "SCOPE_APP" : "SCOPE_DEVELOPER");
    }
}
