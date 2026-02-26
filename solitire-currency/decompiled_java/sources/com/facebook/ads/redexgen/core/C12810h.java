package com.facebook.ads.redexgen.core;

import android.os.Build;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C12810h extends C14346g {
    public static String[] A00 = {"4mrgyhu5NuMSfoRJ7wvth", "0QrbVGKHuGc2eSGsbm7N10peHve4GVgP", "Meba3O6SWeMBrZzPyfP10SBJe7jX", "3Oa5wanHMWuCrkjHvXNfwyLB0ZtCKHr4", "YOQh7xYBrfW2123ECT3lDkRgUFpenV07", "JuO7BKBrPjkMVs4", "5m", "UWhmaXdvjdchgK72Wd2HML9QO634NCpp"};

    public C12810h(C2387dL c2387dL) {
        super(c2387dL);
        setCarouselLayoutManager(c2387dL);
    }

    public FG getFullscreenCarouselRecyclerViewAdapter() {
        getAdapter();
        if (0 != 0) {
            getAdapter();
            return null;
        }
        if (A00[6].length() != 2) {
            throw new RuntimeException();
        }
        A00[2] = "XAsjP5XwQSgGjSaOGRXjEIyXW47w";
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.C14346g
    public C2567gI getLayoutManager() {
        return (C2567gI) super.getLayoutManager();
    }

    public QT getOnScrollListener() {
        return new OC(this);
    }

    private void setCarouselLayoutManager(C2387dL c2387dL) {
        C2567gI c2567gI = new C2567gI(c2387dL, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c2567gI.A1T(true);
        }
        super.setLayoutManager(c2567gI);
    }

    @Override // com.facebook.ads.redexgen.core.C14346g
    public void setLayoutManager(QO qo) {
    }
}
