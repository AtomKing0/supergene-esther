package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3097pf {
    public final InterfaceC3102pk A00;
    public final String A01;
    public final Collection<C3111pu> A02;
    public final Collection<C3111pu> A03;
    public final List<Rect> A04;

    public C3097pf(String str, InterfaceC3102pk interfaceC3102pk, List<Rect> rects, Collection<C3111pu> collection, Collection<C3111pu> collection2) {
        this.A01 = str;
        this.A00 = interfaceC3102pk;
        this.A04 = new ArrayList(rects);
        this.A02 = collection;
        this.A03 = collection2;
    }
}
