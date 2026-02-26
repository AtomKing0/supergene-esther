package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageResources.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageResources_androidKt {
    @NotNull
    public static final ImageBitmap imageResource(@NotNull ImageBitmap.Companion companion, @NotNull Resources res, @DrawableRes int i10) {
        t.i(companion, "<this>");
        t.i(res, "res");
        Drawable drawable = res.getDrawable(i10, null);
        if (drawable == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        t.h(bitmap, "res.getDrawable(id, null…as BitmapDrawable).bitmap");
        return AndroidImageBitmap_androidKt.asImageBitmap(bitmap);
    }

    @Composable
    @NotNull
    public static final ImageBitmap imageResource(@NotNull ImageBitmap.Companion companion, @DrawableRes int i10, @Nullable Composer composer, int i11) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-304919470);
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion2 = Composer.Companion;
        if (objRememberedValue == companion2.getEmpty()) {
            objRememberedValue = new TypedValue();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TypedValue typedValue = (TypedValue) objRememberedValue;
        context.getResources().getValue(i10, typedValue, true);
        CharSequence charSequence = typedValue.string;
        t.f(charSequence);
        String string = charSequence.toString();
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(string);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion2.getEmpty()) {
            Resources resources = context.getResources();
            t.h(resources, "context.resources");
            objRememberedValue2 = imageResource(companion, resources, i10);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ImageBitmap imageBitmap = (ImageBitmap) objRememberedValue2;
        composer.endReplaceableGroup();
        return imageBitmap;
    }
}
