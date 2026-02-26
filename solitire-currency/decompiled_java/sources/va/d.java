package va;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.q0;

/* JADX INFO: compiled from: ZipEntry.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final q0 f35233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f35234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f35235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f35236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f35237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f35238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f35239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final Long f35240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f35241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final List<q0> f35242j;

    public d(@NotNull q0 canonicalPath, boolean z10, @NotNull String comment, long j10, long j11, long j12, int i10, @Nullable Long l10, long j13) {
        t.i(canonicalPath, "canonicalPath");
        t.i(comment, "comment");
        this.f35233a = canonicalPath;
        this.f35234b = z10;
        this.f35235c = comment;
        this.f35236d = j10;
        this.f35237e = j11;
        this.f35238f = j12;
        this.f35239g = i10;
        this.f35240h = l10;
        this.f35241i = j13;
        this.f35242j = new ArrayList();
    }

    @NotNull
    public final q0 a() {
        return this.f35233a;
    }

    @NotNull
    public final List<q0> b() {
        return this.f35242j;
    }

    public final long c() {
        return this.f35237e;
    }

    public final int d() {
        return this.f35239g;
    }

    @Nullable
    public final Long e() {
        return this.f35240h;
    }

    public final long f() {
        return this.f35241i;
    }

    public final long g() {
        return this.f35238f;
    }

    public final boolean h() {
        return this.f35234b;
    }

    public /* synthetic */ d(q0 q0Var, boolean z10, String str, long j10, long j11, long j12, int i10, Long l10, long j13, int i11, k kVar) {
        this(q0Var, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? "" : str, (i11 & 8) != 0 ? -1L : j10, (i11 & 16) != 0 ? -1L : j11, (i11 & 32) != 0 ? -1L : j12, (i11 & 64) != 0 ? -1 : i10, (i11 & 128) != 0 ? null : l10, (i11 & 256) == 0 ? j13 : -1L);
    }
}
