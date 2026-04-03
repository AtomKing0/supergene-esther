package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Canvas.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withMatrix(@NotNull Canvas canvas, @NotNull Matrix matrix, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matrix = new Matrix();
        }
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withRotation(@NotNull Canvas canvas, float f10, float f11, float f12, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f10, float f11, float f12, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withSave(@NotNull Canvas canvas, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withScale(@NotNull Canvas canvas, float f10, float f11, float f12, float f13, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f10, float f11, float f12, float f13, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withSkew(@NotNull Canvas canvas, float f10, float f11, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.skew(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f10, float f11, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.skew(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withTranslation(@NotNull Canvas canvas, float f10, float f11, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f10, float f11, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, @NotNull RectF rectF, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, int i10, int i11, int i12, int i13, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.clipRect(i10, i11, i12, i13);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, float f10, float f11, float f12, float f13, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.clipRect(f10, f11, f12, f13);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, @NotNull Path path, @NotNull h9.l<? super Canvas, v8.k0> lVar) {
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.r.b(1);
            canvas.restoreToCount(iSave);
            kotlin.jvm.internal.r.a(1);
        }
    }
}
