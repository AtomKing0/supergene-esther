package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public class a extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13023b = "com.ironsource.lifecycle.IronsourceLifecycleFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0258a f13024a;

    /* JADX INFO: renamed from: com.ironsource.lifecycle.a$a, reason: collision with other inner class name */
    interface InterfaceC0258a {
        void a(Activity activity);

        void b(Activity activity);

        void onResume(Activity activity);
    }

    static a a(Activity activity) {
        return (a) activity.getFragmentManager().findFragmentByTag(f13023b);
    }

    static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null || fragmentManager.findFragmentByTag(f13023b) != null) {
            return;
        }
        fragmentManager.beginTransaction().add(new a(), f13023b).commit();
        fragmentManager.executePendingTransactions();
    }

    private void c(InterfaceC0258a interfaceC0258a) {
        if (interfaceC0258a != null) {
            interfaceC0258a.a(getActivity());
        }
    }

    void d(InterfaceC0258a interfaceC0258a) {
        this.f13024a = interfaceC0258a;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f13024a);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13024a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f13024a);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f13024a);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    private void a(InterfaceC0258a interfaceC0258a) {
        if (interfaceC0258a != null) {
            interfaceC0258a.b(getActivity());
        }
    }

    private void b(InterfaceC0258a interfaceC0258a) {
        if (interfaceC0258a != null) {
            interfaceC0258a.onResume(getActivity());
        }
    }
}
