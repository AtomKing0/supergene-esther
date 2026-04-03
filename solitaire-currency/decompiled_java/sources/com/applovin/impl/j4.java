package com.applovin.impl;

import android.text.SpannedString;
import com.applovin.impl.j2;

/* JADX INFO: loaded from: classes2.dex */
public class j4 extends j2 {
    public j4(String str) {
        super(j2.c.SECTION);
        this.f5439c = new SpannedString(str);
    }

    public String toString() {
        return "SectionListItemViewModel{text=" + ((Object) this.f5439c) + "}";
    }
}
