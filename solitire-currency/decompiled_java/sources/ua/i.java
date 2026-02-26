package ua;

import java.util.ArrayList;
import java.util.Map;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f34771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f34772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final q0 f34773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final Long f34774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final Long f34775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final Long f34776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final Long f34777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final Map<KClass<?>, Object> f34778h;

    public i(boolean z10, boolean z11, @Nullable q0 q0Var, @Nullable Long l10, @Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @NotNull Map<KClass<?>, ? extends Object> extras) {
        kotlin.jvm.internal.t.i(extras, "extras");
        this.f34771a = z10;
        this.f34772b = z11;
        this.f34773c = q0Var;
        this.f34774d = l10;
        this.f34775e = l11;
        this.f34776f = l12;
        this.f34777g = l13;
        this.f34778h = kotlin.collections.r0.u(extras);
    }

    @NotNull
    public final i a(boolean z10, boolean z11, @Nullable q0 q0Var, @Nullable Long l10, @Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @NotNull Map<KClass<?>, ? extends Object> extras) {
        kotlin.jvm.internal.t.i(extras, "extras");
        return new i(z10, z11, q0Var, l10, l11, l12, l13, extras);
    }

    @Nullable
    public final Long c() {
        return this.f34776f;
    }

    @Nullable
    public final Long d() {
        return this.f34774d;
    }

    @Nullable
    public final q0 e() {
        return this.f34773c;
    }

    public final boolean f() {
        return this.f34772b;
    }

    public final boolean g() {
        return this.f34771a;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f34771a) {
            arrayList.add("isRegularFile");
        }
        if (this.f34772b) {
            arrayList.add("isDirectory");
        }
        if (this.f34774d != null) {
            arrayList.add("byteCount=" + this.f34774d);
        }
        if (this.f34775e != null) {
            arrayList.add("createdAt=" + this.f34775e);
        }
        if (this.f34776f != null) {
            arrayList.add("lastModifiedAt=" + this.f34776f);
        }
        if (this.f34777g != null) {
            arrayList.add("lastAccessedAt=" + this.f34777g);
        }
        if (!this.f34778h.isEmpty()) {
            arrayList.add("extras=" + this.f34778h);
        }
        return kotlin.collections.d0.r0(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ i(boolean z10, boolean z11, q0 q0Var, Long l10, Long l11, Long l12, Long l13, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) == 0 ? z11 : false, (i10 & 4) != 0 ? null : q0Var, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : l11, (i10 & 32) != 0 ? null : l12, (i10 & 64) == 0 ? l13 : null, (i10 & 128) != 0 ? kotlin.collections.r0.g() : map);
    }
}
