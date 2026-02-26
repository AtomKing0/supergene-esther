package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PointerIcon.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPointerIconType implements PointerIcon {
    private final int type;

    public AndroidPointerIconType(int i10) {
        this.type = i10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(AndroidPointerIconType.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            return this.type == ((AndroidPointerIconType) obj).type;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "AndroidPointerIcon(type=" + this.type + ')';
    }
}
