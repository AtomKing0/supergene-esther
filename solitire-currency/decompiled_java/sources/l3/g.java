package l3;

/* JADX INFO: compiled from: CompositeSequenceableLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final v0[] f30535a;

    public g(v0[] v0VarArr) {
        this.f30535a = v0VarArr;
    }

    @Override // l3.v0
    public boolean a(long j10) {
        boolean zA;
        boolean z10 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zA = false;
            for (v0 v0Var : this.f30535a) {
                long nextLoadPositionUs2 = v0Var.getNextLoadPositionUs();
                boolean z11 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j10;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z11) {
                    zA |= v0Var.a(j10);
                }
            }
            z10 |= zA;
        } while (zA);
        return z10;
    }

    @Override // l3.v0
    public final long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (v0 v0Var : this.f30535a) {
            long bufferedPositionUs = v0Var.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // l3.v0
    public final long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (v0 v0Var : this.f30535a) {
            long nextLoadPositionUs = v0Var.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // l3.v0
    public boolean isLoading() {
        for (v0 v0Var : this.f30535a) {
            if (v0Var.isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // l3.v0
    public final void reevaluateBuffer(long j10) {
        for (v0 v0Var : this.f30535a) {
            v0Var.reevaluateBuffer(j10);
        }
    }
}
