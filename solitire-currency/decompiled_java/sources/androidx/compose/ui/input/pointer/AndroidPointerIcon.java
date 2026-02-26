package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PointerIcon.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPointerIcon implements PointerIcon {

    @NotNull
    private final android.view.PointerIcon pointerIcon;

    public AndroidPointerIcon(@NotNull android.view.PointerIcon pointerIcon) {
        t.i(pointerIcon, "pointerIcon");
        this.pointerIcon = pointerIcon;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(AndroidPointerIcon.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            return t.d(this.pointerIcon, ((AndroidPointerIcon) obj).pointerIcon);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIcon");
    }

    @NotNull
    public final android.view.PointerIcon getPointerIcon() {
        return this.pointerIcon;
    }

    public int hashCode() {
        return this.pointerIcon.hashCode();
    }

    @NotNull
    public String toString() {
        return "AndroidPointerIcon(pointerIcon=" + this.pointerIcon + ')';
    }
}
