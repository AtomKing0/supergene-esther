package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RoundRect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RoundRectKt {
    @NotNull
    public static final RoundRect RoundRect(float f10, float f11, float f12, float f13, float f14, float f15) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f14, f15);
        return new RoundRect(f10, f11, f12, f13, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    @NotNull
    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m1419RoundRectZAM2FJo(@NotNull Rect rect, long j10, long j11, long j12, long j13) {
        t.i(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j10, j11, j12, j13, null);
    }

    @NotNull
    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m1421RoundRectgG7oq9Y(float f10, float f11, float f12, float f13, long j10) {
        return RoundRect(f10, f11, f12, f13, CornerRadius.m1342getXimpl(j10), CornerRadius.m1343getYimpl(j10));
    }

    @NotNull
    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m1422RoundRectsniSvfs(@NotNull Rect rect, long j10) {
        t.i(rect, "rect");
        return RoundRect(rect, CornerRadius.m1342getXimpl(j10), CornerRadius.m1343getYimpl(j10));
    }

    @NotNull
    public static final Rect getBoundingRect(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final float getMaxDimension(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    @NotNull
    public static final Rect getSafeInnerRect(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs()), CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m1343getYimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return ((roundRect.getWidth() > roundRect.getHeight() ? 1 : (roundRect.getWidth() == roundRect.getHeight() ? 0 : -1)) == 0) && isEllipse(roundRect);
    }

    public static final boolean isEllipse(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs())) && roundRect.getWidth() <= ((double) CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs())) * 2.0d && roundRect.getHeight() <= ((double) CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs())) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isEmpty(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        float left = roundRect.getLeft();
        if ((Float.isInfinite(left) || Float.isNaN(left)) ? false : true) {
            float top = roundRect.getTop();
            if ((Float.isInfinite(top) || Float.isNaN(top)) ? false : true) {
                float right = roundRect.getRight();
                if ((Float.isInfinite(right) || Float.isNaN(right)) ? false : true) {
                    float bottom = roundRect.getBottom();
                    if ((Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isRect(@org.jetbrains.annotations.NotNull androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.t.i(r6, r0)
            long r0 = r6.m1417getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            if (r0 != 0) goto L2a
            long r4 = r6.m1417getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L27
            r0 = r2
            goto L28
        L27:
            r0 = r3
        L28:
            if (r0 == 0) goto L91
        L2a:
            long r4 = r6.m1418getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L38
            r0 = r2
            goto L39
        L38:
            r0 = r3
        L39:
            if (r0 != 0) goto L4c
            long r4 = r6.m1418getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
            r0 = r2
            goto L4a
        L49:
            r0 = r3
        L4a:
            if (r0 == 0) goto L91
        L4c:
            long r4 = r6.m1415getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5a
            r0 = r2
            goto L5b
        L5a:
            r0 = r3
        L5b:
            if (r0 != 0) goto L6e
            long r4 = r6.m1415getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6b
            r0 = r2
            goto L6c
        L6b:
            r0 = r3
        L6c:
            if (r0 == 0) goto L91
        L6e:
            long r4 = r6.m1416getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L7c
            r0 = r2
            goto L7d
        L7c:
            r0 = r3
        L7d:
            if (r0 != 0) goto L92
            long r4 = r6.m1416getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L8d
            r6 = r2
            goto L8e
        L8d:
            r6 = r3
        L8e:
            if (r6 == 0) goto L91
            goto L92
        L91:
            r2 = r3
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isSimple(@NotNull RoundRect roundRect) {
        t.i(roundRect, "<this>");
        if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1343getYimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public static final RoundRect lerp(@NotNull RoundRect start, @NotNull RoundRect stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new RoundRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), f10), MathHelpersKt.lerp(start.getTop(), stop.getTop(), f10), MathHelpersKt.lerp(start.getRight(), stop.getRight(), f10), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), f10), CornerRadiusKt.m1353lerp3Ry4LBc(start.m1417getTopLeftCornerRadiuskKHJgLs(), stop.m1417getTopLeftCornerRadiuskKHJgLs(), f10), CornerRadiusKt.m1353lerp3Ry4LBc(start.m1418getTopRightCornerRadiuskKHJgLs(), stop.m1418getTopRightCornerRadiuskKHJgLs(), f10), CornerRadiusKt.m1353lerp3Ry4LBc(start.m1416getBottomRightCornerRadiuskKHJgLs(), stop.m1416getBottomRightCornerRadiuskKHJgLs(), f10), CornerRadiusKt.m1353lerp3Ry4LBc(start.m1415getBottomLeftCornerRadiuskKHJgLs(), stop.m1415getBottomLeftCornerRadiuskKHJgLs(), f10), null);
    }

    @NotNull
    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m1423translateUv8p0NA(@NotNull RoundRect translate, long j10) {
        t.i(translate, "$this$translate");
        return new RoundRect(translate.getLeft() + Offset.m1367getXimpl(j10), translate.getTop() + Offset.m1368getYimpl(j10), translate.getRight() + Offset.m1367getXimpl(j10), translate.getBottom() + Offset.m1368getYimpl(j10), translate.m1417getTopLeftCornerRadiuskKHJgLs(), translate.m1418getTopRightCornerRadiuskKHJgLs(), translate.m1416getBottomRightCornerRadiuskKHJgLs(), translate.m1415getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    @NotNull
    public static final RoundRect RoundRect(@NotNull Rect rect, float f10, float f11) {
        t.i(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f10, f11);
    }
}
