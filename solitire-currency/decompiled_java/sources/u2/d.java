package u2;

import p2.b0;
import p2.c0;
import p2.e0;
import p2.n;

/* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f34512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f34513b;

    /* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
    class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f34514a;

        a(b0 b0Var) {
            this.f34514a = b0Var;
        }

        @Override // p2.b0
        public long getDurationUs() {
            return this.f34514a.getDurationUs();
        }

        @Override // p2.b0
        public b0.a getSeekPoints(long j10) {
            b0.a seekPoints = this.f34514a.getSeekPoints(j10);
            c0 c0Var = seekPoints.f32444a;
            c0 c0Var2 = new c0(c0Var.f32449a, c0Var.f32450b + d.this.f34512a);
            c0 c0Var3 = seekPoints.f32445b;
            return new b0.a(c0Var2, new c0(c0Var3.f32449a, c0Var3.f32450b + d.this.f34512a));
        }

        @Override // p2.b0
        public boolean isSeekable() {
            return this.f34514a.isSeekable();
        }
    }

    public d(long j10, n nVar) {
        this.f34512a = j10;
        this.f34513b = nVar;
    }

    @Override // p2.n
    public void endTracks() {
        this.f34513b.endTracks();
    }

    @Override // p2.n
    public void h(b0 b0Var) {
        this.f34513b.h(new a(b0Var));
    }

    @Override // p2.n
    public e0 track(int i10, int i11) {
        return this.f34513b.track(i10, i11);
    }
}
