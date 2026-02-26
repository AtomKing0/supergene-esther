package com.king.amp.sa;

import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import java.util.Map;

/* JADX INFO: compiled from: AbmMediaPlayerPromptDialogFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class y extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private e1 f17017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConstraintLayout f17018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Button f17019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f17020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AbmMediaPlayerLayoutConfig f17021e;

    /* JADX INFO: compiled from: AbmMediaPlayerPromptDialogFragment.java */
    class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            y.this.dismiss();
            if (y.this.f17017a != null) {
                y.this.f17017a.onPlayerEvent("prompt_continue", s1.a());
            }
            return true;
        }
    }

    private void A() {
        this.f17019c.setOnClickListener(new View.OnClickListener() { // from class: com.king.amp.sa.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17008a.u(view);
            }
        });
        this.f17020d.setOnClickListener(new View.OnClickListener() { // from class: com.king.amp.sa.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17009a.v(view);
            }
        });
    }

    private void s(Configuration configuration) {
        double d10;
        double d11;
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        getDialog().getWindow().getAttributes().windowAnimations = j6.j.f28760d;
        int i10 = getResources().getDisplayMetrics().widthPixels;
        int i11 = getResources().getDisplayMetrics().heightPixels;
        int i12 = configuration.orientation;
        if (i12 != 2) {
            if (i12 == 1) {
                i10 = (int) (((double) i10) * 0.8d);
                d10 = i11;
                d11 = 0.5d;
            }
            getDialog().getWindow().setDimAmount(0.85f);
            getDialog().getWindow().setLayout(i10, i11);
        }
        i10 = (int) (((double) i10) * 0.4d);
        d10 = i11;
        d11 = 0.9d;
        i11 = (int) (d10 * d11);
        getDialog().getWindow().setDimAmount(0.85f);
        getDialog().getWindow().setLayout(i10, i11);
    }

    private void t(Map<String, String> map) {
        x(this.f17018b, map.get("prompt_dialog_background"));
        z(this.f17019c, map.get("prompt_dialog_continue_button_image_default"), map.get("prompt_dialog_continue_button_image_clicked"));
        z(this.f17020d, map.get("prompt_dialog_close_button_image_default"), map.get("prompt_dialog_close_button_image_clicked"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        e1 e1Var = this.f17017a;
        if (e1Var != null) {
            e1Var.onPlayerEvent("prompt_continue", s1.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        e1 e1Var = this.f17017a;
        if (e1Var != null) {
            e1Var.onPlayerEvent("prompt_close", s1.a());
        }
    }

    static y w(Bundle bundle, e1 e1Var) {
        y yVar = new y();
        yVar.setArguments(bundle);
        yVar.y(e1Var);
        return yVar;
    }

    private void x(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        view.setBackground(Drawable.createFromPath(str));
    }

    private void y(e1 e1Var) {
        this.f17017a = e1Var;
    }

    private void z(View view, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Drawable drawableCreateFromPath = Drawable.createFromPath(str);
        if (TextUtils.isEmpty(str2)) {
            view.setBackground(drawableCreateFromPath);
            return;
        }
        Drawable drawableCreateFromPath2 = Drawable.createFromPath(str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableCreateFromPath2);
        stateListDrawable.addState(new int[0], drawableCreateFromPath);
        view.setBackground(stateListDrawable);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        s(configuration);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, j6.j.f28759c);
        if (getArguments() != null) {
            String string = getArguments().getString("layout_configuration");
            if (!TextUtils.isEmpty(string)) {
                this.f17021e = new AbmMediaPlayerLayoutConfig(string);
            }
            e1 e1Var = this.f17017a;
            if (e1Var != null) {
                e1Var.onPlayerEvent(AbmAdPlayer.USER_ACTION_PROMPT_SHOWN, s1.a());
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setCancelable(false);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        dialogOnCreateDialog.setOnKeyListener(new a());
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.85f);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(j6.g.f28751m, viewGroup, false);
        this.f17018b = (ConstraintLayout) viewInflate.findViewById(j6.f.f28728p);
        this.f17019c = (Button) viewInflate.findViewById(j6.f.f28724l);
        this.f17020d = (Button) viewInflate.findViewById(j6.f.f28723k);
        AbmMediaPlayerLayoutConfig abmMediaPlayerLayoutConfig = this.f17021e;
        if (abmMediaPlayerLayoutConfig != null) {
            t(abmMediaPlayerLayoutConfig.getLayoutConfigMap());
        }
        A();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        s(getResources().getConfiguration());
    }
}
