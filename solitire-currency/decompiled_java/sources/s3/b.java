package s3;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SsaDialogueFormat.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33503e;

    private b(int i10, int i11, int i12, int i13, int i14) {
        this.f33499a = i10;
        this.f33500b = i11;
        this.f33501c = i12;
        this.f33502d = i13;
        this.f33503e = i14;
    }

    @Nullable
    public static b a(String str) {
        a4.a.a(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            String strE = e5.c.e(strArrSplit[i14].trim());
            strE.hashCode();
            switch (strE) {
                case "end":
                    i11 = i14;
                    break;
                case "text":
                    i13 = i14;
                    break;
                case "start":
                    i10 = i14;
                    break;
                case "style":
                    i12 = i14;
                    break;
            }
        }
        if (i10 == -1 || i11 == -1 || i13 == -1) {
            return null;
        }
        return new b(i10, i11, i12, i13, strArrSplit.length);
    }
}
