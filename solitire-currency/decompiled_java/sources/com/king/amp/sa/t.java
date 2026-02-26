package com.king.amp.sa;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.king.amp.sa.i0;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: AbmImageFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class t extends r0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static String f16941y = "AbmImageFragment";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k6.e f16942p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f16943q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private i0 f16946t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f16949w;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f16944r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f16945s = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f16947u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f16948v = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f16950x = false;

    /* JADX INFO: compiled from: AbmImageFragment.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.z("end_card_cta", s1.a());
            t.this.T();
        }
    }

    /* JADX INFO: compiled from: AbmImageFragment.java */
    class b extends TimerTask {

        /* JADX INFO: compiled from: AbmImageFragment.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                t.this.f16943q.setClickable(true);
            }
        }

        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (t.this.getActivity() != null) {
                t.this.getActivity().runOnUiThread(new a());
            }
        }
    }

    /* JADX INFO: compiled from: AbmImageFragment.java */
    class c implements i0.c {
        c() {
        }

        @Override // com.king.amp.sa.i0.c
        public void a(float f10) {
            t.this.H((int) f10);
        }
    }

    /* JADX INFO: compiled from: AbmImageFragment.java */
    class d implements i0.b {
        d() {
        }

        @Override // com.king.amp.sa.i0.b
        public void a() {
            t.this.f16948v = false;
            if (t.this.f16947u) {
                return;
            }
            t.this.H(100);
            t.this.f16945s = true;
            t tVar = t.this;
            n nVar = tVar.f16880d;
            if (nVar != null) {
                nVar.o(tVar.f16949w);
            }
        }
    }

    public static t P(@NonNull Map<String, String> map, long j10) {
        t tVar = new t();
        Bundle bundle = new Bundle();
        bundle.putSerializable("custom_map", new HashMap(map));
        bundle.putLong("player_id", j10);
        tVar.setArguments(bundle);
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (isAdded()) {
            this.f16943q.setClickable(false);
            new Timer().schedule(new b(), 500L);
        }
    }

    public boolean O() {
        return this.f16945s;
    }

    protected void Q() {
        if (this.f16945s) {
            this.f16946t = null;
        }
        i0 i0Var = this.f16946t;
        if (i0Var == null || !i0Var.p()) {
            return;
        }
        this.f16947u = true;
        this.f16946t.r();
    }

    protected void R() {
        i0 i0Var = this.f16946t;
        if (i0Var != null) {
            i0Var.n();
            this.f16946t = null;
        }
        H(0);
    }

    protected void S() {
        i0 i0Var = this.f16946t;
        if (i0Var == null || !this.f16947u) {
            U();
        } else {
            this.f16947u = false;
            i0Var.s();
        }
    }

    protected void U() {
        i0 i0Var = this.f16946t;
        if (i0Var != null) {
            i0Var.n();
        }
        this.f16948v = true;
        this.f16945s = false;
        this.f16947u = false;
        H(0);
        i0 i0Var2 = new i0(0, 100, this.f16944r, new LinearInterpolator(), new c(), new d());
        this.f16946t = i0Var2;
        i0Var2.v();
    }

    protected void V() {
        i0 i0Var = this.f16946t;
        if (i0Var != null) {
            i0Var.n();
            this.f16946t = null;
        }
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        boolean z10 = Boolean.parseBoolean((String) s(this.f16879c, "is_chapter_image", "false"));
        this.f16950x = z10;
        if (z10) {
            this.f16881e = true;
        } else {
            this.f16881e = false;
        }
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        k6.e eVarC = k6.e.c(layoutInflater, viewGroup, false);
        this.f16942p = eVarC;
        if (this.f16950x) {
            this.f16943q = eVarC.f29708c;
            eVarC.f29710e.setVisibility(8);
            n nVar = this.f16880d;
            if (nVar != null) {
                nVar.s(0);
            }
            this.f16944r = Integer.parseInt((String) s(this.f16879c, "media_duration", "0")) * 1000;
        } else {
            this.f16943q = eVarC.f29710e;
            eVarC.f29708c.setVisibility(8);
        }
        String str = (String) s(this.f16879c, "content_file_path", "");
        boolean z10 = Boolean.parseBoolean((String) s(this.f16879c, "is_gif", "false"));
        this.f16949w = Integer.parseInt((String) s(this.f16879c, "chapter_idx", "-1"));
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                com.bumptech.glide.b.t(getContext()).k().x0(str).f(u0.j.f34321a).t0(this.f16943q);
            } else {
                this.f16943q.setImageDrawable(Drawable.createFromPath(str));
            }
        }
        String str2 = (String) s(this.f16879c, "image_width", "");
        String str3 = (String) s(this.f16879c, "image_height", "");
        ViewGroup.LayoutParams layoutParams = this.f16943q.getLayoutParams();
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            layoutParams.width = Integer.parseInt(str2);
            layoutParams.height = Integer.parseInt(str3);
        }
        this.f16943q.setLayoutParams(layoutParams);
        if (!this.f16950x) {
            this.f16943q.setOnClickListener(new a());
        }
        return this.f16942p.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        V();
        super.onDestroy();
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f16950x && this.f16949w == 0 && !this.f16948v) {
            U();
        }
    }

    @Override // com.king.amp.sa.r0
    public String p() {
        return "image";
    }

    @Override // com.king.amp.sa.r0
    String r() {
        return f16941y;
    }
}
