package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class w40 extends zb0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w40(cc0 sessionId, double d10, Double d11, boolean z10) {
        super(sessionId, d10, d11, z10);
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
    }

    @Override // bo.app.zb0
    public final void a(Double d10) {
        this.f4423c = d10;
    }

    @Override // bo.app.zb0
    public final Double c() {
        return this.f4423c;
    }

    @Override // bo.app.zb0
    public final String toString() {
        return "\nMutableSession(sessionId=" + this.f4421a + ", startTime=" + this.f4422b + ", endTime=" + this.f4423c + ", isSealed=" + this.f4424d + ", duration=" + b() + ')';
    }
}
