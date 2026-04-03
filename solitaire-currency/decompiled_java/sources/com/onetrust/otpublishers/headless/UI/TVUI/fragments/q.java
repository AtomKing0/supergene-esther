package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCustomConfigurator;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProxyType;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.g;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.e;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.g;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.n;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class q extends Fragment implements g.a, View.OnKeyListener, View.OnFocusChangeListener, g.a, n.a, e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f22609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f22611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f22613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f22614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f22615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f22616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f22617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RelativeLayout f22619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f22620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f22621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f22622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f22623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public n f22624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f22625q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f22626r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.g f22627s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f22628t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public OTConfiguration f22629u;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        View view;
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22615g.clearFocus();
            this.f22614f.clearFocus();
            this.f22613e.clearFocus();
            n nVar = this.f22624p;
            CardView cardView = nVar.f22600t;
            if (cardView == null || cardView.getVisibility() != 0) {
                CardView cardView2 = nVar.f22601u;
                if (cardView2 == null || cardView2.getVisibility() != 0) {
                    view = nVar.f22582b;
                    if (view == null) {
                        return;
                    }
                } else {
                    view = nVar.f22601u;
                }
            } else {
                view = nVar.f22600t;
            }
            view.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22615g.clearFocus();
            this.f22614f.clearFocus();
            this.f22613e.clearFocus();
            TextView textView = this.f22625q.f22498b;
            if (textView != null) {
                textView.requestFocus();
            }
        }
    }

    public final void a(int i10) {
        if (i10 == 24) {
            this.f22627s.notifyDataSetChanged();
        }
        if (i10 == 26) {
            this.f22614f.requestFocus();
        }
        if (18 == i10) {
            ((k) this.f22611c).a(18);
        }
        if (17 == i10) {
            ((k) this.f22611c).a(17);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22609a = getActivity();
        this.f22618j = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        StringBuilder sb;
        FragmentActivity fragmentActivity = this.f22609a;
        int i10 = p6.e.f32889w;
        if (com.onetrust.otpublishers.headless.Internal.c.x(fragmentActivity)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(fragmentActivity, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(p6.d.R5);
        this.f22617i = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f22617i.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f22613e = (Button) viewInflate.findViewById(p6.d.f32743l5);
        this.f22614f = (Button) viewInflate.findViewById(p6.d.f32734k5);
        this.f22615g = (Button) viewInflate.findViewById(p6.d.f32779p5);
        this.f22616h = (Button) viewInflate.findViewById(p6.d.J3);
        this.f22619k = (RelativeLayout) viewInflate.findViewById(p6.d.Y5);
        this.f22620l = (LinearLayout) viewInflate.findViewById(p6.d.f32770o5);
        this.f22621m = (ImageView) viewInflate.findViewById(p6.d.L3);
        this.f22622n = (ImageView) viewInflate.findViewById(p6.d.I3);
        this.f22626r = viewInflate.findViewById(p6.d.f32651b3);
        this.f22613e.setOnKeyListener(this);
        this.f22614f.setOnKeyListener(this);
        this.f22615g.setOnKeyListener(this);
        this.f22616h.setOnKeyListener(this);
        this.f22622n.setOnKeyListener(this);
        this.f22613e.setOnFocusChangeListener(this);
        this.f22614f.setOnFocusChangeListener(this);
        this.f22615g.setOnFocusChangeListener(this);
        this.f22616h.setOnFocusChangeListener(this);
        this.f22622n.setOnFocusChangeListener(this);
        try {
            JSONObject jSONObjectL = this.f22618j.l(this.f22609a);
            this.f22619k.setBackgroundColor(Color.parseColor(this.f22618j.a()));
            this.f22620l.setBackgroundColor(Color.parseColor(this.f22618j.a()));
            this.f22626r.setBackgroundColor(Color.parseColor(this.f22618j.m()));
            this.f22617i.setBackgroundColor(Color.parseColor(this.f22618j.f22370j.B.f22794a));
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22618j.f22370j.f22873y;
            com.onetrust.otpublishers.headless.UI.Helper.i.d(this.f22613e, fVar);
            com.onetrust.otpublishers.headless.UI.Helper.i.d(this.f22614f, this.f22618j.f22370j.f22871w);
            com.onetrust.otpublishers.headless.UI.Helper.i.d(this.f22615g, this.f22618j.f22370j.f22872x);
            com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.f22618j.f22378r;
            v(false, fVar);
            this.f22622n.setVisibility(cVar.f22152o);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.a())) {
                this.f22616h.setText(cVar.a());
                if (com.onetrust.otpublishers.headless.Internal.b.a(cVar.f22155r.f22765h)) {
                    com.onetrust.otpublishers.headless.UI.Helper.i.d(this.f22616h, cVar.f22155r);
                } else {
                    String strC = cVar.c();
                    Button button = this.f22616h;
                    if (strC != null && !com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                        button.setTextColor(Color.parseColor(strC));
                    }
                    button.setPaintFlags(button.getPaintFlags() | 8);
                    button.getBackground().setTint(Color.parseColor(this.f22618j.a()));
                    button.setElevation(0.0f);
                }
            }
            this.f22616h.setVisibility(cVar.f22156s);
            a();
            if (jSONObjectL != null) {
                JSONArray jSONArrayR = r(jSONObjectL.getJSONArray("Groups"));
                int i11 = (getArguments() == null || !getArguments().containsKey("OT_FOCUSED_PC_LIST_ITEM")) ? 0 : getArguments().getInt("OT_FOCUSED_PC_LIST_ITEM");
                com.onetrust.otpublishers.headless.UI.TVUI.adapter.g gVar = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.g(this.f22609a, jSONArrayR, this);
                this.f22627s = gVar;
                gVar.f22242l = i11;
                this.f22617i.setAdapter(gVar);
                a(jSONArrayR.getJSONObject(0));
            }
        } catch (IndexOutOfBoundsException e10) {
            e = e10;
            sb = new StringBuilder("error while populating PC list");
            sb.append(e.getMessage());
            OTLogger.a("TVPreferenceCenter", 6, sb.toString());
        } catch (JSONException e11) {
            e = e11;
            sb = new StringBuilder("JSON error while populating PC fields");
            sb.append(e.getMessage());
            OTLogger.a("TVPreferenceCenter", 6, sb.toString());
        }
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.f32743l5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22613e, this.f22618j.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32779p5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22615g, this.f22618j.f22370j.f22872x, z10);
        }
        if (view.getId() == p6.d.f32734k5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22614f, this.f22618j.f22370j.f22871w, z10);
        }
        if (view.getId() == p6.d.J3) {
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22618j.f22378r.f22155r;
            if (com.onetrust.otpublishers.headless.Internal.b.a(fVar.f22765h)) {
                com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22616h, fVar, z10);
            } else {
                Button button = this.f22616h;
                String strC = this.f22618j.f22378r.c();
                if (z10) {
                    com.onetrust.otpublishers.headless.UI.Helper.i.k(button, fVar, true);
                    button.setPaintFlags(button.getPaintFlags() & (-9));
                } else {
                    if (strC != null && !com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                        button.setTextColor(Color.parseColor(strC));
                    }
                    button.setPaintFlags(button.getPaintFlags() | 8);
                    button.getBackground().setTint(Color.parseColor(this.f22618j.a()));
                    button.setElevation(0.0f);
                }
            }
        }
        if (view.getId() == p6.d.I3) {
            v(z10, this.f22618j.f22370j.f22873y);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        View view2;
        TextView textView;
        View view3;
        View view4;
        TextView textView2;
        View view5;
        View view6;
        TextView textView3;
        View view7;
        View view8;
        TextView textView4;
        View view9;
        View view10;
        TextView textView5;
        View view11;
        int id = view.getId();
        int i11 = p6.d.f32743l5;
        if (id == i11 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22611c).a(14);
        }
        if (view.getId() == i11 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.f22628t) {
                n nVar = this.f22624p;
                if (nVar != null) {
                    CardView cardView = nVar.f22600t;
                    if (cardView == null || cardView.getVisibility() != 0) {
                        CardView cardView2 = nVar.f22601u;
                        if (cardView2 == null || cardView2.getVisibility() != 0) {
                            view11 = nVar.f22582b;
                            if (view11 != null) {
                            }
                        } else {
                            view11 = nVar.f22601u;
                        }
                    } else {
                        view11 = nVar.f22600t;
                    }
                    view11.requestFocus();
                }
                e eVar = this.f22625q;
                if (eVar != null && (textView5 = eVar.f22498b) != null) {
                    textView5.requestFocus();
                }
                g gVar = this.f22623o;
                if (gVar.f22557u.optBoolean("IS_PARTNERS_LINK")) {
                    view10 = gVar.f22554r;
                } else if (gVar.C.getVisibility() == 0) {
                    view10 = gVar.C;
                } else if (gVar.D.getVisibility() == 0) {
                    view10 = gVar.D;
                } else if (gVar.f22537b.getVisibility() == 0) {
                    view10 = gVar.f22537b;
                }
                view10.requestFocus();
            } else {
                this.f22627s.notifyDataSetChanged();
            }
            return true;
        }
        int id2 = view.getId();
        int i12 = p6.d.f32734k5;
        if (id2 == i12 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.f22628t) {
                n nVar2 = this.f22624p;
                if (nVar2 != null) {
                    CardView cardView3 = nVar2.f22600t;
                    if (cardView3 == null || cardView3.getVisibility() != 0) {
                        CardView cardView4 = nVar2.f22601u;
                        if (cardView4 == null || cardView4.getVisibility() != 0) {
                            view9 = nVar2.f22582b;
                            if (view9 != null) {
                            }
                        } else {
                            view9 = nVar2.f22601u;
                        }
                    } else {
                        view9 = nVar2.f22600t;
                    }
                    view9.requestFocus();
                }
                e eVar2 = this.f22625q;
                if (eVar2 != null && (textView4 = eVar2.f22498b) != null) {
                    textView4.requestFocus();
                }
                g gVar2 = this.f22623o;
                if (gVar2.f22557u.optBoolean("IS_PARTNERS_LINK")) {
                    view8 = gVar2.f22554r;
                } else if (gVar2.C.getVisibility() == 0) {
                    view8 = gVar2.C;
                } else if (gVar2.D.getVisibility() == 0) {
                    view8 = gVar2.D;
                } else if (gVar2.f22537b.getVisibility() == 0) {
                    view8 = gVar2.f22537b;
                }
                view8.requestFocus();
            } else {
                this.f22627s.notifyDataSetChanged();
            }
            return true;
        }
        int id3 = view.getId();
        int i13 = p6.d.f32779p5;
        if (id3 == i13 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.f22628t) {
                n nVar3 = this.f22624p;
                if (nVar3 != null) {
                    CardView cardView5 = nVar3.f22600t;
                    if (cardView5 == null || cardView5.getVisibility() != 0) {
                        CardView cardView6 = nVar3.f22601u;
                        if (cardView6 == null || cardView6.getVisibility() != 0) {
                            view7 = nVar3.f22582b;
                            if (view7 != null) {
                            }
                        } else {
                            view7 = nVar3.f22601u;
                        }
                    } else {
                        view7 = nVar3.f22600t;
                    }
                    view7.requestFocus();
                }
                e eVar3 = this.f22625q;
                if (eVar3 != null && (textView3 = eVar3.f22498b) != null) {
                    textView3.requestFocus();
                }
                g gVar3 = this.f22623o;
                if (gVar3.f22557u.optBoolean("IS_PARTNERS_LINK")) {
                    view6 = gVar3.f22554r;
                } else if (gVar3.C.getVisibility() == 0) {
                    view6 = gVar3.C;
                } else if (gVar3.D.getVisibility() == 0) {
                    view6 = gVar3.D;
                } else if (gVar3.f22537b.getVisibility() == 0) {
                    view6 = gVar3.f22537b;
                }
                view6.requestFocus();
            } else {
                this.f22627s.notifyDataSetChanged();
            }
            return true;
        }
        if (view.getId() == i12 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22611c).a(21);
        }
        if (view.getId() == i13 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22611c).a(22);
        }
        if (i10 == 4 && keyEvent.getAction() == 1) {
            ((k) this.f22611c).a(23);
        }
        int id4 = view.getId();
        int i14 = p6.d.I3;
        if ((id4 == i14 || view.getId() == p6.d.J3) && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            this.f22610b.resetUpdatedConsent();
            ((k) this.f22611c).a(23);
        }
        if ((view.getId() == i14 || view.getId() == p6.d.J3) && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 26) {
            if (this.f22628t) {
                n nVar4 = this.f22624p;
                if (nVar4 != null) {
                    CardView cardView7 = nVar4.f22600t;
                    if (cardView7 == null || cardView7.getVisibility() != 0) {
                        CardView cardView8 = nVar4.f22601u;
                        if (cardView8 == null || cardView8.getVisibility() != 0) {
                            view5 = nVar4.f22582b;
                            if (view5 != null) {
                            }
                        } else {
                            view5 = nVar4.f22601u;
                        }
                    } else {
                        view5 = nVar4.f22600t;
                    }
                    view5.requestFocus();
                }
                e eVar4 = this.f22625q;
                if (eVar4 != null && (textView2 = eVar4.f22498b) != null) {
                    textView2.requestFocus();
                }
                g gVar4 = this.f22623o;
                if (gVar4.f22557u.optBoolean("IS_PARTNERS_LINK")) {
                    view4 = gVar4.f22554r;
                } else if (gVar4.C.getVisibility() == 0) {
                    view4 = gVar4.C;
                } else if (gVar4.D.getVisibility() == 0) {
                    view4 = gVar4.D;
                } else if (gVar4.f22537b.getVisibility() == 0) {
                    view4 = gVar4.f22537b;
                }
                view4.requestFocus();
            } else {
                this.f22627s.notifyDataSetChanged();
            }
            return true;
        }
        if (!((view.getId() == i14 || view.getId() == p6.d.J3) && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24)) {
            return false;
        }
        n nVar5 = this.f22624p;
        if (nVar5 != null) {
            CardView cardView9 = nVar5.f22600t;
            if (cardView9 == null || cardView9.getVisibility() != 0) {
                CardView cardView10 = nVar5.f22601u;
                if (cardView10 == null || cardView10.getVisibility() != 0) {
                    view3 = nVar5.f22582b;
                    if (view3 != null) {
                    }
                } else {
                    view3 = nVar5.f22601u;
                }
            } else {
                view3 = nVar5.f22600t;
            }
            view3.requestFocus();
        }
        e eVar5 = this.f22625q;
        if (eVar5 != null && (textView = eVar5.f22498b) != null) {
            textView.requestFocus();
        }
        g gVar5 = this.f22623o;
        if (gVar5.f22557u.optBoolean("IS_PARTNERS_LINK")) {
            view2 = gVar5.f22554r;
        } else if (gVar5.C.getVisibility() == 0) {
            view2 = gVar5.C;
        } else {
            if (gVar5.D.getVisibility() != 0) {
                if (gVar5.f22537b.getVisibility() == 0) {
                    view2 = gVar5.f22537b;
                }
                return true;
            }
            view2 = gVar5.D;
        }
        view2.requestFocus();
        return true;
    }

    public final JSONArray r(@Nullable JSONArray jSONArray) {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray != null) {
            try {
                String str2 = this.f22618j.f22370j.f22859k.f22724e;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("GroupName", str2);
                String str3 = this.f22618j.f22370j.f22860l.f22724e;
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put("GroupDescription", str3);
                jSONObject.put("isAlertNotice", true);
                jSONArray2.put(jSONObject);
                if (this.f22618j.f22365e) {
                    JSONObject jSONObject2 = new JSONObject();
                    com.onetrust.otpublishers.headless.UI.UIProperty.d0 d0Var = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a().f22385f;
                    if (d0Var == null || (str = d0Var.f22755r.f22875a.f22724e) == null) {
                        str = "";
                    }
                    jSONObject2.put("GroupName", str);
                    jSONObject2.put("GroupDescription", "");
                    jSONObject2.put("IS_PARTNERS_LINK", true);
                    jSONArray2.put(jSONObject2);
                }
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    jSONArray2.put(jSONArray.getJSONObject(i10));
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.n.a(e10, new StringBuilder("Exception while setting alert notice text, err : "), "OneTrust", 6);
                return jSONArray;
            }
        }
        return jSONArray2;
    }

    public final void t(ArrayList arrayList) {
        k kVar = (k) this.f22611c;
        kVar.f22576j = 6;
        b bVar = kVar.f22577k;
        if (bVar != null && bVar.getArguments() != null) {
            kVar.f22577k.getArguments().putInt("OT_TV_FOCUSED_BTN", 1);
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = kVar.f22575i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(25);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = kVar.f22573g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = kVar.f22573g;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = kVar.f22572f;
        OTConfiguration oTConfiguration = kVar.f22578l;
        u uVar = new u();
        Bundle bundle = new Bundle();
        bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
        uVar.setArguments(bundle);
        uVar.f22664b = kVar;
        uVar.f22673k = arrayList;
        uVar.f22688z = oTPublishersHeadlessSDK;
        uVar.A = aVar2;
        uVar.C = oTConfiguration;
        kVar.getChildFragmentManager().beginTransaction().replace(p6.d.W5, uVar).addToBackStack(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG).commit();
    }

    @RequiresApi(api = 21)
    public final void u(JSONObject jSONObject, boolean z10, boolean z11) {
        boolean z12;
        if (z11) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22610b;
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString("TVIllustration", OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
            eVar.setArguments(bundle);
            z12 = eVar.f22502f != null;
            eVar.f22502f = jSONObject;
            if (z12) {
                eVar.p();
            }
            eVar.f22504h = this;
            eVar.f22501e = oTPublishersHeadlessSDK;
            this.f22625q = eVar;
            getChildFragmentManager().beginTransaction().replace(p6.d.f32642a3, this.f22625q).addToBackStack(null).commit();
            this.f22625q.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.p
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    this.f22608a.w(lifecycleOwner, event);
                }
            });
            return;
        }
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22612d;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = this.f22610b;
        n nVar = new n();
        Bundle bundle2 = new Bundle();
        bundle2.putString("GroupDetails", OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
        nVar.setArguments(bundle2);
        z12 = nVar.f22592l != null;
        nVar.f22592l = jSONObject;
        if (z12) {
            nVar.w();
        }
        nVar.f22594n = aVar;
        nVar.f22595o = this;
        nVar.f22596p = z10;
        nVar.f22591k = oTPublishersHeadlessSDK2;
        this.f22624p = nVar;
        getChildFragmentManager().beginTransaction().replace(p6.d.f32642a3, this.f22624p).addToBackStack(null).commit();
        this.f22624p.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.o
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f22607a.s(lifecycleOwner, event);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(boolean r7, com.onetrust.otpublishers.headless.UI.UIProperty.f r8) {
        /*
            r6 = this;
            java.lang.String r1 = r8.f22768k
            java.lang.String r2 = r8.f22766i
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r0 = r6.f22618j
            java.lang.String r3 = r0.a()
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r0 = r6.f22618j
            java.lang.String r4 = r0.m()
            android.widget.ImageView r5 = r6.f22622n
            r0 = r7
            android.graphics.drawable.GradientDrawable r0 = com.onetrust.otpublishers.headless.UI.Helper.i.b(r0, r1, r2, r3, r4, r5)
            if (r7 == 0) goto L41
            java.lang.String r7 = r8.f22766i
            boolean r7 = com.onetrust.otpublishers.headless.Internal.c.q(r7)
            if (r7 != 0) goto L67
            java.lang.String r7 = r8.f22767j
            boolean r7 = com.onetrust.otpublishers.headless.Internal.c.q(r7)
            if (r7 != 0) goto L67
            android.widget.ImageView r7 = r6.f22622n
            android.graphics.drawable.Drawable r7 = r7.getBackground()
            java.lang.String r1 = r8.f22766i
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTint(r1)
            android.widget.ImageView r7 = r6.f22622n
            android.graphics.drawable.Drawable r7 = r7.getDrawable()
            java.lang.String r1 = r8.f22767j
            goto L60
        L41:
            android.widget.ImageView r7 = r6.f22622n
            android.graphics.drawable.Drawable r7 = r7.getBackground()
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r1 = r6.f22618j
            java.lang.String r1 = r1.m()
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTint(r1)
            android.widget.ImageView r7 = r6.f22622n
            android.graphics.drawable.Drawable r7 = r7.getDrawable()
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r1 = r6.f22618j
            java.lang.String r1 = r1.a()
        L60:
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTint(r1)
        L67:
            java.lang.String r7 = r8.f22761d
            boolean r7 = com.onetrust.otpublishers.headless.Internal.c.q(r7)
            if (r7 != 0) goto L74
            android.widget.ImageView r7 = r6.f22622n
            r7.setBackground(r0)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.q.v(boolean, com.onetrust.otpublishers.headless.UI.UIProperty.f):void");
    }

    public final void a(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22612d;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22610b;
            g gVar = new g();
            Bundle bundle = new Bundle();
            bundle.putString("GroupDetails", "GroupDetails");
            gVar.setArguments(bundle);
            boolean z10 = gVar.f22557u != null;
            gVar.f22557u = jSONObject;
            if (z10) {
                gVar.w();
            }
            gVar.f22559w = aVar;
            gVar.f22560x = this;
            gVar.f22561y = false;
            gVar.f22547k = oTPublishersHeadlessSDK;
            this.f22623o = gVar;
            getChildFragmentManager().beginTransaction().replace(p6.d.f32642a3, this.f22623o).addToBackStack(null).commit();
        }
    }

    public final void a() {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        if (!this.f22618j.f22370j.A.b()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = getResources().getDimensionPixelSize(p6.b.f32633e);
            this.f22621m.setLayoutParams(layoutParams);
            return;
        }
        FragmentActivity fragmentActivity = this.f22609a;
        SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        boolean z11 = true;
        String proxyDomainURLString = null;
        if (new com.onetrust.otpublishers.headless.Internal.profile.d(fragmentActivity).t()) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(fragmentActivity, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            z10 = false;
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        if (sharedPreferences.getBoolean("OTT_LOAD_OFFLINE_DATA", false)) {
            OTConfiguration oTConfiguration = this.f22629u;
            if (oTConfiguration == null || oTConfiguration.getPcLogo() == null) {
                return;
            }
        } else {
            FragmentActivity fragmentActivity2 = this.f22609a;
            SharedPreferences sharedPreferences2 = fragmentActivity2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (new com.onetrust.otpublishers.headless.Internal.profile.d(fragmentActivity2).t()) {
                hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(fragmentActivity2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
            } else {
                z11 = false;
                hVar2 = null;
            }
            if (z11) {
                sharedPreferences2 = hVar2;
            }
            if (!sharedPreferences2.getBoolean("OTT_OFFLINE_DATA_SET_FLAG", false) || com.onetrust.otpublishers.headless.Internal.Network.o.a(this.f22609a)) {
                String strA = this.f22618j.f22370j.A.a();
                try {
                    proxyDomainURLString = OTCustomConfigurator.getProxyDomainURLString(new OTProxyType.PCLogo(new URL(strA)));
                } catch (MalformedURLException e10) {
                    OTLogger.a("TVPreferenceCenter", 6, "Error while fetching PC Logo using proxy" + e10.getMessage());
                }
                com.onetrust.otpublishers.headless.UI.extensions.f.a(p6.c.f32635b, 10000, this.f22621m, proxyDomainURLString, strA, "Preference Center");
                return;
            }
            OTConfiguration oTConfiguration2 = this.f22629u;
            if (oTConfiguration2 == null || oTConfiguration2.getPcLogo() == null) {
                return;
            }
        }
        this.f22621m.setImageDrawable(this.f22629u.getPcLogo());
    }
}
