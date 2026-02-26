package com.king.amp.sa;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: AbmChapterFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class q extends r0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k6.b f16845p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ViewPager2 f16846q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private NewAbmMediaPlayerChapterAdIndicatorView f16847r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<Map<String, String>> f16849t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private u f16850u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Timer f16851v;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f16848s = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f16852w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f16853x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f16854y = 5000;

    /* JADX INFO: compiled from: AbmChapterFragment.java */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            q.this.f16847r.d(i10, f10);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            super.onPageSelected(i10);
            if (q.this.f16852w == i10) {
                return;
            }
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            adProviderNameValuePairs.add("previous_page", Integer.valueOf(q.this.f16852w + 1));
            adProviderNameValuePairs.add("current_page", Integer.valueOf(i10 + 1));
            adProviderNameValuePairs.add("is_manually_scrolled", Integer.valueOf(q.this.f16853x));
            q.this.z("page_changed", s1.d(adProviderNameValuePairs));
            q qVar = q.this;
            qVar.V(qVar.f16852w, i10);
            q.this.f16852w = i10;
            q.this.T();
            q.this.f16853x = 1;
        }
    }

    /* JADX INFO: compiled from: AbmChapterFragment.java */
    class b extends TimerTask {

        /* JADX INFO: compiled from: AbmChapterFragment.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.f16853x = 0;
                int itemCount = (q.this.f16852w + 1) % q.this.f16846q.getAdapter().getItemCount();
                q.this.f16846q.setCurrentItem(itemCount, true);
                q.this.f16852w = itemCount;
            }
        }

        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (q.this.getActivity() == null) {
                return;
            }
            q.this.getActivity().runOnUiThread(new a());
        }
    }

    public static q Q(@NonNull Map<String, String> map, @NonNull List<Map<String, String>> list, long j10) {
        q qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putSerializable("custom_map", new HashMap(map));
        bundle.putSerializable("chapter_config_map_list", new ArrayList(list));
        bundle.putLong("player_id", j10);
        qVar.setArguments(bundle);
        return qVar;
    }

    private void S() {
        if (this.f16851v == null) {
            Log.d("AbmChapterFragment", "resumeChapterScroll");
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        U();
        Timer timer = new Timer();
        this.f16851v = timer;
        b bVar = new b();
        long j10 = this.f16854y;
        timer.schedule(bVar, j10, j10);
    }

    private void U() {
        Timer timer = this.f16851v;
        if (timer != null) {
            timer.cancel();
            this.f16851v = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i10, int i11) {
        HashMap map = new HashMap();
        String str = this.f16849t.get(i10).get("ad_title_text");
        String str2 = this.f16849t.get(i10).get("ad_description_text");
        String str3 = this.f16849t.get(i11).get("ad_title_text");
        String str4 = this.f16849t.get(i11).get("ad_description_text");
        map.put("current_title", str);
        map.put("current_description", str2);
        map.put("next_title", str3);
        map.put("next_description", str4);
        n nVar = this.f16880d;
        if (nVar != null) {
            nVar.l(map);
        }
    }

    public void R() {
        Log.d("AbmChapterFragment", "pauseChapterScroll");
        U();
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(1);
        }
        this.f16881e = true;
        if (getArguments() != null) {
            this.f16849t = (ArrayList) getArguments().getSerializable("chapter_config_map_list");
        }
        List<Map<String, String>> list = this.f16849t;
        if (list == null || list.isEmpty()) {
            Log.e("AbmChapterFragment", "Media playback error: chapter ad config is empty.");
            w(4, "Chapter ad error: media config is empty.");
        } else {
            String str = (String) s(this.f16879c, "video_duration", "");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f16848s = Integer.parseInt(str);
        }
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        k6.b bVarC = k6.b.c(layoutInflater, viewGroup, false);
        this.f16845p = bVarC;
        ViewPager2 viewPager2 = bVarC.f29698c;
        this.f16846q = viewPager2;
        this.f16847r = bVarC.f29697b;
        viewPager2.setOrientation(1);
        ArrayList arrayList = new ArrayList();
        List<Map<String, String>> list = this.f16849t;
        if (list != null) {
            Iterator<Map<String, String>> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Drawable.createFromPath(it.next().get("ad_image")));
            }
        }
        int i10 = this.f16848s;
        this.f16854y = i10 != 0 ? (((long) i10) * 1000) / ((long) arrayList.size()) : 5000L;
        u uVar = new u(arrayList, this);
        this.f16850u = uVar;
        this.f16846q.setAdapter(uVar);
        this.f16847r.e(getActivity(), arrayList.size());
        this.f16846q.registerOnPageChangeCallback(new a());
        T();
        return this.f16845p.getRoot();
    }

    @Override // com.king.amp.sa.r0, android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z10) {
        if (this.f16885i) {
            if (z10) {
                E();
                T();
            } else {
                B();
                U();
            }
        }
    }

    @Override // com.king.amp.sa.r0
    public String p() {
        return "chapter";
    }

    @Override // com.king.amp.sa.r0
    String r() {
        return "AbmChapterFragment";
    }

    @Override // com.king.amp.sa.r0
    public void u() {
        super.u();
        R();
    }

    @Override // com.king.amp.sa.r0
    public void v() {
        super.v();
        S();
    }
}
