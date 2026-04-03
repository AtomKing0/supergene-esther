package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;

/* JADX INFO: loaded from: classes4.dex */
public class b extends Fragment implements View.OnKeyListener, View.OnFocusChangeListener {
    public OTConfiguration A;
    public NestedScrollView B;
    public boolean C = true;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f22442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f22443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f22444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentActivity f22445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.a f22446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f22447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f22448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f22449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f22450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f22451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f22452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f22453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f22454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f22455p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f22456q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f22457r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f22458s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Button f22459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Button f22460u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f22461v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f22462w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f22463x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f22464y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f22465z;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        float f10 = getResources().getConfiguration().fontScale;
        OTLogger.a("OTTVBanner", 3, "text scalability : " + f10);
        boolean z10 = true;
        boolean z11 = ((((((double) this.f22441b.getMeasuredHeight()) + ((double) this.f22440a.getMeasuredHeight())) + ((double) this.f22452m.getMeasuredHeight())) + ((double) this.f22451l.getMeasuredHeight())) + ((double) this.f22463x.getMeasuredHeight())) * ((double) f10) > ((double) this.B.getHeight());
        this.C = z11;
        com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.f22446g.f22334e;
        if (cVar.f22152o != 0 && cVar.f22156s != 0 && cVar.f22157t != 0) {
            z10 = false;
        }
        this.f22462w = z10;
        if (z10 || z11 || !this.D) {
            return;
        }
        OTLogger.a("OTTVBanner", 3, "Banner content is not scrollable, setting focus to button layout" + this.f22462w);
        this.B.setFocusable(false);
        this.B.setFocusableInTouchMode(false);
        this.f22442c.setNextFocusUpId(p6.d.f32738l0);
        this.f22443d.setNextFocusUpId(p6.d.f32810t0);
        this.f22444e.setNextFocusUpId(p6.d.f32783q0);
        this.f22459t.setNextFocusUpId(p6.d.f32720j0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f22445f = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.a aVar;
        FragmentActivity fragmentActivity = this.f22445f;
        int i10 = p6.e.f32876j;
        if (com.onetrust.otpublishers.headless.Internal.c.x(fragmentActivity)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(fragmentActivity, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22442c = (Button) viewInflate.findViewById(p6.d.f32738l0);
        this.f22443d = (Button) viewInflate.findViewById(p6.d.f32810t0);
        this.f22444e = (Button) viewInflate.findViewById(p6.d.f32783q0);
        this.f22440a = (TextView) viewInflate.findViewById(p6.d.f32684f0);
        this.f22441b = (TextView) viewInflate.findViewById(p6.d.Z);
        this.f22448i = (LinearLayout) viewInflate.findViewById(p6.d.f32702h0);
        this.f22451l = (TextView) viewInflate.findViewById(p6.d.f32657c0);
        this.f22452m = (TextView) viewInflate.findViewById(p6.d.f32648b0);
        this.f22453n = viewInflate.findViewById(p6.d.f32855y3);
        this.f22454o = (ImageView) viewInflate.findViewById(p6.d.A5);
        this.f22455p = (ImageView) viewInflate.findViewById(p6.d.f32847x3);
        this.f22457r = (TextView) viewInflate.findViewById(p6.d.T);
        this.f22456q = (TextView) viewInflate.findViewById(p6.d.V);
        this.f22458s = (TextView) viewInflate.findViewById(p6.d.U);
        this.f22459t = (Button) viewInflate.findViewById(p6.d.f32720j0);
        this.f22460u = (Button) viewInflate.findViewById(p6.d.B5);
        this.f22449j = (LinearLayout) viewInflate.findViewById(p6.d.A0);
        this.f22450k = (LinearLayout) viewInflate.findViewById(p6.d.f32860z0);
        this.B = (NestedScrollView) viewInflate.findViewById(p6.d.f32639a0);
        this.f22464y = (LinearLayout) viewInflate.findViewById(p6.d.f32645a6);
        this.f22463x = (ImageView) viewInflate.findViewById(p6.d.f32778p4);
        this.f22465z = (TextView) viewInflate.findViewById(p6.d.f32663c6);
        this.f22442c.setOnKeyListener(this);
        this.f22443d.setOnKeyListener(this);
        this.f22444e.setOnKeyListener(this);
        this.f22454o.setOnKeyListener(this);
        this.f22459t.setOnKeyListener(this);
        this.f22460u.setOnKeyListener(this);
        this.f22463x.setOnKeyListener(this);
        this.f22465z.setOnKeyListener(this);
        this.B.setOnKeyListener(this);
        this.f22442c.setOnFocusChangeListener(this);
        this.f22443d.setOnFocusChangeListener(this);
        this.f22444e.setOnFocusChangeListener(this);
        this.f22459t.setOnFocusChangeListener(this);
        this.f22460u.setOnFocusChangeListener(this);
        this.f22454o.setOnFocusChangeListener(this);
        if (getArguments() != null && getArguments().containsKey("OT_TV_FOCUSED_BTN")) {
            this.f22461v = getArguments().getInt("OT_TV_FOCUSED_BTN");
        }
        synchronized (com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.class) {
            if (com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.f22329h == null) {
                com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.f22329h = new com.onetrust.otpublishers.headless.UI.TVUI.datautils.a();
            }
            aVar = com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.f22329h;
        }
        this.f22446g = aVar;
        r();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.f32738l0) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22442c, this.f22446g.f22335f.f22824i, z10);
        }
        if (view.getId() == p6.d.f32810t0) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22443d, this.f22446g.f22335f.f22825j, z10);
        }
        if (view.getId() == p6.d.f32783q0) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22444e, this.f22446g.f22335f.f22826k, z10);
        }
        if (view.getId() == p6.d.f32720j0) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22459t, this.f22446g.f22336g, z10);
        }
        if (view.getId() == p6.d.B5) {
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22446g.f22334e.f22155r;
            if (com.onetrust.otpublishers.headless.Internal.b.a(fVar.f22765h)) {
                com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22460u, fVar, z10);
            } else {
                Button button = this.f22460u;
                String strC = this.f22446g.f22334e.c();
                if (z10) {
                    com.onetrust.otpublishers.headless.UI.Helper.i.k(button, fVar, true);
                    button.setPaintFlags(button.getPaintFlags() & (-9));
                } else {
                    if (strC != null && !com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                        button.setTextColor(Color.parseColor(strC));
                    }
                    button.setPaintFlags(button.getPaintFlags() | 8);
                    Drawable background = button.getBackground();
                    String str = this.f22446g.f22335f.f22816a;
                    if (str == null) {
                        str = "#FFFFFF";
                    }
                    background.setTint(Color.parseColor(str));
                    button.setElevation(0.0f);
                }
            }
        }
        if (view.getId() == p6.d.A5) {
            q(z10, this.f22446g.f22335f.f22824i);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        int id = view.getId();
        int i11 = p6.d.f32738l0;
        if (id == i11 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22447h).a(11);
        }
        int id2 = view.getId();
        int i12 = p6.d.f32810t0;
        if (id2 == i12 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22447h).a(12);
        }
        int id3 = view.getId();
        int i13 = p6.d.f32783q0;
        if (id3 == i13 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            k kVar = (k) this.f22447h;
            kVar.getClass();
            OTUIDisplayReason oTUIDisplayReason = new OTUIDisplayReason(210, OTUIDisplayReason.getResponseMessage(210));
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(5);
            bVar.f21750f = oTUIDisplayReason;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = kVar.f22575i;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = kVar.f22573g;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
            kVar.f22576j = 1;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = kVar.f22573g;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = kVar.f22572f;
            OTConfiguration oTConfiguration = kVar.f22578l;
            q qVar = new q();
            Bundle bundle = new Bundle();
            bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
            qVar.setArguments(bundle);
            qVar.f22612d = aVar2;
            qVar.f22611c = kVar;
            qVar.f22610b = oTPublishersHeadlessSDK;
            qVar.f22629u = oTConfiguration;
            kVar.getChildFragmentManager().beginTransaction().replace(p6.d.W5, qVar).addToBackStack(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG).commit();
            b bVar2 = kVar.f22577k;
            if (bVar2 != null && bVar2.getArguments() != null) {
                kVar.f22577k.getArguments().putInt("OT_TV_FOCUSED_BTN", 1);
            }
        }
        if (view.getId() == p6.d.A5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22447h).a(13);
        }
        if (view.getId() == p6.d.B5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22447h).a(16);
        }
        int id4 = view.getId();
        int i14 = p6.d.f32720j0;
        if (id4 == i14 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22447h).a(15);
        }
        if (view.getId() == i12 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.D) {
                if (this.f22462w || this.C) {
                    this.B.setNextFocusDownId(i12);
                    this.B.requestFocus();
                }
                return true;
            }
            if (this.f22442c.getVisibility() != 0 && this.f22460u.getVisibility() != 0 && this.f22454o.getVisibility() != 0) {
                this.f22443d.requestFocus();
            }
        }
        if (view.getId() == i11 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.D) {
                if (this.f22462w || this.C) {
                    this.B.setNextFocusDownId(i11);
                    this.B.requestFocus();
                }
                return true;
            }
            (this.f22460u.getVisibility() == 0 ? this.f22460u : this.f22454o.getVisibility() == 0 ? this.f22454o : this.f22442c).requestFocus();
        }
        if (view.getId() == i13 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.D) {
                if (this.f22462w || this.C) {
                    this.B.setNextFocusDownId(i13);
                    this.B.requestFocus();
                }
                return true;
            }
            if (this.f22442c.getVisibility() != 0 && this.f22443d.getVisibility() != 0 && this.f22460u.getVisibility() != 0 && this.f22454o.getVisibility() != 0) {
                this.f22444e.requestFocus();
            }
        }
        if (view.getId() != i14 || com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 25 || !this.D) {
            return false;
        }
        if (this.f22462w || this.C) {
            this.B.setNextFocusDownId(i14);
            this.B.requestFocus();
        }
        return true;
    }

    @RequiresApi(api = 21)
    public final void q(boolean z10, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar) {
        String str = fVar.f22768k;
        String str2 = fVar.f22766i;
        com.onetrust.otpublishers.headless.UI.UIProperty.u uVar = this.f22446g.f22335f;
        String str3 = uVar.f22816a;
        if (str3 == null) {
            str3 = "#FFFFFF";
        }
        GradientDrawable gradientDrawableB = com.onetrust.otpublishers.headless.UI.Helper.i.b(z10, str, str2, str3, uVar.f22820e.f22722c, this.f22454o);
        if (!z10) {
            this.f22454o.getBackground().setTint(Color.parseColor(this.f22446g.f22335f.f22820e.f22722c));
            Drawable drawable = this.f22454o.getDrawable();
            String str4 = this.f22446g.f22335f.f22816a;
            drawable.setTint(Color.parseColor(str4 != null ? str4 : "#FFFFFF"));
        } else if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22766i) && !com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22767j)) {
            this.f22454o.getBackground().setTint(Color.parseColor(fVar.f22766i));
            this.f22454o.getDrawable().setTint(Color.parseColor(fVar.f22767j));
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            return;
        }
        this.f22454o.setBackground(gradientDrawableB);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x016f A[PHI: r0 r5
      0x016f: PHI (r0v141 android.widget.TextView) = (r0v140 android.widget.TextView), (r0v143 android.widget.TextView), (r0v144 android.widget.TextView) binds: [B:31:0x016d, B:28:0x015a, B:25:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r5v14 java.lang.String) = (r5v13 java.lang.String), (r5v15 java.lang.String), (r5v16 java.lang.String) binds: [B:31:0x016d, B:28:0x015a, B:25:0x0147] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020a  */
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            Method dump skipped, instruction units count: 1058
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.b.r():void");
    }
}
