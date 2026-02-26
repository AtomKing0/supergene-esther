package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$ShadowSaver$2 extends v implements l<Object, Shadow> {
    public static final SaversKt$ShadowSaver$2 INSTANCE = new SaversKt$ShadowSaver$2();

    SaversKt$ShadowSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final Shadow invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        Saver<Color, Object> saver = SaversKt.getSaver(Color.Companion);
        Boolean bool = Boolean.FALSE;
        Color colorRestore = (t.d(obj, bool) || obj == null) ? null : saver.restore(obj);
        t.f(colorRestore);
        long jM1608unboximpl = colorRestore.m1608unboximpl();
        Object obj2 = list.get(1);
        Offset offsetRestore = (t.d(obj2, bool) || obj2 == null) ? null : SaversKt.getSaver(Offset.Companion).restore(obj2);
        t.f(offsetRestore);
        long jM1377unboximpl = offsetRestore.m1377unboximpl();
        Object obj3 = list.get(2);
        Float f10 = obj3 != null ? (Float) obj3 : null;
        t.f(f10);
        return new Shadow(jM1608unboximpl, jM1377unboximpl, f10.floatValue(), null);
    }
}
