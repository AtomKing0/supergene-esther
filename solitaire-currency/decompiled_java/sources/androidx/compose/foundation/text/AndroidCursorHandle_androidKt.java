package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.HandleReferencePoint;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.graphics.drawscope.c;
import androidx.compose.ui.unit.Dp;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight;
    private static final float CursorHandleWidth;
    private static final float Sqrt2 = 1.4142135f;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$DefaultCursorHandle$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Modifier modifier, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            AndroidCursorHandle_androidKt.DefaultCursorHandle(this.$modifier, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
    static final class C08961 extends v implements q<Modifier, Composer, Integer, Modifier> {
        public static final C08961 INSTANCE = new C08961();

        /* JADX INFO: renamed from: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
        static final class C00571 extends v implements l<CacheDrawScope, DrawResult> {
            final /* synthetic */ long $handleColor;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
            static final class C00581 extends v implements l<ContentDrawScope, k0> {
                final /* synthetic */ ColorFilter $colorFilter;
                final /* synthetic */ ImageBitmap $imageBitmap;
                final /* synthetic */ float $radius;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00581(float f10, ImageBitmap imageBitmap, ColorFilter colorFilter) {
                    super(1);
                    this.$radius = f10;
                    this.$imageBitmap = imageBitmap;
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
                    float f10 = this.$radius;
                    ImageBitmap imageBitmap = this.$imageBitmap;
                    ColorFilter colorFilter = this.$colorFilter;
                    DrawContext drawContext = onDrawWithContent.getDrawContext();
                    long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    DrawTransform transform = drawContext.getTransform();
                    c.g(transform, f10, 0.0f, 2, null);
                    transform.mo2008rotateUv8p0NA(45.0f, Offset.Companion.m1383getZeroF1C5BW0());
                    b.A(onDrawWithContent, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                    drawContext.getCanvas().restore();
                    drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00571(long j10) {
                super(1);
                this.$handleColor = j10;
            }

            @Override // h9.l
            @NotNull
            public final DrawResult invoke(@NotNull CacheDrawScope drawWithCache) {
                t.i(drawWithCache, "$this$drawWithCache");
                float fM1436getWidthimpl = Size.m1436getWidthimpl(drawWithCache.m1290getSizeNHjbRc()) / 2.0f;
                return drawWithCache.onDrawWithContent(new C00581(fM1436getWidthimpl, AndroidSelectionHandles_androidKt.createHandleImage(drawWithCache, fM1436getWidthimpl), ColorFilter.Companion.m1639tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, null)));
            }
        }

        C08961() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-2126899193);
            Modifier modifierThen = composed.then(DrawModifierKt.drawWithCache(Modifier.Companion, new C00571(((TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m851getHandleColor0d7_KjU())));
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl(25);
        CursorHandleHeight = fM3673constructorimpl;
        CursorHandleWidth = Dp.m3673constructorimpl(Dp.m3673constructorimpl(fM3673constructorimpl * 2.0f) / 2.4142137f);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: CursorHandle-ULxng0E, reason: not valid java name */
    public static final void m649CursorHandleULxng0E(long j10, @NotNull Modifier modifier, @Nullable p<? super Composer, ? super Integer, k0> pVar, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-5185995);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(j10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar) ? 256 : 128;
        }
        if ((i11 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            AndroidSelectionHandles_androidKt.m753HandlePopupULxng0E(j10, HandleReferencePoint.TopMiddle, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1458480226, true, new AndroidCursorHandle_androidKt$CursorHandle$1(pVar, modifier, i11)), composerStartRestartGroup, (i11 & 14) | 432);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidCursorHandle_androidKt$CursorHandle$2(j10, modifier, pVar, i10));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DefaultCursorHandle(@NotNull Modifier modifier, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(694251107);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            SpacerKt.Spacer(drawCursorHandle(SizeKt.m442sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight)), composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier, i10));
    }

    @NotNull
    public static final Modifier drawCursorHandle(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, null, C08961.INSTANCE, 1, null);
    }

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }
}
