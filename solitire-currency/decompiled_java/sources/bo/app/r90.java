package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class r90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f3753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3757f;

    public /* synthetic */ r90() {
        this(false, null, null, 0L, 0L, 0L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r90)) {
            return false;
        }
        r90 r90Var = (r90) obj;
        return this.f3752a == r90Var.f3752a && kotlin.jvm.internal.t.d(this.f3753b, r90Var.f3753b) && kotlin.jvm.internal.t.d(this.f3754c, r90Var.f3754c) && this.f3755d == r90Var.f3755d && this.f3756e == r90Var.f3756e && this.f3757f == r90Var.f3757f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z10 = this.f3752a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        Long l10 = this.f3753b;
        int iHashCode = (i10 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.f3754c;
        return androidx.compose.animation.a.a(this.f3757f) + ((androidx.compose.animation.a.a(this.f3756e) + ((androidx.compose.animation.a.a(this.f3755d) + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Config(isEnabled=" + this.f3752a + ", sdkDebuggerExpirationTime=" + this.f3753b + ", sdkDebuggerAuthCode=" + this.f3754c + ", sdkDebuggerFlushIntervalBytes=" + this.f3755d + ", sdkDebuggerFlushIntervalSeconds=" + this.f3756e + ", sdkDebuggerMaxPayloadBytes=" + this.f3757f + ')';
    }

    public r90(boolean z10, Long l10, String str, long j10, long j11, long j12) {
        this.f3752a = z10;
        this.f3753b = l10;
        this.f3754c = str;
        this.f3755d = j10;
        this.f3756e = j11;
        this.f3757f = j12;
    }
}
