package m;

import androidx.annotation.Px;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DecodeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f31103a = new h();

    /* JADX INFO: compiled from: DecodeUtils.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31104a;

        static {
            int[] iArr = new int[w.h.values().length];
            iArr[w.h.FILL.ordinal()] = 1;
            iArr[w.h.FIT.ordinal()] = 2;
            f31104a = iArr;
        }
    }

    private h() {
    }

    public static final int a(@Px int i10, @Px int i11, @Px int i12, @Px int i13, @NotNull w.h hVar) {
        int iMin;
        int iHighestOneBit = Integer.highestOneBit(i10 / i12);
        int iHighestOneBit2 = Integer.highestOneBit(i11 / i13);
        int i14 = a.f31104a[hVar.ordinal()];
        if (i14 == 1) {
            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
        } else {
            if (i14 != 2) {
                throw new v8.q();
            }
            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
        }
        return n9.o.e(iMin, 1);
    }

    public static final double b(@Px double d10, @Px double d11, @Px double d12, @Px double d13, @NotNull w.h hVar) {
        double d14 = d12 / d10;
        double d15 = d13 / d11;
        int i10 = a.f31104a[hVar.ordinal()];
        if (i10 == 1) {
            return Math.max(d14, d15);
        }
        if (i10 == 2) {
            return Math.min(d14, d15);
        }
        throw new v8.q();
    }

    public static final double c(@Px int i10, @Px int i11, @Px int i12, @Px int i13, @NotNull w.h hVar) {
        double d10 = ((double) i12) / ((double) i10);
        double d11 = ((double) i13) / ((double) i11);
        int i14 = a.f31104a[hVar.ordinal()];
        if (i14 == 1) {
            return Math.max(d10, d11);
        }
        if (i14 == 2) {
            return Math.min(d10, d11);
        }
        throw new v8.q();
    }
}
