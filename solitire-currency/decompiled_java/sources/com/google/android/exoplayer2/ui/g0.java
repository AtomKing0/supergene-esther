package com.google.android.exoplayer2.ui;

import a4.o0;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: WebViewSubtitleOutput.java */
/* JADX INFO: loaded from: classes2.dex */
final class g0 extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.ui.a f8624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebView f8625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<n3.b> f8626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private y3.b f8627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f8630g;

    /* JADX INFO: compiled from: WebViewSubtitleOutput.java */
    class a extends WebView {
        a(g0 g0Var, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: WebViewSubtitleOutput.java */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8631a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f8631a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8631a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8631a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g0(Context context) {
        this(context, null);
    }

    private static int b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i10 = b.f8631a[alignment.ordinal()];
        return i10 != 1 ? i10 != 2 ? TtmlNode.CENTER : TtmlNode.END : TtmlNode.START;
    }

    private static String d(y3.b bVar) {
        int i10 = bVar.f36508d;
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "unset" : o0.z("-0.05em -0.05em 0.15em %s", c.b(bVar.f36509e)) : o0.z("0.06em 0.08em 0.15em %s", c.b(bVar.f36509e)) : o0.z("0.1em 0.12em 0.15em %s", c.b(bVar.f36509e)) : o0.z("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", c.b(bVar.f36509e));
    }

    private String e(int i10, float f10) {
        float fH = e0.h(i10, f10, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fH == -3.4028235E38f ? "unset" : o0.z("%.2fpx", Float.valueOf(fH / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i10) {
        return i10 != 1 ? i10 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    private static String h(n3.b bVar) {
        float f10 = bVar.f31639q;
        if (f10 == 0.0f) {
            return "";
        }
        int i10 = bVar.f31638p;
        return o0.z("%s(%.2fdeg)", (i10 == 2 || i10 == 1) ? "skewY" : "skewX", Float.valueOf(f10));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() {
        /*
            Method dump skipped, instruction units count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.g0.i():void");
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<n3.b> list, y3.b bVar, float f10, int i10, float f11) {
        this.f8627d = bVar;
        this.f8628e = f10;
        this.f8629f = i10;
        this.f8630g = f11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            n3.b bVar2 = list.get(i11);
            if (bVar2.f31626d != null) {
                arrayList.add(bVar2);
            } else {
                arrayList2.add(bVar2);
            }
        }
        if (!this.f8626c.isEmpty() || !arrayList2.isEmpty()) {
            this.f8626c = arrayList2;
            i();
        }
        this.f8624a.a(arrayList, bVar, f10, i10, f11);
        invalidate();
    }

    public void g() {
        this.f8625b.destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || this.f8626c.isEmpty()) {
            return;
        }
        i();
    }

    public g0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8626c = Collections.emptyList();
        this.f8627d = y3.b.f36504g;
        this.f8628e = 0.0533f;
        this.f8629f = 0;
        this.f8630g = 0.08f;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f8624a = aVar;
        a aVar2 = new a(this, context, attributeSet);
        this.f8625b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }
}
