package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: BottomSheetDialogFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8939a;

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f8939a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void r(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z10) {
        this.f8939a = z10;
        if (bottomSheetBehavior.Q() == 5) {
            q();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) getDialog()).i();
        }
        bottomSheetBehavior.y(new C0206b());
        bottomSheetBehavior.s0(5);
    }

    private boolean s(boolean z10) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorG = aVar.g();
        if (!bottomSheetBehaviorG.W() || !aVar.h()) {
            return false;
        }
        r(bottomSheetBehaviorG, z10);
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (s(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (s(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(getContext(), getTheme());
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BottomSheetDialogFragment.java */
    private class C0206b extends BottomSheetBehavior.g {
        private C0206b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(@NonNull View view, int i10) {
            if (i10 == 5) {
                b.this.q();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@NonNull View view, float f10) {
        }
    }
}
