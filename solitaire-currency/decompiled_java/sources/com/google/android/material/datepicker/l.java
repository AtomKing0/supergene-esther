package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: MaterialDatePicker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l<S> extends DialogFragment {
    static final Object E = "CONFIRM_BUTTON_TAG";
    static final Object F = "CANCEL_BUTTON_TAG";
    static final Object G = "TOGGLE_BUTTON_TAG";
    private Button A;
    private boolean B;

    @Nullable
    private CharSequence C;

    @Nullable
    private CharSequence D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet<m<? super S>> f9218a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f9219b = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f9220c = new LinkedHashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f9221d = new LinkedHashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @StyleRes
    private int f9222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private com.google.android.material.datepicker.d<S> f9223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private s<S> f9224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private com.google.android.material.datepicker.a f9225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private h f9226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private j<S> f9227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @StringRes
    private int f9228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CharSequence f9229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @StringRes
    private int f9232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f9233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @StringRes
    private int f9234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f9235r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @StringRes
    private int f9236s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f9237t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @StringRes
    private int f9238u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CharSequence f9239v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f9240w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f9241x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CheckableImageButton f9242y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private x4.g f9243z;

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = l.this.f9218a.iterator();
            while (it.hasNext()) {
                ((m) it.next()).a(l.this.B());
            }
            l.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = l.this.f9219b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            l.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class c implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f9247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9248c;

        c(int i10, View view, int i11) {
            this.f9246a = i10;
            this.f9247b = view;
            this.f9248c = i11;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i10 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            if (this.f9246a >= 0) {
                this.f9247b.getLayoutParams().height = this.f9246a + i10;
                View view2 = this.f9247b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f9247b;
            view3.setPadding(view3.getPaddingLeft(), this.f9248c + i10, this.f9247b.getPaddingRight(), this.f9247b.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class d extends r<S> {
        d() {
        }

        @Override // com.google.android.material.datepicker.r
        public void a(S s10) {
            l lVar = l.this;
            lVar.K(lVar.z());
            l.this.A.setEnabled(l.this.w().R());
        }
    }

    private static int A(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(e4.d.N);
        int i10 = o.e().f9258d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(e4.d.P) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(e4.d.S));
    }

    private int C(Context context) {
        int i10 = this.f9222e;
        return i10 != 0 ? i10 : w().x(context);
    }

    private void D(Context context) {
        this.f9242y.setTag(G);
        this.f9242y.setImageDrawable(u(context));
        this.f9242y.setChecked(this.f9231n != 0);
        ViewCompat.setAccessibilityDelegate(this.f9242y, null);
        M(this.f9242y);
        this.f9242y.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9217a.H(view);
            }
        });
    }

    static boolean E(@NonNull Context context) {
        return I(context, R.attr.windowFullscreen);
    }

    private boolean F() {
        return getResources().getConfiguration().orientation == 2;
    }

    static boolean G(@NonNull Context context) {
        return I(context, e4.b.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        this.A.setEnabled(w().R());
        this.f9242y.toggle();
        this.f9231n = this.f9231n == 1 ? 0 : 1;
        M(this.f9242y);
        J();
    }

    static boolean I(@NonNull Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(u4.b.d(context, e4.b.f24766w, j.class.getCanonicalName()), new int[]{i10});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    private void J() {
        int iC = C(requireContext());
        n nVarH = j.H(w(), iC, this.f9225h, this.f9226i);
        this.f9227j = nVarH;
        if (this.f9231n == 1) {
            nVarH = n.r(w(), iC, this.f9225h);
        }
        this.f9224g = nVarH;
        L();
        K(z());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(e4.f.f24845z, this.f9224g);
        fragmentTransactionBeginTransaction.commitNow();
        this.f9224g.p(new d());
    }

    private void L() {
        this.f9240w.setText((this.f9231n == 1 && F()) ? this.D : this.C);
    }

    private void M(@NonNull CheckableImageButton checkableImageButton) {
        this.f9242y.setContentDescription(this.f9231n == 1 ? checkableImageButton.getContext().getString(e4.i.f24889r) : checkableImageButton.getContext().getString(e4.i.f24891t));
    }

    @NonNull
    private static Drawable u(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(context, e4.e.f24811d));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, e4.e.f24812e));
        return stateListDrawable;
    }

    private void v(Window window) {
        if (this.B) {
            return;
        }
        View viewFindViewById = requireView().findViewById(e4.f.f24828i);
        com.google.android.material.internal.d.a(window, true, com.google.android.material.internal.s.d(viewFindViewById), null);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new c(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.datepicker.d<S> w() {
        if (this.f9223f == null) {
            this.f9223f = (com.google.android.material.datepicker.d) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f9223f;
    }

    @Nullable
    private static CharSequence x(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    private String y() {
        return w().q(requireContext());
    }

    @Nullable
    public final S B() {
        return w().W();
    }

    @VisibleForTesting
    void K(String str) {
        this.f9241x.setContentDescription(y());
        this.f9241x.setText(str);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f9220c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9222e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f9223f = (com.google.android.material.datepicker.d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f9225h = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f9226i = (h) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f9228k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f9229l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f9231n = bundle.getInt("INPUT_MODE_KEY");
        this.f9232o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f9233p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f9234q = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f9235r = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f9236s = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f9237t = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f9238u = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f9239v = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f9229l;
        if (text == null) {
            text = requireContext().getResources().getText(this.f9228k);
        }
        this.C = text;
        this.D = x(text);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), C(requireContext()));
        Context context = dialog.getContext();
        this.f9230m = E(context);
        int i10 = e4.b.f24766w;
        int i11 = e4.j.f24915u;
        this.f9243z = new x4.g(context, null, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, e4.k.D2, i10, i11);
        int color = typedArrayObtainStyledAttributes.getColor(e4.k.E2, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f9243z.O(context);
        this.f9243z.Y(ColorStateList.valueOf(color));
        this.f9243z.X(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f9230m ? e4.h.f24871w : e4.h.f24870v, viewGroup);
        Context context = viewInflate.getContext();
        h hVar = this.f9226i;
        if (hVar != null) {
            hVar.h(context);
        }
        if (this.f9230m) {
            viewInflate.findViewById(e4.f.f24845z).setLayoutParams(new LinearLayout.LayoutParams(A(context), -2));
        } else {
            viewInflate.findViewById(e4.f.A).setLayoutParams(new LinearLayout.LayoutParams(A(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(e4.f.F);
        this.f9241x = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.f9242y = (CheckableImageButton) viewInflate.findViewById(e4.f.G);
        this.f9240w = (TextView) viewInflate.findViewById(e4.f.H);
        D(context);
        this.A = (Button) viewInflate.findViewById(e4.f.f24823d);
        if (w().R()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
        this.A.setTag(E);
        CharSequence charSequence = this.f9233p;
        if (charSequence != null) {
            this.A.setText(charSequence);
        } else {
            int i10 = this.f9232o;
            if (i10 != 0) {
                this.A.setText(i10);
            }
        }
        CharSequence charSequence2 = this.f9235r;
        if (charSequence2 != null) {
            this.A.setContentDescription(charSequence2);
        } else if (this.f9234q != 0) {
            this.A.setContentDescription(getContext().getResources().getText(this.f9234q));
        }
        this.A.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(e4.f.f24820a);
        button.setTag(F);
        CharSequence charSequence3 = this.f9237t;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i11 = this.f9236s;
            if (i11 != 0) {
                button.setText(i11);
            }
        }
        CharSequence charSequence4 = this.f9239v;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f9238u != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f9238u));
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f9221d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f9222e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f9223f);
        a.b bVar = new a.b(this.f9225h);
        j<S> jVar = this.f9227j;
        o oVarC = jVar == null ? null : jVar.C();
        if (oVarC != null) {
            bVar.b(oVarC.f9260f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f9226i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f9228k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f9229l);
        bundle.putInt("INPUT_MODE_KEY", this.f9231n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f9232o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f9233p);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f9234q);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f9235r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f9236s);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f9237t);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f9238u);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f9239v);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f9230m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f9243z);
            v(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(e4.d.R);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f9243z, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new o4.a(requireDialog(), rect));
        }
        J();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f9224g.q();
        super.onStop();
    }

    public String z() {
        return w().B(getContext());
    }
}
