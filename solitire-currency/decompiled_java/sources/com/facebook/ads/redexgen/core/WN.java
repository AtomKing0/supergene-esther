package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlayAdError;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WN {
    public static byte[] A00;
    public static String[] A01 = {"T4dPy6oALRnRtXie0LYtNa7PXoaz5xNV", "GuB", "", "N5ZcwGbFLOfjQt8i7LOYdNhhAY9bfZ8J", "XGEF2r9HzP4eyBZiq0puzcaX55o", "r68Pu4BAqG0jUrZ19Ek7iVXcY822rh1q", "w97ZnD7u", "Y1Vl"};

    public static String A07(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{77, 66, 83, 74, 78, 56, 77, 83, 95, 73, 79, 89, 94, 73, 83, 88, 67, 71, 73, 66, 84, 91, 74, 82, 69, 70, 74, 84, 81, 74, 86, 90, 91, 65, 80, 91, 65, 85, 87, 90, 90, 83, 68, 73, 82, 89, 91, 87, 95, 88, 88, 122, 117, 60, 111, 59, 104, 111, 122, 105, 111, 59, 90, 110, 127, 114, 126, 117, 120, 126, 85, 126, 111, 108, 116, 105, 112, 90, 120, 111, 114, 109, 114, 111, 98, 53, 59, 86, 122, 112, 126, 59, 104, 110, 105, 126, 59, 111, 115, 122, 111, 59, 114, 111, 60, 104, 59, 114, 117, 59, 98, 116, 110, 105, 59, 90, 117, 127, 105, 116, 114, 127, 86, 122, 117, 114, 125, 126, 104, 111, 53, 99, 118, 119, 59, 125, 114, 119, 126, 53, 28, 1, 13, 11, 24, 6, 12, 11, 21, 21, 17, 18, 38, 55, 58, 54, 61, 48, 54, 29, 54, 39, 36, 60, 33, 56, 26, 104, 64, 79, 126, 64, 66, 85, 72, 87, 72, 85, 88, 41, 38, 44, 58, 39, 33, 44, 36, 43, 33, 55, 42, 44, 33, 107, 44, 43, 49, 32, 43, 49, 107, 36, 38, 49, 44, 42, 43, 107, 19, 12, 0, 18, 58, 53, 63, 41, 52, 50, 63, 117, 50, 53, 47, 62, 53, 47, 117, 56, 58, 47, 62, 60, 52, 41, 34, 117, 25, 9, 20, 12, 8, 26, 25, 23, 30, 112, 125, 125, 126, 70, 86, 75, 83, 87, 65, 86, 113, 118, 104, 50, 48, 61, 61, 52, 35, 24, 53, 20, 22, 27, 27, 18, 5, 35, 14, 7, 18, 54, 57, 60, 48, 59, 33, 1, 58, 62, 48, 59, 113, 125, 127, 60, 115, 124, 118, 96, 125, 123, 118, 60, 112, 96, 125, 101, 97, 119, 96, 60, 115, 98, 98, 126, 123, 113, 115, 102, 123, 125, 124, 77, 123, 118, 15, 3, 1, 66, 13, 2, 8, 30, 3, 5, 8, 66, 26, 9, 2, 8, 5, 2, 11, 103, 107, 105, 42, 98, 101, 103, 97, 102, 107, 107, 111, 42, 99, 107, 107, 99, 104, 97, 116, 104, 101, 125, 119, 112, 107, 118, 97, 101, 106, 42, 67, 107, 107, 99, 104, 97, 84, 104, 101, 125, 87, 112, 107, 118, 97, 69, 74, 75, 114, 97, 118, 104, 101, 125, 65, 124, 112, 97, 118, 106, 101, 104, 69, 103, 112, 109, 114, 109, 112, 125, 109, 97, 99, 32, 104, 111, 109, 107, 108, 97, 97, 101, 32, 101, 111, 122, 111, 96, 111, 66, 78, 79, 71, 72, 70, 126, 82, 84, 81, 81, 78, 83, 85, 82, 108, 84, 77, 85, 72, 118, 72, 79, 69, 78, 86, 3, 15, 14, 6, 9, 7, 63, 19, 21, 16, 16, 15, 18, 20, 19, 51, 16, 12, 9, 20, 51, 3, 18, 5, 5, 14, 45, 21, 12, 20, 9, 55, 9, 14, 4, 15, 23, 5, 20, 3, 7, 18, 3, 57, 8, 3, 17, 57, 18, 7, 4, 75, 79, 4, 11, 14, 22, 7, 16, 7, 6, 61, 1, 14, 11, 1, 9, 61, 6, 7, 14, 3, 27, 61, 15, 17, 39, 46, 33, 43, 35, 42, 61, 27, 38, 34, 42, 23, 11, 11, 15, 36, 56, 56, 60, 118, 99, 99, 60, 32, 45, 53, 98, 43, 35, 35, 43, 32, 41, 98, 47, 35, 33, 99, 63, 56, 35, 62, 41, 99, 45, 60, 60, 63, 99, 38, 58, 58, 62, 61, 82, 78, 78, 74, 73, 0, 21, 21, 74, 86, 91, 67, 20, 93, 85, 85, 93, 86, 95, 20, 89, 85, 87, 21, 94, 5, 24, 21, 64, 71, 90, 93, 72, 71, 93, 118, 78, 72, 68, 76, 90, 61, 39, 11, 55, 53, 55, 11, 50, 61, 56, 32, 49, 38, 11, 55, 56, 61, 55, 63, 39, 11, 59, 58, 11, 55, 32, 53, 13, 23, 59, 7, 22, 1, 5, 16, 13, 18, 1, 59, 5, 23, 59, 7, 16, 5, 59, 18, 86, 106, 102, 117, 108, 98, 115, 85, 76, 95, 72, 86, 91, 67, 57, 37, 40, 48, 103, 46, 38, 38, 46, 37, 44, 103, 42, 38, 36, 53, 34, 52, 46, 61, 34, 10, 40, 35, 34, 35, 56, 63, 39, 35, 51, 31, 50, 65, 94, 82, 64, 99, 78, 71, 82};
    }

    static {
        A09();
    }

    private int A00(C2387dL c2387dL) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = c2387dL.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(A07(412, 19, 65), 0)) != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                return Integer.parseInt(packageInfo.versionName.split(A07(166, 2, 9), 2)[0]);
            }
            return -1;
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            return -1;
        }
    }

    public static Intent A01(Uri uri) {
        Intent intent = new Intent(A07(186, 26, 10), uri);
        intent.setComponent(null);
        intent.setSelector(null);
        return intent;
    }

    public static Intent A02(C2387dL c2387dL, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.addCategory(A07(212, 33, 20));
        intentA01.addFlags(268435456);
        intentA01.putExtra(A07(288, 34, 93), c2387dL.getPackageName());
        intentA01.putExtra(A07(494, 14, 41), false);
        if (U7.A1y(c2387dL)) {
            if (A07(508, 2, 98).equals(uri.getScheme())) {
                intentA01.setPackage(A07(412, 19, 65));
            }
        }
        return intentA01;
    }

    public static Intent A03(C2387dL c2387dL, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.setPackage(A07(322, 19, 35));
        intentA01.putExtra(A07(259, 8, 30), c2387dL.getPackageName());
        intentA01.putExtra(A07(682, 7, 117), true);
        return intentA01;
    }

    public static Uri A04(C2387dL c2387dL, Uri uri) {
        boolean zEquals = A07(676, 6, 72).equals(uri.getScheme());
        String strA07 = A07(587, 26, 117);
        if (zEquals) {
            return WQ.A00(strA07 + uri.getEncodedQuery());
        }
        if (uri.toString().startsWith(strA07)) {
            return uri;
        }
        c2387dL.A0F().AB3(5);
        return null;
    }

    private final ME A05(C2387dL c2387dL, Uri uri, String str, Map<String, String> map) throws W9 {
        boolean zA05 = U8.A05(c2387dL);
        boolean isInAppBrowserEnabled = A0F(uri);
        if (isInAppBrowserEnabled && zA05) {
            A0C(c2387dL, uri, str, map);
            ME me = ME.A08;
            if (A01[7].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "";
            strArr[1] = "Q7p";
            return me;
        }
        c2387dL.A0F().A9p(zA05);
        A0A(c2387dL, uri);
        return ME.A07;
    }

    public static ME A06(WN wn, C2387dL c2387dL, Uri uri, String str, Map<String, String> extraData) throws W9 {
        boolean z10 = A0F(uri) && A07(689, 15, 6).equals(uri.getHost());
        boolean isGooglePlayWebLink = A07(676, 6, 72).equals(uri.getScheme());
        if (!isGooglePlayWebLink && !z10) {
            return wn.A05(c2387dL, uri, str, extraData);
        }
        try {
            wn.A0B(c2387dL, uri, str);
            return ME.A03;
        } catch (WL unused) {
            return wn.A05(c2387dL, uri, str, extraData);
        }
    }

    private String A08(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    private void A0A(C2387dL c2387dL, Uri uri) throws W9 {
        WB.A0D(c2387dL, A02(c2387dL, uri));
    }

    private final void A0B(C2387dL c2387dL, Uri uri, String str) throws W9, WL {
        if (A0H(c2387dL)) {
            if (U7.A1H(c2387dL)) {
                String queryParameter = uri.getQueryParameter(A07(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE, 2, 62));
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (A01[3].charAt(29) != 'Z') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[4] = "AXwrjbGi2NqoDqohSkmHlyhQGK6";
                    strArr[6] = "xSKC0PNk";
                    String strA07 = A07(IronSourceError.ERROR_BN_LOAD_NO_CONFIG, 13, 102);
                    String packageName = uri.toString();
                    AbstractC1874Nw.A03(queryParameter, strA07, packageName);
                }
            }
            boolean z10 = (c2387dL.A0H().A01() && U7.A1b(c2387dL)) || (U7.A1z(c2387dL) && A0I(c2387dL));
            if (!z10) {
                boolean shouldTryToOpenSplitScreen = U7.A2L(c2387dL);
                if (shouldTryToOpenSplitScreen) {
                    boolean shouldTryToOpenSplitScreen2 = WB.A0E(c2387dL, A03(c2387dL, uri));
                    if (shouldTryToOpenSplitScreen2) {
                        return;
                    }
                }
            }
            boolean zA0M = A0M(c2387dL, uri, str);
            if (A01[3].charAt(29) != 'Z') {
                A01[7] = "w5Gj6271lmeoEbiTTMEsWTdaWp";
                if (zA0M) {
                    return;
                }
            } else {
                A01[3] = "TMuIQjN9vpUXBqY7VYY4Z8DVMg5lcZnK";
                if (zA0M) {
                    return;
                }
            }
            boolean shouldTryToOpenSplitScreen3 = A0K(c2387dL, uri);
            if (shouldTryToOpenSplitScreen3) {
                return;
            }
            Intent intentA02 = A02(c2387dL, uri);
            intentA02.setPackage(A07(322, 19, 35));
            if (Build.VERSION.SDK_INT >= 24 && z10) {
                intentA02.addFlags(268472320);
            }
            WB.A0D(c2387dL, intentA02);
            return;
        }
        throw new WL();
    }

    private void A0C(C2387dL c2387dL, Uri uri, String str, Map<String, String> map) {
        AdActivityIntent adActivityIntentA05 = WB.A05(c2387dL);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA05.addFlags(268435456);
        }
        adActivityIntentA05.putExtra(A07(722, 8, 120), EnumC2057Vb.A03);
        adActivityIntentA05.putExtra(A07(249, 10, 107), uri.toString());
        adActivityIntentA05.putExtra(A07(277, 11, 26), str);
        adActivityIntentA05.putExtra(A07(533, 11, 0), System.currentTimeMillis());
        if (map != null) {
            String strA07 = A07(267, 10, 56);
            adActivityIntentA05.putExtra(strA07, map.get(strA07));
            String strA072 = A07(655, 21, 43);
            adActivityIntentA05.putExtra(strA072, map.get(strA072));
            String strA073 = A07(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, 27, 27);
            adActivityIntentA05.putExtra(strA073, map.get(strA073));
            String strA074 = A07(510, 23, 45);
            adActivityIntentA05.putExtra(strA074, map.get(strA074));
            String strA075 = A07(714, 8, 25);
            String str2 = map.get(strA075);
            if (str2 != null) {
                adActivityIntentA05.putExtra(strA075, str2);
            }
        }
        try {
            WB.A0B(c2387dL, adActivityIntentA05);
        } catch (W9 e10) {
            Throwable cause = e10.getCause();
            W9 cause2 = e10;
            if (cause != null) {
                cause2 = e10.getCause();
            }
            c2387dL.A08().AAy(A07(168, 11, 110), AbstractC2000Sv.A0D, new C2001Sw(cause2));
            Log.e(A07(149, 17, 28), A07(50, 90, 84), cause2);
        }
    }

    public static void A0D(WN wn, C2387dL c2387dL, Uri uri, String str) {
        wn.A0N(c2387dL, uri, str);
    }

    public static void A0E(WN wn, C2387dL c2387dL, Uri uri, String str) throws W9 {
        A06(wn, c2387dL, uri, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0F(android.net.Uri r5) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            r4 = 0
            if (r1 < r0) goto L1f
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r0 = r0.isCleartextTrafficPermitted()
            if (r0 != 0) goto L1f
            android.security.NetworkSecurityPolicy r1 = android.security.NetworkSecurityPolicy.getInstance()
            java.lang.String r0 = r5.getHost()
            boolean r0 = r1.isCleartextTrafficPermitted(r0)
            if (r0 == 0) goto L45
        L1f:
            r0 = 1
        L20:
            java.lang.String r3 = r5.getScheme()
            if (r0 == 0) goto L35
            r2 = 544(0x220, float:7.62E-43)
            r1 = 4
            r0 = 48
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L43
        L35:
            r2 = 582(0x246, float:8.16E-43)
            r1 = 5
            r0 = 1
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L44
        L43:
            r4 = 1
        L44:
            return r4
        L45:
            r0 = 0
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.WN.A0F(android.net.Uri):boolean");
    }

    private boolean A0G(C2387dL c2387dL) {
        if (!U7.A1E(c2387dL)) {
            return false;
        }
        int deviceFBVersion = U7.A0E(c2387dL);
        int iA00 = A00(c2387dL);
        if (deviceFBVersion == -1 || iA00 == -1 || deviceFBVersion > iA00) {
            return false;
        }
        int i10 = Build.VERSION.SDK_INT;
        String[] strArr = A01;
        String str = strArr[4];
        String str2 = strArr[6];
        int length = str.length();
        int fbVersionWithGPOverlay = str2.length();
        if (length == fbVersionWithGPOverlay) {
            throw new RuntimeException();
        }
        A01[7] = "9F";
        if (i10 < 28) {
            return false;
        }
        String[] strArr2 = A01;
        String str3 = strArr2[2];
        String str4 = strArr2[1];
        int length2 = str3.length();
        int fbVersionWithGPOverlay2 = str4.length();
        if (length2 != fbVersionWithGPOverlay2) {
            String[] strArr3 = A01;
            strArr3[4] = "HTEWLbQNfCJbfH7LEcJTogLCYG9";
            strArr3[6] = "jIuteURS";
            return true;
        }
        return true;
    }

    private boolean A0H(C2387dL c2387dL) {
        Intent playStoreIntent = new Intent(A07(186, 26, 10), WQ.A00(A07(548, 34, 3)));
        Iterator<ResolveInfo> it = c2387dL.getPackageManager().queryIntentActivities(playStoreIntent, 0).iterator();
        do {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[5].charAt(7) != strArr[0].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "NqbTETCkL6wtg2G74gvKWlTJws9";
            strArr2[6] = "JszVyiBC";
            if (!zHasNext) {
                return false;
            }
        } while (!it.next().activityInfo.applicationInfo.packageName.equals(A07(322, 19, 35)));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[PHI: r0 r1 r5
      0x0079: PHI (r0v21 int) = (r0v17 int), (r0v25 int) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r1v15 java.lang.String) = (r1v12 java.lang.String), (r1v19 java.lang.String) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r5v2 java.lang.String) = (r5v0 java.lang.String), (r5v3 java.lang.String) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0I(com.facebook.ads.redexgen.core.C2387dL r12) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.WN.A0I(com.facebook.ads.redexgen.X.dL):boolean");
    }

    public static boolean A0J(C2387dL c2387dL) {
        ActivityInfo activityInfo;
        try {
            Activity activityA0E = c2387dL.A0E();
            PackageManager packageManager = c2387dL.getPackageManager();
            if (activityA0E == null || packageManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT > 32) {
                activityInfo = packageManager.getActivityInfo(activityA0E.getComponentName(), PackageManager.ComponentInfoFlags.of(0L));
            } else {
                activityInfo = packageManager.getActivityInfo(activityA0E.getComponentName(), 128);
            }
            Field declaredField = ActivityInfo.class.getDeclaredField(A07(704, 10, 8));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityInfo);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue() != 0;
            }
        } catch (PackageManager.NameNotFoundException | IllegalAccessException | NoSuchFieldException e10) {
            c2387dL.A0F().ABV(e10.getMessage());
        }
        return false;
    }

    public static boolean A0K(C2387dL c2387dL, Uri uri) {
        String strA07 = A07(322, 19, 35);
        if (!U7.A1G(c2387dL)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            c2387dL.A0F().AB3(1);
            return false;
        }
        PackageManager packageManager = c2387dL.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(strA07, 0);
            if (packageInfo != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                String[] strArrSplit = packageInfo.versionName.split(A07(166, 2, 9), 2);
                if (strArrSplit.length < 1) {
                    c2387dL.A0F().AB3(2);
                    return false;
                }
                if (Integer.parseInt(strArrSplit[0]) < U7.A0G(c2387dL)) {
                    c2387dL.A0F().AB3(3);
                    return false;
                }
            }
            Intent intent = new Intent(A07(186, 26, 10));
            String packageName = c2387dL.getPackageName();
            intent.setPackage(strA07);
            Uri hsdpUri = A04(c2387dL, uri);
            if (hsdpUri == null) {
                return false;
            }
            intent.setData(hsdpUri);
            intent.putExtra(A07(682, 7, 117), true);
            intent.putExtra(A07(259, 8, 30), packageName);
            if (intent.resolveActivity(packageManager) != null) {
                Activity activityA0E = c2387dL.A0E();
                if (activityA0E == null) {
                    activityA0E = ActivityUtils.A00();
                }
                if (activityA0E != null) {
                    activityA0E.startActivityForResult(intent, 945321098);
                    c2387dL.A0F().AB3(0);
                    return true;
                }
                c2387dL.A0F().AB3(7);
                return false;
            }
            LH lhA0F = c2387dL.A0F();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "";
            strArr2[1] = "uL3";
            lhA0F.AB3(6);
            return false;
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            c2387dL.A0F().AB3(4);
            return false;
        }
    }

    private boolean A0L(C2387dL c2387dL, Uri uri, String str) throws W9 {
        try {
            Activity activityA0E = c2387dL.A0E();
            String string = uri.toString();
            if (activityA0E != null && !TextUtils.isEmpty(string)) {
                Intent fbIntent = new Intent();
                if (U7.A1F(c2387dL)) {
                    String strA06 = AbstractC2662hy.A06(str);
                    if (TextUtils.isEmpty(strA06)) {
                        return false;
                    }
                    fbIntent.putExtra(A07(0, 20, 67), A08(strA06));
                }
                fbIntent.setComponent(new ComponentName(A07(412, 19, 65), A07(341, 71, 75)));
                fbIntent.putExtra(A07(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 9, 22), string);
                fbIntent.putExtra(A07(37, 13, 89), A08(A07(20, 17, 90)));
                if (!WB.A0E(c2387dL, fbIntent)) {
                    activityA0E.startActivityForResult(fbIntent, 2);
                    return true;
                }
                return true;
            }
            return false;
        } catch (ActivityNotFoundException | IllegalStateException e10) {
            c2387dL.A0F().AB2(e10.getMessage());
            return false;
        }
    }

    private boolean A0M(C2387dL c2387dL, Uri uri, String str) throws W9 {
        return A0G(c2387dL) && A0L(c2387dL, uri, str);
    }

    private final boolean A0N(C2387dL c2387dL, Uri uri, String str) {
        return WB.A0G(c2387dL, uri, str);
    }

    public static boolean A0O(WN wn, C2387dL c2387dL, Uri uri, String str) {
        try {
            A0E(wn, c2387dL, uri, str);
            return true;
        } catch (W9 e10) {
            Throwable cause = e10.getCause();
            W9 cause2 = e10;
            if (cause != null) {
                cause2 = e10.getCause();
            }
            c2387dL.A08().AAy(A07(168, 11, 110), AbstractC2000Sv.A05, new C2001Sw(cause2));
            return false;
        }
    }
}
