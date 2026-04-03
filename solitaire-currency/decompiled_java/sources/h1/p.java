package h1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SupportRequestManagerFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h1.a f26415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f26416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<p> f26417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private p f26418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.j f26419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f26420f;

    /* JADX INFO: compiled from: SupportRequestManagerFragment.java */
    private class a implements n {
        a() {
        }

        @Override // h1.n
        @NonNull
        public Set<com.bumptech.glide.j> a() {
            Set<p> setQ = p.this.q();
            HashSet hashSet = new HashSet(setQ.size());
            for (p pVar : setQ) {
                if (pVar.t() != null) {
                    hashSet.add(pVar.t());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + p.this + "}";
        }
    }

    public p() {
        this(new h1.a());
    }

    private void B() {
        p pVar = this.f26418d;
        if (pVar != null) {
            pVar.y(this);
            this.f26418d = null;
        }
    }

    private void p(p pVar) {
        this.f26417c.add(pVar);
    }

    @Nullable
    private Fragment s() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f26420f;
    }

    @Nullable
    private static FragmentManager v(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean w(@NonNull Fragment fragment) {
        Fragment fragmentS = s();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentS)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void x(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        B();
        p pVarR = com.bumptech.glide.b.c(context).k().r(context, fragmentManager);
        this.f26418d = pVarR;
        if (equals(pVarR)) {
            return;
        }
        this.f26418d.p(this);
    }

    private void y(p pVar) {
        this.f26417c.remove(pVar);
    }

    public void A(@Nullable com.bumptech.glide.j jVar) {
        this.f26419e = jVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerV = v(this);
        if (fragmentManagerV == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                x(getContext(), fragmentManagerV);
            } catch (IllegalStateException e10) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e10);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f26415a.c();
        B();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f26420f = null;
        B();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f26415a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f26415a.e();
    }

    @NonNull
    Set<p> q() {
        p pVar = this.f26418d;
        if (pVar == null) {
            return Collections.emptySet();
        }
        if (equals(pVar)) {
            return Collections.unmodifiableSet(this.f26417c);
        }
        HashSet hashSet = new HashSet();
        for (p pVar2 : this.f26418d.q()) {
            if (w(pVar2.s())) {
                hashSet.add(pVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    h1.a r() {
        return this.f26415a;
    }

    @Nullable
    public com.bumptech.glide.j t() {
        return this.f26419e;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + s() + "}";
    }

    @NonNull
    public n u() {
        return this.f26416b;
    }

    void z(@Nullable Fragment fragment) {
        FragmentManager fragmentManagerV;
        this.f26420f = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerV = v(fragment)) == null) {
            return;
        }
        x(fragment.getContext(), fragmentManagerV);
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public p(@NonNull h1.a aVar) {
        this.f26416b = new a();
        this.f26417c = new HashSet();
        this.f26415a = aVar;
    }
}
