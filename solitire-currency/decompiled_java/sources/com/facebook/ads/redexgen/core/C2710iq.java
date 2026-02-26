package com.facebook.ads.redexgen.core;

import androidx.media3.common.C;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"NON_FINAL"}, value = "D54147219: For usage in Hero Simple Cache")
public final class C2710iq extends C1824Lx {
    public static byte[] A00;
    public static String[] A01 = {"OfRtwvXctRBBw9gKY8TWbFYEyrfTWUJ5", "O6KpU7VzQb47vbeRDg05X09dlcjSdrsx", "cGvb3Ixjw9glBryIXlKjYbTfS5Fhfs8X", "N3q9w52q7yAs4MQ92KFgaGGqaH957eGg", "tjYOyBogfVGQWArOceKhNo0cgBZwypsu", "xmSgRcjNSrQyzCd8Uu5cYZa5hRrGr9a8", "10tums6VyruOnAjrgpE7eJ8", "dQkd96lx4iAtJg2k9NqdAtWwc5SxpqrB"};
    public static final Pattern A02;
    public static final Pattern A03;
    public static final Pattern A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa A[PHI: r8
      0x00aa: PHI (r8v2 long) = (r8v0 long), (r8v3 long) binds: [B:30:0x00d7, B:25:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.core.C2710iq A01(java.io.File r14, long r15, long r17, com.facebook.ads.redexgen.core.M6 r19) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2710iq.A01(java.io.File, long, long, com.facebook.ads.redexgen.X.M6):com.facebook.ads.redexgen.X.iq");
    }

    public static String A07(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{93, -93, -21, -88, -93, -38, -19, -28, -28, -82, -76, -79, -81, -30, -76, -82, -30, -22, -79, -81, -30, -76, -82, -30, -22, -79, -81, -30, -76, -4, -73, -30, -76, -21, -2, -11, -86, -13, -67, -61, -64, -66, -15, -61, -67, -15, -7, -64, -66, -15, -61, -67, -15, -7, -64, -66, -15, -61, 11, -57, -15, -61, -6, 13, 4, -71, -40, -94, -42, -34, -91, -93, -42, -88, -94, -42, -34, -91, -93, -42, -88, -94, -42, -34, -91, -93, -42, -88, -16, -83, -42, -88, -33, -14, -23, -98};
    }

    static {
        A08();
        A02 = Pattern.compile(A07(8, 29, 103), 32);
        A03 = Pattern.compile(A07(37, 29, 118), 32);
        A04 = Pattern.compile(A07(66, 30, 91), 32);
    }

    public C2710iq(String str, long j10, long j11, long j12, File file) {
        super(str, j10, j11, j12, file);
    }

    public static C2710iq A02(File file, long j10, M6 m62) {
        return A01(file, j10, C.TIME_UNSET, m62);
    }

    public static C2710iq A03(String str, long j10) {
        return new C2710iq(str, j10, -1L, C.TIME_UNSET, null);
    }

    public static C2710iq A04(String str, long j10, long j11) {
        return new C2710iq(str, j10, j11, C.TIME_UNSET, null);
    }

    public static File A05(File file, int i10, long j10, long j11) {
        StringBuilder sbAppend = new StringBuilder().append(i10);
        String strA07 = A07(0, 1, 16);
        return new File(file, sbAppend.append(strA07).append(j10).append(strA07).append(j11).append(A07(1, 7, 86)).toString());
    }

    public static File A06(File file, M6 m62) {
        String strA0l = null;
        String name = file.getName();
        Matcher matcher = A03.matcher(name);
        if (matcher.matches()) {
            String key = matcher.group(1);
            strA0l = AbstractC13764a.A0l((String) C3M.A01(key));
        } else {
            matcher = A02.matcher(name);
            if (matcher.matches()) {
                String key2 = matcher.group(1);
                Object objA01 = C3M.A01(key2);
                String[] strArr = A01;
                String filename = strArr[0];
                if (filename.charAt(16) == strArr[2].charAt(16)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[0] = "SH9gvm8hJK4XlSeUgFI9DN0CGl9RiOAn";
                strArr2[2] = "6Y4JW5a7TLCjGmr1nVotQhjybpiv9cHJ";
                strA0l = (String) objA01;
            }
        }
        if (strA0l == null) {
            return null;
        }
        File file2 = (File) C3M.A02(file.getParentFile());
        int iA0B = m62.A0B(strA0l);
        String key3 = matcher.group(2);
        long j10 = Long.parseLong((String) C3M.A01(key3));
        String key4 = matcher.group(3);
        File fileA05 = A05(file2, iA0B, j10, Long.parseLong((String) C3M.A01(key4)));
        if (!file.renameTo(fileA05)) {
            return null;
        }
        return fileA05;
    }

    public final C2710iq A09(File file, long j10) {
        C3M.A08(this.A05);
        return new C2710iq(this.A04, this.A02, this.A01, j10, file);
    }
}
