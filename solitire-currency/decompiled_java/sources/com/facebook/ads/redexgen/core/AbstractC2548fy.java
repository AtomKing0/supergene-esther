package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2548fy extends QR {
    public static byte[] A03;
    public static String[] A04 = {"VI3k6vbyE", "wbKxmRtdnLanYPPQlq0AQ7UHjncjxjam", "7rHsxeXjhwTRluKKUSI3i7DNAgzyS", "RLsJgHk6VqLvU3GrilIJimxIkswsMvKT", "sHDfA32w1RYOD3HMFDMkWGxW2yjuY1ZH", "JEcuqbBofZsfD30FS8fTTaggCipMDK", "8NUawD4TiWbh8YzDjR1LHPIBKq0RidcG", "8EIjrQLLrDPWSel1MFlzfXR6TVhPBcGW"};
    public C14346g A00;
    public Scroller A01;
    public final QT A02 = new C2549fz(this);

    public static String A06(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A03 = new byte[]{-120, -75, 103, -80, -75, -70, -69, -88, -75, -86, -84, 103, -74, -83, 103, -106, -75, -115, -77, -80, -75, -82, -109, -80, -70, -69, -84, -75, -84, -71, 103, -88, -77, -71, -84, -88, -85, -64, 103, -70, -84, -69, 117};
    }

    public abstract int A0C(QO qo, int i10, int i11);

    public abstract View A0D(QO qo);

    @Deprecated
    public abstract C2566gH A0E(QO qo);

    public abstract int[] A0H(QO qo, View view);

    static {
        A09();
    }

    private final C2566gH A05(QO qo) {
        return A0E(qo);
    }

    private void A07() {
        this.A00.A1i(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A08() throws IllegalStateException {
        if (this.A00.getOnFlingListener() == null) {
            this.A00.A1h(this.A02);
            this.A00.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException(A06(0, 43, 56));
    }

    private boolean A0A(QO qo, int i10, int i11) {
        C2566gH c2566gHA05;
        int iA0C;
        if (!(qo instanceof InterfaceC1928Qa) || (c2566gHA05 = A05(qo)) == null || (iA0C = A0C(qo, i10, i11)) == -1) {
            return false;
        }
        c2566gHA05.A0A(iA0C);
        qo.A1N(c2566gHA05);
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.QR
    public final boolean A0B(int i10, int i11) {
        QO layoutManager = this.A00.getLayoutManager();
        if (layoutManager == null || this.A00.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.A00.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && A0A(layoutManager, i10, i11);
    }

    public final void A0F() {
        QO layoutManager;
        View viewA0D;
        if (this.A00 == null || (layoutManager = this.A00.getLayoutManager()) == null || (viewA0D = A0D(layoutManager)) == null) {
            return;
        }
        int[] iArrA0H = A0H(layoutManager, viewA0D);
        if (iArrA0H[0] != 0 || iArrA0H[1] != 0) {
            this.A00.A1e(iArrA0H[0], iArrA0H[1]);
        }
    }

    public final void A0G(C14346g c14346g) throws IllegalStateException {
        if (this.A00 == c14346g) {
            return;
        }
        C14346g c14346g2 = this.A00;
        if (A04[3].charAt(14) == 'w') {
            throw new RuntimeException();
        }
        A04[4] = "xzKGxret4GzWIxaR6oK37PWpSNYAUaFQ";
        if (c14346g2 != null) {
            A07();
        }
        this.A00 = c14346g;
        if (this.A00 != null) {
            A08();
            this.A01 = new Scroller(this.A00.getContext(), new DecelerateInterpolator());
            A0F();
        }
    }
}
