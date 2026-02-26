package com.google.android.exoplayer2.ui;

import a4.o0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.C;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.f0;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import k2.b2;
import k2.l1;
import k2.n2;
import k2.n3;
import k2.o1;
import k2.q2;
import k2.r2;
import k2.s3;
import k2.t2;
import k2.w1;
import l3.c1;

/* JADX INFO: compiled from: StyledPlayerControlView.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final float[] f8552x0;

    @Nullable
    private final View A;

    @Nullable
    private final View B;

    @Nullable
    private final TextView C;

    @Nullable
    private final TextView D;

    @Nullable
    private final f0 E;
    private final StringBuilder F;
    private final Formatter G;
    private final n3.b H;
    private final n3.d I;
    private final Runnable J;
    private final Drawable K;
    private final Drawable L;
    private final Drawable M;
    private final String N;
    private final String O;
    private final String P;
    private final Drawable Q;
    private final Drawable R;
    private final float S;
    private final float T;
    private final String U;
    private final String V;
    private final Drawable W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f8553a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final Drawable f8554a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f8555b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final String f8556b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f8557c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final String f8558c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<m> f8559d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Drawable f8560d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RecyclerView f8561e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final Drawable f8562e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f8563f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final String f8564f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f8565g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final String f8566g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j f8567h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @Nullable
    private r2 f8568h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b f8569i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    private d f8570i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final y3.u f8571j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f8572j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PopupWindow f8573k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f8574k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f8575l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f8576l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final View f8577m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f8578m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final View f8579n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f8580n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final View f8581o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f8582o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private final View f8583p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f8584p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private final View f8585q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f8586q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private final TextView f8587r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private long[] f8588r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private final TextView f8589s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean[] f8590s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final ImageView f8591t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private long[] f8592t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private final ImageView f8593u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean[] f8594u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private final View f8595v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private long f8596v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private final ImageView f8597w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f8598w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private final ImageView f8599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private final ImageView f8600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private final View f8601z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    final class b extends l {
        private b() {
            super();
        }

        private boolean g(x3.z zVar) {
            for (int i10 = 0; i10 < this.f8622i.size(); i10++) {
                if (zVar.f36052y.containsKey(this.f8622i.get(i10).f8619a.b())) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolderAtZeroPosition$0(View view) {
            if (g.this.f8568h0 == null) {
                return;
            }
            ((r2) o0.j(g.this.f8568h0)).c(g.this.f8568h0.getTrackSelectionParameters().a().B(1).J(1, false).A());
            g.this.f8563f.setSubTextAtPosition(1, g.this.getResources().getString(y3.o.f36592w));
            g.this.f8573k.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.g.l
        public void d(i iVar) {
            iVar.f8616b.setText(y3.o.f36592w);
            iVar.f8617c.setVisibility(g(((r2) a4.a.e(g.this.f8568h0)).getTrackSelectionParameters()) ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8632a.lambda$onBindViewHolderAtZeroPosition$0(view);
                }
            });
        }

        public void init(List<k> list) {
            this.f8622i = list;
            x3.z trackSelectionParameters = ((r2) a4.a.e(g.this.f8568h0)).getTrackSelectionParameters();
            if (list.isEmpty()) {
                g.this.f8563f.setSubTextAtPosition(1, g.this.getResources().getString(y3.o.f36593x));
                return;
            }
            if (!g(trackSelectionParameters)) {
                g.this.f8563f.setSubTextAtPosition(1, g.this.getResources().getString(y3.o.f36592w));
                return;
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                k kVar = list.get(i10);
                if (kVar.a()) {
                    g.this.f8563f.setSubTextAtPosition(1, kVar.f8621c);
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.ui.g.l
        public void onTrackSelection(String str) {
            g.this.f8563f.setSubTextAtPosition(1, str);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    private final class c implements r2.d, f0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        private c() {
        }

        @Override // k2.r2.d
        public /* synthetic */ void B(k2.o oVar) {
            t2.d(this, oVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void D(r2.e eVar, r2.e eVar2, int i10) {
            t2.u(this, eVar, eVar2, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void E(n2 n2Var) {
            t2.r(this, n2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void F(r2.b bVar) {
            t2.a(this, bVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void G(s3 s3Var) {
            t2.D(this, s3Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void H(x3.z zVar) {
            t2.C(this, zVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void a(n3.f fVar) {
            t2.c(this, fVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void f(b4.b0 b0Var) {
            t2.E(this, b0Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void h(q2 q2Var) {
            t2.n(this, q2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void j(c3.a aVar) {
            t2.l(this, aVar);
        }

        @Override // com.google.android.exoplayer2.ui.f0.a
        public void k(f0 f0Var, long j10) {
            if (g.this.D != null) {
                g.this.D.setText(o0.b0(g.this.F, g.this.G, j10));
            }
        }

        @Override // k2.r2.d
        public /* synthetic */ void m(b2 b2Var) {
            t2.k(this, b2Var);
        }

        @Override // com.google.android.exoplayer2.ui.f0.a
        public void n(f0 f0Var, long j10, boolean z10) {
            g.this.f8580n0 = false;
            if (!z10 && g.this.f8568h0 != null) {
                g gVar = g.this;
                gVar.p0(gVar.f8568h0, j10);
            }
            g.this.f8553a.W();
        }

        @Override // com.google.android.exoplayer2.ui.f0.a
        public void o(f0 f0Var, long j10) {
            g.this.f8580n0 = true;
            if (g.this.D != null) {
                g.this.D.setText(o0.b0(g.this.F, g.this.G, j10));
            }
            g.this.f8553a.V();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r2 r2Var = g.this.f8568h0;
            if (r2Var == null) {
                return;
            }
            g.this.f8553a.W();
            if (g.this.f8579n == view) {
                r2Var.seekToNext();
                return;
            }
            if (g.this.f8577m == view) {
                r2Var.seekToPrevious();
                return;
            }
            if (g.this.f8583p == view) {
                if (r2Var.getPlaybackState() != 4) {
                    r2Var.seekForward();
                    return;
                }
                return;
            }
            if (g.this.f8585q == view) {
                r2Var.seekBack();
                return;
            }
            if (g.this.f8581o == view) {
                g.this.X(r2Var);
                return;
            }
            if (g.this.f8591t == view) {
                r2Var.setRepeatMode(a4.f0.a(r2Var.getRepeatMode(), g.this.f8586q0));
                return;
            }
            if (g.this.f8593u == view) {
                r2Var.setShuffleModeEnabled(!r2Var.getShuffleModeEnabled());
                return;
            }
            if (g.this.f8601z == view) {
                g.this.f8553a.V();
                g gVar = g.this;
                gVar.Y(gVar.f8563f, g.this.f8601z);
                return;
            }
            if (g.this.A == view) {
                g.this.f8553a.V();
                g gVar2 = g.this;
                gVar2.Y(gVar2.f8565g, g.this.A);
            } else if (g.this.B == view) {
                g.this.f8553a.V();
                g gVar3 = g.this;
                gVar3.Y(gVar3.f8569i, g.this.B);
            } else if (g.this.f8597w == view) {
                g.this.f8553a.V();
                g gVar4 = g.this;
                gVar4.Y(gVar4.f8567h, g.this.f8597w);
            }
        }

        @Override // k2.r2.d
        public /* synthetic */ void onCues(List list) {
            t2.b(this, list);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
            t2.e(this, i10, z10);
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (g.this.f8598w0) {
                g.this.f8553a.W();
            }
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            t2.g(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            t2.h(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            t2.i(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
            t2.m(this, z10, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlaybackStateChanged(int i10) {
            t2.o(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            t2.p(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
            t2.s(this, z10, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            t2.t(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            t2.v(this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onRepeatModeChanged(int i10) {
            t2.w(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            t2.y(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            t2.z(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
            t2.A(this, i10, i11);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onVolumeChanged(float f10) {
            t2.F(this, f10);
        }

        @Override // k2.r2.d
        public void t(r2 r2Var, r2.c cVar) {
            if (cVar.b(4, 5)) {
                g.this.y0();
            }
            if (cVar.b(4, 5, 7)) {
                g.this.A0();
            }
            if (cVar.a(8)) {
                g.this.B0();
            }
            if (cVar.a(9)) {
                g.this.E0();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                g.this.x0();
            }
            if (cVar.b(11, 0)) {
                g.this.F0();
            }
            if (cVar.a(12)) {
                g.this.z0();
            }
            if (cVar.a(2)) {
                g.this.G0();
            }
        }

        @Override // k2.r2.d
        public /* synthetic */ void u(n2 n2Var) {
            t2.q(this, n2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void x(w1 w1Var, int i10) {
            t2.j(this, w1Var, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void y() {
            t2.x(this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void z(n3 n3Var, int i10) {
            t2.B(this, n3Var, i10);
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    @Deprecated
    public interface d {
        void onFullScreenModeChanged(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    final class e extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String[] f8604i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f8605j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f8606k;

        public e(String[] strArr, float[] fArr) {
            this.f8604i = strArr;
            this.f8605j = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i10, View view) {
            if (i10 != this.f8606k) {
                g.this.setPlaybackSpeed(this.f8605j[i10]);
            }
            g.this.f8573k.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i10) {
            String[] strArr = this.f8604i;
            if (i10 < strArr.length) {
                iVar.f8616b.setText(strArr[i10]);
            }
            if (i10 == this.f8606k) {
                iVar.itemView.setSelected(true);
                iVar.f8617c.setVisibility(0);
            } else {
                iVar.itemView.setSelected(false);
                iVar.f8617c.setVisibility(4);
            }
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8633a.lambda$onBindViewHolder$0(i10, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new i(LayoutInflater.from(g.this.getContext()).inflate(y3.m.f36567e, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f8604i.length;
        }

        public String getSelectedText() {
            return this.f8604i[this.f8606k];
        }

        public void updateSelectedIndex(float f10) {
            int i10 = 0;
            float f11 = Float.MAX_VALUE;
            int i11 = 0;
            while (true) {
                float[] fArr = this.f8605j;
                if (i10 >= fArr.length) {
                    this.f8606k = i11;
                    return;
                }
                float fAbs = Math.abs(f10 - fArr[i10]);
                if (fAbs < f11) {
                    i11 = i10;
                    f11 = fAbs;
                }
                i10++;
            }
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    public interface f {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    final class C0190g extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f8608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TextView f8609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ImageView f8610d;

        public C0190g(View view) {
            super(view);
            if (o0.f214a < 26) {
                view.setFocusable(true);
            }
            this.f8608b = (TextView) view.findViewById(y3.k.f36555u);
            this.f8609c = (TextView) view.findViewById(y3.k.N);
            this.f8610d = (ImageView) view.findViewById(y3.k.f36554t);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f8635a.lambda$new$0(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            g.this.l0(getAdapterPosition());
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    private class h extends RecyclerView.Adapter<C0190g> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String[] f8612i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String[] f8613j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Drawable[] f8614k;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f8612i = strArr;
            this.f8613j = new String[strArr.length];
            this.f8614k = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0190g c0190g, int i10) {
            c0190g.f8608b.setText(this.f8612i[i10]);
            if (this.f8613j[i10] == null) {
                c0190g.f8609c.setVisibility(8);
            } else {
                c0190g.f8609c.setText(this.f8613j[i10]);
            }
            if (this.f8614k[i10] == null) {
                c0190g.f8610d.setVisibility(8);
            } else {
                c0190g.f8610d.setImageDrawable(this.f8614k[i10]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0190g onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return g.this.new C0190g(LayoutInflater.from(g.this.getContext()).inflate(y3.m.f36566d, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f8612i.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        public void setSubTextAtPosition(int i10, String str) {
            this.f8613j[i10] = str;
        }
    }

    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    private static class i extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f8616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f8617c;

        public i(View view) {
            super(view);
            if (o0.f214a < 26) {
                view.setFocusable(true);
            }
            this.f8616b = (TextView) view.findViewById(y3.k.Q);
            this.f8617c = view.findViewById(y3.k.f36542h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s3.a f8619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8621c;

        public k(s3 s3Var, int i10, int i11, String str) {
            this.f8619a = s3Var.b().get(i10);
            this.f8620b = i11;
            this.f8621c = str;
        }

        public boolean a() {
            return this.f8619a.f(this.f8620b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    abstract class l extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected List<k> f8622i = new ArrayList();

        protected l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(r2 r2Var, c1 c1Var, k kVar, View view) {
            r2Var.c(r2Var.getTrackSelectionParameters().a().G(new x3.x(c1Var, com.google.common.collect.y.r(Integer.valueOf(kVar.f8620b)))).J(kVar.f8619a.d(), false).A());
            onTrackSelection(kVar.f8621c);
            g.this.f8573k.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c */
        public void onBindViewHolder(i iVar, int i10) {
            final r2 r2Var = g.this.f8568h0;
            if (r2Var == null) {
                return;
            }
            if (i10 == 0) {
                d(iVar);
                return;
            }
            final k kVar = this.f8622i.get(i10 - 1);
            final c1 c1VarB = kVar.f8619a.b();
            boolean z10 = r2Var.getTrackSelectionParameters().f36052y.get(c1VarB) != null && kVar.a();
            iVar.f8616b.setText(kVar.f8621c);
            iVar.f8617c.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8637a.b(r2Var, c1VarB, kVar, view);
                }
            });
        }

        protected void clear() {
            this.f8622i = Collections.emptyList();
        }

        protected abstract void d(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new i(LayoutInflater.from(g.this.getContext()).inflate(y3.m.f36567e, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f8622i.isEmpty()) {
                return 0;
            }
            return this.f8622i.size() + 1;
        }

        protected abstract void onTrackSelection(String str);
    }

    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    @Deprecated
    public interface m {
        void onVisibilityChange(int i10);
    }

    static {
        l1.a("goog.exo.ui");
        f8552x0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.view.LayoutInflater] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.view.ViewGroup, com.google.android.exoplayer2.ui.g$a] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public g(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        c cVar;
        boolean z18;
        boolean z19;
        ?? r92;
        boolean z20;
        super(context, attributeSet, i10);
        int resourceId = y3.m.f36563a;
        this.f8582o0 = 5000;
        this.f8586q0 = 0;
        this.f8584p0 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, y3.q.A, i10, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(y3.q.C, resourceId);
                this.f8582o0 = typedArrayObtainStyledAttributes.getInt(y3.q.K, this.f8582o0);
                this.f8586q0 = a0(typedArrayObtainStyledAttributes, this.f8586q0);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(y3.q.H, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(y3.q.E, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(y3.q.G, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(y3.q.F, true);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(y3.q.I, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(y3.q.J, false);
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(y3.q.L, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(y3.q.M, this.f8584p0));
                boolean z28 = typedArrayObtainStyledAttributes.getBoolean(y3.q.B, true);
                typedArrayObtainStyledAttributes.recycle();
                z11 = z25;
                z12 = z26;
                z14 = z21;
                z15 = z22;
                z16 = z23;
                z13 = z28;
                z17 = z24;
                z10 = z27;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = true;
            z17 = true;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar2 = new c();
        this.f8557c = cVar2;
        this.f8559d = new CopyOnWriteArrayList<>();
        this.H = new n3.b();
        this.I = new n3.d();
        StringBuilder sb = new StringBuilder();
        this.F = sb;
        this.G = new Formatter(sb, Locale.getDefault());
        this.f8588r0 = new long[0];
        this.f8590s0 = new boolean[0];
        this.f8592t0 = new long[0];
        this.f8594u0 = new boolean[0];
        this.J = new Runnable() { // from class: y3.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f36624a.A0();
            }
        };
        this.C = (TextView) findViewById(y3.k.f36547m);
        this.D = (TextView) findViewById(y3.k.D);
        ImageView imageView = (ImageView) findViewById(y3.k.O);
        this.f8597w = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(y3.k.f36553s);
        this.f8599x = imageView2;
        e0(imageView2, new View.OnClickListener() { // from class: y3.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f36625a.j0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(y3.k.f36557w);
        this.f8600y = imageView3;
        e0(imageView3, new View.OnClickListener() { // from class: y3.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f36625a.j0(view);
            }
        });
        View viewFindViewById = findViewById(y3.k.K);
        this.f8601z = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar2);
        }
        View viewFindViewById2 = findViewById(y3.k.C);
        this.A = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar2);
        }
        View viewFindViewById3 = findViewById(y3.k.f36537c);
        this.B = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar2);
        }
        int i11 = y3.k.F;
        f0 f0Var = (f0) findViewById(i11);
        View viewFindViewById4 = findViewById(y3.k.G);
        if (f0Var != null) {
            this.E = f0Var;
            cVar = cVar2;
            z18 = z13;
            z19 = z10;
            r92 = 0;
        } else if (viewFindViewById4 != null) {
            r92 = 0;
            cVar = cVar2;
            z18 = z13;
            z19 = z10;
            com.google.android.exoplayer2.ui.b bVar = new com.google.android.exoplayer2.ui.b(context, null, 0, attributeSet2, y3.p.f36596a);
            bVar.setId(i11);
            bVar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(bVar, iIndexOfChild);
            this.E = bVar;
        } else {
            cVar = cVar2;
            z18 = z13;
            z19 = z10;
            r92 = 0;
            this.E = null;
        }
        f0 f0Var2 = this.E;
        c cVar3 = cVar;
        if (f0Var2 != null) {
            f0Var2.a(cVar3);
        }
        View viewFindViewById5 = findViewById(y3.k.B);
        this.f8581o = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar3);
        }
        View viewFindViewById6 = findViewById(y3.k.E);
        this.f8577m = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar3);
        }
        View viewFindViewById7 = findViewById(y3.k.f36558x);
        this.f8579n = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar3);
        }
        Typeface font = ResourcesCompat.getFont(context, y3.j.f36534a);
        ?? FindViewById = findViewById(y3.k.I);
        ?? r62 = FindViewById == 0 ? (TextView) findViewById(y3.k.J) : r92;
        this.f8589s = r62;
        if (r62 != 0) {
            r62.setTypeface(font);
        }
        FindViewById = FindViewById == 0 ? r62 : FindViewById;
        this.f8585q = FindViewById;
        if (FindViewById != 0) {
            FindViewById.setOnClickListener(cVar3);
        }
        ?? FindViewById2 = findViewById(y3.k.f36551q);
        ?? r63 = FindViewById2 == 0 ? (TextView) findViewById(y3.k.f36552r) : r92;
        this.f8587r = r63;
        if (r63 != 0) {
            r63.setTypeface(font);
        }
        FindViewById2 = FindViewById2 == 0 ? r63 : FindViewById2;
        this.f8583p = FindViewById2;
        if (FindViewById2 != 0) {
            FindViewById2.setOnClickListener(cVar3);
        }
        ImageView imageView4 = (ImageView) findViewById(y3.k.H);
        this.f8591t = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar3);
        }
        ImageView imageView5 = (ImageView) findViewById(y3.k.L);
        this.f8593u = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar3);
        }
        Resources resources = context.getResources();
        this.f8555b = resources;
        this.S = resources.getInteger(y3.l.f36562b) / 100.0f;
        this.T = resources.getInteger(y3.l.f36561a) / 100.0f;
        View viewFindViewById8 = findViewById(y3.k.S);
        this.f8595v = viewFindViewById8;
        if (viewFindViewById8 != null) {
            t0(false, viewFindViewById8);
        }
        z zVar = new z(this);
        this.f8553a = zVar;
        zVar.X(z18);
        h hVar = new h(new String[]{resources.getString(y3.o.f36577h), resources.getString(y3.o.f36594y)}, new Drawable[]{resources.getDrawable(y3.i.f36531l), resources.getDrawable(y3.i.f36521b)});
        this.f8563f = hVar;
        this.f8575l = resources.getDimensionPixelSize(y3.h.f36516a);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(y3.m.f36565c, r92);
        this.f8561e = recyclerView;
        recyclerView.setAdapter(hVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.f8573k = popupWindow;
        if (o0.f214a < 23) {
            z20 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z20 = false;
        }
        popupWindow.setOnDismissListener(cVar3);
        this.f8598w0 = true;
        this.f8571j = new y3.e(getResources());
        this.W = resources.getDrawable(y3.i.f36533n);
        this.f8554a0 = resources.getDrawable(y3.i.f36532m);
        this.f8556b0 = resources.getString(y3.o.f36571b);
        this.f8558c0 = resources.getString(y3.o.f36570a);
        this.f8567h = new j();
        this.f8569i = new b();
        this.f8565g = new e(resources.getStringArray(y3.f.f36514a), f8552x0);
        this.f8560d0 = resources.getDrawable(y3.i.f36523d);
        this.f8562e0 = resources.getDrawable(y3.i.f36522c);
        this.K = resources.getDrawable(y3.i.f36527h);
        this.L = resources.getDrawable(y3.i.f36528i);
        this.M = resources.getDrawable(y3.i.f36526g);
        this.Q = resources.getDrawable(y3.i.f36530k);
        this.R = resources.getDrawable(y3.i.f36529j);
        this.f8564f0 = resources.getString(y3.o.f36573d);
        this.f8566g0 = resources.getString(y3.o.f36572c);
        this.N = this.f8555b.getString(y3.o.f36579j);
        this.O = this.f8555b.getString(y3.o.f36580k);
        this.P = this.f8555b.getString(y3.o.f36578i);
        this.U = this.f8555b.getString(y3.o.f36583n);
        this.V = this.f8555b.getString(y3.o.f36582m);
        this.f8553a.Y((ViewGroup) findViewById(y3.k.f36539e), true);
        this.f8553a.Y(this.f8583p, z15);
        this.f8553a.Y(this.f8585q, z14);
        this.f8553a.Y(this.f8577m, z16);
        this.f8553a.Y(this.f8579n, z17);
        this.f8553a.Y(this.f8593u, z11);
        this.f8553a.Y(this.f8597w, z12);
        this.f8553a.Y(this.f8595v, z19);
        this.f8553a.Y(this.f8591t, this.f8586q0 != 0 ? true : z20);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: y3.t
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                this.f36626a.k0(view, i12, i13, i14, i15, i16, i17, i18, i19);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        long contentPosition;
        long contentBufferedPosition;
        if (h0() && this.f8574k0) {
            r2 r2Var = this.f8568h0;
            if (r2Var != null) {
                contentPosition = this.f8596v0 + r2Var.getContentPosition();
                contentBufferedPosition = this.f8596v0 + r2Var.getContentBufferedPosition();
            } else {
                contentPosition = 0;
                contentBufferedPosition = 0;
            }
            TextView textView = this.D;
            if (textView != null && !this.f8580n0) {
                textView.setText(o0.b0(this.F, this.G, contentPosition));
            }
            f0 f0Var = this.E;
            if (f0Var != null) {
                f0Var.setPosition(contentPosition);
                this.E.setBufferedPosition(contentBufferedPosition);
            }
            removeCallbacks(this.J);
            int playbackState = r2Var == null ? 1 : r2Var.getPlaybackState();
            if (r2Var == null || !r2Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.J, 1000L);
                return;
            }
            f0 f0Var2 = this.E;
            long jMin = Math.min(f0Var2 != null ? f0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f10 = r2Var.getPlaybackParameters().f29421a;
            postDelayed(this.J, o0.q(f10 > 0.0f ? (long) (jMin / f10) : 1000L, this.f8584p0, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        ImageView imageView;
        if (h0() && this.f8574k0 && (imageView = this.f8591t) != null) {
            if (this.f8586q0 == 0) {
                t0(false, imageView);
                return;
            }
            r2 r2Var = this.f8568h0;
            if (r2Var == null) {
                t0(false, imageView);
                this.f8591t.setImageDrawable(this.K);
                this.f8591t.setContentDescription(this.N);
                return;
            }
            t0(true, imageView);
            int repeatMode = r2Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f8591t.setImageDrawable(this.K);
                this.f8591t.setContentDescription(this.N);
            } else if (repeatMode == 1) {
                this.f8591t.setImageDrawable(this.L);
                this.f8591t.setContentDescription(this.O);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f8591t.setImageDrawable(this.M);
                this.f8591t.setContentDescription(this.P);
            }
        }
    }

    private void C0() {
        r2 r2Var = this.f8568h0;
        int seekBackIncrement = (int) ((r2Var != null ? r2Var.getSeekBackIncrement() : 5000L) / 1000);
        TextView textView = this.f8589s;
        if (textView != null) {
            textView.setText(String.valueOf(seekBackIncrement));
        }
        View view = this.f8585q;
        if (view != null) {
            view.setContentDescription(this.f8555b.getQuantityString(y3.n.f36569b, seekBackIncrement, Integer.valueOf(seekBackIncrement)));
        }
    }

    private void D0() {
        this.f8561e.measure(0, 0);
        this.f8573k.setWidth(Math.min(this.f8561e.getMeasuredWidth(), getWidth() - (this.f8575l * 2)));
        this.f8573k.setHeight(Math.min(getHeight() - (this.f8575l * 2), this.f8561e.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        ImageView imageView;
        if (h0() && this.f8574k0 && (imageView = this.f8593u) != null) {
            r2 r2Var = this.f8568h0;
            if (!this.f8553a.A(imageView)) {
                t0(false, this.f8593u);
                return;
            }
            if (r2Var == null) {
                t0(false, this.f8593u);
                this.f8593u.setImageDrawable(this.R);
                this.f8593u.setContentDescription(this.V);
            } else {
                t0(true, this.f8593u);
                this.f8593u.setImageDrawable(r2Var.getShuffleModeEnabled() ? this.Q : this.R);
                this.f8593u.setContentDescription(r2Var.getShuffleModeEnabled() ? this.U : this.V);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F0() {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.g.F0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        d0();
        t0(this.f8567h.getItemCount() > 0, this.f8597w);
    }

    private static boolean T(n3 n3Var, n3.d dVar) {
        if (n3Var.t() > 100) {
            return false;
        }
        int iT = n3Var.t();
        for (int i10 = 0; i10 < iT; i10++) {
            if (n3Var.r(i10, dVar).f29326n == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    private void V(r2 r2Var) {
        r2Var.pause();
    }

    private void W(r2 r2Var) {
        int playbackState = r2Var.getPlaybackState();
        if (playbackState == 1) {
            r2Var.prepare();
        } else if (playbackState == 4) {
            o0(r2Var, r2Var.getCurrentMediaItemIndex(), C.TIME_UNSET);
        }
        r2Var.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(r2 r2Var) {
        int playbackState = r2Var.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !r2Var.getPlayWhenReady()) {
            W(r2Var);
        } else {
            V(r2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(RecyclerView.Adapter<?> adapter, View view) {
        this.f8561e.setAdapter(adapter);
        D0();
        this.f8598w0 = false;
        this.f8573k.dismiss();
        this.f8598w0 = true;
        this.f8573k.showAsDropDown(view, (getWidth() - this.f8573k.getWidth()) - this.f8575l, (-this.f8573k.getHeight()) - this.f8575l);
    }

    private com.google.common.collect.y<k> Z(s3 s3Var, int i10) {
        y.a aVar = new y.a();
        com.google.common.collect.y<s3.a> yVarB = s3Var.b();
        for (int i11 = 0; i11 < yVarB.size(); i11++) {
            s3.a aVar2 = yVarB.get(i11);
            if (aVar2.d() == i10) {
                for (int i12 = 0; i12 < aVar2.f29478a; i12++) {
                    if (aVar2.g(i12)) {
                        o1 o1VarC = aVar2.c(i12);
                        if ((o1VarC.f29339d & 2) == 0) {
                            aVar.a(new k(s3Var, i11, i12, this.f8571j.a(o1VarC)));
                        }
                    }
                }
            }
        }
        return aVar.k();
    }

    private static int a0(TypedArray typedArray, int i10) {
        return typedArray.getInt(y3.q.D, i10);
    }

    private void d0() {
        this.f8567h.clear();
        this.f8569i.clear();
        r2 r2Var = this.f8568h0;
        if (r2Var != null && r2Var.isCommandAvailable(30) && this.f8568h0.isCommandAvailable(29)) {
            s3 currentTracks = this.f8568h0.getCurrentTracks();
            this.f8569i.init(Z(currentTracks, 1));
            if (this.f8553a.A(this.f8597w)) {
                this.f8567h.init(Z(currentTracks, 3));
            } else {
                this.f8567h.init(com.google.common.collect.y.q());
            }
        }
    }

    private static void e0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean g0(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(View view) {
        if (this.f8570i0 == null) {
            return;
        }
        boolean z10 = !this.f8572j0;
        this.f8572j0 = z10;
        v0(this.f8599x, z10);
        v0(this.f8600y, this.f8572j0);
        d dVar = this.f8570i0;
        if (dVar != null) {
            dVar.onFullScreenModeChanged(this.f8572j0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i13 - i11;
        int i19 = i17 - i15;
        if (!(i12 - i10 == i16 - i14 && i18 == i19) && this.f8573k.isShowing()) {
            D0();
            this.f8573k.update(view, (getWidth() - this.f8573k.getWidth()) - this.f8575l, (-this.f8573k.getHeight()) - this.f8575l, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(int i10) {
        if (i10 == 0) {
            Y(this.f8565g, (View) a4.a.e(this.f8601z));
        } else if (i10 == 1) {
            Y(this.f8569i, (View) a4.a.e(this.f8601z));
        } else {
            this.f8573k.dismiss();
        }
    }

    private void o0(r2 r2Var, int i10, long j10) {
        r2Var.seekTo(i10, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(r2 r2Var, long j10) {
        int currentMediaItemIndex;
        n3 currentTimeline = r2Var.getCurrentTimeline();
        if (this.f8578m0 && !currentTimeline.u()) {
            int iT = currentTimeline.t();
            currentMediaItemIndex = 0;
            while (true) {
                long jG = currentTimeline.r(currentMediaItemIndex, this.I).g();
                if (j10 < jG) {
                    break;
                }
                if (currentMediaItemIndex == iT - 1) {
                    j10 = jG;
                    break;
                } else {
                    j10 -= jG;
                    currentMediaItemIndex++;
                }
            }
        } else {
            currentMediaItemIndex = r2Var.getCurrentMediaItemIndex();
        }
        o0(r2Var, currentMediaItemIndex, j10);
        A0();
    }

    private boolean q0() {
        r2 r2Var = this.f8568h0;
        return (r2Var == null || r2Var.getPlaybackState() == 4 || this.f8568h0.getPlaybackState() == 1 || !this.f8568h0.getPlayWhenReady()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        r2 r2Var = this.f8568h0;
        if (r2Var == null) {
            return;
        }
        r2Var.b(r2Var.getPlaybackParameters().e(f10));
    }

    private void t0(boolean z10, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.S : this.T);
    }

    private void u0() {
        r2 r2Var = this.f8568h0;
        int seekForwardIncrement = (int) ((r2Var != null ? r2Var.getSeekForwardIncrement() : 15000L) / 1000);
        TextView textView = this.f8587r;
        if (textView != null) {
            textView.setText(String.valueOf(seekForwardIncrement));
        }
        View view = this.f8583p;
        if (view != null) {
            view.setContentDescription(this.f8555b.getQuantityString(y3.n.f36568a, seekForwardIncrement, Integer.valueOf(seekForwardIncrement)));
        }
    }

    private void v0(@Nullable ImageView imageView, boolean z10) {
        if (imageView == null) {
            return;
        }
        if (z10) {
            imageView.setImageDrawable(this.f8560d0);
            imageView.setContentDescription(this.f8564f0);
        } else {
            imageView.setImageDrawable(this.f8562e0);
            imageView.setContentDescription(this.f8566g0);
        }
    }

    private static void w0(@Nullable View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (h0() && this.f8574k0) {
            r2 r2Var = this.f8568h0;
            if (r2Var != null) {
                zIsCommandAvailable = r2Var.isCommandAvailable(5);
                zIsCommandAvailable3 = r2Var.isCommandAvailable(7);
                zIsCommandAvailable4 = r2Var.isCommandAvailable(11);
                zIsCommandAvailable5 = r2Var.isCommandAvailable(12);
                zIsCommandAvailable2 = r2Var.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            if (zIsCommandAvailable4) {
                C0();
            }
            if (zIsCommandAvailable5) {
                u0();
            }
            t0(zIsCommandAvailable3, this.f8577m);
            t0(zIsCommandAvailable4, this.f8585q);
            t0(zIsCommandAvailable5, this.f8583p);
            t0(zIsCommandAvailable2, this.f8579n);
            f0 f0Var = this.E;
            if (f0Var != null) {
                f0Var.setEnabled(zIsCommandAvailable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (h0() && this.f8574k0 && this.f8581o != null) {
            if (q0()) {
                ((ImageView) this.f8581o).setImageDrawable(this.f8555b.getDrawable(y3.i.f36524e));
                this.f8581o.setContentDescription(this.f8555b.getString(y3.o.f36575f));
            } else {
                ((ImageView) this.f8581o).setImageDrawable(this.f8555b.getDrawable(y3.i.f36525f));
                this.f8581o.setContentDescription(this.f8555b.getString(y3.o.f36576g));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        r2 r2Var = this.f8568h0;
        if (r2Var == null) {
            return;
        }
        this.f8565g.updateSelectedIndex(r2Var.getPlaybackParameters().f29421a);
        this.f8563f.setSubTextAtPosition(0, this.f8565g.getSelectedText());
    }

    @Deprecated
    public void S(m mVar) {
        a4.a.e(mVar);
        this.f8559d.add(mVar);
    }

    public boolean U(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        r2 r2Var = this.f8568h0;
        if (r2Var == null || !g0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (r2Var.getPlaybackState() == 4) {
                return true;
            }
            r2Var.seekForward();
            return true;
        }
        if (keyCode == 89) {
            r2Var.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            X(r2Var);
            return true;
        }
        if (keyCode == 87) {
            r2Var.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            r2Var.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            W(r2Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        V(r2Var);
        return true;
    }

    public void b0() {
        this.f8553a.C();
    }

    public void c0() {
        this.f8553a.F();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return U(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean f0() {
        return this.f8553a.I();
    }

    @Nullable
    public r2 getPlayer() {
        return this.f8568h0;
    }

    public int getRepeatToggleModes() {
        return this.f8586q0;
    }

    public boolean getShowShuffleButton() {
        return this.f8553a.A(this.f8593u);
    }

    public boolean getShowSubtitleButton() {
        return this.f8553a.A(this.f8597w);
    }

    public int getShowTimeoutMs() {
        return this.f8582o0;
    }

    public boolean getShowVrButton() {
        return this.f8553a.A(this.f8595v);
    }

    public boolean h0() {
        return getVisibility() == 0;
    }

    void i0() {
        Iterator<m> it = this.f8559d.iterator();
        while (it.hasNext()) {
            it.next().onVisibilityChange(getVisibility());
        }
    }

    @Deprecated
    public void m0(m mVar) {
        this.f8559d.remove(mVar);
    }

    void n0() {
        View view = this.f8581o;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8553a.O();
        this.f8574k0 = true;
        if (f0()) {
            this.f8553a.W();
        }
        s0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8553a.P();
        this.f8574k0 = false;
        removeCallbacks(this.J);
        this.f8553a.V();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f8553a.Q(z10, i10, i11, i12, i13);
    }

    public void r0() {
        this.f8553a.b0();
    }

    void s0() {
        y0();
        x0();
        B0();
        E0();
        G0();
        z0();
        F0();
    }

    public void setAnimationEnabled(boolean z10) {
        this.f8553a.X(z10);
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.f8570i0 = dVar;
        w0(this.f8599x, dVar != null);
        w0(this.f8600y, dVar != null);
    }

    public void setPlayer(@Nullable r2 r2Var) {
        boolean z10 = true;
        a4.a.g(Looper.myLooper() == Looper.getMainLooper());
        if (r2Var != null && r2Var.getApplicationLooper() != Looper.getMainLooper()) {
            z10 = false;
        }
        a4.a.a(z10);
        r2 r2Var2 = this.f8568h0;
        if (r2Var2 == r2Var) {
            return;
        }
        if (r2Var2 != null) {
            r2Var2.f(this.f8557c);
        }
        this.f8568h0 = r2Var;
        if (r2Var != null) {
            r2Var.a(this.f8557c);
        }
        s0();
    }

    public void setRepeatToggleModes(int i10) {
        this.f8586q0 = i10;
        r2 r2Var = this.f8568h0;
        if (r2Var != null) {
            int repeatMode = r2Var.getRepeatMode();
            if (i10 == 0 && repeatMode != 0) {
                this.f8568h0.setRepeatMode(0);
            } else if (i10 == 1 && repeatMode == 2) {
                this.f8568h0.setRepeatMode(1);
            } else if (i10 == 2 && repeatMode == 1) {
                this.f8568h0.setRepeatMode(2);
            }
        }
        this.f8553a.Y(this.f8591t, i10 != 0);
        B0();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f8553a.Y(this.f8583p, z10);
        x0();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.f8576l0 = z10;
        F0();
    }

    public void setShowNextButton(boolean z10) {
        this.f8553a.Y(this.f8579n, z10);
        x0();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f8553a.Y(this.f8577m, z10);
        x0();
    }

    public void setShowRewindButton(boolean z10) {
        this.f8553a.Y(this.f8585q, z10);
        x0();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f8553a.Y(this.f8593u, z10);
        E0();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f8553a.Y(this.f8597w, z10);
    }

    public void setShowTimeoutMs(int i10) {
        this.f8582o0 = i10;
        if (f0()) {
            this.f8553a.W();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f8553a.Y(this.f8595v, z10);
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.f8584p0 = o0.p(i10, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f8595v;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            t0(onClickListener != null, this.f8595v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyledPlayerControlView.java */
    final class j extends l {
        private j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolderAtZeroPosition$0(View view) {
            if (g.this.f8568h0 != null) {
                g.this.f8568h0.c(g.this.f8568h0.getTrackSelectionParameters().a().B(3).F(-3).A());
                g.this.f8573k.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.g.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i10) {
            super.onBindViewHolder(iVar, i10);
            if (i10 > 0) {
                iVar.f8617c.setVisibility(this.f8622i.get(i10 + (-1)).a() ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.g.l
        public void d(i iVar) {
            boolean z10;
            iVar.f8616b.setText(y3.o.f36593x);
            int i10 = 0;
            while (true) {
                if (i10 >= this.f8622i.size()) {
                    z10 = true;
                    break;
                } else {
                    if (this.f8622i.get(i10).a()) {
                        z10 = false;
                        break;
                    }
                    i10++;
                }
            }
            iVar.f8617c.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8636a.lambda$onBindViewHolderAtZeroPosition$0(view);
                }
            });
        }

        public void init(List<k> list) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= list.size()) {
                    break;
                }
                if (list.get(i10).a()) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (g.this.f8597w != null) {
                ImageView imageView = g.this.f8597w;
                g gVar = g.this;
                imageView.setImageDrawable(z10 ? gVar.W : gVar.f8554a0);
                g.this.f8597w.setContentDescription(z10 ? g.this.f8556b0 : g.this.f8558c0);
            }
            this.f8622i = list;
        }

        @Override // com.google.android.exoplayer2.ui.g.l
        public void onTrackSelection(String str) {
        }
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }
}
