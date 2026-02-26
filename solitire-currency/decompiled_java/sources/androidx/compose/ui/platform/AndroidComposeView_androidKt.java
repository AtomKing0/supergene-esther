package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.annotation.RestrictTo;
import androidx.compose.ui.InternalComposeUiApi;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView_androidKt {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private static h9.l<? super PlatformTextInputService, ? extends TextInputService> textInputServiceFactory = AndroidComposeView_androidKt$textInputServiceFactory$1.INSTANCE;

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m3165dotp89u6pk(float[] fArr, int i10, float[] fArr2, int i11) {
        int i12 = i10 * 4;
        return (fArr[i12 + 0] * fArr2[0 + i11]) + (fArr[i12 + 1] * fArr2[4 + i11]) + (fArr[i12 + 2] * fArr2[8 + i11]) + (fArr[i12 + 3] * fArr2[12 + i11]);
    }

    @NotNull
    public static final LayoutDirection getLocaleLayoutDirection(@NotNull Configuration configuration) {
        kotlin.jvm.internal.t.i(configuration, "<this>");
        return layoutDirectionFromInt(configuration.getLayoutDirection());
    }

    @NotNull
    public static final h9.l<PlatformTextInputService, TextInputService> getTextInputServiceFactory() {
        return textInputServiceFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutDirection layoutDirectionFromInt(int i10) {
        return i10 != 0 ? i10 != 1 ? LayoutDirection.Ltr : LayoutDirection.Rtl : LayoutDirection.Ltr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m3166preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM3165dotp89u6pk = m3165dotp89u6pk(fArr2, 0, fArr, 0);
        float fM3165dotp89u6pk2 = m3165dotp89u6pk(fArr2, 0, fArr, 1);
        float fM3165dotp89u6pk3 = m3165dotp89u6pk(fArr2, 0, fArr, 2);
        float fM3165dotp89u6pk4 = m3165dotp89u6pk(fArr2, 0, fArr, 3);
        float fM3165dotp89u6pk5 = m3165dotp89u6pk(fArr2, 1, fArr, 0);
        float fM3165dotp89u6pk6 = m3165dotp89u6pk(fArr2, 1, fArr, 1);
        float fM3165dotp89u6pk7 = m3165dotp89u6pk(fArr2, 1, fArr, 2);
        float fM3165dotp89u6pk8 = m3165dotp89u6pk(fArr2, 1, fArr, 3);
        float fM3165dotp89u6pk9 = m3165dotp89u6pk(fArr2, 2, fArr, 0);
        float fM3165dotp89u6pk10 = m3165dotp89u6pk(fArr2, 2, fArr, 1);
        float fM3165dotp89u6pk11 = m3165dotp89u6pk(fArr2, 2, fArr, 2);
        float fM3165dotp89u6pk12 = m3165dotp89u6pk(fArr2, 2, fArr, 3);
        float fM3165dotp89u6pk13 = m3165dotp89u6pk(fArr2, 3, fArr, 0);
        float fM3165dotp89u6pk14 = m3165dotp89u6pk(fArr2, 3, fArr, 1);
        float fM3165dotp89u6pk15 = m3165dotp89u6pk(fArr2, 3, fArr, 2);
        float fM3165dotp89u6pk16 = m3165dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM3165dotp89u6pk;
        fArr[1] = fM3165dotp89u6pk2;
        fArr[2] = fM3165dotp89u6pk3;
        fArr[3] = fM3165dotp89u6pk4;
        fArr[4] = fM3165dotp89u6pk5;
        fArr[5] = fM3165dotp89u6pk6;
        fArr[6] = fM3165dotp89u6pk7;
        fArr[7] = fM3165dotp89u6pk8;
        fArr[8] = fM3165dotp89u6pk9;
        fArr[9] = fM3165dotp89u6pk10;
        fArr[10] = fM3165dotp89u6pk11;
        fArr[11] = fM3165dotp89u6pk12;
        fArr[12] = fM3165dotp89u6pk13;
        fArr[13] = fM3165dotp89u6pk14;
        fArr[14] = fM3165dotp89u6pk15;
        fArr[15] = fM3165dotp89u6pk16;
    }

    public static final void setTextInputServiceFactory(@NotNull h9.l<? super PlatformTextInputService, ? extends TextInputService> lVar) {
        kotlin.jvm.internal.t.i(lVar, "<set-?>");
        textInputServiceFactory = lVar;
    }

    @InternalComposeUiApi
    public static /* synthetic */ void getTextInputServiceFactory$annotations() {
    }
}
