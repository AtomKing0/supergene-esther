package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$SpanStyleSaver$2 extends v implements l<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final SpanStyle invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        Color.Companion companion = Color.Companion;
        Saver<Color, Object> saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        Color colorRestore = (t.d(obj, bool) || obj == null) ? null : saver.restore(obj);
        t.f(colorRestore);
        long jM1608unboximpl = colorRestore.m1608unboximpl();
        Object obj2 = list.get(1);
        TextUnit.Companion companion2 = TextUnit.Companion;
        TextUnit textUnitRestore = (t.d(obj2, bool) || obj2 == null) ? null : SaversKt.getSaver(companion2).restore(obj2);
        t.f(textUnitRestore);
        long jM3863unboximpl = textUnitRestore.m3863unboximpl();
        Object obj3 = list.get(2);
        FontWeight fontWeightRestore = (t.d(obj3, bool) || obj3 == null) ? null : SaversKt.getSaver(FontWeight.Companion).restore(obj3);
        Object obj4 = list.get(3);
        FontStyle fontStyle = obj4 != null ? (FontStyle) obj4 : null;
        Object obj5 = list.get(4);
        FontSynthesis fontSynthesis = obj5 != null ? (FontSynthesis) obj5 : null;
        FontFamily fontFamily = null;
        Object obj6 = list.get(6);
        String str = obj6 != null ? (String) obj6 : null;
        Object obj7 = list.get(7);
        TextUnit textUnitRestore2 = (t.d(obj7, bool) || obj7 == null) ? null : SaversKt.getSaver(companion2).restore(obj7);
        t.f(textUnitRestore2);
        long jM3863unboximpl2 = textUnitRestore2.m3863unboximpl();
        Object obj8 = list.get(8);
        BaselineShift baselineShiftRestore = (t.d(obj8, bool) || obj8 == null) ? null : SaversKt.getSaver(BaselineShift.Companion).restore(obj8);
        Object obj9 = list.get(9);
        TextGeometricTransform textGeometricTransformRestore = (t.d(obj9, bool) || obj9 == null) ? null : SaversKt.getSaver(TextGeometricTransform.Companion).restore(obj9);
        Object obj10 = list.get(10);
        LocaleList localeListRestore = (t.d(obj10, bool) || obj10 == null) ? null : SaversKt.getSaver(LocaleList.Companion).restore(obj10);
        Object obj11 = list.get(11);
        Color colorRestore2 = (t.d(obj11, bool) || obj11 == null) ? null : SaversKt.getSaver(companion).restore(obj11);
        t.f(colorRestore2);
        long jM1608unboximpl2 = colorRestore2.m1608unboximpl();
        Object obj12 = list.get(12);
        TextDecoration textDecorationRestore = (t.d(obj12, bool) || obj12 == null) ? null : SaversKt.getSaver(TextDecoration.Companion).restore(obj12);
        Object obj13 = list.get(13);
        return new SpanStyle(jM1608unboximpl, jM3863unboximpl, fontWeightRestore, fontStyle, fontSynthesis, fontFamily, str, jM3863unboximpl2, baselineShiftRestore, textGeometricTransformRestore, localeListRestore, jM1608unboximpl2, textDecorationRestore, (t.d(obj13, bool) || obj13 == null) ? null : SaversKt.getSaver(Shadow.Companion).restore(obj13), 32, (k) null);
    }
}
