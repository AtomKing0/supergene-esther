package com.unity3d.player;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public class PlatformSupport {
    static final boolean MARSHMALLOW_SUPPORT;
    static final boolean NOUGAT_SUPPORT;
    static final boolean PIE_SUPPORT;
    static final boolean RED_VELVET_CAKE_SUPPORT;
    static final boolean SNOW_CONE_SUPPORT;
    static final boolean TIRAMISU_SUPPORT;
    static final boolean UPSIDE_DOWN_CAKE_SUPPORT;
    static final boolean VANILLA_ICE_CREAM_SUPPORT;

    static {
        int i10 = Build.VERSION.SDK_INT;
        MARSHMALLOW_SUPPORT = true;
        NOUGAT_SUPPORT = i10 >= 24;
        PIE_SUPPORT = i10 >= 28;
        RED_VELVET_CAKE_SUPPORT = i10 >= 30;
        SNOW_CONE_SUPPORT = i10 >= 31;
        TIRAMISU_SUPPORT = i10 >= 33;
        UPSIDE_DOWN_CAKE_SUPPORT = i10 >= 34;
        VANILLA_ICE_CREAM_SUPPORT = i10 >= 35;
    }
}
