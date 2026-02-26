package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ShapeContainingUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m1343getYimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
    }

    public static final boolean isInOutline(@NotNull Outline outline, float f10, float f11, @Nullable Path path, @Nullable Path path2) {
        kotlin.jvm.internal.t.i(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f10, f11);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f10, f11, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f10, f11, path, path2);
        }
        throw new v8.q();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f10, float f11, Path path, Path path2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            path = null;
        }
        if ((i10 & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f10, f11, path, path2);
    }

    private static final boolean isInPath(Path path, float f10, float f11, Path path2, Path path3) {
        Rect rect = new Rect(f10 - 0.005f, f11 - 0.005f, f10 + 0.005f, f11 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        path2.addRect(rect);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo1501opN5in7k0(path, path2, PathOperation.Companion.m1834getIntersectb3I0S0c());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f10, float f11) {
        return rect.getLeft() <= f10 && f10 < rect.getRight() && rect.getTop() <= f11 && f11 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f10, float f11, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f10 < roundRect.getLeft() || f10 >= roundRect.getRight() || f11 < roundRect.getTop() || f11 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect(roundRect);
            return isInPath(Path, f10, f11, path, path2);
        }
        float fM1342getXimpl = CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float fM1343getYimpl = CornerRadius.m1343getYimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m1342getXimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs());
        float fM1343getYimpl2 = CornerRadius.m1343getYimpl(roundRect.m1418getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m1342getXimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m1343getYimpl(roundRect.m1416getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m1343getYimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs());
        float fM1342getXimpl2 = CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f10 < fM1342getXimpl && f11 < fM1343getYimpl) {
            return m3214isWithinEllipseVE1yxkc(f10, f11, roundRect.m1417getTopLeftCornerRadiuskKHJgLs(), fM1342getXimpl, fM1343getYimpl);
        }
        if (f10 < fM1342getXimpl2 && f11 > bottom2) {
            return m3214isWithinEllipseVE1yxkc(f10, f11, roundRect.m1415getBottomLeftCornerRadiuskKHJgLs(), fM1342getXimpl2, bottom2);
        }
        if (f10 > right && f11 < fM1343getYimpl2) {
            return m3214isWithinEllipseVE1yxkc(f10, f11, roundRect.m1418getTopRightCornerRadiuskKHJgLs(), right, fM1343getYimpl2);
        }
        if (f10 <= right2 || f11 <= bottom) {
            return true;
        }
        return m3214isWithinEllipseVE1yxkc(f10, f11, roundRect.m1416getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m3214isWithinEllipseVE1yxkc(float f10, float f11, long j10, float f12, float f13) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float fM1342getXimpl = CornerRadius.m1342getXimpl(j10);
        float fM1343getYimpl = CornerRadius.m1343getYimpl(j10);
        return ((f14 * f14) / (fM1342getXimpl * fM1342getXimpl)) + ((f15 * f15) / (fM1343getYimpl * fM1343getYimpl)) <= 1.0f;
    }
}
