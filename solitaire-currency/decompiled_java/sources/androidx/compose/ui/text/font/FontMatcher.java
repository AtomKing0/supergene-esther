package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontMatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontMatcher {
    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher fontMatcher, List list, FontWeight fontWeight, boolean z10, FontWeight fontWeight2, FontWeight fontWeight3, int i10, Object obj) {
        FontWeight fontWeight4 = null;
        if ((i10 & 4) != 0) {
            fontWeight2 = null;
        }
        if ((i10 & 8) != 0) {
            fontWeight3 = null;
        }
        t.i(list, "<this>");
        t.i(fontWeight, "fontWeight");
        int size = list.size();
        int i11 = 0;
        FontWeight fontWeight5 = null;
        while (true) {
            if (i11 >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i11)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    }
                    if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i11++;
        }
        if (!z10 ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Object obj2 = list.get(i12);
            if (t.d(((Font) obj2).getWeight(), fontWeight4)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Font> filterByClosestWeight$ui_text_release(@NotNull List<? extends Font> list, @NotNull FontWeight fontWeight, boolean z10, @Nullable FontWeight fontWeight2, @Nullable FontWeight fontWeight3) {
        t.i(list, "<this>");
        t.i(fontWeight, "fontWeight");
        int size = list.size();
        FontWeight fontWeight4 = null;
        FontWeight fontWeight5 = null;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            FontWeight weight = list.get(i10).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    }
                    if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i10++;
        }
        if (!z10 ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Font font = list.get(i11);
            if (t.d(font.getWeight(), fontWeight4)) {
                arrayList.add(font);
            }
        }
        return arrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m3407matchFontRetOiIg(@NotNull FontFamily fontFamily, @NotNull FontWeight fontWeight, int i10) {
        t.i(fontFamily, "fontFamily");
        t.i(fontWeight, "fontWeight");
        if (fontFamily instanceof FontListFontFamily) {
            return m3408matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, i10);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    @NotNull
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m3408matchFontRetOiIg(@NotNull FontListFontFamily fontFamily, @NotNull FontWeight fontWeight, int i10) {
        t.i(fontFamily, "fontFamily");
        t.i(fontWeight, "fontWeight");
        return m3409matchFontRetOiIg(fontFamily.getFonts(), fontWeight, i10);
    }

    @NotNull
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m3409matchFontRetOiIg(@NotNull List<? extends Font> fontList, @NotNull FontWeight fontWeight, int i10) {
        t.i(fontList, "fontList");
        t.i(fontWeight, "fontWeight");
        ArrayList arrayList = new ArrayList(fontList.size());
        int size = fontList.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            Font font = fontList.get(i12);
            Font font2 = font;
            if (t.d(font2.getWeight(), fontWeight) && FontStyle.m3413equalsimpl0(font2.mo3361getStyle_LCdwA(), i10)) {
                arrayList.add(font);
            }
            i12++;
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        k0 k0Var = k0.f35197a;
        ArrayList arrayList2 = new ArrayList(fontList.size());
        int size2 = fontList.size();
        for (int i13 = 0; i13 < size2; i13++) {
            Font font3 = fontList.get(i13);
            if (FontStyle.m3413equalsimpl0(font3.mo3361getStyle_LCdwA(), i10)) {
                arrayList2.add(font3);
            }
        }
        if (!arrayList2.isEmpty()) {
            fontList = arrayList2;
        }
        List<? extends Font> list = fontList;
        FontWeight.Companion companion = FontWeight.Companion;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) < 0) {
            int size3 = list.size();
            FontWeight fontWeight3 = null;
            int i14 = 0;
            while (true) {
                if (i14 >= size3) {
                    break;
                }
                FontWeight weight = list.get(i14).getWeight();
                if (weight.compareTo(fontWeight) < 0) {
                    if (fontWeight2 == null || weight.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight;
                    }
                } else {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight3 = weight;
                        fontWeight2 = fontWeight3;
                        break;
                    }
                    if (fontWeight3 == null || weight.compareTo(fontWeight3) < 0) {
                        fontWeight3 = weight;
                    }
                }
                i14++;
            }
            if (fontWeight2 != null) {
                fontWeight3 = fontWeight2;
            }
            ArrayList arrayList3 = new ArrayList(list.size());
            int size4 = list.size();
            while (i11 < size4) {
                Font font4 = list.get(i11);
                if (t.d(font4.getWeight(), fontWeight3)) {
                    arrayList3.add(font4);
                }
                i11++;
            }
            return arrayList3;
        }
        if (fontWeight.compareTo(companion.getW500()) > 0) {
            int size5 = list.size();
            FontWeight fontWeight4 = null;
            int i15 = 0;
            while (true) {
                if (i15 >= size5) {
                    break;
                }
                FontWeight weight2 = list.get(i15).getWeight();
                if (weight2.compareTo(fontWeight) < 0) {
                    if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight2;
                    }
                } else {
                    if (weight2.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight2;
                        fontWeight2 = fontWeight4;
                        break;
                    }
                    if (fontWeight4 == null || weight2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight2;
                    }
                }
                i15++;
            }
            if (fontWeight4 == null) {
                fontWeight4 = fontWeight2;
            }
            ArrayList arrayList4 = new ArrayList(list.size());
            int size6 = list.size();
            while (i11 < size6) {
                Font font5 = list.get(i11);
                if (t.d(font5.getWeight(), fontWeight4)) {
                    arrayList4.add(font5);
                }
                i11++;
            }
            return arrayList4;
        }
        FontWeight w500 = companion.getW500();
        int size7 = list.size();
        FontWeight fontWeight5 = null;
        FontWeight fontWeight6 = null;
        int i16 = 0;
        while (true) {
            if (i16 >= size7) {
                break;
            }
            FontWeight weight3 = list.get(i16).getWeight();
            if (w500 == null || weight3.compareTo(w500) <= 0) {
                if (weight3.compareTo(fontWeight) < 0) {
                    if (fontWeight5 == null || weight3.compareTo(fontWeight5) > 0) {
                        fontWeight5 = weight3;
                    }
                } else {
                    if (weight3.compareTo(fontWeight) <= 0) {
                        fontWeight5 = weight3;
                        fontWeight6 = fontWeight5;
                        break;
                    }
                    if (fontWeight6 == null || weight3.compareTo(fontWeight6) < 0) {
                        fontWeight6 = weight3;
                    }
                }
            }
            i16++;
        }
        if (fontWeight6 != null) {
            fontWeight5 = fontWeight6;
        }
        ArrayList arrayList5 = new ArrayList(list.size());
        int size8 = list.size();
        for (int i17 = 0; i17 < size8; i17++) {
            Font font6 = list.get(i17);
            if (t.d(font6.getWeight(), fontWeight5)) {
                arrayList5.add(font6);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        FontWeight w5002 = FontWeight.Companion.getW500();
        int size9 = list.size();
        FontWeight fontWeight7 = null;
        int i18 = 0;
        while (true) {
            if (i18 >= size9) {
                break;
            }
            FontWeight weight4 = list.get(i18).getWeight();
            if (w5002 == null || weight4.compareTo(w5002) >= 0) {
                if (weight4.compareTo(fontWeight) < 0) {
                    if (fontWeight2 == null || weight4.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight4;
                    }
                } else {
                    if (weight4.compareTo(fontWeight) <= 0) {
                        fontWeight2 = weight4;
                        fontWeight7 = fontWeight2;
                        break;
                    }
                    if (fontWeight7 == null || weight4.compareTo(fontWeight7) < 0) {
                        fontWeight7 = weight4;
                    }
                }
            }
            i18++;
        }
        if (fontWeight7 != null) {
            fontWeight2 = fontWeight7;
        }
        ArrayList arrayList6 = new ArrayList(list.size());
        int size10 = list.size();
        while (i11 < size10) {
            Font font7 = list.get(i11);
            if (t.d(font7.getWeight(), fontWeight2)) {
                arrayList6.add(font7);
            }
            i11++;
        }
        return arrayList6;
    }
}
