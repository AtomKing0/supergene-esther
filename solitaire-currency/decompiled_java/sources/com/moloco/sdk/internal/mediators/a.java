package com.moloco.sdk.internal.mediators;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.Nullable;
import q9.d;
import q9.e;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final long a(@Nullable String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 76100) {
                if (iHashCode != 63085501) {
                    if (iHashCode == 347625656 && str.equals("LevelPlay")) {
                        return d.s(8, e.f33187e);
                    }
                } else if (str.equals("AdMob")) {
                    return d.s(8, e.f33187e);
                }
            } else if (str.equals("MAX")) {
                return d.s(8, e.f33187e);
            }
        }
        return d.s(60, e.f33187e);
    }

    public static final long b(@Nullable String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 76100) {
                if (iHashCode != 63085501) {
                    if (iHashCode == 347625656 && str.equals("LevelPlay")) {
                        return d.s(26, e.f33187e);
                    }
                } else if (str.equals("AdMob")) {
                    return d.s(26, e.f33187e);
                }
            } else if (str.equals("MAX")) {
                return d.s(26, e.f33187e);
            }
        }
        return d.s(60, e.f33187e);
    }

    public static final long c(@Nullable String str) {
        return t.d(str, "MAX") ? d.s(8, e.f33187e) : t.d(str, "AdMob") ? d.s(58, e.f33187e) : d.s(60, e.f33187e);
    }
}
