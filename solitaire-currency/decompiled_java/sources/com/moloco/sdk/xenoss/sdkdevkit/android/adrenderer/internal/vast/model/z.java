package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.animation.core.AnimationConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes4.dex */
public enum z {
    XmlParsing(100),
    Wrapper(AnimationConstants.DefaultDurationMillis),
    WrapperTimeout(301),
    WrapperLimit(302),
    WrapperNoAds(303),
    Linear(400),
    LinearFileNotFound(401),
    LinearNotSupportedMedia(403),
    Companion(600),
    Undefined(TypedValues.Custom.TYPE_INT);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20721a;

    z(int i10) {
        this.f20721a = i10;
    }

    public final int c() {
        return this.f20721a;
    }
}
