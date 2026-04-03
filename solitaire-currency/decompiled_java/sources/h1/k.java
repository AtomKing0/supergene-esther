package h1;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: RequestManagerFragment.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class k extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h1.a f26396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f26397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<k> f26398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.j f26399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private k f26400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f26401f;

    /* JADX INFO: compiled from: RequestManagerFragment.java */
    private class a implements n {
        a() {
        }

        @Override // h1.n
        @NonNull
        public Set<com.bumptech.glide.j> a() {
            Set<k> setB = k.this.b();
            HashSet hashSet = new HashSet(setB.size());
            for (k kVar : setB) {
                if (kVar.e() != null) {
                    hashSet.add(kVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new h1.a());
    }

    private void a(k kVar) {
        this.f26398c.add(kVar);
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f26401f;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        k kVarP = com.bumptech.glide.b.c(activity).k().p(activity);
        this.f26400e = kVarP;
        if (equals(kVarP)) {
            return;
        }
        this.f26400e.a(this);
    }

    private void i(k kVar) {
        this.f26398c.remove(kVar);
    }

    private void l() {
        k kVar = this.f26400e;
        if (kVar != null) {
            kVar.i(this);
            this.f26400e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<k> b() {
        if (equals(this.f26400e)) {
            return Collections.unmodifiableSet(this.f26398c);
        }
        if (this.f26400e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (k kVar : this.f26400e.b()) {
            if (g(kVar.getParentFragment())) {
                hashSet.add(kVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    h1.a c() {
        return this.f26396a;
    }

    @Nullable
    public com.bumptech.glide.j e() {
        return this.f26399d;
    }

    @NonNull
    public n f() {
        return this.f26397b;
    }

    void j(@Nullable Fragment fragment) {
        this.f26401f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@Nullable com.bumptech.glide.j jVar) {
        this.f26399d = jVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f26396a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f26396a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f26396a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    k(@NonNull h1.a aVar) {
        this.f26397b = new a();
        this.f26398c = new HashSet();
        this.f26396a = aVar;
    }
}
