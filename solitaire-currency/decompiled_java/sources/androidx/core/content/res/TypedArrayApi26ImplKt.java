package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TypedArray.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class TypedArrayApi26ImplKt {

    @NotNull
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @DoNotInline
    @NotNull
    public static final Typeface getFont(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        Typeface font = typedArray.getFont(i10);
        t.f(font);
        return font;
    }
}
