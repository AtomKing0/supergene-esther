package com.onetrust.otpublishers.headless.UI.fragment;

import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static SharedPreferences a(String str, String str2, FragmentActivity fragmentActivity, int i10) {
        return fragmentActivity.getSharedPreferences(str + str2, i10);
    }
}
