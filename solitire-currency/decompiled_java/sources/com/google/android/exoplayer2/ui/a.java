package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n3.b;

/* JADX INFO: compiled from: CanvasSubtitleOutput.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b0> f8454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<n3.b> f8455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y3.b f8458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f8459f;

    public a(Context context) {
        this(context, null);
    }

    private static n3.b b(n3.b bVar) {
        b.C0631b c0631bP = bVar.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (bVar.f31628f == 0) {
            c0631bP.h(1.0f - bVar.f31627e, 0);
        } else {
            c0631bP.h((-bVar.f31627e) - 1.0f, 1);
        }
        int i10 = bVar.f31629g;
        if (i10 == 0) {
            c0631bP.i(2);
        } else if (i10 == 2) {
            c0631bP.i(0);
        }
        return c0631bP.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<n3.b> list, y3.b bVar, float f10, int i10, float f11) {
        this.f8455b = list;
        this.f8458e = bVar;
        this.f8457d = f10;
        this.f8456c = i10;
        this.f8459f = f11;
        while (this.f8454a.size() < list.size()) {
            this.f8454a.add(new b0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<n3.b> list = this.f8455b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i10 = paddingBottom - paddingTop;
        float fH = e0.h(this.f8456c, this.f8457d, height, i10);
        if (fH <= 0.0f) {
            return;
        }
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            n3.b bVarB = list.get(i11);
            if (bVarB.f31638p != Integer.MIN_VALUE) {
                bVarB = b(bVarB);
            }
            n3.b bVar = bVarB;
            int i12 = paddingBottom;
            this.f8454a.get(i11).b(bVar, this.f8458e, fH, e0.h(bVar.f31636n, bVar.f31637o, height, i10), this.f8459f, canvas, paddingLeft, paddingTop, width, i12);
            i11++;
            size = size;
            i10 = i10;
            paddingBottom = i12;
            width = width;
        }
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8454a = new ArrayList();
        this.f8455b = Collections.emptyList();
        this.f8456c = 0;
        this.f8457d = 0.0533f;
        this.f8458e = y3.b.f36504g;
        this.f8459f = 0.08f;
    }
}
