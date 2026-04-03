package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextGeometricTransform.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextGeometricTransform {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextGeometricTransform None = new TextGeometricTransform(1.0f, 0.0f);
    private final float scaleX;
    private final float skewX;

    /* JADX WARN: Illegal instructions before constructor call */
    public TextGeometricTransform() {
        float f10 = 0.0f;
        this(f10, f10, 3, null);
    }

    public static /* synthetic */ TextGeometricTransform copy$default(TextGeometricTransform textGeometricTransform, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = textGeometricTransform.scaleX;
        }
        if ((i10 & 2) != 0) {
            f11 = textGeometricTransform.skewX;
        }
        return textGeometricTransform.copy(f10, f11);
    }

    @NotNull
    public final TextGeometricTransform copy(float f10, float f11) {
        return new TextGeometricTransform(f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextGeometricTransform)) {
            return false;
        }
        TextGeometricTransform textGeometricTransform = (TextGeometricTransform) obj;
        if (this.scaleX == textGeometricTransform.scaleX) {
            return (this.skewX > textGeometricTransform.skewX ? 1 : (this.skewX == textGeometricTransform.skewX ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getSkewX() {
        return this.skewX;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.skewX);
    }

    @NotNull
    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.scaleX + ", skewX=" + this.skewX + ')';
    }

    public TextGeometricTransform(float f10, float f11) {
        this.scaleX = f10;
        this.skewX = f11;
    }

    public /* synthetic */ TextGeometricTransform(float f10, float f11, int i10, k kVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? 0.0f : f11);
    }

    /* JADX INFO: compiled from: TextGeometricTransform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TextGeometricTransform getNone$ui_text_release() {
            return TextGeometricTransform.None;
        }

        @Stable
        public static /* synthetic */ void getNone$ui_text_release$annotations() {
        }
    }
}
