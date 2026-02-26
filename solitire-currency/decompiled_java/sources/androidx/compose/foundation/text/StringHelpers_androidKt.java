package androidx.compose.foundation.text;

import java.text.BreakIterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StringHelpers.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StringHelpers_androidKt {
    public static final int findFollowingBreak(@NotNull String str, int i10) {
        t.i(str, "<this>");
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.following(i10);
    }

    public static final int findPrecedingBreak(@NotNull String str, int i10) {
        t.i(str, "<this>");
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i10);
    }
}
