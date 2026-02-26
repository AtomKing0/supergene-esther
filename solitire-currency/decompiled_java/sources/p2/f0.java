package p2;

import androidx.annotation.Nullable;
import java.io.IOException;
import p2.e0;

/* JADX INFO: compiled from: TrueHdSampleRechunker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f32475a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f32478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32481g;

    public void a(e0 e0Var, @Nullable e0.a aVar) {
        if (this.f32477c > 0) {
            e0Var.a(this.f32478d, this.f32479e, this.f32480f, this.f32481g, aVar);
            this.f32477c = 0;
        }
    }

    public void b() {
        this.f32476b = false;
        this.f32477c = 0;
    }

    public void c(e0 e0Var, long j10, int i10, int i11, int i12, @Nullable e0.a aVar) {
        a4.a.h(this.f32481g <= i11 + i12, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f32476b) {
            int i13 = this.f32477c;
            int i14 = i13 + 1;
            this.f32477c = i14;
            if (i13 == 0) {
                this.f32478d = j10;
                this.f32479e = i10;
                this.f32480f = 0;
            }
            this.f32480f += i11;
            this.f32481g = i12;
            if (i14 >= 16) {
                a(e0Var, aVar);
            }
        }
    }

    public void d(m mVar) throws IOException {
        if (this.f32476b) {
            return;
        }
        mVar.peekFully(this.f32475a, 0, 10);
        mVar.resetPeekPosition();
        if (m2.b.i(this.f32475a) == 0) {
            return;
        }
        this.f32476b = true;
    }
}
