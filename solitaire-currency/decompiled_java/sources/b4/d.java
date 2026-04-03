package b4;

import a4.c0;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DolbyVisionConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2092c;

    private d(int i10, int i11, String str) {
        this.f2090a = i10;
        this.f2091b = i11;
        this.f2092c = str;
    }

    @Nullable
    public static d a(c0 c0Var) {
        String str;
        c0Var.Q(2);
        int iD = c0Var.D();
        int i10 = iD >> 1;
        int iD2 = ((c0Var.D() >> 3) & 31) | ((iD & 1) << 5);
        if (i10 == 4 || i10 == 5 || i10 == 7) {
            str = "dvhe";
        } else if (i10 == 8) {
            str = "hev1";
        } else {
            if (i10 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i10);
        sb.append(iD2 >= 10 ? "." : ".0");
        sb.append(iD2);
        return new d(i10, iD2, sb.toString());
    }
}
