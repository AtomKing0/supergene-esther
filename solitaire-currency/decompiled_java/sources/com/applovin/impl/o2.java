package com.applovin.impl;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z3 f6456a = new z3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TreeSet f6457b = new TreeSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f6458c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6460e;

    public o2(MaxAdPlacerSettings maxAdPlacerSettings) {
        a(maxAdPlacerSettings);
    }

    private void a(MaxAdPlacerSettings maxAdPlacerSettings) {
        if (!maxAdPlacerSettings.hasValidPositioning()) {
            com.applovin.impl.sdk.n.h("MaxAdPlacerData", "No positioning info was provided with ad placer settings. You must set at least (1) one or more fixed positions or (2) a repeating interval greater than or equal to 2 for the ad placer to determine where to position ads.");
            return;
        }
        this.f6456a.addAll(maxAdPlacerSettings.getFixedPositions());
        if (!maxAdPlacerSettings.isRepeatingEnabled()) {
            return;
        }
        int repeatingInterval = maxAdPlacerSettings.getRepeatingInterval();
        if (this.f6456a.isEmpty()) {
            this.f6456a.add(Integer.valueOf(repeatingInterval - 1));
        }
        int iIntValue = ((Integer) this.f6456a.a()).intValue();
        while (true) {
            iIntValue += repeatingInterval;
            if (this.f6456a.size() >= maxAdPlacerSettings.getMaxAdCount()) {
                return;
            } else {
                this.f6456a.add(Integer.valueOf(iIntValue));
            }
        }
    }

    public Collection b() {
        return new TreeSet((SortedSet) this.f6457b);
    }

    public int c() {
        int i10 = this.f6459d;
        if (i10 != -1 && this.f6460e != -1) {
            while (i10 <= this.f6460e) {
                if (g(i10) && !h(i10)) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public int d(int i10) {
        if (g(i10)) {
            return -1;
        }
        return i10 - a(i10, true);
    }

    public Collection e(int i10) {
        return new TreeSet((SortedSet) this.f6457b.tailSet(Integer.valueOf(i10), false));
    }

    public void f(int i10) {
        int iB = this.f6456a.b(Integer.valueOf(i10));
        for (int size = this.f6456a.size() - 1; size >= iB; size--) {
            Integer num = (Integer) this.f6456a.a(size);
            int iIntValue = num.intValue() + 1;
            a(num.intValue(), iIntValue);
            this.f6456a.a(size, Integer.valueOf(iIntValue));
        }
    }

    public boolean g(int i10) {
        return this.f6456a.contains(Integer.valueOf(i10));
    }

    public boolean h(int i10) {
        return this.f6457b.contains(Integer.valueOf(i10));
    }

    public void i(int i10) {
        int iB = this.f6456a.b(Integer.valueOf(i10));
        if (g(i10)) {
            this.f6458c.remove(Integer.valueOf(i10));
            this.f6457b.remove(Integer.valueOf(i10));
            this.f6456a.b(iB);
        }
        while (iB < this.f6456a.size()) {
            Integer num = (Integer) this.f6456a.a(iB);
            int iIntValue = num.intValue() - 1;
            a(num.intValue(), iIntValue);
            this.f6456a.a(iB, Integer.valueOf(iIntValue));
            iB++;
        }
    }

    public int b(int i10) {
        if (i10 == 0) {
            return 0;
        }
        return i10 + a(i10 - 1, false);
    }

    public void b(int i10, int i11) {
        i(i10);
        f(i11);
    }

    public void c(int i10, int i11) {
        this.f6459d = i10;
        this.f6460e = i11;
    }

    public int c(int i10) {
        return i10 + a(i10, false);
    }

    public MaxAd a(int i10) {
        return (MaxAd) this.f6458c.get(Integer.valueOf(i10));
    }

    public void a(MaxAd maxAd, int i10) {
        this.f6458c.put(Integer.valueOf(i10), maxAd);
        this.f6457b.add(Integer.valueOf(i10));
    }

    public void a() {
        this.f6458c.clear();
        this.f6457b.clear();
    }

    public void a(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            this.f6458c.remove(num);
            this.f6457b.remove(num);
        }
    }

    private void a(int i10, int i11) {
        if (this.f6458c.containsKey(Integer.valueOf(i10))) {
            this.f6458c.put(Integer.valueOf(i11), (MaxAd) this.f6458c.get(Integer.valueOf(i10)));
            this.f6457b.add(Integer.valueOf(i11));
            this.f6458c.remove(Integer.valueOf(i10));
            this.f6457b.remove(Integer.valueOf(i10));
        }
    }

    private int a(int i10, boolean z10) {
        int iC = this.f6456a.c(Integer.valueOf(i10));
        if (!z10) {
            int i11 = i10 + iC;
            while (iC < this.f6456a.size() && i11 >= ((Integer) this.f6456a.a(iC)).intValue()) {
                i11++;
                iC++;
            }
        }
        return iC;
    }
}
