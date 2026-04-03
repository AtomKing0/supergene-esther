package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BorderKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$border$2, reason: invalid class name */
    /* JADX INFO: compiled from: Border.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ Brush $brush;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ float $width;

        /* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$border$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Border.kt */
        static final class AnonymousClass1 extends v implements h9.l<CacheDrawScope, DrawResult> {
            final /* synthetic */ Ref<BorderCache> $borderCacheRef;
            final /* synthetic */ Brush $brush;
            final /* synthetic */ Shape $shape;
            final /* synthetic */ float $width;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(float f10, Shape shape, Ref<BorderCache> ref, Brush brush) {
                super(1);
                this.$width = f10;
                this.$shape = shape;
                this.$borderCacheRef = ref;
                this.$brush = brush;
            }

            @Override // h9.l
            @NotNull
            public final DrawResult invoke(@NotNull CacheDrawScope drawWithCache) {
                t.i(drawWithCache, "$this$drawWithCache");
                if (!(drawWithCache.mo296toPx0680j_4(this.$width) >= 0.0f && Size.m1435getMinDimensionimpl(drawWithCache.m1290getSizeNHjbRc()) > 0.0f)) {
                    return BorderKt.drawContentWithoutBorder(drawWithCache);
                }
                float f10 = 2;
                float fMin = Math.min(Dp.m3678equalsimpl0(this.$width, Dp.Companion.m3691getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(drawWithCache.mo296toPx0680j_4(this.$width)), (float) Math.ceil(Size.m1435getMinDimensionimpl(drawWithCache.m1290getSizeNHjbRc()) / f10));
                float f11 = fMin / f10;
                long jOffset = OffsetKt.Offset(f11, f11);
                long jSize = SizeKt.Size(Size.m1436getWidthimpl(drawWithCache.m1290getSizeNHjbRc()) - fMin, Size.m1433getHeightimpl(drawWithCache.m1290getSizeNHjbRc()) - fMin);
                boolean z10 = f10 * fMin > Size.m1435getMinDimensionimpl(drawWithCache.m1290getSizeNHjbRc());
                Outline outlineMo201createOutlinePq9zytI = this.$shape.mo201createOutlinePq9zytI(drawWithCache.m1290getSizeNHjbRc(), drawWithCache.getLayoutDirection(), drawWithCache);
                if (outlineMo201createOutlinePq9zytI instanceof Outline.Generic) {
                    return BorderKt.drawGenericBorder(drawWithCache, this.$borderCacheRef, this.$brush, (Outline.Generic) outlineMo201createOutlinePq9zytI, z10, fMin);
                }
                if (outlineMo201createOutlinePq9zytI instanceof Outline.Rounded) {
                    return BorderKt.m175drawRoundRectBorderSYlcjDY(drawWithCache, this.$borderCacheRef, this.$brush, (Outline.Rounded) outlineMo201createOutlinePq9zytI, jOffset, jSize, z10, fMin);
                }
                if (outlineMo201createOutlinePq9zytI instanceof Outline.Rectangle) {
                    return BorderKt.m174drawRectBorderNsqcLGU(drawWithCache, this.$brush, jOffset, jSize, z10, fMin);
                }
                throw new v8.q();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f10, Shape shape, Brush brush) {
            super(3);
            this.$width = f10;
            this.$shape = shape;
            this.$brush = brush;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1498088849);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Ref();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierThen = composed.then(DrawModifierKt.drawWithCache(Modifier.Companion, new AnonymousClass1(this.$width, this.$shape, (Ref) objRememberedValue, this.$brush)));
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1, reason: invalid class name */
    /* JADX INFO: compiled from: Border.kt */
    static final class AnonymousClass1 extends v implements h9.l<ContentDrawScope, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
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
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$drawGenericBorder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Border.kt */
    static final class C08231 extends v implements h9.l<ContentDrawScope, k0> {
        final /* synthetic */ Brush $brush;
        final /* synthetic */ Outline.Generic $outline;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08231(Outline.Generic generic, Brush brush) {
            super(1);
            this.$outline = generic;
            this.$brush = brush;
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
            androidx.compose.ui.graphics.drawscope.b.F(onDrawWithContent, this.$outline.getPath(), this.$brush, 0.0f, null, null, 0, 60, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$drawGenericBorder$3, reason: invalid class name */
    /* JADX INFO: compiled from: Border.kt */
    static final class AnonymousClass3 extends v implements h9.l<ContentDrawScope, k0> {
        final /* synthetic */ n0<ImageBitmap> $cacheImageBitmap;
        final /* synthetic */ ColorFilter $colorFilter;
        final /* synthetic */ Rect $pathBounds;
        final /* synthetic */ long $pathBoundsSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Rect rect, n0<ImageBitmap> n0Var, long j10, ColorFilter colorFilter) {
            super(1);
            this.$pathBounds = rect;
            this.$cacheImageBitmap = n0Var;
            this.$pathBoundsSize = j10;
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
            float left = this.$pathBounds.getLeft();
            float top = this.$pathBounds.getTop();
            n0<ImageBitmap> n0Var = this.$cacheImageBitmap;
            long j10 = this.$pathBoundsSize;
            ColorFilter colorFilter = this.$colorFilter;
            onDrawWithContent.getDrawContext().getTransform().translate(left, top);
            androidx.compose.ui.graphics.drawscope.b.z(onDrawWithContent, n0Var.f29834a, 0L, j10, 0L, 0L, 0.0f, null, colorFilter, 0, 0, 890, null);
            onDrawWithContent.getDrawContext().getTransform().translate(-left, -top);
        }
    }

    @NotNull
    public static final Modifier border(@NotNull Modifier modifier, @NotNull BorderStroke border, @NotNull Shape shape) {
        t.i(modifier, "<this>");
        t.i(border, "border");
        t.i(shape, "shape");
        return m173borderziNgDLE(modifier, border.m179getWidthD9Ej5fM(), border.getBrush(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    @NotNull
    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m171borderxT4_qwU(@NotNull Modifier border, float f10, long j10, @NotNull Shape shape) {
        t.i(border, "$this$border");
        t.i(shape, "shape");
        return m173borderziNgDLE(border, f10, new SolidColor(j10, null), shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m172borderxT4_qwU$default(Modifier modifier, float f10, long j10, Shape shape, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m171borderxT4_qwU(modifier, f10, j10, shape);
    }

    @NotNull
    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m173borderziNgDLE(@NotNull Modifier border, float f10, @NotNull Brush brush, @NotNull Shape shape) {
        t.i(border, "$this$border");
        t.i(brush, "brush");
        t.i(shape, "shape");
        return ComposedModifierKt.composed(border, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(f10, brush, shape) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(f10, shape, brush));
    }

    private static final RoundRect createInsetRoundedRect(float f10, RoundRect roundRect) {
        return new RoundRect(f10, f10, roundRect.getWidth() - f10, roundRect.getHeight() - f10, m176shrinkKibmq7A(roundRect.m1417getTopLeftCornerRadiuskKHJgLs(), f10), m176shrinkKibmq7A(roundRect.m1418getTopRightCornerRadiuskKHJgLs(), f10), m176shrinkKibmq7A(roundRect.m1416getBottomRightCornerRadiuskKHJgLs(), f10), m176shrinkKibmq7A(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs(), f10), null);
    }

    private static final Path createRoundRectPath(Path path, RoundRect roundRect, float f10, boolean z10) {
        path.reset();
        path.addRoundRect(roundRect);
        if (!z10) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect(createInsetRoundedRect(f10, roundRect));
            path.mo1501opN5in7k0(path, Path, PathOperation.Companion.m1833getDifferenceb3I0S0c());
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r42, androidx.compose.ui.node.Ref<androidx.compose.foundation.BorderCache> r43, androidx.compose.ui.graphics.Brush r44, androidx.compose.ui.graphics.Outline.Generic r45, boolean r46, float r47) {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.node.Ref, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m174drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, Brush brush, long j10, long j11, boolean z10, float f10) {
        return cacheDrawScope.onDrawWithContent(new BorderKt$drawRectBorder$1(brush, z10 ? Offset.Companion.m1383getZeroF1C5BW0() : j10, z10 ? cacheDrawScope.m1290getSizeNHjbRc() : j11, z10 ? Fill.INSTANCE : new Stroke(f10, 0.0f, 0, 0, null, 30, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRoundRectBorder-SYlcjDY, reason: not valid java name */
    public static final DrawResult m175drawRoundRectBorderSYlcjDY(CacheDrawScope cacheDrawScope, Ref<BorderCache> ref, Brush brush, Outline.Rounded rounded, long j10, long j11, boolean z10, float f10) {
        return RoundRectKt.isSimple(rounded.getRoundRect()) ? cacheDrawScope.onDrawWithContent(new BorderKt$drawRoundRectBorder$1(z10, brush, rounded.getRoundRect().m1417getTopLeftCornerRadiuskKHJgLs(), f10 / 2, f10, j10, j11, new Stroke(f10, 0.0f, 0, 0, null, 30, null))) : cacheDrawScope.onDrawWithContent(new BorderKt$drawRoundRectBorder$2(createRoundRectPath(obtain(ref).obtainPath(), rounded.getRoundRect(), f10, z10), brush));
    }

    private static final BorderCache obtain(Ref<BorderCache> ref) {
        BorderCache value = ref.getValue();
        if (value != null) {
            return value;
        }
        BorderCache borderCache = new BorderCache(null, null, null, null, 15, null);
        ref.setValue(borderCache);
        return borderCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m176shrinkKibmq7A(long j10, float f10) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m1342getXimpl(j10) - f10), Math.max(0.0f, CornerRadius.m1343getYimpl(j10) - f10));
    }
}
