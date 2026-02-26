package com.king.amp.sa;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.king.amp.sa.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AbmMixedChapterFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class h0 extends r0 {
    private static String A = "AbmMixedChapterFragment";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k6.b f16752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ArrayList<HashMap<String, String>> f16753q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<c0> f16754r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b0 f16755s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f16756t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f16757u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f16758v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f16759w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f16760x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f16761y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f16762z = false;

    /* JADX INFO: compiled from: AbmMixedChapterFragment.java */
    class a extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f16763a = false;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (h0.this.f16755s.d(h0.this.f16756t)) {
                h0.this.k0();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            boolean z10 = i10 != 0;
            n nVar = h0.this.f16880d;
            if (nVar != null) {
                nVar.u(!z10);
            }
            if (i10 == 1) {
                h0.this.f16760x = true;
                h0 h0Var = h0.this;
                h0Var.f16761y = h0Var.f16756t;
            } else if (i10 == 0 && h0.this.f16760x) {
                h0.this.f16760x = false;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.king.amp.sa.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16750a.b();
                    }
                }, 50L);
            }
            if (i10 == 0 && h0.this.f16761y == h0.this.f16754r.size() - 1 && h0.this.f16756t == h0.this.f16754r.size() - 1) {
                h0.this.e0();
                return;
            }
            if (i10 == 0 && h0.this.f16756t != h0.this.f16754r.size() - 1) {
                h0.this.f16761y = -1;
            }
            super.onPageScrollStateChanged(i10);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            super.onPageScrolled(i10, f10, i11);
            h0.this.f16752p.f29697b.d(i10, f10);
            if (f10 < 0.5d || this.f16763a || ((c0) h0.this.f16754r.get(i10)).d() != b0.b.VIDEO) {
                return;
            }
            h0.this.f16755s.f(i10, h0.this.f16758v);
            this.f16763a = true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            super.onPageSelected(i10);
            if (h0.this.f16756t == i10 || h0.this.f16755s == null) {
                return;
            }
            if (h0.this.f16762z) {
                Log.d(h0.A, "skipping normal page selected handling during overscroll");
                return;
            }
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            adProviderNameValuePairs.add("previous_page", Integer.valueOf(h0.this.f16756t + 1));
            adProviderNameValuePairs.add("current_page", Integer.valueOf(i10 + 1));
            adProviderNameValuePairs.add("is_manually_scrolled", Integer.valueOf(h0.this.f16757u));
            h0.this.z("page_changed", s1.d(adProviderNameValuePairs));
            h0 h0Var = h0.this;
            h0Var.n0(h0Var.f16756t, i10);
            this.f16763a = false;
            b0.b bVarD = ((c0) h0.this.f16754r.get(h0.this.f16756t)).d();
            b0.b bVar = b0.b.VIDEO;
            if (bVarD == bVar) {
                h0.this.f16755s.p(h0.this.f16756t);
                h0.this.f16755s.s(h0.this.f16756t);
            } else {
                h0.this.f16755s.r(h0.this.f16756t);
            }
            if (((c0) h0.this.f16754r.get(i10)).d() == bVar) {
                h0.this.f16755s.q(i10);
            }
            h0.this.f16756t = i10;
            if (((c0) h0.this.f16754r.get(h0.this.f16756t)).d() == bVar) {
                h0.this.f16755s.v(h0.this.f16756t);
                h0.this.f16755s.e(h0.this.f16756t, h0.this.f16758v);
            } else {
                h0.this.f16755s.u(h0.this.f16756t);
            }
            h0.this.f16755s.k(i10);
            h0.this.f16757u = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Log.d(A, "User overscrolled past the last page — looping to first.");
        this.f16762z = true;
        final boolean z10 = this.f16757u == 0;
        this.f16757u = 1;
        if (this.f16754r.get(this.f16756t).d() == b0.b.VIDEO) {
            this.f16755s.p(this.f16756t);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.king.amp.sa.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f16744a.i0(z10);
            }
        }, 50L);
    }

    private void f0() {
        if (this.f16755s == null) {
            return;
        }
        if (this.f16754r.get(this.f16756t).d() == b0.b.VIDEO) {
            this.f16755s.p(this.f16756t);
        } else {
            this.f16755s.o(this.f16756t);
        }
    }

    private void g0() {
        if (this.f16755s == null) {
            return;
        }
        if (this.f16754r.get(this.f16756t).d() == b0.b.VIDEO) {
            this.f16755s.t(this.f16756t);
        } else {
            this.f16755s.u(this.f16756t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(boolean z10) {
        this.f16755s.k(0);
        if (this.f16754r.get(this.f16756t).d() == b0.b.VIDEO) {
            this.f16755s.q(this.f16756t);
            this.f16755s.v(this.f16756t);
            this.f16755s.e(this.f16756t, this.f16758v);
        } else {
            this.f16755s.u(this.f16756t);
        }
        if (z10) {
            this.f16757u = 0;
        }
        this.f16762z = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(final boolean z10) {
        this.f16752p.f29698c.setCurrentItem(0, true);
        this.f16756t = 0;
        n0(this.f16753q.size() - 1, this.f16756t);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.king.amp.sa.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f16747a.h0(z10);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Integer num) {
        if (num == null || num.intValue() != this.f16756t || this.f16760x) {
            return;
        }
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        if (this.f16760x) {
            return;
        }
        this.f16757u = 0;
        int itemCount = (this.f16756t + 1) % this.f16752p.f29698c.getAdapter().getItemCount();
        this.f16752p.f29698c.setCurrentItem(itemCount, true);
        this.f16756t = itemCount;
    }

    public static h0 l0(@NonNull Map<String, String> map, @NonNull ArrayList<HashMap<String, String>> arrayList, long j10) {
        h0 h0Var = new h0();
        Bundle bundle = new Bundle();
        bundle.putSerializable("custom_map", new HashMap(map));
        bundle.putSerializable("ad_content_list", arrayList);
        bundle.putLong("player_id", j10);
        h0Var.setArguments(bundle);
        return h0Var;
    }

    private void m0() {
        this.f16752p.f29698c.registerOnPageChangeCallback(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i10, int i11) {
        if (this.f16755s == null) {
            return;
        }
        HashMap map = new HashMap();
        Map<String, String> mapG = this.f16755s.g(i10);
        Map<String, String> mapG2 = this.f16755s.g(i11);
        String str = mapG.get("ad_title_text");
        String str2 = mapG.get("ad_description_text");
        String str3 = mapG.get("advertiser_icon");
        String str4 = mapG.get("cta_button_title");
        String str5 = mapG2.get("ad_title_text");
        String str6 = mapG2.get("ad_description_text");
        String str7 = mapG2.get("advertiser_icon");
        String str8 = mapG2.get("cta_button_title");
        map.put("current_title", str);
        map.put("current_description", str2);
        map.put("current_adIcon", str3);
        map.put("current_cta_title", str4);
        map.put("next_title", str5);
        map.put("next_description", str6);
        map.put("next_adIcon", str7);
        map.put("next_cta_title", str8);
        n nVar = this.f16880d;
        if (nVar != null) {
            nVar.l(map);
        }
    }

    public String c0(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".bmp") || lowerCase.endsWith(".webp")) ? "image" : (lowerCase.endsWith(".mp4") || lowerCase.endsWith(".mkv") || lowerCase.endsWith(".avi") || lowerCase.endsWith(".mov")) ? "video" : lowerCase.endsWith(".gif") ? "gif" : "unknown";
    }

    public AbmAdPlayer d0() {
        return this.f16878b;
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requireActivity().setRequestedOrientation(1);
        this.f16881e = true;
        if (getArguments() != null) {
            ArrayList<HashMap<String, String>> arrayList = (ArrayList) getArguments().getSerializable("ad_content_list");
            this.f16753q = arrayList;
            if (arrayList == null || arrayList.isEmpty()) {
                Log.e(A, "Media playback error: chapter ad config is empty.");
                w(4, "Chapter ad error: media config is empty.");
            }
            if (TextUtils.isEmpty((String) s(this.f16879c, "sound_fade_duration", ""))) {
                return;
            }
            this.f16758v = Integer.parseInt(r3);
        }
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        k6.b bVarC = k6.b.c(layoutInflater, viewGroup, false);
        this.f16752p = bVarC;
        bVarC.f29698c.setOrientation(1);
        this.f16754r = new ArrayList();
        this.f16752p.f29698c.setOffscreenPageLimit(1);
        for (HashMap<String, String> map : this.f16753q) {
            String str = map.get("content_file_path");
            String str2 = map.get("media_duration");
            Map<String, String> layoutConfigMap = new AbmMediaPlayerLayoutConfig(map.get("content_layout_config")).getLayoutConfigMap();
            String strC0 = c0(str);
            if (strC0.equals("image")) {
                this.f16754r.add(new c0(str, str2, layoutConfigMap, false));
            } else if (strC0.equals("video")) {
                this.f16754r.add(new c0(str, str2, layoutConfigMap));
            } else if (strC0.equals("gif")) {
                this.f16754r.add(new c0(str, str2, layoutConfigMap, true));
            }
        }
        b0 b0Var = new b0(this.f16754r, this);
        this.f16755s = b0Var;
        this.f16752p.f29698c.setAdapter(b0Var);
        this.f16752p.f29697b.e(getActivity(), this.f16754r.size());
        n nVar = this.f16880d;
        if (nVar != null) {
            nVar.g().observe(getViewLifecycleOwner(), new Observer() { // from class: com.king.amp.sa.d0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f16742a.j0((Integer) obj);
                }
            });
        }
        m0();
        return this.f16752p.getRoot();
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        n nVar = this.f16880d;
        if (nVar != null) {
            nVar.t(0);
        }
    }

    @Override // com.king.amp.sa.r0, android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z10) {
        if (this.f16885i) {
            if (z10) {
                E();
                if (!this.f16759w) {
                    g0();
                }
            } else {
                B();
                if (!this.f16759w) {
                    f0();
                }
            }
        }
        this.f16759w = false;
    }

    @Override // com.king.amp.sa.r0
    public String p() {
        return "mixed";
    }

    @Override // com.king.amp.sa.r0
    String r() {
        return "";
    }

    @Override // com.king.amp.sa.r0
    public void u() {
        super.u();
    }

    @Override // com.king.amp.sa.r0
    public void v() {
        super.v();
    }
}
