package u2;

import p2.m;
import p2.w;

/* JADX INFO: compiled from: StartOffsetExtractorInput.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f34511b;

    public c(m mVar, long j10) {
        super(mVar);
        a4.a.a(mVar.getPosition() >= j10);
        this.f34511b = j10;
    }

    @Override // p2.w, p2.m
    public long getLength() {
        return super.getLength() - this.f34511b;
    }

    @Override // p2.w, p2.m
    public long getPeekPosition() {
        return super.getPeekPosition() - this.f34511b;
    }

    @Override // p2.w, p2.m
    public long getPosition() {
        return super.getPosition() - this.f34511b;
    }
}
