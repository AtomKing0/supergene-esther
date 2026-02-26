package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import h9.a;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CardKt {
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Card-9VG74zQ, reason: not valid java name */
    public static final void m913Card9VG74zQ(@NotNull a<k0> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j10, long j11, @Nullable BorderStroke borderStroke, float f10, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z10, @Nullable String str, @Nullable Role role, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11, int i12) {
        MutableInteractionSource mutableInteractionSource2;
        t.i(onClick, "onClick");
        t.i(content, "content");
        composer.startReplaceableGroup(1353606722);
        Modifier modifier2 = (i12 & 2) != 0 ? Modifier.Companion : modifier;
        Shape medium = (i12 & 4) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM955getSurface0d7_KjU = (i12 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j10;
        long jM969contentColorForek8zF_U = (i12 & 16) != 0 ? ColorsKt.m969contentColorForek8zF_U(jM955getSurface0d7_KjU, composer, (i10 >> 9) & 14) : j11;
        BorderStroke borderStroke2 = (i12 & 32) != 0 ? null : borderStroke;
        float fM3673constructorimpl = (i12 & 64) != 0 ? Dp.m3673constructorimpl(1) : f10;
        if ((i12 & 128) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        SurfaceKt.m1146Surface9VG74zQ(onClick, modifier2, medium, jM955getSurface0d7_KjU, jM969contentColorForek8zF_U, borderStroke2, fM3673constructorimpl, mutableInteractionSource2, (i12 & 256) != 0 ? (Indication) composer.consume(IndicationKt.getLocalIndication()) : indication, (i12 & 512) != 0 ? true : z10, (i12 & 1024) != 0 ? null : str, (i12 & 2048) != 0 ? null : role, content, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), (i11 & 14) | (i11 & 112) | (i11 & 896), 0);
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Card-F-jzlyU, reason: not valid java name */
    public static final void m914CardFjzlyU(@Nullable Modifier modifier, @Nullable Shape shape, long j10, long j11, @Nullable BorderStroke borderStroke, float f10, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        t.i(content, "content");
        composer.startReplaceableGroup(1956755640);
        Modifier modifier2 = (i11 & 1) != 0 ? Modifier.Companion : modifier;
        Shape medium = (i11 & 2) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM955getSurface0d7_KjU = (i11 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j10;
        SurfaceKt.m1147SurfaceFjzlyU(modifier2, medium, jM955getSurface0d7_KjU, (i11 & 8) != 0 ? ColorsKt.m969contentColorForek8zF_U(jM955getSurface0d7_KjU, composer, (i10 >> 6) & 14) : j11, (i11 & 16) != 0 ? null : borderStroke, (i11 & 32) != 0 ? Dp.m3673constructorimpl(1) : f10, content, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (i10 & 3670016), 0);
        composer.endReplaceableGroup();
    }

    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Card-LPr_se0, reason: not valid java name */
    public static final void m915CardLPr_se0(@NotNull a<k0> onClick, @Nullable Modifier modifier, boolean z10, @Nullable Shape shape, long j10, long j11, @Nullable BorderStroke borderStroke, float f10, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        MutableInteractionSource mutableInteractionSource2;
        t.i(onClick, "onClick");
        t.i(content, "content");
        composer.startReplaceableGroup(778538979);
        Modifier modifier2 = (i11 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z11 = (i11 & 4) != 0 ? true : z10;
        Shape medium = (i11 & 8) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM955getSurface0d7_KjU = (i11 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j10;
        long jM969contentColorForek8zF_U = (i11 & 32) != 0 ? ColorsKt.m969contentColorForek8zF_U(jM955getSurface0d7_KjU, composer, (i10 >> 12) & 14) : j11;
        BorderStroke borderStroke2 = (i11 & 64) != 0 ? null : borderStroke;
        float fM3673constructorimpl = (i11 & 128) != 0 ? Dp.m3673constructorimpl(1) : f10;
        if ((i11 & 256) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        SurfaceKt.m1148SurfaceLPr_se0(onClick, modifier2, z11, medium, jM955getSurface0d7_KjU, jM969contentColorForek8zF_U, borderStroke2, fM3673constructorimpl, mutableInteractionSource2, content, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), 0);
        composer.endReplaceableGroup();
    }
}
