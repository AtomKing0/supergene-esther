package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EncodeHelper {

    @NotNull
    private Parcel parcel;

    public EncodeHelper() {
        Parcel parcelObtain = Parcel.obtain();
        kotlin.jvm.internal.t.h(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
    }

    public final void encode(@NotNull SpanStyle spanStyle) {
        kotlin.jvm.internal.t.i(spanStyle, "spanStyle");
        long jM3308getColor0d7_KjU = spanStyle.m3308getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1599equalsimpl0(jM3308getColor0d7_KjU, companion.m1634getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m3184encode8_81llA(spanStyle.m3308getColor0d7_KjU());
        }
        long jM3309getFontSizeXSAIIZE = spanStyle.m3309getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m3851equalsimpl0(jM3309getFontSizeXSAIIZE, companion2.m3865getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m3181encodeR2X_6o(spanStyle.m3309getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyleM3310getFontStyle4Lr2A7w = spanStyle.m3310getFontStyle4Lr2A7w();
        if (fontStyleM3310getFontStyle4Lr2A7w != null) {
            int iM3416unboximpl = fontStyleM3310getFontStyle4Lr2A7w.m3416unboximpl();
            encode((byte) 4);
            m3186encodenzbMABs(iM3416unboximpl);
        }
        FontSynthesis fontSynthesisM3311getFontSynthesisZQGJjVo = spanStyle.m3311getFontSynthesisZQGJjVo();
        if (fontSynthesisM3311getFontSynthesisZQGJjVo != null) {
            int iM3427unboximpl = fontSynthesisM3311getFontSynthesisZQGJjVo.m3427unboximpl();
            encode((byte) 5);
            m3183encode6p3vJLY(iM3427unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m3851equalsimpl0(spanStyle.m3312getLetterSpacingXSAIIZE(), companion2.m3865getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m3181encodeR2X_6o(spanStyle.m3312getLetterSpacingXSAIIZE());
        }
        BaselineShift baselineShiftM3307getBaselineShift5SSeXJ0 = spanStyle.m3307getBaselineShift5SSeXJ0();
        if (baselineShiftM3307getBaselineShift5SSeXJ0 != null) {
            float fM3548unboximpl = baselineShiftM3307getBaselineShift5SSeXJ0.m3548unboximpl();
            encode((byte) 8);
            m3182encode4Dl_Bck(fM3548unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m1599equalsimpl0(spanStyle.m3306getBackground0d7_KjU(), companion.m1634getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m3184encode8_81llA(spanStyle.m3306getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m3181encodeR2X_6o(long j10) {
        long jM3853getTypeUIouoOA = TextUnit.m3853getTypeUIouoOA(j10);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b10 = 0;
        if (!TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3888getUnspecifiedUIouoOA())) {
            if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA())) {
                b10 = 1;
            } else if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA())) {
                b10 = 2;
            }
        }
        encode(b10);
        if (TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j10), companion.m3888getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m3854getValueimpl(j10));
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m3182encode4Dl_Bck(float f10) {
        encode(f10);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m3183encode6p3vJLY(int i10) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b10 = 0;
        if (!FontSynthesis.m3422equalsimpl0(i10, companion.m3429getNoneGVVA2EU())) {
            if (FontSynthesis.m3422equalsimpl0(i10, companion.m3428getAllGVVA2EU())) {
                b10 = 1;
            } else if (FontSynthesis.m3422equalsimpl0(i10, companion.m3431getWeightGVVA2EU())) {
                b10 = 2;
            } else if (FontSynthesis.m3422equalsimpl0(i10, companion.m3430getStyleGVVA2EU())) {
                b10 = 3;
            }
        }
        encode(b10);
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m3184encode8_81llA(long j10) {
        m3185encodeVKZWuLQ(j10);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m3185encodeVKZWuLQ(long j10) {
        this.parcel.writeLong(j10);
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m3186encodenzbMABs(int i10) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b10 = 0;
        if (!FontStyle.m3413equalsimpl0(i10, companion.m3418getNormal_LCdwA()) && FontStyle.m3413equalsimpl0(i10, companion.m3417getItalic_LCdwA())) {
            b10 = 1;
        }
        encode(b10);
    }

    @NotNull
    public final String encodedString() {
        String strEncodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        kotlin.jvm.internal.t.h(strEncodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return strEncodeToString;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel parcelObtain = Parcel.obtain();
        kotlin.jvm.internal.t.h(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
    }

    public final void encode(@NotNull FontWeight fontWeight) {
        kotlin.jvm.internal.t.i(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    public final void encode(@NotNull TextGeometricTransform textGeometricTransform) {
        kotlin.jvm.internal.t.i(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(@NotNull TextDecoration textDecoration) {
        kotlin.jvm.internal.t.i(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(@NotNull Shadow shadow) {
        kotlin.jvm.internal.t.i(shadow, "shadow");
        m3184encode8_81llA(shadow.m1865getColor0d7_KjU());
        encode(Offset.m1367getXimpl(shadow.m1866getOffsetF1C5BW0()));
        encode(Offset.m1368getYimpl(shadow.m1866getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b10) {
        this.parcel.writeByte(b10);
    }

    public final void encode(int i10) {
        this.parcel.writeInt(i10);
    }

    public final void encode(float f10) {
        this.parcel.writeFloat(f10);
    }

    public final void encode(@NotNull String string) {
        kotlin.jvm.internal.t.i(string, "string");
        this.parcel.writeString(string);
    }
}
