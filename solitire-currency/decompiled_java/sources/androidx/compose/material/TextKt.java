package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextKt {

    @NotNull
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.material.TextKt$ProvideTextStyle$1, reason: invalid class name */
    /* JADX INFO: compiled from: Text.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ TextStyle $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(TextStyle textStyle, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$value = textStyle;
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TextKt.ProvideTextStyle(this.$value, this.$content, composer, this.$$changed | 1);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ProvideTextStyle(@NotNull TextStyle value, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        int i11;
        t.i(value, "value");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772272796);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) composerStartRestartGroup.consume(providableCompositionLocal)).merge(value))}, content, composerStartRestartGroup, (i11 & 112) | 8);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(value, content, i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:265:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0130  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1217Text4IGK_g(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.AnnotatedString r59, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r60, long r61, long r63, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontStyle r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontWeight r66, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontFamily r67, long r68, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextDecoration r70, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextAlign r71, long r72, int r74, boolean r75, int r76, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r77, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.ui.text.TextLayoutResult, v8.k0> r78, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r79, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r80, int r81, int r82, int r83) {
        /*
            Method dump skipped, instruction units count: 1108
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1217Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, h9.l, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0132  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1218TextfLXpl1I(@org.jetbrains.annotations.NotNull java.lang.String r54, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r55, long r56, long r58, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontStyle r60, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontWeight r61, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontFamily r62, long r63, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextDecoration r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextAlign r66, long r67, int r69, boolean r70, int r71, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.ui.text.TextLayoutResult, v8.k0> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r73, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r74, int r75, int r76, int r77) {
        /*
            Method dump skipped, instruction units count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1218TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, h9.l, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @NotNull
    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }
}
