package com.google.android.exoplayer2.ui;

import a4.o0;
import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.exoplayer2.ui.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SpannedToHtmlConverter.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8541a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f8543b;

        private b(String str, Map<String, String> map) {
            this.f8542a = str;
            this.f8543b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Comparator<c> f8544e = new Comparator() { // from class: com.google.android.exoplayer2.ui.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return d.c.e((d.c) obj, (d.c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Comparator<c> f8545f = new Comparator() { // from class: com.google.android.exoplayer2.ui.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return d.c.f((d.c) obj, (d.c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f8549d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f8547b, cVar.f8547b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.f8548c.compareTo(cVar2.f8548c);
            return iCompareTo != 0 ? iCompareTo : cVar.f8549d.compareTo(cVar2.f8549d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int f(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f8546a, cVar.f8546a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.f8548c.compareTo(cVar.f8548c);
            return iCompareTo != 0 ? iCompareTo : cVar2.f8549d.compareTo(cVar.f8549d);
        }

        private c(int i10, int i11, String str, String str2) {
            this.f8546a = i10;
            this.f8547b = i11;
            this.f8548c = str;
            this.f8549d = str2;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    private static final class C0189d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f8550a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<c> f8551b = new ArrayList();
    }

    public static b a(@Nullable CharSequence charSequence, float f10) {
        if (charSequence == null) {
            return new b("", com.google.common.collect.a0.k());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), com.google.common.collect.a0.k());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            map.put(com.google.android.exoplayer2.ui.c.a("bg_" + iIntValue), o0.z("background-color:%s;", com.google.android.exoplayer2.ui.c.b(iIntValue)));
        }
        SparseArray<C0189d> sparseArrayC = c(spanned, f10);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i11 = 0;
        while (i10 < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i10);
            sb.append(b(spanned.subSequence(i11, iKeyAt)));
            C0189d c0189d = sparseArrayC.get(iKeyAt);
            Collections.sort(c0189d.f8551b, c.f8545f);
            Iterator it2 = c0189d.f8551b.iterator();
            while (it2.hasNext()) {
                sb.append(((c) it2.next()).f8549d);
            }
            Collections.sort(c0189d.f8550a, c.f8544e);
            Iterator it3 = c0189d.f8550a.iterator();
            while (it3.hasNext()) {
                sb.append(((c) it3.next()).f8548c);
            }
            i10++;
            i11 = iKeyAt;
        }
        sb.append(b(spanned.subSequence(i11, spanned.length())));
        return new b(sb.toString(), map);
    }

    private static String b(CharSequence charSequence) {
        return f8541a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray<C0189d> c(Spanned spanned, float f10) {
        SparseArray<C0189d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f10);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                a4.a.e(strD);
                c cVar = new c(spanStart, spanEnd, strE, strD);
                f(sparseArray, spanStart).f8550a.add(cVar);
                f(sparseArray, spanEnd).f8551b.add(cVar);
            }
        }
        return sparseArray;
    }

    @Nullable
    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof r3.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof r3.e)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof r3.c) {
                return "<rt>" + b(((r3.c) obj).f33302a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @Nullable
    private static String e(Object obj, float f10) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return o0.z("<span style='color:%s;'>", com.google.android.exoplayer2.ui.c.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return o0.z("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof r3.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            return o0.z("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r4.getSize() : r4.getSize() / f10));
        }
        if (obj instanceof RelativeSizeSpan) {
            return o0.z("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return o0.z("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof r3.c)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof r3.e)) {
                return null;
            }
            r3.e eVar = (r3.e) obj;
            return o0.z("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.f33304a, eVar.f33305b), g(eVar.f33306c));
        }
        int i10 = ((r3.c) obj).f33303b;
        if (i10 == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i10 == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i10 != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    private static C0189d f(SparseArray<C0189d> sparseArray, int i10) {
        C0189d c0189d = sparseArray.get(i10);
        if (c0189d != null) {
            return c0189d;
        }
        C0189d c0189d2 = new C0189d();
        sparseArray.put(i10, c0189d2);
        return c0189d2;
    }

    private static String g(int i10) {
        return i10 != 2 ? "over right" : "under left";
    }

    private static String h(int i10, int i11) {
        StringBuilder sb = new StringBuilder();
        if (i11 == 1) {
            sb.append("filled ");
        } else if (i11 == 2) {
            sb.append("open ");
        }
        if (i10 == 0) {
            sb.append("none");
        } else if (i10 == 1) {
            sb.append(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
        } else if (i10 == 2) {
            sb.append(TtmlNode.TEXT_EMPHASIS_MARK_DOT);
        } else if (i10 != 3) {
            sb.append("unset");
        } else {
            sb.append(TtmlNode.TEXT_EMPHASIS_MARK_SESAME);
        }
        return sb.toString();
    }
}
