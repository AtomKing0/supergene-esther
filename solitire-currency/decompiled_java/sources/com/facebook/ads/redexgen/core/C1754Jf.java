package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1754Jf implements ZN {
    public static String[] A01 = {"Kf9IFIGkXS68FEluY8iO", "HZKyOot4e1aVyegaf8lIb0bgnGZodGvN", "MGWXSz8iondoAx3vwHSWPDz", "1vF28DvouTYuJpgxZbcCtj3BonOpfXf0", "hNMoe3gYfV5QWpuVljUPjUuKx8toPdic", "kDVCOfKU1nzjkl2JPkHRjE9k6FSheaPB", "SHeKxuODcoO7wzXqEy6VB5XREjq4nAxo", "ViwjD0ocXU7cRIhjEHnYvFil28fnYSUL"};
    public final /* synthetic */ JU A00;

    public C1754Jf(JU ju) {
        this.A00 = ju;
    }

    @Override // com.facebook.ads.redexgen.core.ZN
    public final void ACl() {
        this.A00.A0i(false);
    }

    @Override // com.facebook.ads.redexgen.core.ZN
    public final void AEL() {
        if (U7.A15(this.A00.getAdContextWrapper())) {
            JU ju = this.A00;
            String[] strArr = A01;
            if (strArr[2].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "KrFGzHoXsfsafO9ToSguPoB5cWeuxqIV";
            strArr2[4] = "kqOpGw0ynU1zwk9LjTPYr4TgjSNfVfpA";
            ju.A0N();
        }
    }
}
