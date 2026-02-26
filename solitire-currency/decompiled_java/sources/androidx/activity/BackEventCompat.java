package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BackEventCompat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackEventCompat {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int EDGE_LEFT = 0;
    public static final int EDGE_RIGHT = 1;
    private final float progress;
    private final int swipeEdge;
    private final float touchX;
    private final float touchY;

    /* JADX INFO: compiled from: BackEventCompat.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: BackEventCompat.kt */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface SwipeEdge {
    }

    @VisibleForTesting
    public BackEventCompat(float f10, float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, int i10) {
        this.touchX = f10;
        this.touchY = f11;
        this.progress = f12;
        this.swipeEdge = i10;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getSwipeEdge() {
        return this.swipeEdge;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    @RequiresApi(34)
    @NotNull
    public final BackEvent toBackEvent() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.INSTANCE.createOnBackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 34+");
    }

    @NotNull
    public String toString() {
        return "BackEventCompat{touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(34)
    public BackEventCompat(@NotNull BackEvent backEvent) {
        t.i(backEvent, "backEvent");
        Api34Impl api34Impl = Api34Impl.INSTANCE;
        this(api34Impl.touchX(backEvent), api34Impl.touchY(backEvent), api34Impl.progress(backEvent), api34Impl.swipeEdge(backEvent));
    }
}
