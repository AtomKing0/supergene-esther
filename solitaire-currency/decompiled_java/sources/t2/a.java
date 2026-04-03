package t2;

import a4.c0;
import androidx.media3.common.MimeTypes;
import java.util.Collections;
import k2.j2;
import k2.o1;
import m2.a;
import p2.e0;
import t2.e;

/* JADX INFO: compiled from: AudioTagPayloadReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f34033e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34036d;

    public a(e0 e0Var) {
        super(e0Var);
    }

    @Override // t2.e
    protected boolean b(c0 c0Var) throws e.a {
        if (this.f34034b) {
            c0Var.Q(1);
        } else {
            int iD = c0Var.D();
            int i10 = (iD >> 4) & 15;
            this.f34036d = i10;
            if (i10 == 2) {
                this.f34057a.f(new o1.b().e0(MimeTypes.AUDIO_MPEG).H(1).f0(f34033e[(iD >> 2) & 3]).E());
                this.f34035c = true;
            } else if (i10 == 7 || i10 == 8) {
                this.f34057a.f(new o1.b().e0(i10 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).H(1).f0(8000).E());
                this.f34035c = true;
            } else if (i10 != 10) {
                throw new e.a("Audio format not supported: " + this.f34036d);
            }
            this.f34034b = true;
        }
        return true;
    }

    @Override // t2.e
    protected boolean c(c0 c0Var, long j10) throws j2 {
        if (this.f34036d == 2) {
            int iA = c0Var.a();
            this.f34057a.e(c0Var, iA);
            this.f34057a.a(j10, 1, iA, 0, null);
            return true;
        }
        int iD = c0Var.D();
        if (iD != 0 || this.f34035c) {
            if (this.f34036d == 10 && iD != 1) {
                return false;
            }
            int iA2 = c0Var.a();
            this.f34057a.e(c0Var, iA2);
            this.f34057a.a(j10, 1, iA2, 0, null);
            return true;
        }
        int iA3 = c0Var.a();
        byte[] bArr = new byte[iA3];
        c0Var.j(bArr, 0, iA3);
        a.b bVarE = m2.a.e(bArr);
        this.f34057a.f(new o1.b().e0(MimeTypes.AUDIO_AAC).I(bVarE.f31146c).H(bVarE.f31145b).f0(bVarE.f31144a).T(Collections.singletonList(bArr)).E());
        this.f34035c = true;
        return false;
    }
}
