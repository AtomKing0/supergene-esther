package com.king.amp.sa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class v extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private d1 f16985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageButton f16986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f16987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbmMediaPlayerLayoutConfig f16988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f16989e;

    /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
    class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            v.this.dismiss();
            if (v.this.f16985a != null) {
                v.this.f16986b.setVisibility(4);
                v.this.f16985a.a(AbmMediaPlayer.USER_ACTION_END_CARD_CLOSE);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.v();
            if (v.this.f16985a != null) {
                v.this.f16986b.setVisibility(4);
                v.this.f16985a.a(AbmMediaPlayer.USER_ACTION_END_CARD_CLOSE);
            }
        }
    }

    /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.v();
            if (v.this.f16985a != null) {
                v.this.f16985a.a("end_card_cta");
            }
        }
    }

    /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
    class d implements ViewTreeObserver.OnWindowFocusChangeListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z10) {
            FragmentActivity activity = v.this.getActivity();
            if (activity != null) {
                activity.onWindowFocusChanged(z10);
            }
        }
    }

    /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
    class e extends TimerTask {

        /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.f16986b.setVisibility(0);
            }
        }

        e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (v.this.getActivity() != null) {
                v.this.getActivity().runOnUiThread(new a());
            }
        }
    }

    /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
    class f extends TimerTask {

        /* JADX INFO: compiled from: AbmMediaPlayerEndCardFragment.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.f16986b.setClickable(true);
                v.this.f16987c.setClickable(true);
            }
        }

        f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (v.this.getActivity() != null) {
                v.this.getActivity().runOnUiThread(new a());
            }
        }
    }

    static v t(AbmMediaPlayerLayoutConfig abmMediaPlayerLayoutConfig, d1 d1Var) {
        v vVar = new v();
        vVar.u(abmMediaPlayerLayoutConfig, d1Var);
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (isAdded()) {
            this.f16986b.setClickable(false);
            this.f16987c.setClickable(false);
            new Timer().schedule(new f(), 500L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setRequestedOrientation(1);
        setStyle(0, j6.j.f28758b);
        if (getArguments() != null) {
            String string = getArguments().getString("layout_configuration");
            if (!TextUtils.isEmpty(string)) {
                this.f16988d = new AbmMediaPlayerLayoutConfig(string);
            }
        }
        this.f16989e = new Timer();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setCancelable(false);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        dialogOnCreateDialog.setOnKeyListener(new a());
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(j6.g.f28744f, viewGroup, false);
        this.f16986b = (ImageButton) viewInflate.findViewById(j6.f.f28730r);
        this.f16987c = (ImageView) viewInflate.findViewById(j6.f.f28731s);
        AbmMediaPlayerLayoutConfig abmMediaPlayerLayoutConfig = this.f16988d;
        if (abmMediaPlayerLayoutConfig != null) {
            String str = abmMediaPlayerLayoutConfig.getLayoutConfigMap().get("end_card_image");
            if (!TextUtils.isEmpty(str)) {
                this.f16987c.setImageDrawable(Drawable.createFromPath(str));
            }
        }
        this.f16986b.setOnClickListener(new b());
        this.f16987c.setOnClickListener(new c());
        viewInflate.getViewTreeObserver().addOnWindowFocusChangeListener(new d());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16989e.schedule(new e(), 500L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().setLayout(-1, -1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        getDialog().getWindow().getAttributes().windowAnimations = j6.j.f28757a;
    }

    public void u(AbmMediaPlayerLayoutConfig abmMediaPlayerLayoutConfig, d1 d1Var) {
        this.f16988d = abmMediaPlayerLayoutConfig;
        this.f16985a = d1Var;
    }
}
