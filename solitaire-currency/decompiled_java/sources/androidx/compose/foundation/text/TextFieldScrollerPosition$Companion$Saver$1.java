package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.saveable.SaverScope;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFieldScroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldScrollerPosition$Companion$Saver$1 extends v implements p<SaverScope, TextFieldScrollerPosition, List<? extends Object>> {
    public static final TextFieldScrollerPosition$Companion$Saver$1 INSTANCE = new TextFieldScrollerPosition$Companion$Saver$1();

    TextFieldScrollerPosition$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final List<Object> mo4invoke(@NotNull SaverScope listSaver, @NotNull TextFieldScrollerPosition it) {
        t.i(listSaver, "$this$listSaver");
        t.i(it, "it");
        Object[] objArr = new Object[2];
        objArr[0] = Float.valueOf(it.getOffset());
        objArr[1] = Boolean.valueOf(it.getOrientation() == Orientation.Vertical);
        return kotlin.collections.v.n(objArr);
    }
}
