package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import h9.l;
import h9.p;
import h9.q;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidSelectionHandles_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ ResolvedTextDirection $direction;
        final /* synthetic */ boolean $handlesCrossed;
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Modifier modifier, boolean z10, ResolvedTextDirection resolvedTextDirection, boolean z11, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$isStartHandle = z10;
            this.$direction = resolvedTextDirection;
            this.$handlesCrossed = z11;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            AndroidSelectionHandles_androidKt.DefaultSelectionHandle(this.$modifier, this.$isStartHandle, this.$direction, this.$handlesCrossed, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
    static final class C09111 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ ResolvedTextDirection $direction;
        final /* synthetic */ boolean $handlesCrossed;
        final /* synthetic */ boolean $isStartHandle;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
        static final class C00701 extends v implements l<CacheDrawScope, DrawResult> {
            final /* synthetic */ ResolvedTextDirection $direction;
            final /* synthetic */ long $handleColor;
            final /* synthetic */ boolean $handlesCrossed;
            final /* synthetic */ boolean $isStartHandle;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
            static final class C00711 extends v implements l<ContentDrawScope, k0> {
                final /* synthetic */ ColorFilter $colorFilter;
                final /* synthetic */ ResolvedTextDirection $direction;
                final /* synthetic */ ImageBitmap $handleImage;
                final /* synthetic */ boolean $handlesCrossed;
                final /* synthetic */ boolean $isStartHandle;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00711(boolean z10, ResolvedTextDirection resolvedTextDirection, boolean z11, ImageBitmap imageBitmap, ColorFilter colorFilter) {
                    super(1);
                    this.$isStartHandle = z10;
                    this.$direction = resolvedTextDirection;
                    this.$handlesCrossed = z11;
                    this.$handleImage = imageBitmap;
                    this.$colorFilter = colorFilter;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ContentDrawScope onDrawWithContent) {
                    t.i(onDrawWithContent, "$this$onDrawWithContent");
                    onDrawWithContent.drawContent();
                    if (!AndroidSelectionHandles_androidKt.isLeft(this.$isStartHandle, this.$direction, this.$handlesCrossed)) {
                        androidx.compose.ui.graphics.drawscope.b.A(onDrawWithContent, this.$handleImage, 0L, 0.0f, null, this.$colorFilter, 0, 46, null);
                        return;
                    }
                    ImageBitmap imageBitmap = this.$handleImage;
                    ColorFilter colorFilter = this.$colorFilter;
                    long jMo1995getCenterF1C5BW0 = onDrawWithContent.mo1995getCenterF1C5BW0();
                    DrawContext drawContext = onDrawWithContent.getDrawContext();
                    long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo2009scale0AR0LA0(-1.0f, 1.0f, jMo1995getCenterF1C5BW0);
                    androidx.compose.ui.graphics.drawscope.b.A(onDrawWithContent, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                    drawContext.getCanvas().restore();
                    drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00701(long j10, boolean z10, ResolvedTextDirection resolvedTextDirection, boolean z11) {
                super(1);
                this.$handleColor = j10;
                this.$isStartHandle = z10;
                this.$direction = resolvedTextDirection;
                this.$handlesCrossed = z11;
            }

            @Override // h9.l
            @NotNull
            public final DrawResult invoke(@NotNull CacheDrawScope drawWithCache) {
                t.i(drawWithCache, "$this$drawWithCache");
                return drawWithCache.onDrawWithContent(new C00711(this.$isStartHandle, this.$direction, this.$handlesCrossed, AndroidSelectionHandles_androidKt.createHandleImage(drawWithCache, Size.m1436getWidthimpl(drawWithCache.m1290getSizeNHjbRc()) / 2.0f), ColorFilter.Companion.m1639tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, null)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09111(boolean z10, ResolvedTextDirection resolvedTextDirection, boolean z11) {
            super(3);
            this.$isStartHandle = z10;
            this.$direction = resolvedTextDirection;
            this.$handlesCrossed = z11;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1538687176);
            Modifier modifierThen = composed.then(DrawModifierKt.drawWithCache(Modifier.Companion, new C00701(((TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m851getHandleColor0d7_KjU(), this.$isStartHandle, this.$direction, this.$handlesCrossed)));
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DefaultSelectionHandle(@NotNull Modifier modifier, boolean z10, @NotNull ResolvedTextDirection direction, boolean z11, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        t.i(direction, "direction");
        Composer composerStartRestartGroup = composer.startRestartGroup(47957398);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(direction) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i11 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m442sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), z10, direction, z11), composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, z10, direction, z11, i10));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: HandlePopup-ULxng0E, reason: not valid java name */
    public static final void m753HandlePopupULxng0E(long j10, @NotNull HandleReferencePoint handleReferencePoint, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        int i11;
        t.i(handleReferencePoint, "handleReferencePoint");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1409050158);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(j10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(handleReferencePoint) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i11 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            long jIntOffset = IntOffsetKt.IntOffset(c.c(Offset.m1367getXimpl(j10)), c.c(Offset.m1368getYimpl(j10)));
            IntOffset intOffsetM3782boximpl = IntOffset.m3782boximpl(jIntOffset);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(intOffsetM3782boximpl) | composerStartRestartGroup.changed(handleReferencePoint);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new HandlePositionProvider(handleReferencePoint, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidPopup_androidKt.Popup((HandlePositionProvider) objRememberedValue, null, new PopupProperties(false, false, false, null, true, false, 15, null), content, composerStartRestartGroup, (i11 << 3) & 7168, 2);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$HandlePopup$1(j10, handleReferencePoint, content, i10));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SelectionHandle-8fL75-g, reason: not valid java name */
    public static final void m754SelectionHandle8fL75g(long j10, boolean z10, @NotNull ResolvedTextDirection direction, boolean z11, @NotNull Modifier modifier, @Nullable p<? super Composer, ? super Integer, k0> pVar, @Nullable Composer composer, int i10) {
        int i11;
        t.i(direction, "direction");
        t.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-616295642);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(j10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(direction) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((57344 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((458752 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar) ? 131072 : 65536;
        }
        int i12 = i11;
        if ((i12 & 374491) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            m753HandlePopupULxng0E(j10, isLeft(z10, direction, z11) ? HandleReferencePoint.TopRight : HandleReferencePoint.TopLeft, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 732099485, true, new AndroidSelectionHandles_androidKt$SelectionHandle$1(pVar, modifier, z10, j10, i12, direction, z11)), composerStartRestartGroup, (i12 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandle$2(j10, z10, direction, z11, modifier, pVar, i10));
    }

    @NotNull
    public static final ImageBitmap createHandleImage(@NotNull CacheDrawScope cacheDrawScope, float f10) {
        t.i(cacheDrawScope, "<this>");
        int iCeil = ((int) Math.ceil(f10)) * 2;
        HandleImageCache handleImageCache = HandleImageCache.INSTANCE;
        ImageBitmap imageBitmap = handleImageCache.getImageBitmap();
        Canvas canvas = handleImageCache.getCanvas();
        CanvasDrawScope canvasDrawScope = handleImageCache.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || iCeil > imageBitmap.getWidth() || iCeil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m1773ImageBitmapx__hDU$default(iCeil, iCeil, ImageBitmapConfig.Companion.m1767getAlpha8_sVssgQ(), false, null, 24, null);
            handleImageCache.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            handleImageCache.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            handleImageCache.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long jSize = androidx.compose.ui.geometry.SizeKt.Size(imageBitmap2.getWidth(), imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM1998component4NHjbRc = drawParams.m1998component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m2001setSizeuvyYCjk(jSize);
        canvas2.save();
        androidx.compose.ui.graphics.drawscope.b.K(canvasDrawScope2, Color.Companion.m1624getBlack0d7_KjU(), 0L, canvasDrawScope2.mo1996getSizeNHjbRc(), 0.0f, null, null, BlendMode.Companion.m1521getClear0nO6VwU(), 58, null);
        androidx.compose.ui.graphics.drawscope.b.K(canvasDrawScope2, ColorKt.Color(4278190080L), Offset.Companion.m1383getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f10, f10), 0.0f, null, null, 0, 120, null);
        androidx.compose.ui.graphics.drawscope.b.x(canvasDrawScope2, ColorKt.Color(4278190080L), f10, OffsetKt.Offset(f10, f10), 0.0f, null, null, 0, 120, null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m2001setSizeuvyYCjk(jM1998component4NHjbRc);
        return imageBitmap2;
    }

    @NotNull
    public static final Modifier drawSelectionHandle(@NotNull Modifier modifier, boolean z10, @NotNull ResolvedTextDirection direction, boolean z11) {
        t.i(modifier, "<this>");
        t.i(direction, "direction");
        return ComposedModifierKt.composed$default(modifier, null, new C09111(z10, direction, z11), 1, null);
    }

    public static final boolean isHandleLtrDirection(@NotNull ResolvedTextDirection direction, boolean z10) {
        t.i(direction, "direction");
        return (direction == ResolvedTextDirection.Ltr && !z10) || (direction == ResolvedTextDirection.Rtl && z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isLeft(boolean z10, ResolvedTextDirection resolvedTextDirection, boolean z11) {
        return z10 ? isHandleLtrDirection(resolvedTextDirection, z11) : !isHandleLtrDirection(resolvedTextDirection, z11);
    }
}
