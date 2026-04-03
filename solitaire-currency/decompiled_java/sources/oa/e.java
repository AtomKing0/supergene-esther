package oa;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;

/* JADX INFO: compiled from: Http2.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f32134a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ua.f f32135b = ua.f.f34755d.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String[] f32136c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String[] f32137d = new String[64];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String[] f32138e;

    static {
        String[] strArr = new String[256];
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            String binaryString = Integer.toBinaryString(i11);
            t.h(binaryString, "toBinaryString(it)");
            strArr[i11] = q.F(ha.d.t("%8s", binaryString), ' ', '0', false, 4, null);
        }
        f32138e = strArr;
        String[] strArr2 = f32137d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = t.r("END_STREAM", "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i12 = 0;
        while (i12 < 3) {
            int i13 = iArr2[i12];
            i12++;
            int i14 = iArr[0];
            String[] strArr3 = f32137d;
            int i15 = i14 | i13;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) strArr3[i14]);
            sb.append('|');
            sb.append((Object) strArr3[i13]);
            strArr3[i15] = sb.toString();
            strArr3[i15 | 8] = ((Object) strArr3[i14]) + '|' + ((Object) strArr3[i13]) + "|PADDED";
        }
        int length = f32137d.length;
        while (i10 < length) {
            int i16 = i10 + 1;
            String[] strArr4 = f32137d;
            if (strArr4[i10] == null) {
                strArr4[i10] = f32138e[i10];
            }
            i10 = i16;
        }
    }

    private e() {
    }

    @NotNull
    public final String a(int i10, int i11) {
        String str;
        if (i11 == 0) {
            return "";
        }
        if (i10 != 2 && i10 != 3) {
            if (i10 == 4 || i10 == 6) {
                return i11 == 1 ? "ACK" : f32138e[i11];
            }
            if (i10 != 7 && i10 != 8) {
                String[] strArr = f32137d;
                if (i11 < strArr.length) {
                    str = strArr[i11];
                    t.f(str);
                } else {
                    str = f32138e[i11];
                }
                String str2 = str;
                return (i10 != 5 || (i11 & 4) == 0) ? (i10 != 0 || (i11 & 32) == 0) ? str2 : q.G(str2, "PRIORITY", "COMPRESSED", false, 4, null) : q.G(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return f32138e[i11];
    }

    @NotNull
    public final String b(int i10) {
        String[] strArr = f32136c;
        return i10 < strArr.length ? strArr[i10] : ha.d.t("0x%02x", Integer.valueOf(i10));
    }

    @NotNull
    public final String c(boolean z10, int i10, int i11, int i12, int i13) {
        return ha.d.t("%s 0x%08x %5d %-13s %s", z10 ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), b(i12), a(i12, i13));
    }
}
