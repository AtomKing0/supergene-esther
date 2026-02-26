package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import android.content.res.Resources;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntSize;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f20066a = new c();

    public final float a(int i10) {
        return i10 / Resources.getSystem().getDisplayMetrics().density;
    }

    @NotNull
    public final a.AbstractC0481a.c b(@NotNull LayoutCoordinates layoutCoordinates, @NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(layoutCoordinates, "<this>");
        t.i(buttonType, "buttonType");
        return new a.AbstractC0481a.c(buttonType, d(layoutCoordinates), f(layoutCoordinates));
    }

    @NotNull
    public final a.AbstractC0481a.f c(long j10) {
        return new a.AbstractC0481a.f(a((int) Offset.m1367getXimpl(j10)), a((int) Offset.m1368getYimpl(j10)));
    }

    @NotNull
    public final a.AbstractC0481a.f d(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        return new a.AbstractC0481a.f(a((int) Offset.m1367getXimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))), a((int) Offset.m1368getYimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))));
    }

    public final boolean e(@NotNull a.AbstractC0481a.c cVar) {
        t.i(cVar, "<this>");
        return cVar.e().a() > 0.0f && cVar.e().b() > 0.0f;
    }

    @NotNull
    public final a.AbstractC0481a.g f(@NotNull LayoutCoordinates layoutCoordinates) {
        t.i(layoutCoordinates, "<this>");
        return new a.AbstractC0481a.g(a(IntSize.m3833getWidthimpl(layoutCoordinates.mo2989getSizeYbymL2g())), a(IntSize.m3832getHeightimpl(layoutCoordinates.mo2989getSizeYbymL2g())));
    }
}
