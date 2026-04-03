package io.sentry.vendor;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: io.sentry.vendor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Base64.java */
    static abstract class AbstractC0589a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f28402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f28403b;

        AbstractC0589a() {
        }
    }

    /* JADX INFO: compiled from: Base64.java */
    static class b extends AbstractC0589a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final byte[] f28404j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final byte[] f28405k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f28406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f28407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f28408e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f28409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f28410g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f28411h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final byte[] f28412i;

        public b(int i10, byte[] bArr) {
            this.f28402a = bArr;
            this.f28409f = (i10 & 1) == 0;
            boolean z10 = (i10 & 2) == 0;
            this.f28410g = z10;
            this.f28411h = (i10 & 4) != 0;
            this.f28412i = (i10 & 8) == 0 ? f28404j : f28405k;
            this.f28406c = new byte[2];
            this.f28407d = 0;
            this.f28408e = z10 ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 478
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i10) {
        return b(bArr, 0, bArr.length, i10);
    }

    public static byte[] b(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, null);
        int i13 = (i11 / 3) * 4;
        if (!bVar.f28409f) {
            int i14 = i11 % 3;
            if (i14 == 1) {
                i13 += 2;
            } else if (i14 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (bVar.f28410g && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (bVar.f28411h ? 2 : 1);
        }
        bVar.f28402a = new byte[i13];
        bVar.a(bArr, i10, i11, true);
        return bVar.f28402a;
    }

    public static String c(byte[] bArr, int i10) {
        try {
            return new String(a(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
