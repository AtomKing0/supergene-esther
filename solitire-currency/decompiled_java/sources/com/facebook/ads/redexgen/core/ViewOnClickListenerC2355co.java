package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.co, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC2355co implements View.OnClickListener {
    public static String[] A01 = {"hS5f9KbstsMPLbUbPSxFVdCfAROmcRtV", "DUM08yoPCPer4HETov37xY8lXqOkWet1", "HD0hLshA4", "cNo3fMkBKvz7jHUo", "0KN3KUldF", "ICLtCAijF", "iMQeuY1uIySJVoFID8xkudblEyJz6Aif", "P1hZJiyY"};
    public final /* synthetic */ C2356cp A00;

    public ViewOnClickListenerC2355co(C2356cp c2356cp) {
        this.A00 = c2356cp;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A05.performClick();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
            if (A01[6].charAt(1) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "I2wlNoUiFEETsNdyZ3cedgIbWPjbODtt";
            strArr[1] = "f6nspZJA1kETXV8rRnTaX6zeidOCX4th";
        }
    }
}
