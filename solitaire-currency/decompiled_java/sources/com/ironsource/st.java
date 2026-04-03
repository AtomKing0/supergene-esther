package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class st {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NetworkSettings f15331b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f15330a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f15332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15333d = true;

    st() {
    }

    public static st a() {
        return new st();
    }

    public JSONObject b() {
        return this.f15332c;
    }

    @Nullable
    public NetworkSettings c() {
        return this.f15331b;
    }

    public ArrayList<String> d() {
        return this.f15330a;
    }

    public boolean e() {
        return this.f15333d;
    }

    public void a(NetworkSettings networkSettings) {
        this.f15331b = networkSettings;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f15330a.add(str);
    }

    public void a(JSONObject jSONObject) {
        this.f15332c = jSONObject;
    }

    public void a(boolean z10) {
        this.f15333d = z10;
    }
}
