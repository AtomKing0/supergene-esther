package com.onetrust.otpublishers.headless.UI.UIProperty;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f22714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f22715b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f22718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f22719f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f22717d = new j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f22716c = new e();

    public b0(@NonNull Context context) {
        this.f22714a = new g(context);
        this.f22715b = new r(context);
        this.f22718e = new b(context);
        this.f22719f = new d(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0259  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.s a() {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.b0.a():com.onetrust.otpublishers.headless.UI.UIProperty.s");
    }

    @NonNull
    public final x b(int i10) throws JSONException {
        x xVar;
        JSONObject jSONObjectB = this.f22714a.b();
        JSONObject jSONObject = (jSONObjectB == null || !jSONObjectB.has(OTUXParamsKeys.OT_PREFERENCE_CENTER_THEME)) ? null : jSONObjectB.getJSONObject(OTUXParamsKeys.OT_PREFERENCE_CENTER_THEME);
        if (jSONObject != null) {
            xVar = new x();
            if (jSONObject.has("backgroundColor")) {
                xVar.f22849a = jSONObject.getString("backgroundColor");
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR)) {
                xVar.f22850b = jSONObject.getString(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON)) {
                xVar.f22851c = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF)) {
                xVar.f22852d = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR)) {
                xVar.f22853e = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR)) {
                xVar.f22855g = jSONObject.getString(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_SHOW_LOGO_ON_PC)) {
                p pVar = new p();
                pVar.f22791a = String.valueOf(jSONObject.getBoolean(OTUXParamsKeys.OT_UX_SHOW_LOGO_ON_PC));
                xVar.A = pVar;
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_SUMMARY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_SUMMARY);
                if (jSONObject2.has("title")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("title");
                    xVar.f22859k = g.g(jSONObject3);
                    xVar.f22867s = g.g(jSONObject3);
                    xVar.f22870v = g.g(jSONObject3);
                    xVar.f22861m = g.g(jSONObject3);
                }
                if (jSONObject2.has("description")) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("description");
                    xVar.f22860l = g.g(jSONObject4);
                    xVar.f22866r = g.g(jSONObject4);
                }
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_PURPOSE_TITLE)) {
                JSONObject jSONObject5 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_PURPOSE_TITLE);
                xVar.f22868t = g.g(jSONObject5);
                xVar.f22862n = g.g(jSONObject5);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_ALWAYS_ACTIVE_STATUS)) {
                xVar.f22869u = g.g(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_TOGGLE_ALWAYS_ACTIVE_STATUS));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
                JSONObject jSONObject6 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS);
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_CLOSE_BUTTON_COLOR)) {
                    String string = jSONObject6.getString(OTUXParamsKeys.OT_UX_CLOSE_BUTTON_COLOR);
                    h hVar = new h();
                    hVar.f22777e = string;
                    xVar.f22874z = hVar;
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_CLOSE_BUTTON)) {
                    JSONObject jSONObject7 = jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_CLOSE_BUTTON);
                    h hVar2 = xVar.f22874z;
                    f fVarA = g.a(jSONObject7);
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(fVarA.f22759b)) {
                        fVarA.f22765h = com.ironsource.mediationsdk.metadata.a.f13688g;
                        hVar2.f22778f = fVarA;
                        xVar.f22874z = hVar2;
                    }
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR)) {
                    xVar.C = jSONObject6.getString(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR);
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_ACCEPT_ALL)) {
                    xVar.f22871w = g.a(jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_ACCEPT_ALL));
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_REJECT_ALL)) {
                    xVar.f22872x = g.a(jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_REJECT_ALL));
                }
                if (jSONObject6.has(OTUXParamsKeys.OT_UX_CONFIRM_CHOICE)) {
                    xVar.f22873y = g.a(jSONObject6.getJSONObject(OTUXParamsKeys.OT_UX_CONFIRM_CHOICE));
                }
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINKS)) {
                JSONObject jSONObject8 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_LINKS);
                if (jSONObject8.has(OTUXParamsKeys.OT_UX_LINK_POLICY_LINK)) {
                    xVar.D = g.e(jSONObject8.getJSONObject(OTUXParamsKeys.OT_UX_LINK_POLICY_LINK));
                }
                if (jSONObject8.has(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST)) {
                    xVar.E = g.e(jSONObject8.getJSONObject(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST));
                }
            }
        } else {
            xVar = null;
        }
        x xVarG = this.f22715b.g(i10);
        j jVar = this.f22717d;
        v vVarD = this.f22714a.d();
        jVar.getClass();
        if (xVar == null) {
            if (vVarD != null && !com.onetrust.otpublishers.headless.Internal.c.q(vVarD.f22832b)) {
                String str = vVarD.f22832b;
                if (xVarG == null) {
                    return null;
                }
                o oVar = xVarG.D;
                c cVar = oVar.f22787a;
                cVar.f22722c = str;
                oVar.f22787a = cVar;
                xVarG.D = oVar;
            }
            return xVarG;
        }
        if (xVarG != null) {
            String strJ = j.j(xVar.f22849a, xVarG.f22849a);
            if (strJ != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ)) {
                xVar.f22849a = strJ;
            }
            String strJ2 = j.j(xVar.f22856h, xVarG.f22856h);
            if (strJ2 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ2)) {
                xVar.f22856h = strJ2;
            }
            String strJ3 = j.j(xVar.f22855g, xVarG.f22855g);
            if (strJ3 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ3)) {
                xVar.f22855g = strJ3;
            }
            xVar.f22857i = xVarG.f22857i;
            xVar.f22859k = j.b(xVar.f22859k, xVarG.f22859k);
            xVar.f22861m = j.b(xVar.f22861m, xVarG.f22861m);
            xVar.f22865q = j.b(xVar.f22865q, xVarG.f22865q);
            xVar.f22863o = j.b(xVar.f22863o, xVarG.f22863o);
            xVar.f22864p = j.b(xVar.f22864p, xVarG.f22864p);
            xVar.K = j.j(xVar.K, xVarG.K);
            xVar.f22860l = j.b(xVar.f22860l, xVarG.f22860l);
            xVar.f22866r = j.b(xVar.f22866r, xVarG.f22866r);
            xVar.f22867s = j.b(xVar.f22867s, xVarG.f22867s);
            xVar.f22870v = j.b(xVar.f22870v, xVarG.f22870v);
            xVar.f22862n = j.b(xVar.f22862n, xVarG.f22862n);
            xVar.I = j.j(xVar.I, xVarG.I);
            xVar.J = j.j(xVar.J, xVarG.J);
            o oVarF = j.f(xVar.D, xVarG.D, vVarD);
            oVarF.f22789c = xVarG.D.f22789c;
            xVar.D = oVarF;
            xVar.E = j.e(xVar.E, xVarG.E);
            o oVarE = j.e(xVar.F, xVarG.F);
            c cVar2 = xVarG.F.f22787a;
            String str2 = cVar2.f22724e;
            if (str2 != null) {
                oVarE.f22787a.f22724e = str2;
            }
            oVarE.f22787a.f22725f = cVar2.f22725f;
            xVar.F = oVarE;
            xVar.f22858j = xVarG.f22858j;
            xVar.f22871w = j.c(xVar.f22871w, xVarG.f22871w);
            xVar.f22872x = j.c(xVar.f22872x, xVarG.f22872x);
            xVar.f22873y = j.c(xVar.f22873y, xVarG.f22873y);
            xVar.f22874z = j.d(xVar.f22874z, xVarG.f22874z);
            c cVar3 = xVar.f22869u;
            c cVar4 = xVarG.f22869u;
            String strJ4 = j.j(cVar3.f22722c, cVar4.f22722c);
            if (strJ4 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ4)) {
                cVar3.f22722c = strJ4;
            }
            l lVar = cVar3.f22720a;
            String strJ5 = j.j(lVar.f22783b, cVar4.f22720a.f22783b);
            if (strJ5 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ5)) {
                lVar.f22783b = strJ5;
            }
            cVar3.f22720a = lVar;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(xVarG.f22869u.f22724e)) {
                cVar3.f22724e = xVarG.f22869u.f22724e;
            }
            xVar.f22869u = cVar3;
            c cVar5 = xVar.f22868t;
            c cVar6 = xVarG.f22868t;
            String strJ6 = j.j(cVar5.f22722c, cVar6.f22722c);
            if (strJ6 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ6)) {
                cVar5.f22722c = strJ6;
            }
            l lVar2 = cVar5.f22720a;
            String strJ7 = j.j(lVar2.f22783b, cVar6.f22720a.f22783b);
            if (strJ7 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ7)) {
                lVar2.f22783b = strJ7;
            }
            cVar5.f22720a = lVar2;
            xVar.f22868t = cVar5;
            p pVar2 = xVar.A;
            p pVar3 = xVarG.A;
            String strJ8 = j.j(pVar2.a(), pVar3.a());
            if (strJ8 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ8)) {
                pVar2.f22792b = strJ8;
            }
            String strJ9 = j.j(pVar2.f22791a, pVar3.f22791a);
            if (strJ9 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ9)) {
                pVar2.f22791a = strJ9;
            }
            xVar.A = pVar2;
            String strJ10 = j.j(xVar.f22851c, xVarG.f22851c);
            if (strJ10 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ10)) {
                xVar.f22851c = strJ10;
            }
            String strJ11 = j.j(xVar.f22852d, xVarG.f22852d);
            if (strJ11 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ11)) {
                xVar.f22852d = strJ11;
            }
            String strJ12 = j.j(xVar.f22850b, xVarG.f22850b);
            if (strJ12 != null && !com.onetrust.otpublishers.headless.Internal.c.q(strJ12)) {
                xVar.f22850b = strJ12;
            }
        }
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f4  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.a0 c(com.onetrust.otpublishers.headless.Internal.Helper.w r24, int r25) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.b0.c(com.onetrust.otpublishers.headless.Internal.Helper.w, int):com.onetrust.otpublishers.headless.UI.UIProperty.a0");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ad  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.w d() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.b0.d():com.onetrust.otpublishers.headless.UI.UIProperty.w");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.z e(int r18) {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.b0.e(int):com.onetrust.otpublishers.headless.UI.UIProperty.z");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c9  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.b0.f():com.onetrust.otpublishers.headless.UI.UIProperty.c0");
    }

    @Nullable
    public final d0 g(int i10) {
        d0 d0Var;
        g gVar = this.f22714a;
        JSONObject jSONObjectB = gVar.b();
        y yVar = null;
        JSONObject jSONObject = (jSONObjectB == null || !jSONObjectB.has(OTUXParamsKeys.OT_VENDOR_LIST_THEME)) ? null : jSONObjectB.getJSONObject(OTUXParamsKeys.OT_VENDOR_LIST_THEME);
        if (jSONObject != null) {
            d0Var = new d0();
            if (jSONObject.has("backgroundColor")) {
                d0Var.f22738a = jSONObject.getString("backgroundColor");
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR)) {
                d0Var.f22739b = jSONObject.getString(OTUXParamsKeys.OT_UX_LINE_BREAK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_COLOR_ON)) {
                d0Var.f22743f = jSONObject.getString(OTUXParamsKeys.OT_UX_FILTER_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_COLOR_OFF)) {
                d0Var.f22744g = jSONObject.getString(OTUXParamsKeys.OT_UX_FILTER_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_SELECTION_COLOR)) {
                d0Var.f22745h = jSONObject.getString(OTUXParamsKeys.OT_UX_FILTER_SELECTION_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON)) {
                d0Var.f22740c = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_ON);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF)) {
                d0Var.f22741d = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_THUMB_COLOR_OFF);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR)) {
                d0Var.f22742e = jSONObject.getString(OTUXParamsKeys.OT_UX_TOGGLE_TRACK_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR)) {
                d0Var.f22746i = jSONObject.getString(OTUXParamsKeys.OT_UX_RIGHT_CHEVRON_COLOR);
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_SEARCH_BAR)) {
                d0Var.f22751n = g.f(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_SEARCH_BAR));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_NAVIGATION_TEXT)) {
                d0Var.f22747j = g.g(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_FILTER_NAVIGATION_TEXT));
            }
            if (jSONObject.has("title")) {
                d0Var.f22748k = g.g(jSONObject.getJSONObject("title"));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_ALLOW_ALL_TOGGLE_TEXT)) {
                d0Var.f22749l = g.g(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_ALLOW_ALL_TOGGLE_TEXT));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_FILTER_ITEM_TITLE_TEXT)) {
                d0Var.f22750m = g.g(jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_FILTER_ITEM_TITLE_TEXT));
            }
            if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS);
                if (jSONObject2.has(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR)) {
                    d0Var.f22754q = jSONObject2.getString(OTUXParamsKeys.OT_UX_BACK_BUTTON_COLOR);
                }
                if (jSONObject2.has(OTUXParamsKeys.OT_UX_VL_CONFIRM_CHOICE)) {
                    d0Var.f22752o = g.a(jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_VL_CONFIRM_CHOICE));
                }
                if (jSONObject2.has(OTUXParamsKeys.OT_UX_APPLY_FILTER_BUTTON)) {
                    d0Var.f22753p = g.a(jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_APPLY_FILTER_BUTTON));
                }
            }
        } else {
            d0Var = null;
        }
        JSONObject jSONObjectB2 = gVar.b();
        JSONObject jSONObject3 = (jSONObjectB2 == null || !jSONObjectB2.has("pageHeader")) ? null : jSONObjectB2.getJSONObject("pageHeader");
        if (jSONObject3 != null) {
            yVar = new y();
            c cVar = new c();
            cVar.f22720a = g.c(jSONObject3);
            if (jSONObject3.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
                cVar.f22722c = jSONObject3.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            }
            yVar.f22875a = cVar;
        }
        if (yVar != null) {
            (d0Var == null ? new d0() : d0Var).f22755r = yVar;
        }
        d0 d0VarK = this.f22715b.k(i10);
        this.f22717d.getClass();
        return j.i(d0Var, d0VarK);
    }

    public b0(@NonNull Context context, int i10) {
        this.f22714a = new g(context);
        this.f22715b = new r(context, i10);
    }
}
