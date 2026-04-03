package x2;

import a4.t;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import p2.e0;

/* JADX INFO: compiled from: TrackEncryptionBox.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f35869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f35870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0.a f35871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final byte[] f35873e;

    public p(boolean z10, @Nullable String str, int i10, byte[] bArr, int i11, int i12, @Nullable byte[] bArr2) {
        a4.a.a((bArr2 == null) ^ (i10 == 0));
        this.f35869a = z10;
        this.f35870b = str;
        this.f35872d = i10;
        this.f35873e = bArr2;
        this.f35871c = new e0.a(a(str), bArr, i11, i12);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        byte b10 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    b10 = 0;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    b10 = 1;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    b10 = 2;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    b10 = 3;
                }
                break;
        }
        switch (b10) {
            case 0:
            case 1:
                return 2;
            default:
                t.i("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
