package n2;

import a4.o0;
import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: CryptoInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public byte[] f31561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f31562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public int[] f31564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public int[] f31565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f31567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f31568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f31569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final b f31570j;

    /* JADX INFO: compiled from: CryptoInfo.java */
    @RequiresApi(24)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f31571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f31572b;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i10, int i11) {
            this.f31572b.set(i10, i11);
            this.f31571a.setPattern(this.f31572b);
        }

        private b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f31571a = cryptoInfo;
            this.f31572b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f31569i = cryptoInfo;
        this.f31570j = o0.f214a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f31569i;
    }

    public void b(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f31564d == null) {
            int[] iArr = new int[1];
            this.f31564d = iArr;
            this.f31569i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f31564d;
        iArr2[0] = iArr2[0] + i10;
    }

    public void c(int i10, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i11, int i12, int i13) {
        this.f31566f = i10;
        this.f31564d = iArr;
        this.f31565e = iArr2;
        this.f31562b = bArr;
        this.f31561a = bArr2;
        this.f31563c = i11;
        this.f31567g = i12;
        this.f31568h = i13;
        MediaCodec.CryptoInfo cryptoInfo = this.f31569i;
        cryptoInfo.numSubSamples = i10;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i11;
        if (o0.f214a >= 24) {
            ((b) a4.a.e(this.f31570j)).b(i12, i13);
        }
    }
}
