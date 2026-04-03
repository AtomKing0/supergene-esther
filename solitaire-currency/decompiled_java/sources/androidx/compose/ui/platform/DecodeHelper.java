package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DecodeHelper {

    @NotNull
    private final Parcel parcel;

    public DecodeHelper(@NotNull String string) {
        kotlin.jvm.internal.t.i(string, "string");
        Parcel parcelObtain = Parcel.obtain();
        kotlin.jvm.internal.t.h(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
        byte[] bArrDecode = Base64.decode(string, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    /* JADX INFO: renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m3175decodeBaselineShifty9eOQZs() {
        return BaselineShift.m3543constructorimpl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m3177decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        int iDecodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        boolean z10 = (companion.getLineThrough().getMask() & iDecodeInt) != 0;
        boolean z11 = (iDecodeInt & companion.getUnderline().getMask()) != 0;
        return (z10 && z11) ? companion.combine(kotlin.collections.v.n(companion.getLineThrough(), companion.getUnderline())) : z10 ? companion.getLineThrough() : z11 ? companion.getUnderline() : companion.getNone();
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* JADX INFO: renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m3176decodeULongsVKNKU() {
        return v8.e0.c(this.parcel.readLong());
    }

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m3177decodeColor0d7_KjU() {
        return Color.m1594constructorimpl(m3176decodeULongsVKNKU());
    }

    /* JADX INFO: renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m3178decodeFontStyle_LCdwA() {
        byte bDecodeByte = decodeByte();
        return bDecodeByte == 0 ? FontStyle.Companion.m3418getNormal_LCdwA() : bDecodeByte == 1 ? FontStyle.Companion.m3417getItalic_LCdwA() : FontStyle.Companion.m3418getNormal_LCdwA();
    }

    /* JADX INFO: renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m3179decodeFontSynthesisGVVA2EU() {
        byte bDecodeByte = decodeByte();
        return bDecodeByte == 0 ? FontSynthesis.Companion.m3429getNoneGVVA2EU() : bDecodeByte == 1 ? FontSynthesis.Companion.m3428getAllGVVA2EU() : bDecodeByte == 3 ? FontSynthesis.Companion.m3430getStyleGVVA2EU() : bDecodeByte == 2 ? FontSynthesis.Companion.m3431getWeightGVVA2EU() : FontSynthesis.Companion.m3429getNoneGVVA2EU();
    }

    @NotNull
    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    @NotNull
    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle2 = mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle3 = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte bDecodeByte = decodeByte();
            if (bDecodeByte != 1) {
                mutableSpanStyle = mutableSpanStyle2;
                if (bDecodeByte == 2) {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m3201setFontSizeR2X_6o(m3180decodeTextUnitXSAIIZE());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (bDecodeByte == 3) {
                    if (dataAvailable() < 4) {
                        break;
                    }
                    mutableSpanStyle.setFontWeight(decodeFontWeight());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (bDecodeByte == 4) {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m3202setFontStylemLjRB2g(FontStyle.m3410boximpl(m3178decodeFontStyle_LCdwA()));
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (bDecodeByte != 5) {
                    if (bDecodeByte != 6) {
                        if (bDecodeByte != 7) {
                            if (bDecodeByte != 8) {
                                if (bDecodeByte != 9) {
                                    if (bDecodeByte != 10) {
                                        if (bDecodeByte != 11) {
                                            if (bDecodeByte == 12) {
                                                if (dataAvailable() < 20) {
                                                    break;
                                                }
                                                mutableSpanStyle.setShadow(decodeShadow());
                                            }
                                        } else {
                                            if (dataAvailable() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                        }
                                    } else {
                                        if (dataAvailable() < 8) {
                                            break;
                                        }
                                        mutableSpanStyle.m3198setBackground8_81llA(m3177decodeColor0d7_KjU());
                                    }
                                } else {
                                    if (dataAvailable() < 8) {
                                        break;
                                    }
                                    mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                }
                            } else {
                                if (dataAvailable() < 4) {
                                    break;
                                }
                                mutableSpanStyle.m3199setBaselineShift_isdbwI(BaselineShift.m3542boximpl(m3175decodeBaselineShifty9eOQZs()));
                            }
                        } else {
                            if (dataAvailable() < 5) {
                                break;
                            }
                            mutableSpanStyle.m3204setLetterSpacingR2X_6o(m3180decodeTextUnitXSAIIZE());
                        }
                    } else {
                        mutableSpanStyle.setFontFeatureSettings(decodeString());
                    }
                    mutableSpanStyle2 = mutableSpanStyle;
                } else {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m3203setFontSynthesistDdu0R4(FontSynthesis.m3419boximpl(m3179decodeFontSynthesisGVVA2EU()));
                    mutableSpanStyle2 = mutableSpanStyle;
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle2.m3200setColor8_81llA(m3177decodeColor0d7_KjU());
            }
        }
        mutableSpanStyle = mutableSpanStyle2;
        return mutableSpanStyle.toSpanStyle();
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m3180decodeTextUnitXSAIIZE() {
        byte bDecodeByte = decodeByte();
        long jM3887getSpUIouoOA = bDecodeByte == 1 ? TextUnitType.Companion.m3887getSpUIouoOA() : bDecodeByte == 2 ? TextUnitType.Companion.m3886getEmUIouoOA() : TextUnitType.Companion.m3888getUnspecifiedUIouoOA();
        return TextUnitType.m3882equalsimpl0(jM3887getSpUIouoOA, TextUnitType.Companion.m3888getUnspecifiedUIouoOA()) ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : TextUnitKt.m3866TextUnitanM5pPY(decodeFloat(), jM3887getSpUIouoOA);
    }
}
