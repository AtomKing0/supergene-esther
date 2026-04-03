package androidx.compose.ui.text.font;

/* JADX INFO: compiled from: FontSynthesis.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    @org.jetbrains.annotations.NotNull
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m3432synthesizeTypefaceFxwP2eA(int r5, @org.jetbrains.annotations.NotNull java.lang.Object r6, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r7, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontWeight r8, int r9) {
        /*
            java.lang.String r0 = "typeface"
            kotlin.jvm.internal.t.i(r6, r0)
            java.lang.String r0 = "font"
            kotlin.jvm.internal.t.i(r7, r0)
            java.lang.String r0 = "requestedWeight"
            kotlin.jvm.internal.t.i(r8, r0)
            boolean r0 = r6 instanceof android.graphics.Typeface
            if (r0 != 0) goto L14
            return r6
        L14:
            boolean r0 = androidx.compose.ui.text.font.FontSynthesis.m3425isWeightOnimpl$ui_text_release(r5)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L42
            androidx.compose.ui.text.font.FontWeight r0 = r7.getWeight()
            boolean r0 = kotlin.jvm.internal.t.d(r0, r8)
            if (r0 != 0) goto L42
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r3 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r3 = r8.compareTo(r3)
            if (r3 < 0) goto L42
            androidx.compose.ui.text.font.FontWeight r3 = r7.getWeight()
            androidx.compose.ui.text.font.FontWeight r0 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r0 = r3.compareTo(r0)
            if (r0 >= 0) goto L42
            r0 = r1
            goto L43
        L42:
            r0 = r2
        L43:
            boolean r5 = androidx.compose.ui.text.font.FontSynthesis.m3424isStyleOnimpl$ui_text_release(r5)
            if (r5 == 0) goto L55
            int r5 = r7.mo3361getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m3413equalsimpl0(r9, r5)
            if (r5 != 0) goto L55
            r5 = r1
            goto L56
        L55:
            r5 = r2
        L56:
            if (r5 != 0) goto L5b
            if (r0 != 0) goto L5b
            return r6
        L5b:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 >= r4) goto L7c
            if (r5 == 0) goto L70
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m3417getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m3413equalsimpl0(r9, r5)
            if (r5 == 0) goto L70
            goto L71
        L70:
            r1 = r2
        L71:
            int r5 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidTypefaceStyle(r0, r1)
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r6, r5)
            goto Lae
        L7c:
            if (r0 == 0) goto L83
            int r8 = r8.getWeight()
            goto L8b
        L83:
            androidx.compose.ui.text.font.FontWeight r8 = r7.getWeight()
            int r8 = r8.getWeight()
        L8b:
            if (r5 == 0) goto L98
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m3417getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m3413equalsimpl0(r9, r5)
            goto La6
        L98:
            int r5 = r7.mo3361getStyle_LCdwA()
            androidx.compose.ui.text.font.FontStyle$Companion r7 = androidx.compose.ui.text.font.FontStyle.Companion
            int r7 = r7.m3417getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m3413equalsimpl0(r5, r7)
        La6:
            androidx.compose.ui.text.font.TypefaceHelperMethodsApi28 r7 = androidx.compose.ui.text.font.TypefaceHelperMethodsApi28.INSTANCE
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            android.graphics.Typeface r5 = r7.create(r6, r8, r5)
        Lae:
            java.lang.String r6 = "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }"
            kotlin.jvm.internal.t.h(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontSynthesis_androidKt.m3432synthesizeTypefaceFxwP2eA(int, java.lang.Object, androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.FontWeight, int):java.lang.Object");
    }
}
