package com.applovin.impl;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes2.dex */
public class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f7523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FriendlyObstructionPurpose f7524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7525c;

    public u3(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f7523a = view;
        this.f7524b = friendlyObstructionPurpose;
        this.f7525c = str;
    }

    public String a() {
        return this.f7525c;
    }

    public FriendlyObstructionPurpose b() {
        return this.f7524b;
    }

    public View c() {
        return this.f7523a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u3 u3Var = (u3) obj;
        View view = this.f7523a;
        if (view == null ? u3Var.f7523a != null : !view.equals(u3Var.f7523a)) {
            return false;
        }
        if (this.f7524b != u3Var.f7524b) {
            return false;
        }
        String str = this.f7525c;
        String str2 = u3Var.f7525c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        View view = this.f7523a;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.f7524b;
        int iHashCode2 = (iHashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.f7525c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
