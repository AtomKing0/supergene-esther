package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Outline.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Outline {

    /* JADX INFO: compiled from: Outline.kt */
    public static final class Generic extends Outline {

        @NotNull
        private final Path path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Generic(@NotNull Path path) {
            super(null);
            kotlin.jvm.internal.t.i(path, "path");
            this.path = path;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Generic) && kotlin.jvm.internal.t.d(this.path, ((Generic) obj).path);
        }

        @Override // androidx.compose.ui.graphics.Outline
        @NotNull
        public Rect getBounds() {
            return this.path.getBounds();
        }

        @NotNull
        public final Path getPath() {
            return this.path;
        }

        public int hashCode() {
            return this.path.hashCode();
        }
    }

    /* JADX INFO: compiled from: Outline.kt */
    @Immutable
    public static final class Rectangle extends Outline {

        @NotNull
        private final Rect rect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rectangle(@NotNull Rect rect) {
            super(null);
            kotlin.jvm.internal.t.i(rect, "rect");
            this.rect = rect;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rectangle) && kotlin.jvm.internal.t.d(this.rect, ((Rectangle) obj).rect);
        }

        @Override // androidx.compose.ui.graphics.Outline
        @NotNull
        public Rect getBounds() {
            return this.rect;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        public int hashCode() {
            return this.rect.hashCode();
        }
    }

    /* JADX INFO: compiled from: Outline.kt */
    @Immutable
    public static final class Rounded extends Outline {

        @NotNull
        private final RoundRect roundRect;

        @Nullable
        private final Path roundRectPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Rounded(@NotNull RoundRect roundRect) {
            super(0 == true ? 1 : 0);
            kotlin.jvm.internal.t.i(roundRect, "roundRect");
            Path Path = null;
            this.roundRect = roundRect;
            if (!OutlineKt.hasSameCornerRadius(roundRect)) {
                Path = AndroidPath_androidKt.Path();
                Path.addRoundRect(roundRect);
            }
            this.roundRectPath = Path;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rounded) && kotlin.jvm.internal.t.d(this.roundRect, ((Rounded) obj).roundRect);
        }

        @Override // androidx.compose.ui.graphics.Outline
        @NotNull
        public Rect getBounds() {
            return RoundRectKt.getBoundingRect(this.roundRect);
        }

        @NotNull
        public final RoundRect getRoundRect() {
            return this.roundRect;
        }

        @Nullable
        public final Path getRoundRectPath$ui_graphics_release() {
            return this.roundRectPath;
        }

        public int hashCode() {
            return this.roundRect.hashCode();
        }
    }

    private Outline() {
    }

    public /* synthetic */ Outline(kotlin.jvm.internal.k kVar) {
        this();
    }

    @NotNull
    public abstract Rect getBounds();
}
