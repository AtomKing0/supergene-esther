package com.king.amp.sa;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.king.amp.sa.r1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BaseMediaFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r0 extends Fragment implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    protected AbmAdPlayer f16878b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected n f16880d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f16882f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    protected r1 f16890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private o0 f16891o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16877a = "BaseMediaFragment";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected Map<String, String> f16879c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f16881e = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f16883g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f16884h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f16885i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16886j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f16887k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f16888l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f16889m = false;

    public void A(int i10, int i11) {
        AbmAdPlayer abmAdPlayer = this.f16878b;
        if (abmAdPlayer != null) {
            abmAdPlayer.onPlayerProgressV2(i10, i11);
        }
    }

    protected void B() {
        n nVar;
        if (this.f16882f || (nVar = this.f16880d) == null) {
            return;
        }
        nVar.q();
    }

    public boolean C(@NonNull String str) {
        return false;
    }

    public void D() {
        z("playback_started", s1.d(new AdProviderNameValuePairs()));
    }

    protected void E() {
        n nVar;
        if (this.f16882f || (nVar = this.f16880d) == null) {
            return;
        }
        if (this.f16889m) {
            nVar.r();
        } else {
            this.f16889m = true;
            nVar.x();
        }
    }

    public boolean F(@NonNull View view, @NonNull r1.d dVar, @NonNull String str) {
        r1 r1Var = this.f16890n;
        if (r1Var != null) {
            return r1Var.b(view, dVar, str);
        }
        return false;
    }

    @Nullable
    protected Integer G(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    protected void H(int i10) {
        n nVar = this.f16880d;
        if (nVar != null) {
            nVar.m(i10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f16885i = bundle.getBoolean("is_on_top", false);
            this.f16886j = bundle.getBoolean("is_in_stack", false);
        }
        if (getArguments() != null) {
            this.f16879c = (Map) getArguments().getSerializable("custom_map");
            this.f16878b = AbmAdPlayer.getInstance(getArguments().getLong("player_id", 0L));
            this.f16882f = Boolean.parseBoolean((String) s(this.f16879c, "is_end_card", "false"));
            this.f16883g = Boolean.parseBoolean((String) s(this.f16879c, "progress_enabled", com.ironsource.mediationsdk.metadata.a.f13688g));
            String str = (String) s(this.f16879c, "ad_verification", null);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o0 o0Var = new o0();
            this.f16891o = o0Var;
            if (o0Var.e(str)) {
                return;
            }
            Log.w("BaseMediaFragment", "Failed to parse verification string");
            this.f16891o = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        n nVar = (n) new ViewModelProvider(requireActivity()).get(n.class);
        this.f16880d = nVar;
        nVar.t(Integer.valueOf(this.f16881e ? 0 : 4));
        this.f16880d.v(Integer.valueOf(this.f16883g ? 0 : 8));
        this.f16880d.w(Integer.valueOf(this.f16884h ? 0 : 8));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        r1 r1Var = this.f16890n;
        if (r1Var != null) {
            r1Var.e();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_on_top", this.f16885i);
        bundle.putBoolean("is_in_stack", this.f16886j);
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        AbmAdPlayer abmAdPlayer;
        Log.d("BaseMediaFragment", "onViewCreated: " + view.toString());
        super.onViewCreated(view, bundle);
        requireView().getViewTreeObserver().addOnWindowFocusChangeListener(this);
        if (!this.f16882f || (abmAdPlayer = this.f16878b) == null) {
            return;
        }
        abmAdPlayer.onPlayerEvent("end_card_shown", s1.a());
    }

    public void onWindowFocusChanged(boolean z10) {
        Log.d("BaseMediaFragment", "onWindowFocusChanged");
    }

    public String p() {
        return TtmlNode.RUBY_BASE;
    }

    protected r1 q(Context context) {
        return new r1(context);
    }

    abstract String r();

    protected <K, V> V s(@Nullable Map<K, V> map, K k10, V v10) {
        if (map == null) {
            return v10;
        }
        V v11 = map.get(k10);
        return (v11 != null || map.containsKey(k10)) ? v11 : v10;
    }

    public void show(@NonNull FragmentManager fragmentManager, String str) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        this.f16885i = true;
        if (this.f16886j) {
            v();
            return;
        }
        fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        str.hashCode();
        switch (str) {
            case "slide_right_to_left":
                fragmentTransactionBeginTransaction.setCustomAnimations(j6.a.f28702d, j6.a.f28703e);
                break;
            case "slide_top_bottom":
                fragmentTransactionBeginTransaction.setCustomAnimations(j6.a.f28701c, j6.a.f28704f);
                break;
            case "slide_left_to_right":
                fragmentTransactionBeginTransaction.setCustomAnimations(j6.a.f28703e, j6.a.f28702d);
                break;
            case "slide_bottom_up":
                int i10 = j6.a.f28704f;
                fragmentTransactionBeginTransaction.setCustomAnimations(i10, i10);
                break;
            default:
                fragmentTransactionBeginTransaction.setCustomAnimations(j6.a.f28699a, j6.a.f28700b);
                break;
        }
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.add(j6.f.f28732t, this, r());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        this.f16886j = true;
        v();
    }

    protected boolean t(@NonNull r1.e eVar) {
        o0 o0Var;
        if (getActivity() == null) {
            Log.w("BaseMediaFragment", "Unable to create OM Sdk, getActivity() is null");
            return false;
        }
        if (this.f16891o == null) {
            Log.w("BaseMediaFragment", "Unable to create OM Sdk, verification is null");
            return false;
        }
        r1 r1VarQ = q(getActivity().getApplicationContext());
        this.f16890n = r1VarQ;
        if (r1VarQ.k(eVar, this.f16891o) || (o0Var = this.f16891o) == null || o0Var.d().isEmpty()) {
            return true;
        }
        Log.w("BaseMediaFragment", "Failed to initialize OM SDK");
        this.f16890n = null;
        if (this.f16878b == null) {
            return true;
        }
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add("description", "omsdk ERROR during initialization");
        this.f16878b.onPlayerEvent(AbmAdPlayer.USER_ACTION_VERIFICATION_ERROR, s1.d(adProviderNameValuePairs));
        return true;
    }

    public void u() {
        this.f16885i = false;
    }

    public void v() {
        this.f16885i = true;
        if (this.f16887k || this.f16882f) {
            return;
        }
        D();
        this.f16887k = true;
    }

    public void w(int i10, String str) {
        AbmAdPlayer abmAdPlayer = this.f16878b;
        if (abmAdPlayer != null) {
            abmAdPlayer.onPlayerDismissed(i10, str);
        }
    }

    protected void x() {
        r1 r1Var = this.f16890n;
        if (r1Var == null || this.f16888l) {
            return;
        }
        r1Var.a(r1.c.PAUSE, 0, null);
        this.f16888l = true;
    }

    protected void y() {
        r1 r1Var = this.f16890n;
        if (r1Var == null || !this.f16888l) {
            return;
        }
        r1Var.a(r1.c.RESUME, 0, null);
        this.f16888l = false;
    }

    public void z(@NonNull String str, s1<AdProviderNameValuePairs> s1Var) {
        AbmAdPlayer abmAdPlayer = this.f16878b;
        if (abmAdPlayer != null) {
            abmAdPlayer.onPlayerEvent(str, s1Var);
        }
    }
}
