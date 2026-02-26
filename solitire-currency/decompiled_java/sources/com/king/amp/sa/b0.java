package com.king.amp.sa;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AbmMixedChapterAdMediaAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class b0 extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<c0> f16721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h0 f16722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FragmentManager f16723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map<Integer, Fragment> f16724l = new HashMap();

    /* JADX INFO: compiled from: AbmMixedChapterAdMediaAdapter.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16725a;

        static {
            int[] iArr = new int[b.values().length];
            f16725a = iArr;
            try {
                iArr[b.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16725a[b.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16725a[b.GIF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: AbmMixedChapterAdMediaAdapter.java */
    protected enum b {
        VIDEO,
        IMAGE,
        GIF
    }

    /* JADX INFO: compiled from: AbmMixedChapterAdMediaAdapter.java */
    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        FrameLayout f16730b;

        public c(View view) {
            super(view);
            this.f16730b = (FrameLayout) view.findViewById(j6.f.f28736x);
        }
    }

    public b0(List<c0> list, h0 h0Var) {
        this.f16721i = list;
        this.f16722j = h0Var;
        this.f16723k = h0Var.getChildFragmentManager();
    }

    private Fragment c(c0 c0Var, int i10) {
        HashMap map = new HashMap();
        map.put("content_file_path", c0Var.c());
        map.put("media_duration", c0Var.b());
        map.put("chapter_idx", Integer.toString(i10));
        long playerId = this.f16722j.d0() != null ? this.f16722j.d0().getPlayerId() : 0L;
        int i11 = a.f16725a[c0Var.d().ordinal()];
        if (i11 == 1) {
            map.put("is_chapter_video", com.ironsource.mediationsdk.metadata.a.f13688g);
            map.put("chapter_idx", Integer.toString(i10));
            return l0.W(map, playerId);
        }
        if (i11 == 2) {
            map.put("is_chapter_image", com.ironsource.mediationsdk.metadata.a.f13688g);
            return t.P(map, playerId);
        }
        if (i11 != 3) {
            return null;
        }
        map.put("is_chapter_image", com.ironsource.mediationsdk.metadata.a.f13688g);
        map.put("is_gif", com.ironsource.mediationsdk.metadata.a.f13688g);
        return t.P(map, playerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i10, int i11, Fragment fragment) {
        if (this.f16723k.findFragmentByTag("abm_fragment_" + i10) == null) {
            this.f16723k.beginTransaction().setReorderingAllowed(true).add(i11, fragment, "abm_fragment_" + i10).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof l0) {
            ((l0) fragmentH).f0();
        }
    }

    public boolean d(int i10) {
        Fragment fragmentH = h(i10);
        if (!(fragmentH instanceof l0)) {
            if (fragmentH instanceof t) {
                return ((t) fragmentH).O();
            }
            return false;
        }
        if (!fragmentH.isAdded() || fragmentH.isDetached() || fragmentH.getActivity() == null) {
            return false;
        }
        return ((l0) fragmentH).P();
    }

    public void e(int i10, long j10) {
        if (j10 == 0) {
            return;
        }
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof l0) {
            ((l0) fragmentH).Q(j10);
        }
    }

    public void f(int i10, long j10) {
        if (j10 == 0) {
            return;
        }
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof l0) {
            ((l0) fragmentH).R(j10);
        }
    }

    public Map<String, String> g(int i10) {
        return this.f16721i.get(i10).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16721i.size();
    }

    public Fragment h(int i10) {
        return this.f16724l.get(Integer.valueOf(i10));
    }

    public void k(int i10) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        int iMax = Math.max(0, i10 - 1);
        int iMin = Math.min(itemCount - 1, i10 + 1);
        Log.d("AbmMixedChapterAdMediaAdapter", "Managing players for position " + i10 + ", keeping range " + iMax + " to " + iMin);
        for (int i11 = 0; i11 < itemCount; i11++) {
            Fragment fragmentH = h(i11);
            if (fragmentH == null) {
                Log.d("AbmMixedChapterAdMediaAdapter", "Fragment at position " + i11 + " is null");
            } else if ((fragmentH instanceof l0) && fragmentH.isAdded() && !fragmentH.isDetached() && this.f16721i.get(i11).d() == b.VIDEO) {
                l0 l0Var = (l0) fragmentH;
                if (i11 < iMax || i11 > iMin) {
                    Log.d("AbmMixedChapterAdMediaAdapter", "Releasing player at position " + i11);
                    l0Var.a0();
                } else {
                    Log.d("AbmMixedChapterAdMediaAdapter", "Preparing video at position " + i11);
                    q(i11);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, final int i10) {
        final Fragment fragmentC;
        Fragment fragment;
        c0 c0Var = this.f16721i.get(i10);
        final int iGenerateViewId = View.generateViewId();
        cVar.f16730b.setId(iGenerateViewId);
        if ((this.f16724l.containsKey(Integer.valueOf(i10)) && (fragment = this.f16724l.get(Integer.valueOf(i10))) != null && fragment.isAdded()) || (fragmentC = c(c0Var, i10)) == null) {
            return;
        }
        this.f16724l.put(Integer.valueOf(i10), fragmentC);
        cVar.f16730b.post(new Runnable() { // from class: com.king.amp.sa.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f17027a.i(i10, iGenerateViewId, fragmentC);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(j6.g.f28746h, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NonNull c cVar) {
        int bindingAdapterPosition = cVar.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || this.f16723k == null) {
            return;
        }
        Fragment fragmentRemove = this.f16724l.remove(Integer.valueOf(bindingAdapterPosition));
        if (fragmentRemove != null && fragmentRemove.isAdded()) {
            this.f16723k.beginTransaction().remove(fragmentRemove).commitAllowingStateLoss();
        }
        super.onViewRecycled(cVar);
    }

    public void o(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof t) {
            ((t) fragmentH).Q();
        }
    }

    public void p(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof l0) {
            ((l0) fragmentH).C("pause");
        }
    }

    public void q(int i10) {
        if (i10 < 0 || i10 >= getItemCount()) {
            Log.e("AbmMixedChapterAdMediaAdapter", "Invalid position: " + i10);
            return;
        }
        Fragment fragmentH = h(i10);
        if (fragmentH == null) {
            Log.e("AbmMixedChapterAdMediaAdapter", "Fragment at position " + i10 + " is null");
            return;
        }
        if ((fragmentH instanceof l0) && fragmentH.isAdded() && !fragmentH.isDetached() && fragmentH.getActivity() != null) {
            Log.d("AbmMixedChapterAdMediaAdapter", "Creating player at position " + i10);
            ((l0) fragmentH).O();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cant prepare video at position ");
        sb.append(i10);
        sb.append(",fragment state: ");
        sb.append(fragmentH.isAdded() ? "added" : "not added");
        sb.append(fragmentH.isDetached() ? " detached" : " not detached");
        Log.d("AbmMixedChapterAdMediaAdapter", sb.toString());
    }

    public void r(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof t) {
            ((t) fragmentH).R();
        }
    }

    public void s(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof l0) {
            ((l0) fragmentH).b0();
        }
    }

    public void t(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof l0) {
            ((l0) fragmentH).C("resume");
        }
    }

    public void u(int i10) {
        Fragment fragmentH = h(i10);
        if (fragmentH instanceof t) {
            ((t) fragmentH).S();
        }
    }

    public void v(final int i10) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return;
        }
        q(i10);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.king.amp.sa.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f16714a.j(i10);
            }
        }, 50L);
    }
}
