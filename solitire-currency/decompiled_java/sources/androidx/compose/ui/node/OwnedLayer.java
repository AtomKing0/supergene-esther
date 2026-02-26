package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OwnedLayer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OwnedLayer {
    void destroy();

    void drawLayer(@NotNull Canvas canvas);

    void invalidate();

    /* JADX INFO: renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    boolean mo3142isInLayerk4lQ0M(long j10);

    void mapBounds(@NotNull MutableRect mutableRect, boolean z10);

    /* JADX INFO: renamed from: mapOffset-8S9VItk, reason: not valid java name */
    long mo3143mapOffset8S9VItk(long j10, boolean z10);

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    void mo3144movegyyYBs(long j10);

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    void mo3145resizeozmzZPI(long j10);

    void reuseLayer(@NotNull l<? super Canvas, k0> lVar, @NotNull h9.a<k0> aVar);

    void updateDisplayList();

    /* JADX INFO: renamed from: updateLayerProperties-NHXXZp8, reason: not valid java name */
    void mo3146updateLayerPropertiesNHXXZp8(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, @NotNull Shape shape, boolean z10, @Nullable RenderEffect renderEffect, long j11, long j12, @NotNull LayoutDirection layoutDirection, @NotNull Density density);
}
