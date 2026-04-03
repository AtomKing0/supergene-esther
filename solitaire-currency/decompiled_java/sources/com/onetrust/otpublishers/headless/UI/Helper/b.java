package com.onetrust.otpublishers.headless.UI.Helper;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.onetrust.otpublishers.headless.UI.Helper.b;
import kotlin.jvm.internal.t;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T extends ViewBinding> implements k9.a<Fragment, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Fragment f22146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h9.l<View, T> f22147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public T f22148c;

    public static final class a implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Observer<LifecycleOwner> f22149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b<T> f22150b;

        /* JADX INFO: renamed from: com.onetrust.otpublishers.headless.UI.Helper.b$a$a, reason: collision with other inner class name */
        public static final class C0484a implements DefaultLifecycleObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b<T> f22151a;

            public C0484a(b<T> bVar) {
                this.f22151a = bVar;
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.a(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onDestroy(@NotNull LifecycleOwner owner) {
                t.i(owner, "owner");
                this.f22151a.f22148c = null;
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.c(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.d(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.e(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.f(this, lifecycleOwner);
            }
        }

        public a(final b<T> bVar) {
            this.f22150b = bVar;
            this.f22149a = new Observer() { // from class: com.onetrust.otpublishers.headless.UI.Helper.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    b.a.a(bVar, (LifecycleOwner) obj);
                }
            };
        }

        public static final void a(b this$0, LifecycleOwner lifecycleOwner) {
            t.i(this$0, "this$0");
            if (lifecycleOwner == null) {
                return;
            }
            lifecycleOwner.getLifecycle().addObserver(new C0484a(this$0));
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onCreate(@NotNull LifecycleOwner owner) {
            t.i(owner, "owner");
            this.f22150b.f22146a.getViewLifecycleOwnerLiveData().observeForever(this.f22149a);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onDestroy(@NotNull LifecycleOwner owner) {
            t.i(owner, "owner");
            this.f22150b.f22146a.getViewLifecycleOwnerLiveData().removeObserver(this.f22149a);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.c(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.d(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.e(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.f(this, lifecycleOwner);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Fragment fragment, @NotNull h9.l<? super View, ? extends T> viewBindingFactory) {
        t.i(fragment, "fragment");
        t.i(viewBindingFactory, "viewBindingFactory");
        this.f22146a = fragment;
        this.f22147b = viewBindingFactory;
        fragment.getLifecycle().addObserver(new a(this));
    }

    @NotNull
    public final T a(@NotNull Fragment thisRef, @NotNull KProperty<?> property) {
        t.i(thisRef, "thisRef");
        t.i(property, "property");
        T t10 = this.f22148c;
        if (t10 != null) {
            return t10;
        }
        if (!this.f22146a.getViewLifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.");
        }
        h9.l<View, T> lVar = this.f22147b;
        View viewRequireView = thisRef.requireView();
        t.h(viewRequireView, "thisRef.requireView()");
        T tInvoke = lVar.invoke(viewRequireView);
        this.f22148c = tInvoke;
        return tInvoke;
    }
}
