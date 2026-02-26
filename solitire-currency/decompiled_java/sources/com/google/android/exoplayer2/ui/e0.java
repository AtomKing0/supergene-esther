package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import n3.b;

/* JADX INFO: compiled from: SubtitleViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class e0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof r3.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(b.C0631b c0631b) {
        c0631b.b();
        if (c0631b.e() instanceof Spanned) {
            if (!(c0631b.e() instanceof Spannable)) {
                c0631b.o(SpannableString.valueOf(c0631b.e()));
            }
            g((Spannable) a4.a.e(c0631b.e()), new e5.p() { // from class: com.google.android.exoplayer2.ui.d0
                @Override // e5.p
                public final boolean apply(Object obj) {
                    return e0.c(obj);
                }
            });
        }
        f(c0631b);
    }

    public static void f(b.C0631b c0631b) {
        c0631b.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (c0631b.e() instanceof Spanned) {
            if (!(c0631b.e() instanceof Spannable)) {
                c0631b.o(SpannableString.valueOf(c0631b.e()));
            }
            g((Spannable) a4.a.e(c0631b.e()), new e5.p() { // from class: com.google.android.exoplayer2.ui.c0
                @Override // e5.p
                public final boolean apply(Object obj) {
                    return e0.d(obj);
                }
            });
        }
    }

    private static void g(Spannable spannable, e5.p<Object> pVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (pVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i10, float f10, int i11, int i12) {
        float f11;
        if (f10 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i10 == 0) {
            f11 = i12;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    return -3.4028235E38f;
                }
                return f10;
            }
            f11 = i11;
        }
        return f10 * f11;
    }
}
