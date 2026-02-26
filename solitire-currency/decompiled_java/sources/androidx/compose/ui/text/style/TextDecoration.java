package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.TempListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextDecoration.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextDecoration {
    private final int mask;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextDecoration None = new TextDecoration(0);

    @NotNull
    private static final TextDecoration Underline = new TextDecoration(1);

    @NotNull
    private static final TextDecoration LineThrough = new TextDecoration(2);

    public TextDecoration(int i10) {
        this.mask = i10;
    }

    public final boolean contains(@NotNull TextDecoration other) {
        t.i(other, "other");
        int i10 = this.mask;
        return (other.mask | i10) == i10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TextDecoration) && this.mask == ((TextDecoration) obj).mask;
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    @NotNull
    public final TextDecoration plus(@NotNull TextDecoration decoration) {
        t.i(decoration, "decoration");
        return new TextDecoration(decoration.mask | this.mask);
    }

    @NotNull
    public String toString() {
        if (this.mask == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.mask & Underline.mask) != 0) {
            arrayList.add("Underline");
        }
        if ((this.mask & LineThrough.mask) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + TempListUtilsKt.fastJoinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    /* JADX INFO: compiled from: TextDecoration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TextDecoration combine(@NotNull List<TextDecoration> decorations) {
            t.i(decorations, "decorations");
            Integer numValueOf = 0;
            int size = decorations.size();
            for (int i10 = 0; i10 < size; i10++) {
                numValueOf = Integer.valueOf(numValueOf.intValue() | decorations.get(i10).getMask());
            }
            return new TextDecoration(numValueOf.intValue());
        }

        @NotNull
        public final TextDecoration getLineThrough() {
            return TextDecoration.LineThrough;
        }

        @NotNull
        public final TextDecoration getNone() {
            return TextDecoration.None;
        }

        @NotNull
        public final TextDecoration getUnderline() {
            return TextDecoration.Underline;
        }

        @Stable
        public static /* synthetic */ void getLineThrough$annotations() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        @Stable
        public static /* synthetic */ void getUnderline$annotations() {
        }
    }
}
