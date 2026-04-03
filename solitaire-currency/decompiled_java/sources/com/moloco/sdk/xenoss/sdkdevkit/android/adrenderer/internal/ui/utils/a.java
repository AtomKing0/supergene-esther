package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f20060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f20061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f20062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f20063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f20064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final RoundedCornerShape f20065f;

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl(24);
        f20060a = fM3673constructorimpl;
        f20061b = Dp.m3673constructorimpl(4);
        f20062c = TextUnit.Companion.m3865getUnspecifiedXSAIIZE();
        f20063d = DpKt.m3695DpSizeYgX7TsA(fM3673constructorimpl, fM3673constructorimpl);
        f20064e = Color.m1597copywmQWz5c$default(Color.Companion.m1628getGray0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
        f20065f = RoundedCornerShapeKt.getCircleShape();
    }

    public static final float a() {
        return f20061b;
    }

    public static final long b() {
        return f20063d;
    }

    public static final long c() {
        return f20062c;
    }

    public static final long d() {
        return f20064e;
    }

    @NotNull
    public static final RoundedCornerShape e() {
        return f20065f;
    }
}
